package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.FlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.CreateFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight.UpdateFlightDTO;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {

    List<FlightDTO> getAllFlights();
    List<FlightDTO> getAvailableFlights(LocalDate dateFrom, LocalDate dateTo, String origin, String destiny);
    FlightDTO createFlight(CreateFlightDTO flightDTO);
    FlightDTO updateFlight(Long flightId, UpdateFlightDTO flightDTO);
    void deleteFlight(Long flightId);


}
