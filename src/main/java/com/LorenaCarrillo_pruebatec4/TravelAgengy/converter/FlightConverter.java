package com.LorenaCarrillo_pruebatec4.TravelAgengy.converter;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.CreateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.FlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.FlightsDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.UpdateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Flight;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converter class responsible for converting between Flight entities and DTOs.
 */
public class FlightConverter {

    /**
     * Converts a FlightDTO object to a Flight entity.
     * @param in The FlightDTO object to convert
     * @return The converted Flight entity
     */
    public static Flight toEntity(FlightDTO in) {
        if (in == null) {
            return null;
        }

        Flight out = new Flight(in.getFlightId());
        out.setNumberFlight(in.getNumberFlight());
        out.setOrigin(in.getOrigin());
        out.setDestiny(in.getDestiny());
        out.setTypeOfSeat(in.getTypeOfSeat());
        out.setPricePerson(in.getPricePerson());
        out.setDateTo(in.getDateTo());
        out.setDateFrom(in.getDateFrom());

        return out;
    }

    /**
     * Converts a Flight entity to a FlightDTO object.
     * @param in The Flight entity to convert
     * @return The converted FlightDTO object
     */
    public static FlightDTO toDto(Flight in) {
        if (in == null) {
            return null;
        }

        FlightDTO out = new FlightDTO();
        out.setFlightId(in.getFlightId());
        out.setNumberFlight(in.getNumberFlight());
        out.setOrigin(in.getOrigin());
        out.setDestiny(in.getDestiny());
        out.setTypeOfSeat(in.getTypeOfSeat());
        out.setPricePerson(in.getPricePerson());
        out.setDateTo(in.getDateTo());
        out.setDateFrom(in.getDateFrom());

        return out;
    }

    /**
     * Converts a list of Flight entities to a FlightsDTO object.
     * @param in The list of Flight entities to convert
     * @return The converted FlightsDTO object
     */
    public static FlightsDTO toListDto(List<Flight> in) {
        FlightsDTO out = new FlightsDTO();

        if (!CollectionUtils.isEmpty(in)) {
            out.addAll(in.stream().map(FlightConverter::toDto)
                    .collect(Collectors.toList()));
        }

        return out;
    }

    /**
     * Converts a CreateFlightDTO object to a Flight entity.
     * @param in The CreateFlightDTO object to convert
     * @return The converted Flight entity
     */
    public static Flight createToEntity(CreateFlightDTO in) {
        Flight out = new Flight();
        out.setNumberFlight(in.getNumberFlight());
        out.setOrigin(in.getOrigin());
        out.setDestiny(in.getDestiny());
        out.setTypeOfSeat(in.getTypeOfSeat());
        out.setPricePerson(in.getPricePerson());
        out.setDateTo(in.getDateTo());
        out.setDateFrom(in.getDateFrom());

        return out;
    }

    /**
     * Updates a Flight entity based on data from an UpdateFlightDTO object.
     * @param flight The Flight entity to update
     * @param in The UpdateFlightDTO object containing the update data
     * @return The updated Flight entity
     */
    public static Flight updateToEntity(Flight flight, UpdateFlightDTO in) {
        if (in.getNumberFlight() != null) {
            flight.setNumberFlight(in.getNumberFlight());
        }
        if (in.getOrigin() != null) {
            flight.setOrigin(in.getOrigin());
        }
        if (in.getDestiny() != null) {
            flight.setDestiny(in.getDestiny());
        }
        if(in.getTypeOfSeat() != null) {
            flight.setTypeOfSeat(in.getTypeOfSeat());
        }
        if (in.getPricePerson() != null) {
            flight.setPricePerson(in.getPricePerson());
        }
        if (in.getDateTo() != null) {
            flight.setDateTo(in.getDateTo());
        }
        if (in.getDateFrom() != null){
            flight.setDateFrom(in.getDateFrom());
        }

        return flight;
    }
}
