package com.LorenaCarrillo_pruebatec4.TravelAgengy.converter;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.CreateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.RoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.RoomsDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room.UpdateRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Room;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter class responsible for converting between Room entities and DTOs.
 */
public class RoomConverter {

    /**
     * Converts a RoomDTO object to a Room entity.
     * @param in The RoomDTO object to convert
     * @return The converted Room entity
     */
    public static Room toEntity(RoomDTO in) {
        if (in == null) {
            return null;
        }

        Room out = new Room(in.getRoomId());
        out.setRoomType(in.getRoomType());
        out.setPrice(in.getPrice());
        out.setAvailableDateTo(in.getAvailableDateTo());
        out.setAvailableDateFrom(in.getAvailableDateFrom());

        return out;
    }

    /**
     * Converts a Room entity to a RoomDTO object.
     * @param in The Room entity to convert
     * @return The converted RoomDTO object
     */
    public static RoomDTO toDto(Room in) {
        if (in == null) {
            return null;
        }

        RoomDTO out = new RoomDTO();
        out.setRoomId(in.getRoomId());
        out.setRoomType(in.getRoomType());
        out.setPrice(in.getPrice());
        out.setAvailableDateTo(in.getAvailableDateTo());
        out.setAvailableDateFrom(in.getAvailableDateFrom());

        return out;
    }

    /**
     * Converts a list of Room entities to a RoomsDTO object.
     * @param in The list of Room entities to convert
     * @return The converted RoomsDTO object
     */
    public static RoomsDTO toListDto(List<Room> in) {
        RoomsDTO out = new RoomsDTO();

        if (!CollectionUtils.isEmpty(in)) {
            out.addAll(in.stream().map(RoomConverter::toDto)
                    .collect(Collectors.toList()));
        }

        return out;
    }

    /**
     * Converts a CreateRoomDTO object to a Room entity.
     * @param in The CreateRoomDTO object to convert
     * @return The converted Room entity
     */
    public static Room createToEntity(CreateRoomDTO in) {
        Room out = new Room();
        out.setRoomType(in.getRoomType());
        out.setPrice(in.getPrice());
        out.setAvailableDateTo(in.getAvailableDateTo());
        out.setAvailableDateFrom(in.getAvailableDateFrom());

        return out;
    }

    /**
     * Updates a Room entity based on data from an UpdateRoomDTO object.
     * @param room The Room entity to update
     * @param in The UpdateRoomDTO object containing the update data
     * @return The updated Room entity
     */
    public static Room updateToEntity(Room room, UpdateRoomDTO in) {
        if (in.getRoomType() != null) {
            room.setRoomType(in.getRoomType());
        }
        if (in.getPrice() != null) {
            room.setPrice(in.getPrice());
        }
        if (in.getAvailableDateTo() != null) {
            room.setAvailableDateTo(in.getAvailableDateTo());
        }
        if (in.getAvailableDateFrom() != null) {
            room.setAvailableDateFrom(in.getAvailableDateFrom());
        }

        return room;
    }
}
