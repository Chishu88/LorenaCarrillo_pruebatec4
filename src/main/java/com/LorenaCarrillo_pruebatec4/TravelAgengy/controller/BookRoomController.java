package com.LorenaCarrillo_pruebatec4.TravelAgengy.controller;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.BookRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.BookRoomRequest;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.ClientNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.RoomNotAvailableException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.BookRoomService;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller responsible for handling room booking operations
@RestController
public class BookRoomController {

    private final BookRoomService bookRoomService; // Service layer for room booking operations
    private final RoomService roomService; // Service layer for room operations

    // Constructor to inject BookRoomService and RoomService dependencies
    public BookRoomController(BookRoomService bookRoomService, RoomService roomService) {
        this.bookRoomService = bookRoomService;
        this.roomService = roomService;
    }

    // Endpoint to retrieve all room bookings
    @GetMapping("/allBookings")
    public ResponseEntity<List<BookRoomDTO>> getAllBookings() {
        // Retrieve all room bookings from the service layer
        List<BookRoomDTO> bookings = bookRoomService.getAllBookings();
        // Return HTTP response with the list of room bookings and OK status
        return ResponseEntity.ok(bookings);
    }

    // Endpoint to book a room in a hotel
    @PostMapping("/bookingHotel")
    public ResponseEntity<Double> bookRoom(@RequestBody BookRoomRequest request) {
        try {
            // Attempt to book the room using the provided request data
            Double totalPrice = bookRoomService.bookRoom(
                    request.getClientId(),
                    request.getHotelId(),
                    request.getDateFrom(),
                    request.getDateTo(),
                    request.getRoomType(),
                    request.getNights(),
                    request.getPeopleQ()
            );
            // Return the total price of the booked room and OK status
            return ResponseEntity.ok(totalPrice);
        } catch (RoomNotAvailableException e) {
            // Handle the case where the room is not available and return BAD REQUEST status
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (ClientNotFoundException e) {
            // Handle the case where the client is not found and return NOT FOUND status
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
