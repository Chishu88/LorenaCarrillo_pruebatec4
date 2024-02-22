package com.LorenaCarrillo_pruebatec4.TravelAgengy.service;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.converter.HotelConverter;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.CreateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.HotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel.UpdateHotelDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Hotel;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HotelService implements IHotelService{

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public HotelDTO createHotel(CreateHotelDTO hotelDTO) {
        Hotel newHotel = HotelConverter.createToEntity(hotelDTO);
        newHotel = hotelRepository.save(newHotel);
        return HotelConverter.toDto(newHotel);
    }

    @Override
    public List<HotelDTO> getAllHotels() {

        return HotelConverter.toListDto(hotelRepository.findAll());
    }

    @Override
    public HotelDTO updateHotel(Long hotelId, UpdateHotelDTO hotelDTO) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if(optionalHotel.isPresent()){
            Hotel savedHotel = hotelRepository.save(HotelConverter.updateToEntity(optionalHotel.get(), hotelDTO));
            return HotelConverter.toDto(savedHotel);
        }else {
            return null;
        }
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelDTO> getAvailableHotels(LocalDate availableDateTo, LocalDate availableDateFrom, String city) {
        List<Hotel> hotels = hotelRepository.findByRoomsAvailableDateFromLessThanEqualAndRoomsAvailableDateToGreaterThanEqualAndCity(availableDateTo, availableDateFrom, city);

        return hotels.stream()
                .map(HotelConverter::toDto)
                .collect(Collectors.toList());
    }

    public HotelDTO findHotelById(Long hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if (optionalHotel.isPresent()) {
            return HotelConverter.toDto(optionalHotel.get());
        } else {
            return null;
        }
    }
}
