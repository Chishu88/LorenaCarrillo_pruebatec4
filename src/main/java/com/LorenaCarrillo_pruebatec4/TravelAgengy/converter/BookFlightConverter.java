package com.LorenaCarrillo_pruebatec4.TravelAgengy.converter;


import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.BookFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.BookFlightsDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.CreateBookFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.UpdateBookFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.BookFlight;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter class responsible for converting between BookFlight entities and DTOs.
 */
public class BookFlightConverter {

    /**
     * Converts a BookFlightDTO object to a BookFlight entity.
     * @param in The BookFlightDTO object to convert
     * @return The converted BookFlight entity
     */
    public static BookFlight toEntity(BookFlightDTO in) {
        if (in == null) {
            return null;
        }

        BookFlight out = new BookFlight(in.getBookFlightId());
        out.setDate(in.getDate());
        out.setPeopleQ(in.getPeopleQ());

        return out;
    }

    /**
     * Converts a BookFlight entity to a BookFlightDTO object.
     * @param in The BookFlight entity to convert
     * @return The converted BookFlightDTO object
     */
    public static BookFlightDTO toDto(BookFlight in) {
        if (in == null) {
            return null;
        }

        BookFlightDTO out = new BookFlightDTO();
        out.setDate(in.getDate());
        out.setPeopleQ(in.getPeopleQ());

        return out;
    }

    /**
     * Converts a list of BookFlight entities to a BookFlightsDTO object.
     * @param in The list of BookFlight entities to convert
     * @return The converted BookFlightsDTO object
     */
    public static BookFlightsDTO toListDto(List<BookFlight> in) {
        BookFlightsDTO out = new BookFlightsDTO();

        if (!CollectionUtils.isEmpty(in)) {
            out.addAll(in.stream().map(BookFlightConverter::toDto)
                    .collect(Collectors.toList()));
        }

        return out;
    }

    /**
     * Converts a CreateBookFlightDTO object to a BookFlight entity.
     * @param in The CreateBookFlightDTO object to convert
     * @return The converted BookFlight entity
     */
    public static BookFlight createToEntity(CreateBookFlightDTO in) {
        BookFlight out = new BookFlight();
        out.setDate(in.getDate());
        out.setPeopleQ(in.getPeopleQ());

        return out;
    }

    /**
     * Updates a BookFlight entity based on data from an UpdateBookFlightDTO object.
     * @param bookFlight The BookFlight entity to update
     * @param in The UpdateBookFlightDTO object containing the update data
     * @return The updated BookFlight entity
     */
    public static BookFlight updateToEntity(BookFlight bookFlight, UpdateBookFlightDTO in) {
        if (in.getDate() != null) {
            bookFlight.setDate(in.getDate());
        }
        if (in.getPeopleQ() != null) {
            bookFlight.setPeopleQ(in.getPeopleQ());
        }

        return bookFlight;
    }
}
