package com.LorenaCarrillo_pruebatec4.TravelAgengy.repository;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Flight;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    /**
     * Finds flights based on the specified criteria.
     * @param dateTo The end date of the flight
     * @param dateFrom The start date of the flight
     * @param origin The origin city of the flight
     * @param destiny The destination city of the flight
     * @return A list of flights meeting the specified criteria
     */
    List<Flight> findByDateFromLessThanEqualAndDateToGreaterThanEqualAndOriginAndDestiny(
            LocalDate dateTo, LocalDate dateFrom, String origin, String destiny);
}

