package com.LorenaCarrillo_pruebatec4.TravelAgengy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private Long hotelId;

    private String code;
    private String name;
    private String city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;


    public Hotel(Long hotelId) {
    }
}
