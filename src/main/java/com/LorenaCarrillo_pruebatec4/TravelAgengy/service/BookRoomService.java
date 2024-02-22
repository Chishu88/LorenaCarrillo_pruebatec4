package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.BookRoomConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.BookRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.ClientNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.RoomNotAvailableException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.BookRoom;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Room;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Client;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.BookRoomRepository;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.ClientRepository;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookRoomService implements IBookRoomService {

    private final BookRoomRepository bookRoomRepository;
    private final RoomRepository roomRepository;
    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public BookRoomService(BookRoomRepository bookRoomRepository, RoomRepository roomRepository, ClientService clientService, ClientRepository clientRepository) {
        this.bookRoomRepository = bookRoomRepository;
        this.roomRepository = roomRepository;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }


    @Override
    public Double bookRoom(Long hotelId, Long clientId, LocalDate dateFrom, LocalDate dateTo, String roomType, Integer nights, Integer peopleQ) {
        // Obtain the room by hotelId
        List<Room> rooms = roomRepository.findRoomsByHotelIdAndAvailability(hotelId, dateFrom, dateTo);

        // Check room availability
        Room availableRoom = findAvailableRoom(rooms, dateFrom, dateTo);
        if (availableRoom == null) {
            throw new RoomNotAvailableException("No available rooms in the selected hotel for the specified dates.");
        }

        // Get the client by clientId
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with ID: " + clientId));

        // Calculate the total price of the booking
        Double totalPrice = availableRoom.getPrice() * peopleQ;

        // Create and save the room booking
        BookRoom booking = new BookRoom();
        booking.setDateFrom(dateFrom);
        booking.setDateTo(dateTo);
        booking.setNights(nights);
        booking.setPeopleQ(peopleQ);
        booking.setRoom(availableRoom);
        //booking.setClient(client);
        bookRoomRepository.save(booking);

        return totalPrice;
    }

    private Room findAvailableRoom(List<Room> rooms, LocalDate dateFrom, LocalDate dateTo) {
        for (Room room : rooms) {
            if (!room.isBooked() && room.getAvailableDateFrom().isBefore(dateFrom) && room.getAvailableDateTo().isAfter(dateTo)) {
                return room;
            }
        }
        return null;
    }


    @Override
    public List<BookRoomDTO> getAllBookings() {
        List<BookRoom> bookings = bookRoomRepository.findAll();
        return bookings.stream()
                .map(BookRoomConverter::toDto) // Use the converter to convert BookRoom to BookRoomDTO
                .collect(Collectors.toList());
    }


    private boolean isBooked(Room room, LocalDate dateFrom, LocalDate dateTo) {
        // Get all bookings for the room
        List<BookRoom> bookings = room.getBookings();

        // Check if there's any booking overlapping with the specified date range
        for (BookRoom booking : bookings) {
            LocalDate bookingDateFrom = booking.getDateFrom();
            LocalDate bookingDateTo = booking.getDateTo();

            // Check for date overlap
            if (dateFrom.isBefore(bookingDateTo) && dateTo.isAfter(bookingDateFrom)) {
                // Date overlap, room is booked
                return true;
            }
        }

        // No bookings overlap with the specified date range, room is available
        return false;
    }
}
