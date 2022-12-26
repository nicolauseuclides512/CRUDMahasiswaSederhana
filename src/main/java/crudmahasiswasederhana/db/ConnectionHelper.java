/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmahasiswasederhana.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author nicoe
 */
public class ConnectionHelper {
    public static Connection connect;
    public static Statement st;
    public static ResultSet rs;
    
    public static Connection getConnection() throws SQLException{
        String db = "sisteminformasi";
        String url = "jdbc:mysql://localhost:3306/"+db;
        String username = "root";
        String pass = "";
        
        if(connect==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect=DriverManager.getConnection(url,username,pass);
                st = connect.createStatement();
                JOptionPane.showMessageDialog(null,
                        "Terkoneksi");
            }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, 
                        "Tidak Terkoneksi");
            }
        }
        return connect;
    }

    public static void main(String[] args) throws SQLException {
        ConnectionHelper.getConnection();
    }
}
