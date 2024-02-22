package com.LorenaCarrillo_pruebatec4.TravelAgengy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookFlight {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookFlightId;

    private LocalDate date;
    private Integer peopleQ;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToMany(mappedBy = "bookedFlights")
    private List<Client> passengers;

    public BookFlight(Long bookFlightId) {
    }


}
