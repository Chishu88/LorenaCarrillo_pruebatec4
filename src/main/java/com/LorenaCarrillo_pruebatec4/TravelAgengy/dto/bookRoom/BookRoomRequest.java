package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom;

import com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client.ClientDTO;
import com.LorenaCarrillo_pruebatec4.TravelAgengy.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRoomRequest {

    private Long bookRoomId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer nights;
    private Integer peopleQ;
    private String roomType;
    private Long clientId;
    private Long hotelId;
}
