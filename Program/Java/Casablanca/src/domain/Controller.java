/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dataSource.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sholmager
 */
public class Controller {

    private ArrayList<Room> currentRoomsList;
    private ArrayList<Activity> currentActivityList;
    private PayingGuest currentPayingGuest;
    private StayingGuest currentStayingGuest;
    private RoomBooking currentRoomBooking;
    private Room currentRoom;
    private final DBFacade dbf;

    private boolean processingBooking;

    //==Singelton start
    private static Controller c;

    public Controller() {

        processingBooking = false;

        dbf = DBFacade.getInstance();
    }

    public static Controller getInstance() {
        if (c == null) {
            c = new Controller();
        }
        return c;
    }
    //==Singleton end

    public PayingGuest getPayingGuest(int id) {
        currentPayingGuest = dbf.getPayingGuest(id);
        return currentPayingGuest;
    }

    public StayingGuest getStayingGuest(int id) {
        currentStayingGuest = dbf.getStayingGuest(id);
        return currentStayingGuest;
    }

    public Room addCurrentRoom(int id, String number, String roomType, int maxResidents, int costPerNight) {

        currentRoom = null;
        currentRoom = new Room(id, number, roomType, maxResidents, costPerNight);

        return currentRoom;
    }

    public PayingGuest addNewPayingGuest(int id, String firstName, String familyName, String address, String country, String phone, String email) throws SQLException {
        if (processingBooking) {
            return null;
        }
        dbf.startProcessBookingBusinessTransaction();

        int newPayingGuestId = dbf.getNextPayingGuestId();// DB-generated unique ID
        if (newPayingGuestId != 0) {
            processingBooking = true;

            currentPayingGuest = new PayingGuest(newPayingGuestId, firstName, familyName, address, country, phone, email);
            dbf.savePayingGuest(currentPayingGuest);
        } else {
            processingBooking = false;
            currentPayingGuest = null;
        }
        return currentPayingGuest;
    }

    public RoomBooking getRoomBooking(int id) {
        currentRoomBooking = dbf.getRoomBooking(id);
        return currentRoomBooking;
    }

    public RoomBooking addNewRoomBooking(int payingGuestId, String checkIn, String checkOut, String travelAgency, boolean paymentStatus) throws SQLException {
        if (processingBooking) {
            return null;
        }
        int newBookingId = dbf.getNextRoomBookingId();// DB-generated unique ID

        if (newBookingId != 0) {
            processingBooking = true;

            currentRoomBooking = new RoomBooking(newBookingId, currentPayingGuest.getId(), currentRoom.getId(), checkIn, checkOut, travelAgency, paymentStatus);

            dbf.saveRoomBooking(currentRoomBooking);
        } else {
            processingBooking = false;
            currentRoomBooking = null;
        }
        return currentRoomBooking;
    }

    public ArrayList<Room> getRooms() {

        currentRoomsList = dbf.getRooms();
        return currentRoomsList;
    }

//    public ArrayList<Activity> getActivity() {
//
//        currentActivityList = dbf.getActivities();
//        return currentActivityList;
//    }
}
