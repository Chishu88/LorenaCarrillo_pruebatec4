package com.LorenaCarrillo_pruebatec4.TravelAgengy.converter;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.BookRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.BookRoomsDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.CreateBookRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.UpdateBookRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.BookRoom;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter class responsible for converting between BookRoom entities and DTOs.
 */
public class BookRoomConverter {

    /**
     * Converts a BookRoomDTO object to a BookRoom entity.
     * @param in The BookRoomDTO object to convert
     * @return The converted BookRoom entity
     */
    public static BookRoom toEntity(BookRoomDTO in) {
        if (in == null) {
            return null;
        }

        BookRoom out = new BookRoom(in.getBookRoomId());
        out.setDateFrom(in.getDateFrom());
        out.setDateTo(in.getDateTo());
        out.setNights(in.getNights());
        out.setPeopleQ(in.getPeopleQ());

        return out;
    }

    /**
     * Converts a BookRoom entity to a BookRoomDTO object.
     * @param in The BookRoom entity to convert
     * @return The converted BookRoomDTO object
     */
    public static BookRoomDTO toDto(BookRoom in) {
        if (in == null) {
            return null;
        }

        BookRoomDTO out = new BookRoomDTO();
        out.setDateFrom(in.getDateFrom());
        out.setDateTo(in.getDateTo());
        out.setNights(in.getNights());
        out.setPeopleQ(in.getPeopleQ());

        return out;
    }

    /**
     * Converts a list of BookRoom entities to a BookRoomsDTO object.
     * @param in The list of BookRoom entities to convert
     * @return The converted BookRoomsDTO object
     */
    public static BookRoomsDTO toListDto(List<BookRoom> in) {
        BookRoomsDTO out = new BookRoomsDTO();

        if (!CollectionUtils.isEmpty(in)) {
            out.addAll(in.stream().map(BookRoomConverter::toDto)
                    .collect(Collectors.toList()));
        }

        return out;
    }

    /**
     * Converts a CreateBookRoomDTO object to a BookRoom entity.
     * @param in The CreateBookRoomDTO object to convert
     * @return The converted BookRoom entity
     */
    public static BookRoom createToEntity(CreateBookRoomDTO in) {
        BookRoom out = new BookRoom();
        out.setDateFrom(in.getDateFrom());
        out.setDateTo(in.getDateTo());
        out.setNights(in.getNights());
        out.setPeopleQ(in.getPeopleQ());

        return out;
    }

    /**
     * Updates a BookRoom entity based on data from an UpdateBookRoomDTO object.
     * @param bookRoom The BookRoom entity to update
     * @param in The UpdateBookRoomDTO object containing the update data
     * @return The updated BookRoom entity
     */
    public static BookRoom updateToEntity(BookRoom bookRoom, UpdateBookRoomDTO in) {
        if (in.getDateFrom() != null) {
            bookRoom.setDateFrom(in.getDateFrom());
        }
        if (in.getDateTo() != null) {
            bookRoom.setDateTo(in.getDateTo());
        }
        if (in.getNights() != null) {
            bookRoom.setNights(in.getNights());
        }

        return bookRoom;
    }
}


