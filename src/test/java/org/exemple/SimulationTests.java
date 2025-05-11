package org.exemple;

import org.example.enums.OrderStatus;
import org.example.enums.PaymentMethod;
import org.example.enums.PermissionLevel;
import org.example.model.Event;
import org.example.model.Reservation;
import org.example.model.Transaction;
import org.example.model.User;
import org.example.model.Vehicle;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTests {

    @Test
    void testUserCreation() {
        User user = new User();
        user.setId(1);
        user.setUsername("teste");
        user.setPassword("senha");
        user.setEmail("teste@email.com");
        user.setPhone("123456789");
        user.setPermissionLevel(PermissionLevel.CLIENT);
        user.setCPF("987.654.321-00");

        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("teste", user.getUsername());
        assertEquals("teste@email.com", user.getEmail());
        assertEquals(PermissionLevel.CLIENT, user.getPermissionLevel());
        assertEquals("987.654.321-00", user.getCPF());
    }

    @Test
    void testVehicleCreation() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(10);
        vehicle.setPlate("XYZ-5678");
        vehicle.setModel("Hatch");
        vehicle.setUserID(1);

        assertNotNull(vehicle);
        assertEquals(10, vehicle.getId());
        assertEquals("XYZ-5678", vehicle.getPlate());
        assertEquals("Hatch", vehicle.getModel());
        assertEquals(1, vehicle.getUserID());
    }

    @Test
    void testEventCreation() {
        Event event = new Event();
        event.setId(101);
        event.setEventName("Concerto");
        event.setDateTime(LocalDateTime.of(2025, 6, 20, 21, 0));
        event.setLocation("Arena");

        assertNotNull(event);
        assertEquals(101, event.getId());
        assertEquals("Concerto", event.getEventName());
        assertEquals("Arena", event.getLocation());
        assertEquals(LocalDateTime.of(2025, 6, 20, 21, 0), event.getDateTime());
    }

    @Test
    void testReservationCreation() {
        Reservation reservation = new Reservation();
        reservation.setId(401);
        reservation.setUserID(1);
        reservation.setVehicleID(10);
        reservation.setEventID(101);
        reservation.setParkingSpaceID(301);
        reservation.setReservationDateTime(LocalDateTime.now());

        assertNotNull(reservation);
        assertEquals(401, reservation.getId());
        assertEquals(1, reservation.getUserID());
        assertEquals(10, reservation.getVehicleID());
        assertEquals(101, reservation.getEventID());
        assertNotNull(reservation.getReservationDateTime());
    }

    @Test
    void testTransactionCreationAndStatusUpdate() {
        Reservation reservation = new Reservation();
        Transaction transaction = new Transaction(null, reservation);
        transaction.setDateTime(LocalDateTime.now());
        transaction.setOrderStatus(OrderStatus.CREATED);

        assertNotNull(transaction);
        assertEquals(OrderStatus.CREATED, transaction.getOrderStatus());
        assertNotNull(transaction.getDateTime());
        assertNull(transaction.getPaymentMethod());

        transaction.setPaymentMethod(PaymentMethod.PIX);
        transaction.setOrderStatus(OrderStatus.PAID);
        assertEquals(PaymentMethod.PIX, transaction.getPaymentMethod());
        assertEquals(OrderStatus.PAID, transaction.getOrderStatus());
    }
}