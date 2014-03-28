/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dataSource.*;

/**
 *
 * @author sholmager
 */
public class Controller {

    private PayingGuest currentPayingGuest;
    private RoomBooking currentRoomBooking;
    private PayingGuest currentStayingGuest;
    private DBFacade dbf;

    //==Singelton start
    private static Controller c;

    private Controller() {

        dbf = DBFacade.getInstance();
    }

    public static Controller getInstance() {
        if (c == null) {
            c = new Controller();
        }
        return c;
    }
    //==Singleton end
    
    
    public PayingGuest getPayingGuest(int Id) {
        currentPayingGuest = dbf.getPayingGuest(Id);
        return currentPayingGuest;
    }

    public PayingGuest addNewPayingGuest(int ID, String firstName, String familyName, String address, String country, String phone, String email) {
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

    public RoomBooking getRoomBooking(int Id) {
        currentRoomBooking = dbf.getRoomBooking(Id);
        return currentRoomBooking;
    }

    public RoomBooking addNewRoomBooking(int Id, int PayingGuestId, int RoomId, int PaymentStatusId, String TravelAgency, String CheckIn, String CheckOut) {

        //== create order object with ono=0
        currentRoomBooking = new RoomBooking(0, PayingGuestId, RoomId, PaymentStatusId, TravelAgency, CheckIn, CheckOut);

        //== save and get DB-generated unique ono
        boolean status = dbf.saveRoomBooking(currentRoomBooking);
        if (!status) //fail!
        {
            currentPayingGuest = null;
        }
        return currentRoomBooking;
    }
    
    public StayingGuest getStayingGuest(int Id){
        currentStayingGuest = dbf.getStayingGuest(Id);
        return currentStayingGuest;
}
