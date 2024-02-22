package com.LorenaCarrillo_pruebatec4.TravelAgengy.controller;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.CreateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.UpdateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.HotelService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Controller class responsible for handling hotel-related operations
@RestController
public class HotelController {

    private final HotelService hotelService; // Service layer for hotel operations

    // Constructor to inject HotelService dependency
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Endpoint to create a new hotel
    @PostMapping("/agency/hotels/new")
    public HotelDTO createNewHotel(@RequestBody CreateHotelDTO createHotelDTO){
        // Create a new hotel using the provided DTO
        return hotelService.createHotel(createHotelDTO);
    }

    // Endpoint to update a hotel by ID
    @PutMapping("/agency/hotels/edit/{id}")
    public HotelDTO updateHotel(@PathVariable Long id, @RequestBody UpdateHotelDTO updateHotelDTO){
        // Update the hotel using the provided DTO and ID
        return hotelService.updateHotel(id, updateHotelDTO);
    }

    // Endpoint to delete a hotel by ID
    @DeleteMapping("/agency/hotels/delete/{id}")
    public void deleteHotel(@PathVariable Long id) {
        // Delete the hotel by ID using the service layer
        hotelService.deleteHotel(id);
    }

    // Endpoint to retrieve all hotels
    @GetMapping("/agency/allhotels")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        // Retrieve all hotels from the service layer
        List<HotelDTO> hotels = hotelService.getAllHotels();
        // Return the list of hotels in the HTTP response with OK status
        return ResponseEntity.ok().body(hotels);
    }

    // Endpoint to retrieve available hotels based on date range and city
    @GetMapping("/agency/hotels")
    public ResponseEntity<List<HotelDTO>> getAvailableHotels(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo,
            @RequestParam("city") String city) {
        // Retrieve available hotels based on provided parameters from the service layer
        List<HotelDTO> availableHotels = hotelService.getAvailableHotels(dateFrom, dateTo, city);
        // Return the list of available hotels in the HTTP response with OK status
        return ResponseEntity.ok(availableHotels);
    }
}
