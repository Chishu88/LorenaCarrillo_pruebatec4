package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight;

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
public class CreateBookFlightDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private Long bookFlightId;
    private LocalDate date;
    private Integer peopleQ;
}
