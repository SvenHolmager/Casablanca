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

/**
 *
 * @author sholmager
 */
public class BookingMapper {

//== load an order and the associated order details
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
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
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

    //== Insert new order (tuple)
    public boolean saveRoomBooking(RoomBooking rb, Connection con) {
        int rowsInserted = 0;
        String SQLString1
                = "select orderseq.nextval  "
                + "from dual";
        String SQLString2
                = "insert into Room_Booking "
                + "values (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                rb.setId(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, rb.getId());
            statement.setInt(2, rb.getPayingGuestId());
            statement.setInt(3, rb.getRoomId());
            statement.setInt(4, rb.getPaymentStatusId());
            statement.setString(5, rb.getTravelAgency());
            statement.setString(6, rb.getCheckIn());
            statement.setString(7, rb.getCheckOut());
            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - saveRoomBooking");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in BookingMapper - saveRoomBooking");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
}
