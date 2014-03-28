/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.Connection;
import domain.*;

/**
 *
 * @author sholmager
 */
public class DBFacade {

    private BookingMapper bm;
    private RoomMapper rm;
    private GuestMapper gm;
    private Connection con;

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

    public boolean saveRoomBooking(RoomBooking rb) {

        return bm.saveRoomBooking(rb, con);
    }

    public PayingGuest getPayingGuest(int Id) {
        return gm.getPayingGuest(Id, con);
    }

    public boolean savePayingGuest(PayingGuest pg) {

        return gm.savePayingGuest(pg, con);
    }
}
