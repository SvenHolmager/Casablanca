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
        
        ArrayList<Room> rooms = new ArrayList<>();
       
        String SQLString1 = 
                  "select * from room"                
                + "order by room_id";

        PreparedStatement statement = null;
        try {

            statement = con.prepareStatement(SQLString1);

            ResultSet rs = statement.executeQuery();
            
            while(rs.next())                    
            {   
                Room room = new Room(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4));         
                rooms.add(room);
            }

        }
        catch (Exception e)
        {   
          System.out.println("Fail in RoomMapper - getAvailableRooms");
          System.out.println(e.getMessage());
        }
        finally			  					// must close statement
        {
    	  try 
            {
		statement.close();
            } catch (SQLException e) {
			System.out.println("Fail in RoomMapper - getAvailableRooms");
			System.out.println(e.getMessage());
		}  
        }

            return rooms;
        }

    }
