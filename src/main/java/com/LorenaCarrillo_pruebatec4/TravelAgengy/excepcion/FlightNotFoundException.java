package com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion;

public class FlightNotFoundException extends  RuntimeException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
