package com.LorenaCarrillo_pruebatec4.TravelAgengy.repository;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.BookFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookFlightRepository extends JpaRepository<BookFlight, Long> {
  /**
   * Finds a BookFlight entity by its flight number.
   * @param numberFlight The flight number to search for
   * @return An Optional containing the BookFlight entity if found, otherwise empty
   */
  Optional<BookFlight> findByFlight_NumberFlight(String numberFlight);

}
