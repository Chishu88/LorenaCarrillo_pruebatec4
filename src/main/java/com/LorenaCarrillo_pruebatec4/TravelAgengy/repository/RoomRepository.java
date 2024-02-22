package com.LorenaCarrillo_pruebatec4.TravelAgengy.repository;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId " +
            "AND r.availableDateFrom <= :dateFrom " +
            "AND r.availableDateTo >= :dateTo")
    List<Room> findRoomsByHotelIdAndAvailability(@Param("hotelId") Long hotelId,
                                                 @Param("dateFrom") LocalDate dateFrom,
                                                 @Param("dateTo") LocalDate dateTo);
}
