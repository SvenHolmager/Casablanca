/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.util.ArrayList;
import domain.*;
import java.sql.*;

/**
 *
 * @author sholmager
 */
public class UnitOfWork {

    private final BookingMapper bookingMapper;
    private final GuestMapper guestMapper;

    private final ArrayList<RoomBooking> newRoomBookings;
    private final ArrayList<RoomBooking> dirtyRoomBookings;
    private final ArrayList<PayingGuest> newPayingGuests;
    private final ArrayList<PayingGuest> dirtyPayingGuest;

    public UnitOfWork(BookingMapper bm, GuestMapper gm) {

        this.bookingMapper = bm;
        this.guestMapper = gm;

        newRoomBookings = new ArrayList<>(); // will never exceed 1 element
        dirtyRoomBookings = new ArrayList<>(); // will never exceed 1 element
        newPayingGuests = new ArrayList<>(); // will never exceed 1 element
        dirtyPayingGuest = new ArrayList<>(); // will never exceed 1 element

    }
    //====== Methods to register changes ==========================

    public void registerNewRoomBooking(RoomBooking roomBooking) {
        if (!newRoomBookings.contains(roomBooking) && // if not all ready registered in any list
                !dirtyRoomBookings.contains(roomBooking)) {
            newRoomBookings.add(roomBooking);
        }
    }

    public void registerDirtyRoomBooking(RoomBooking roomBooking) {
        if (!newRoomBookings.contains(roomBooking) && // if not all ready registered in any list
                !dirtyRoomBookings.contains(roomBooking)) {
            dirtyRoomBookings.add(roomBooking);
        }
    }

    public void registerNewPayingGuest(PayingGuest payingGuest) {
        if (!newPayingGuests.contains(payingGuest) && // if not all ready registered in any list
                !dirtyPayingGuest.contains(payingGuest)) {
            newPayingGuests.add(payingGuest);
        }
    }

    public void registerDirtyPayingGuest(PayingGuest payingGuest) {
        if (!newPayingGuests.contains(payingGuest) && // if not all ready registered in any list
                !dirtyPayingGuest.contains(payingGuest)) {
            dirtyPayingGuest.add(payingGuest);
        }
    }

    //====== Method to save changes to DB ===============================
    public boolean commit(Connection con) {
        boolean status = true;  // will be set false if any part of transaction fails    
        try {
            //=== system transaction - starts
            con.setAutoCommit(false);

            status = status && bookingMapper.saveRoomBooking(newRoomBookings, con);
//            status = status && bookingMapper.updateRoomBooking(dirtyRoomBookings, con);

            status = status && guestMapper.savePayingGuest(newPayingGuests, con);
//            status = status && guestMapper.updatePayingGuest(dirtyPayingGuest, con);

            if (!status) {
                throw new Exception("Process Order Business Transaction aborted");
            }
            //=== system transaction - ends with success
            con.commit();
        } catch (Exception e) {
            //=== system transaction - ends with roll back
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            status = false;
        }
        return status;
    }

}
