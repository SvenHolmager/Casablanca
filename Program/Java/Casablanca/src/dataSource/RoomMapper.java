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
                rooms.add(new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5) ));
                System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
            }

            statement.close();
        } catch (Exception e) {
            System.out.println("Fail in RoomMapper - getRooms");
            System.out.println(e.getMessage());
        }
        System.out.println("rooms arraylist size: " + rooms.size());
        return rooms;
    }
   
   
   public void updateRoomsTable(Connection con) {
       
       Object[][] roomsMatrix = null;
       int size=0;
       
       String sqlString3 = "SELECT ROOM.ROOM_ID AS 'Room Number', ROOM_TYPE.NAME as 'Room Type', ROOM_TYPE.MAXRESIDENTS as 'Max Residents',ROOM_TYPE.COSTPERNIGHT as 'Cost/night' " +
                "FROM ROOM, ROOM_TYPE "+
                "WHERE ROOM.ROOMTYPEID = ROOM_TYPE.TYPE_ID; ";
           
           
       PreparedStatement statement;
        try {

            statement = con.prepareStatement(sqlString3);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                size++;           
            }
            
            if(size>0)
            {
                roomsMatrix = new Object[size][4];
              while (rs.next())
              {
                 int i =0;
              }
            }

            statement.close();
        } catch (Exception e) {
            System.out.println("Fail in RoomMapper - getRooms");
            System.out.println(e.getMessage());
        }
       
                   
     }
  }
