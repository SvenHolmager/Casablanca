/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sholmager
 */
public class GuestMapper {

//== load an order and the associated order details
    public PayingGuest getPayingGuest(int Id, Connection con) {
        PayingGuest pg = null;
        String SQLString1 = // get RoomBooking
                "select * "
                + "from Paying_Guest "
                + "where Id = ?";

        PreparedStatement statement = null;

        try {
            //=== get RoomBooking

            statement = con.prepareStatement(SQLString1);

            statement.setInt(1, Id);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                pg = new PayingGuest(Id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
            }

        } catch (Exception e) {
            System.out.println("Fail in GuestMapper - getGuestMapper");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in GuestMapper - getGuestMapper");
                System.out.println(e.getMessage());
            }
        }
        return pg;
    }

    //== Insert new PayingGuest (tuple)
    public boolean savePayingGuest(ArrayList<PayingGuest> PayingGuestList, Connection con) throws SQLException {

        int rowsInserted = 0;
        String SQLString1
                = "insert into Paying_Guest "
                + "values (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        statement = con.prepareStatement(SQLString1);

        for (int i = 0; i < PayingGuestList.size(); i++) {
            PayingGuest pg = PayingGuestList.get(i);
            statement.setInt(1, this.getNextPayingGuestNumber(con));
            statement.setString(2, pg.getFirstName());
            statement.setString(3, pg.getFamilyName());
            statement.setString(4, pg.getAddress());
            statement.setString(5, pg.getCountry());
            statement.setString(6, pg.getPhone());
            statement.setString(7, pg.getEmail());
            rowsInserted = statement.executeUpdate();
        }
        return (rowsInserted == PayingGuestList.size());
    }

    public StayingGuest getStayingGuest(int Id, Connection con) {
        StayingGuest sg = null;
        String SQLString1 = // get RoomBooking
                "select * "
                + "from Staying_Guest "
                + "where Id = ?";

        PreparedStatement statement = null;

        try {
            //=== get RoomBooking

            statement = con.prepareStatement(SQLString1);

            statement.setInt(1, Id);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                sg = new StayingGuest(Id,
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }

        } catch (Exception e) {
            System.out.println("Fail in GuestMapper - getGuestMapper");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in GuestMapper - getGuestMapper");
                System.out.println(e.getMessage());
            }
        }
        return sg;
    }

    public boolean saveStayingGuest(StayingGuest sg, Connection con) {
        int rowsInserted = 0;
        String SQLString1
                = "select orderseq.nextval  "
                + "from dual";
        String SQLString2
                = "insert into Staying_Guest "
                + "values (?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique id
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                sg.setId(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, sg.getId());
            statement.setString(2, sg.getFirstName());
            statement.setString(3, sg.getFamilyName());
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

    // Retrieves the next unique PayingGuest number from DB
    public int getNextPayingGuestNumber(Connection conn) {
        int nextPayingGuestNumber = 0;
        String SQLString = "select payingGuestSeq.nextval " + "from dual";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nextPayingGuestNumber = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Fail in BookingMapper - getNextBookingNo");
            System.out.println(e.getMessage());
        }
        return nextPayingGuestNumber;
    }
}
