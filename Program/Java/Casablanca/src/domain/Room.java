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
public class Room {

    private int Id;
    private int RoomTypeId;
    private int RoomBookingId;
    private String Name;

    public Room(int Id, int RoomTypeId, int RoomBookingId, String Name) {
        this.Id = Id;
        this.RoomTypeId = RoomTypeId;
        this.RoomBookingId = RoomBookingId;
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public int getRoomTypeId() {
        return RoomTypeId;
    }

    public int getRoomBookingId() {
        return RoomBookingId;
    }

    public String getName() {
        return Name;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setRoomTypeId(int RoomTypeId) {
        this.RoomTypeId = RoomTypeId;
    }

    public void setRoomBookingId(int RoomBookingId) {
        this.RoomBookingId = RoomBookingId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    

}
