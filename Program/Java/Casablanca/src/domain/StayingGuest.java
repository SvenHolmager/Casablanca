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

    private int id;
    private int roomBookingId;
    private String firstName;
    private String familyName;

    public StayingGuest(int id, int roomBookingId, String firstName, String familyName) {
        this.id = id;
        this.roomBookingId = roomBookingId;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public int getId() {
        return id;
    }

    public int getRoomBookingId() {
        return roomBookingId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomBookingId(int roomBookingId) {
        this.roomBookingId = roomBookingId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    
    
    

}
