package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.bookRoom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRoomDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long bookRoomId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer nights;
    private Integer peopleQ;
}
