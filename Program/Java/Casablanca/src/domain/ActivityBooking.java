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
public class ActivityBooking {
    
    private int Id;
    private int StayingGuestId;
    private int ActivityId;
    private int instructorId;
    private String CheckIn; 

    public ActivityBooking(int Id, int StayingGuestId, int ActivityId, int instructorId, String CheckIn, String CheckOut) {
        this.Id = Id;
        this.StayingGuestId = StayingGuestId;
        this.ActivityId = ActivityId;
        this.instructorId = instructorId;
        this.CheckIn = CheckIn;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getStayingGuestId() {
        return StayingGuestId;
    }

    public void setStayingGuestId(int StayingGuestId) {
        this.StayingGuestId = StayingGuestId;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int ActivityId) {
        this.ActivityId = ActivityId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String CheckIn) {
        this.CheckIn = CheckIn;
    }   
}
