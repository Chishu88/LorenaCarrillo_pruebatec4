package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.CreateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.UpdateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.CreateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.RoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.UpdateRoomDTO;

import java.time.LocalDate;
import java.util.List;

public interface IRoomService {

    RoomDTO createRoom(CreateRoomDTO roomDTO);

    List<RoomDTO> getAllRooms();

    RoomDTO updateRoom(Long roomId, UpdateRoomDTO roomDTO);

    void deleteRoom(Long id);
}
