package com.LorenaCarrillo_pruebatec4.TravelAgengy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;
    private String numberFlight;
    private String origin;
    private String destiny;
    private String typeOfSeat;
    private Double pricePerson;
    private LocalDate dateTo;
    private LocalDate dateFrom;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<BookFlight> bookings;


    public Flight(Long flightId) {
    }

    public void addBooking(BookFlight booking) {
        if (bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setFlight(this);
    }
}


