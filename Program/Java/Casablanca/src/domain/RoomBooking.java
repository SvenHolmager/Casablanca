/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author sholmager
 */
public class RoomBooking {

    private int id;
    private int payingGuestId;
    private int roomId;        
    private String checkIn;
    private String checkOut;    
    private String travelAgency;
    private boolean paymentStatus;

    public RoomBooking(int id, int payingGuestId, int roomId, String checkIn, String checkOut, String travelAgency, boolean paymentStatus) {
        this.id = id;
        this.payingGuestId = payingGuestId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.travelAgency = travelAgency;
        this.paymentStatus = paymentStatus;
    }   

    public int getId() {
        return id;
    }

    public int getPayingGuestId() {
        return payingGuestId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayingGuestId(int payingGuestId) {
        this.payingGuestId = payingGuestId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getRoomId() {
        return roomId;
    }

    

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getTravelAgency() {
        return travelAgency;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setTravelAgency(String travelAgency) {
        this.travelAgency = travelAgency;
    }
    

    
     
   
}
