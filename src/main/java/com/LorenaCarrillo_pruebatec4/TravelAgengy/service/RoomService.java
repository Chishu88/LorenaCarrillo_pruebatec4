package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.RoomConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.CreateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.RoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.UpdateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.HotelNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Hotel;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Room;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.HotelRepository;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService{

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public RoomDTO createRoom(CreateRoomDTO roomDTO) {
        // Convert the room DTO to a Room entity
        Room newRoom = RoomConverter.createToEntity(roomDTO);

        // Get the ID of the hotel to which the room belongs
        Long hotelId = roomDTO.getHotelId();

        // Check if the hotel exists
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (!optionalHotel.isPresent()) {
            // Handle the case where the hotel does not exist
            throw new HotelNotFoundException("Hotel not found with ID: " + hotelId);
        }

        // Associate the room with the hotel
        Hotel hotel = optionalHotel.get();
        newRoom.setHotel(hotel);

        // Save the room to the database
        newRoom = roomRepository.save(newRoom);

        // Convert the Room entity to a room DTO and return the DTO
        return RoomConverter.toDto(newRoom);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return RoomConverter.toListDto(roomRepository.findAll());
    }

    @Override
    public RoomDTO updateRoom(Long roomId, UpdateRoomDTO roomDTO) {
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        if(optionalRoom.isPresent()){
            Room savedRoom = roomRepository.save(RoomConverter.updateToEntity(optionalRoom.get(), roomDTO));
            return RoomConverter.toDto(savedRoom);
        }else {
            return null;
        }
    }

    @Override
    public void deleteRoom(Long id) {
         roomRepository.deleteById(id);
    }

}
