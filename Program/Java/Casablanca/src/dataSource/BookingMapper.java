/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.RoomBooking;
import domain.ActivityBooking;
import java.util.ArrayList;

/**
 *
 * @author sholmager
 */
public class BookingMapper {

    //== load an RoomBooking.
    public RoomBooking getRoomBooking(int Id, Connection con) {
        RoomBooking rb = null;
        String SQLString1 = // get RoomBooking
                "select * "
                + "from Room_Booking "
                + "where Id = ?";
        PreparedStatement statement = null;
        try {
            //=== get RoomBooking
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, Id);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                rb = new RoomBooking(Id,
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7)
                );
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getRoomBooking");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in BookingMapper - getRoomBooking");
                System.out.println(e.getMessage());
            }
        }
        return rb;
    }

    //== Insert new RoomBooking (tuple)
    public boolean saveRoomBooking(ArrayList<RoomBooking> roomBookingList, Connection con) throws SQLException {
        int rowsInserted = 0;
        String SQLString1
                = "insert into Room_Booking "
                + "values (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        statement = con.prepareStatement(SQLString1);

        for (int i = 0; i < roomBookingList.size(); i++) {
            RoomBooking rb = roomBookingList.get(i);
            statement.setInt(1, rb.getId());
            statement.setInt(2, rb.getPayingGuestId());
            statement.setInt(3, rb.getRoomId());
            statement.setString(4, rb.getCheckIn());
            statement.setString(5, rb.getCheckOut());
            statement.setString(6, rb.getTravelAgency());
            statement.setBoolean(7, rb.getPaymentStatus());
            rowsInserted += statement.executeUpdate();
        }
        return (rowsInserted == roomBookingList.size());
    }

    public ActivityBooking getActivityBooking(int Id, Connection con) {
        ActivityBooking ab = null;
        String SQLString1 = // get RoomBooking
                "select * "
                + "from Activity_Booking "
                + "where Id = ?";

        PreparedStatement statement = null;

        try {
            //=== get RoomBooking

            statement = con.prepareStatement(SQLString1);

            statement.setInt(1, Id);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                ab = new ActivityBooking(Id,
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDate(5).toString(),
                        rs.getDate(5).toString()
                );
            }

        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getRoomBooking");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in BookingMapper - getRoomBooking");
                System.out.println(e.getMessage());
            }
        }
        return ab;
    }

    //== Insert new ActivityBooking (tuple)
    public boolean saveActivityBooking(ArrayList<ActivityBooking> activityBookingList, Connection con) throws SQLException {
        int rowsInserted = 0;
        String SQLString1
                = "insert into Activity_Booking "
                + "values (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = con.prepareStatement(SQLString1);

        for (int i = 0; i < activityBookingList.size(); i++) {
            ActivityBooking ab = activityBookingList.get(i);
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, ab.getId());
            statement.setInt(2, ab.getStayingGuestId());
            statement.setInt(3, ab.getActivityId());
            statement.setInt(4, ab.getInstructorId());
            statement.setString(6, ab.getCheckIn());
            rowsInserted = statement.executeUpdate();
        }

        return rowsInserted == 1;
    }

    // Retrieves the next unique RoomBooking number from DB
    public int getNextRoomBookingId(Connection conn) throws SQLException {
        int nextRoomBookingNumber = 0;
        String SQLString = "select roomBookingSeq.nextval " + "from dual";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nextRoomBookingNumber = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getNextRoomBookingId");
            System.out.println(e.getMessage());
        }
        return nextRoomBookingNumber;
    }

    public int getNextActivityBookingId(Connection conn) throws SQLException {
        int nextRoomBookingNumber = 0;
        String SQLString = "select activityBookingSeq.nextval " + "from dual";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nextRoomBookingNumber = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getNextActivityBookingId");
            System.out.println(e.getMessage());
        }
        return nextRoomBookingNumber;
    }

}
