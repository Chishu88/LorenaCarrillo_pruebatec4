package com.LorenaCarrillo_pruebatec4.TravelAgengy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookRoomId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer nights;
    private Integer peopleQ;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToMany(mappedBy = "bookedRooms")
    private List<Client> hosts;

    public BookRoom(Long bookRoomId) {
    }

}
