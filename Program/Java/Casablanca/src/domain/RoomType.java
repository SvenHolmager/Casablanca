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
public class RoomType {
    
    private int id;
    private String name;
    private int MaxResidents;
    private int CostPerNight;

    public RoomType(int id, String name, int MaxResidents, int CostPerNight) {
        this.id = id;
        this.name = name;
        this.MaxResidents = MaxResidents;
        this.CostPerNight = CostPerNight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxResidents() {
        return MaxResidents;
    }

    public void setMaxResidents(int MaxResidents) {
        this.MaxResidents = MaxResidents;
    }

    public int getCostPerNight() {
        return CostPerNight;
    }

    public void setCostPerNight(int CostPerNight) {
        this.CostPerNight = CostPerNight;
    }
    
    
}
