package com.LorenaCarrillo_pruebatec4.TravelAgengy.controller;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.CreateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.RoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.UpdateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.HotelService;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class responsible for handling room-related operations
@RestController
public class RoomController {

    private final RoomService roomService; // Service layer for room operations
    private final HotelService hotelService; // Service layer for hotel operations

    // Constructor to inject dependencies
    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }

    // Endpoint to create a new room
    @PostMapping("/agency/rooms/new")
    public ResponseEntity<RoomDTO> createNewRoom(@RequestBody CreateRoomDTO createRoomDTO) {
        // Get the ID of the hotel to which the room belongs
        Long hotelId = createRoomDTO.getHotelId();

        // Check if the hotel exists
        HotelDTO hotel = hotelService.findHotelById(hotelId);
        if (hotel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Create the room and associate it with the hotel
        RoomDTO roomDTO = roomService.createRoom(createRoomDTO);
        roomDTO.setHotelId(hotelId); // Associate the room with the hotel

        return ResponseEntity.ok(roomDTO);
    }

    // Endpoint to retrieve all rooms
    @GetMapping("/allrooms")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        // Retrieve all rooms from the service layer
        List<RoomDTO> roomDTOList = roomService.getAllRooms();
        // Return the list of rooms in the HTTP response with OK status
        return new ResponseEntity<>(roomDTOList, HttpStatus.OK);
    }

    // Endpoint to update a room by ID
    @PutMapping("/agency/rooms/edit/{id}")
    public RoomDTO updateRoom(@PathVariable Long id, @RequestBody UpdateRoomDTO updateRoomDTO){
        // Update the room using the provided DTO and ID
        return roomService.updateRoom(id, updateRoomDTO);
    }

    // Endpoint to delete a room by ID
    @DeleteMapping("/agency/rooms/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        // Delete the room by ID using the service layer
        roomService.deleteRoom(id);
    }
}
