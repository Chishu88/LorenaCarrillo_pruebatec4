package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.CreateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.UpdateHotelDTO;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {

  HotelDTO createHotel(CreateHotelDTO hotelDTO);

  List<HotelDTO> getAllHotels();

  HotelDTO updateHotel(Long hotelId, UpdateHotelDTO hotelDTO);

  void deleteHotel(Long id);
  List<HotelDTO> getAvailableHotels(LocalDate availableDateTo, LocalDate availableDateFrom, String city);
}
