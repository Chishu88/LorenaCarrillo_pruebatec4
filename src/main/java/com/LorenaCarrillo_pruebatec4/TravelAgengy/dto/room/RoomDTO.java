package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long roomId;
    private String roomType;
    private Double price;
    private LocalDate availableDateTo;
    private LocalDate availableDateFrom;
    private boolean isBooked;
    private Long hotelId;



}
