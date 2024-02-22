package com.LorenaCarrillo_pruebatec4.TravelAgengy.controller;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.BookFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.BookFlightRequest;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.FlightNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.BookFlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// Controller responsible for handling flight booking operations
@RestController
public class BookFlightController {

    private final BookFlightService bookFlightService; // Service layer for flight booking operations

    // Constructor to inject BookFlightService dependency
    public BookFlightController(BookFlightService bookFlightService) {
        this.bookFlightService = bookFlightService;
    }

    // Endpoint to retrieve all flight bookings
    @GetMapping("/allBookingFlights")
    public ResponseEntity<List<BookFlightDTO>> getAllBookings() {
        // Retrieve all flight bookings from the service layer
        List<BookFlightDTO> bookings = bookFlightService.getAllBookings();
        // Return HTTP response with the list of flight bookings and OK status
        return ResponseEntity.ok(bookings);
    }

    // Endpoint to book a flight
    @PostMapping("/bookFlights")
    public ResponseEntity<Double> bookFlight(@RequestBody BookFlightRequest request) {
        try {
            // Attempt to book the flight using the provided request data
            Double totalPrice = bookFlightService.bookFlight(
                    request.getNumberFlight(),
                    request.getDate(),
                    request.getPeopleQ(),
                    request.getClientId()
            );
            // Return the total price of the booked flight and OK status
            return ResponseEntity.ok(totalPrice);
        } catch (FlightNotFoundException e) {
            // Handle the case where the flight is not found and return NOT FOUND status
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Handle other exceptions and return INTERNAL SERVER ERROR status
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
