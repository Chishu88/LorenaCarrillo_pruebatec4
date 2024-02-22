package com.LorenaCarrillo_pruebatec4.TravelAgengy.controller;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.CreateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.FlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.UpdateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Controller class responsible for handling flight-related operations
@RestController
public class FlightController {

    private final FlightService flightService; // Service layer for flight operations

    // Constructor to inject FlightService dependency
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Endpoint to retrieve all flights
    @GetMapping("/allFlights")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        // Retrieve all flights from the service layer
        List<FlightDTO> flights = flightService.getAllFlights();
        // Return the list of flights in the HTTP response with OK status
        return ResponseEntity.ok(flights);
    }

    // User Story Nº 5: Endpoint to retrieve available flights based on date range, origin, and destination
    @GetMapping("/available")
    public ResponseEntity<List<FlightDTO>> getAvailableFlights(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam("origin") String origin,
            @RequestParam("destiny") String destiny) {
        // Retrieve available flights based on provided parameters from the service layer
        List<FlightDTO> availableFlights = flightService.getAvailableFlights(dateFrom, dateTo, origin, destiny);
        // Return the list of available flights in the HTTP response with OK status
        return ResponseEntity.ok(availableFlights);
    }

    // Endpoint to create a new flight
    @PostMapping("/newFlight")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody CreateFlightDTO flightDTO) {
        // Create a new flight using the provided DTO
        FlightDTO createdFlight = flightService.createFlight(flightDTO);
        // Return the created flight DTO in the HTTP response with CREATED status
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    // Endpoint to update a flight by ID
    @PutMapping("/flight/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long flightId, @RequestBody UpdateFlightDTO flightDTO) {
        // Update the flight using the provided DTO and ID
        FlightDTO updatedFlight = flightService.updateFlight(flightId, flightDTO);
        // Return the updated flight DTO with OK status
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    // Endpoint to delete a flight by ID
    @DeleteMapping("/flight/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        // Delete the flight by ID using the service layer
        flightService.deleteFlight(flightId);
        // Return NO CONTENT status as the flight has been successfully deleted
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
