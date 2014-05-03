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

    public PayingGuest addNewPayingGuest(int id, String firstName, String familyName, String address, String country, String phone, String email) {
        if (processingBooking) {
            return null;
        }

        dbf.startProcessBookingBusinessTransaction();
        int newOrderNo = dbFacade.getNextOrderNumber();// DB-generated unique ID
        if (newOrderNo != 0) {
            processingOrder = true;
            //- capture current date.Represent as String
            String dateReceived = (new java.sql.Date(
                    (new java.util.Date().getTime())).toString());
            currentRoomBooking = new Order(newOrderNo, customerNumber, employeeNumber, dateReceived, null, 0);
            dbFacade.registerNewOrder(currentOrder);
        } else {
            processingOrder = false;
            currentRoomBooking = null;
        }
        return currentRoomBooking;

        //        //== create order object with ono=0
//        currentPayingGuest = new PayingGuest(0, firstName, familyName, address, country, phone, email);
//
//        //== save and get DB-generated unique ono
//        boolean status = dbf.savePayingGuest(currentPayingGuest);
//        if (!status) //fail!
//        {
//            currentPayingGuest = null;
//        }
//        return currentPayingGuest;
//    }
    }

    public RoomBooking getRoomBooking(int id) {
        currentRoomBooking = dbf.getRoomBooking(id);
        return currentRoomBooking;
    }

    public RoomBooking addNewRoomBooking(int payingGuestId, String checkIn, String checkOut, String travelAgency, boolean paymentStatus) throws SQLException {
        if (processingBooking) {
            return null;
        }

        dbf.startProcessBookingBusinessTransaction();
        int newBookingId = dbf.getNextRoomBookingId();// DB-generated unique ID

        if (newBookingId != 0) {
            processingBooking = true;
            //- capture current date.Represent as String

            currentRoomBooking = new RoomBooking(newBookingId, int payingGuestId, currentRoom.getId(), String checkIn, String checkOut, String travelAgency, boolean paymentStatus)
            , String checkIn, String checkOut
            , String travelAgency, boolean paymentStatus
            )
            dbf.registerNewOrder(currentOrder);
        } else {
            processingBooking = false;
            currentRoomBooking = null;
        }
        return currentRoomBooking;
//        //== create order object with ono=0
//        currentRoomBooking = new RoomBooking(0, payingGuestId, roomId, checkIn, checkOut, travelAgency, paymentStatus);
//
//        //== save and get DB-generated unique ono
//        boolean status = dbf.saveRoomBooking(currentRoomBooking);
//        if (!status) //fail!
//        {
//            currentPayingGuest = null;
//        }
//        return currentRoomBooking;

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
