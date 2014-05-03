/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.Connection;
import domain.*;
import java.util.ArrayList;

/**
 *
 * @author sholmager
 */
public class DBFacade {

    private BookingMapper bm;
    private RoomMapper rm;
    private GuestMapper gm;
    private Connection con;
    private UnitOfWork unitOfWork;

    //== Singleton start
    private static DBFacade instance;

    private DBFacade() {
        bm = new BookingMapper();
        rm = new RoomMapper();
        gm = new GuestMapper();
        con = new DBConnector().getConnection();  // the connection will be released upon program 
        // termination by the garbage collector		  
    }

    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }
    //== Singleton end

    public RoomBooking getRoomBooking(int Id) {
        return bm.getRoomBooking(Id, con);
    }

    public ActivityBooking getActivityBooking(int Id) {
        return bm.getActivityBooking(Id, con);
    }

    public PayingGuest getPayingGuest(int Id) {
        return gm.getPayingGuest(Id, con);
    }

    public StayingGuest getStayingGuest(int Id) {
        return gm.getStayingGuest(Id, con);
    }

    public ArrayList<Room> getRooms() {
        return rm.getRooms(con);
    }

    public void saveRoomBooking(RoomBooking rb) {
        if (unitOfWork != null) {
            unitOfWork.registerNewRoomBooking(rb);
        }
    }

    public void saveActivityBooking(ActivityBooking ab) {
        if (unitOfWork != null) {
            unitOfWork.registerNewActivityBooking(ab);
        }
    }

    public void savePayingGuest(PayingGuest pg) {
        if (unitOfWork != null) {
            unitOfWork.registerNewPayingGuest(pg);
        }
    }

    public void saveStayingGuest(StayingGuest sg) {
        if (unitOfWork != null) {
            unitOfWork.registerNewStayingGuest(sg);
        }
    }

    public void startProcessBookingBusinessTransaction() {
        unitOfWork = new UnitOfWork(bm, gm);
    }

    //=== Save all changes
    public boolean commitProcessBookingBusinessTransaction() {
        boolean status = false;
        if (unitOfWork != null) {
            status = unitOfWork.commit(con);
            unitOfWork = null;
        }
        return status;
    }
}
