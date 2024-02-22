package com.LorenaCarrillo_pruebatec4.TravelAgengy.converter;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.CreateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelsDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.UpdateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Hotel;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter class responsible for converting between Hotel entities and DTOs.
 */
public class HotelConverter {

    /**
     * Converts a HotelDTO object to a Hotel entity.
     * @param in The HotelDTO object to convert
     * @return The converted Hotel entity
     */
    public static Hotel toEntity(HotelDTO in) {
        if (in == null) {
            return null;
        }

        Hotel out = new Hotel(in.getHotelId());
        out.setCode(in.getCode());
        out.setName(in.getName());
        out.setCity(in.getCity());

        return out;
    }

    /**
     * Converts a Hotel entity to a HotelDTO object.
     * @param in The Hotel entity to convert
     * @return The converted HotelDTO object
     */
    public static HotelDTO toDto(Hotel in) {
        if (in == null) {
            return null;
        }

        HotelDTO out = new HotelDTO();
        out.setHotelId(in.getHotelId());
        out.setCode(in.getCode());
        out.setName(in.getName());
        out.setCity(in.getCity());

        return out;
    }

    /**
     * Converts a list of Hotel entities to a HotelsDTO object.
     * @param in The list of Hotel entities to convert
     * @return The converted HotelsDTO object
     */
    public static HotelsDTO toListDto(List<Hotel> in) {
        HotelsDTO out = new HotelsDTO();

        if (!CollectionUtils.isEmpty(in)) {
            out.addAll(in.stream().map(HotelConverter::toDto)
                    .collect(Collectors.toList()));
        }

        return out;
    }

    /**
     * Converts a CreateHotelDTO object to a Hotel entity.
     * @param in The CreateHotelDTO object to convert
     * @return The converted Hotel entity
     */
    public static Hotel createToEntity(CreateHotelDTO in) {
        Hotel out = new Hotel();
        out.setCode(in.getCode());
        out.setName(in.getName());
        out.setCity(in.getCity());

        return out;
    }

    /**
     * Updates a Hotel entity based on data from an UpdateHotelDTO object.
     * @param hotel The Hotel entity to update
     * @param in The UpdateHotelDTO object containing the update data
     * @return The updated Hotel entity
     */
    public static Hotel updateToEntity(Hotel hotel, UpdateHotelDTO in) {
        if (in.getCode() != null) {
            hotel.setCode(in.getCode());
        }
        if (in.getName() != null) {
            hotel.setName(in.getName());
        }
        if (in.getCity() != null) {
            hotel.setCity(in.getCity());
        }

        return hotel;
    }
}
