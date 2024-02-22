package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookFlight;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookFlightRequest {

    private LocalDate date;
    private Integer peopleQ;
    private Long clientId;
    private String numberFlight;



}
