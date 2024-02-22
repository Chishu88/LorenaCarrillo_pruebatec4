package com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
