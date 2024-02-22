package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom.BookRoomDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;

import java.time.LocalDate;
import java.util.List;


public interface IBookRoomService {

    Double bookRoom(Long hotelId, Long clientId, LocalDate dateFrom, LocalDate dateTo, String roomType, Integer nights, Integer peopleQ);
    List<BookRoomDTO> getAllBookings();
}
