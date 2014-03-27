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

    //== Singleton start
    private static Connection con;
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

    }
