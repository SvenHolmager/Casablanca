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

import domain.Room;
import domain.RoomType;
import java.util.ArrayList;

/**
 *
 * @author Ilici
 */

public class RoomMapper {

   public ArrayList<Room> getRooms(Connection con) {

        ArrayList<Room> rooms = new ArrayList();

        String sqlString1
                = "select * from room "
                + "order by room_id";
        String sqlString2 = "SELECT TABLE_NAME FROM USER_TABLES";

        PreparedStatement statement;
        try {

            statement = con.prepareStatement(sqlString1);
            ResultSet rs = statement.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                System.out.println(rs.getString(1));
                System.out.println("just added room nb " + i);
                rooms.add(new Room(rs.getInt(1), rs.getInt(2), 0, "stringy string"));
            }

            statement.close();
        } catch (Exception e) {
            System.out.println("Fail in RoomMapper - getRooms");
            System.out.println(e.getMessage());
        }
        System.out.println("rooms arraylist size: " + rooms.size());
        return rooms;
    }
  }
