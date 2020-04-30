/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TomPrecious
 * 
 */
public class JConnect {

    public Connection getNewConnection() {
        
        Connection connect = null;
        String connectionString = "jdbc:mysql://127.0.0.1:3306/bill_payment_db";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "osas";
        
        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(connectionString, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex) {
            Logger.getLogger(JConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connect;
    }
    
    public static void main(String[] args) {
    
        JConnect conn = new JConnect();
        System.out.println("Connection Instance: " + conn.getNewConnection());
    }
}
