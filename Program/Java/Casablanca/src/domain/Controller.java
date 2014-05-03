/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dataSource.*;
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

    public PayingGuest addNewPayingGuest(int id, String firstName, String familyName, String address, String country, String phone, String email) {
        //== create order object with ono=0
        currentPayingGuest = new PayingGuest(0, firstName, familyName, address, country, phone, email);

        //== save and get DB-generated unique ono
        boolean status = dbf.savePayingGuest(currentPayingGuest);
        if (!status) //fail!
        {
            currentPayingGuest = null;
        }
        return currentPayingGuest;
    }

    public RoomBooking getRoomBooking(int id) {
        currentRoomBooking = dbf.getRoomBooking(id);
        return currentRoomBooking;
    }

    public RoomBooking addNewRoomBooking(int id, int payingGuestId, int roomId, String checkIn, String checkOut, String travelAgency, boolean paymentStatus) {

        //== create order object with ono=0
        currentRoomBooking = new RoomBooking(0, payingGuestId, roomId, checkIn, checkOut, travelAgency, paymentStatus);

        //== save and get DB-generated unique ono
        boolean status = dbf.saveRoomBooking(currentRoomBooking);
        if (!status) //fail!
        {
            currentPayingGuest = null;
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
