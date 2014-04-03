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

    private int Id;
    private int PayingGuestId;
    private int RoomId;
    private int PaymentStatusId;
    private String TravelAgency;
    private String CheckIn;
    private String CheckOut;    

    public RoomBooking(int Id, int PayingGuestId, int RoomId, int PaymentStatusId, String TravelAgency, String CheckIn, String CheckOut) {
        this.Id = Id;
        this.PayingGuestId = PayingGuestId;
        this.RoomId = RoomId;
        this.PaymentStatusId = PaymentStatusId;
        this.TravelAgency = TravelAgency;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPayingGuestId() {
        return PayingGuestId;
    }

    public void setPayingGuestId(int PayingGuestId) {
        this.PayingGuestId = PayingGuestId;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int RoomId) {
        this.RoomId = RoomId;
    }

    public int getPaymentStatusId() {
        return PaymentStatusId;
    }

    public void setPaymentStatusId(int PaymentStatusId) {
        this.PaymentStatusId = PaymentStatusId;
    }

    public String getTravelAgency() {
        return TravelAgency;
    }

    public void setTravelAgency(String TravelAgency) {
        this.TravelAgency = TravelAgency;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String CheckIn) {
        this.CheckIn = CheckIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String CheckOut) {
        this.CheckOut = CheckOut;
    }

}
