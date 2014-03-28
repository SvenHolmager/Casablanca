/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.Connection;

/**
 *
 * @author sholmager
 */
public class DBFacade {

    private RoomMapper rm;
    private GuestMapper gm;
    private Connection con;

    //== Singleton start
    private static DBFacade instance;

    private DBFacade() {
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
        return rm.getRoomBooking(Id, con)
    }

    public RoomBooking saveRoomBooking(int Id) {

        return rm.saveRoomBooking(Id, con)
    
    }

    public PayingGuest getPayingGuest(int Id) {
        return gm.getPayingGuest(Id, con)
    }

    public PayingGuest savePayingGuest(int Id) {

        return gm.savePayingGuest(Idgit sta)
    }
}