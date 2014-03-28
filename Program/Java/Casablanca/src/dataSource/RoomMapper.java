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
public class RoomMapper 
{
    public String getAvailableRooms(Connection con)
    {
        ArrayList<String> availablerooms = new ArrayList<String>();
        String roomlist = "";
        String SQLString1 = //
                "select room_id  from room" +
                "where room_id not in (select room_id " +
                "                      from room_booking)" +
                "order by room_id";
        PreparedStatement statement = null;
        try
        {
          
          statement = con.prepareStatement(SQLString1);
          
          ResultSet rs = statement.executeQuery();
          roomlist = rs.toString();
         
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
          
        
        return roomlist;
    }
    
}
