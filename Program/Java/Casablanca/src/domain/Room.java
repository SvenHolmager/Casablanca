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

    private int id;
    private int number;
    private String roomType;
    private int maxResidents;
    private int costPerNight;

    public Room(int id, int number, String roomType, int maxResidents, int costPerNight) {
        this.id = id;
        this.roomType = roomType;
        this.maxResidents = maxResidents;
        this.number = number;
    }

 

    public int getCostPerNight() {
        return costPerNight;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCostPerNight(int costPerNight) {
        this.costPerNight = costPerNight;
    }

    public int getId() {
        return id;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getMaxResidents() {
        return maxResidents;
    }

    public int getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setMaxResidents(int maxResidents) {
        this.maxResidents = maxResidents;
    }

    public void setName(int number) {
        this.number = number;
    }
    

}
