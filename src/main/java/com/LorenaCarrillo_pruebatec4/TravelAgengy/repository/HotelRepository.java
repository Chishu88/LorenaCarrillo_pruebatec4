package com.LorenaCarrillo_pruebatec4.TravelAgengy.repository;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    /**
     * Finds hotels based on the availability of rooms and the specified city.
     * @param availableDateFrom The start date for room availability
     * @param availableDateTo The end date for room availability
     * @param city The city where the hotel is located
     * @return A list of hotels with available rooms meeting the specified criteria
     */
    List<Hotel> findByRoomsAvailableDateFromLessThanEqualAndRoomsAvailableDateToGreaterThanEqualAndCity(
            LocalDate availableDateFrom, LocalDate availableDateTo, String city);
}
