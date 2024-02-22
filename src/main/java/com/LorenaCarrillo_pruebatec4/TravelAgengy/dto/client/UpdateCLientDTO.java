package com.LorenaCarrillo_pruebatec4.TravelAgengy.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCLientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long clientId;
    private String name;
    private String lastName;
    private String dni;
    private String numberPhone;
    private String email;
}
