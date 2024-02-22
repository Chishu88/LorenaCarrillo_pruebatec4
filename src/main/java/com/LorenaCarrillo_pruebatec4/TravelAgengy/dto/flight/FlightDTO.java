package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.flight;

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
public class FlightDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long flightId;
    private String numberFlight;
    private String origin;
    private String destiny;
    private String typeOfSeat;
    private Double pricePerson;
    private LocalDate dateTo;
    private LocalDate dateFrom;
}
