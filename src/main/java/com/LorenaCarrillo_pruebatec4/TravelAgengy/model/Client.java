package com.LorenaCarrillo_pruebatec4.TravelAgengy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String lastName;
    private String dni;
    private String numberPhone;
    private String email;

    @ManyToMany
    @JoinTable(name = "client_booked_flights",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "book_flight_id"))
    private List<BookFlight> bookedFlights;

    @ManyToMany
    @JoinTable(name = "client_booked_rooms",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "book_room_id"))
    private List<BookRoom> bookedRooms;

    public Client(Long clientId) {
    }
}
