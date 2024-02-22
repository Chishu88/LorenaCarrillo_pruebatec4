package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateHotelDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    private Long hotelId;
    private String code;
    private String name;
    private String city;
}
