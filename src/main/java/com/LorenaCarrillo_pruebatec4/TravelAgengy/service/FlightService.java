package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.FlightConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.CreateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.FlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.UpdateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion.FlightNotFoundException;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Flight;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.BookFlightRepository;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService{

    private final FlightRepository flightRepository;
    private final BookFlightRepository bookFlightRepository;

    public FlightService(FlightRepository flightRepository, BookFlightRepository bookFlightRepository) {
        this.flightRepository = flightRepository;
        this.bookFlightRepository = bookFlightRepository;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return FlightConverter.toListDto(flights);
    }

    @Override
    public List<FlightDTO> getAvailableFlights(LocalDate dateFrom, LocalDate dateTo, String origin, String destiny) {
        List<Flight> flights = flightRepository.findByDateFromLessThanEqualAndDateToGreaterThanEqualAndOriginAndDestiny(dateFrom, dateTo, origin, destiny);

        return flights.stream()
                .map(FlightConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO createFlight(CreateFlightDTO flightDTO) {
        Flight flight = FlightConverter.createToEntity(flightDTO);
        Flight savedFlight = flightRepository.save(flight);
        return FlightConverter.toDto(savedFlight);
    }

    @Override
    public FlightDTO updateFlight(Long flightId, UpdateFlightDTO flightDTO) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            // Update flight attributes with DTO data
            flight.setOrigin(flightDTO.getOrigin());
            flight.setDestiny(flightDTO.getDestiny());
            flight.setTypeOfSeat(flightDTO.getTypeOfSeat());
            flight.setPricePerson(flightDTO.getPricePerson());
            flight.setDateTo(flightDTO.getDateTo());
            flight.setDateFrom(flightDTO.getDateFrom());

            Flight updatedFlight = flightRepository.save(flight);
            return FlightConverter.toDto(updatedFlight);
        } else {
            // Handle case where flight is not found
            throw new FlightNotFoundException("Flight with id " + flightId + " not found");
        }
    }

    @Override
    public void deleteFlight(Long flightId) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            // Delete flight from the database
            flightRepository.delete(flight);
        } else {
            // Handle case where flight is not found
            throw new FlightNotFoundException("Flight with id " + flightId + " not found");
        }
    }
}


