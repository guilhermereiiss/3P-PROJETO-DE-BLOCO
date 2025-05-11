package org.example.model;

import java.time.LocalDateTime;

public class Reservation {

    int id;
    int userID;
    int vehicleID;
    int eventID;
    int ParkingSpaceID;
    LocalDateTime reservationDateTime; // Usando LocalDateTime para a data e hora da reserva

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getParkingSpaceID() {
        return ParkingSpaceID;
    }

    public void setParkingSpaceID(int parkingSpaceID) {
        ParkingSpaceID = parkingSpaceID;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }
}