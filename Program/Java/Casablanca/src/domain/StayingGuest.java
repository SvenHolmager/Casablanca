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
public class StayingGuest {

    private int Id;
    private String FirstName;
    private String LastName;
    private int RoomBookingId;

    public StayingGuest(int Id, String FirstName, String LastName, int RoomBookingId) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.RoomBookingId = RoomBookingId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getRoomBookingId() {
        return RoomBookingId;
    }

    public void setRoomBookingId(int RoomBookingId) {
        this.RoomBookingId = RoomBookingId;
    }

}
