package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.BookFlightConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.ClientConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.BookFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.ClientNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.FlightNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.BookFlight;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Client;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.BookFlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookFlightService implements IBookFlightService {

    private final BookFlightRepository bookFlightRepository;
    private final ClientService clientService;

    public BookFlightService(BookFlightRepository bookFlightRepository, ClientService clientService) {
        this.bookFlightRepository = bookFlightRepository;
        this.clientService = clientService;
    }

    @Override
    public List<BookFlightDTO> getAllBookings() {
        List<BookFlight> bookings = bookFlightRepository.findAll();
        return bookings.stream()
                .map(BookFlightConverter::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public Double bookFlight(String numberFlight, LocalDate date, Integer peopleQ, Long clientId) {
        // Find the flight by flight number
        BookFlight bookFlight = bookFlightRepository.findByFlight_NumberFlight(numberFlight)
                .orElseThrow(() -> new FlightNotFoundException("Flight booking not found with flight number: " + numberFlight));

        // Find the client by ID
        Client client = clientService.getClientById(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client not found with ID: " + clientId);
        }

        // Calculate the total price
        Double totalPrice = bookFlight.getFlight().getPricePerson() * peopleQ;

        // Create and save a new flight booking
        BookFlight newBookFlight = new BookFlight();
        newBookFlight.setFlight(bookFlight.getFlight());
        newBookFlight.setDate(date);
        newBookFlight.setPeopleQ(peopleQ);

        // Associate the client with the flight
        newBookFlight.getPassengers().add(client);
        client.getBookedFlights().add(newBookFlight);

        bookFlightRepository.save(newBookFlight);

        return totalPrice;
    }
}