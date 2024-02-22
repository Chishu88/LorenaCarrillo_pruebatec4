package com.LorenaCarrillo_pruebatec4.TravelAgengy.excepcion;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String message) {
        super(message);
    }
}
