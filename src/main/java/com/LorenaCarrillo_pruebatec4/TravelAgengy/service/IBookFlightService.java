package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight.BookFlightDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;

import java.time.LocalDate;
import java.util.List;

public interface IBookFlightService {

    List<BookFlightDTO> getAllBookings();

    Double bookFlight(String numberFlight, LocalDate date, Integer peopleQ, Long clientId);
}
