package com.LorenaCarrillo_pruebatec4.TravelAgengy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomType;
    private Double price;
    private LocalDate availableDateFrom;
    private LocalDate availableDateTo;
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name ="hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<BookRoom> bookings;


    public Room(Long roomId) {
    }
}
