/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpm.dbapp;
import java.sql.*;//for create database

/**
 *
 * @author sspmcoe
 */
public class Mydb {
    Connection connection;//for connection object
    PreparedStatement st;
    ResultSet rs1,rs2;
    
    Mydb()//data connection code
    {
        try {       
             Class.forName("com.mysql.jdbc.Driver"); //data base used mysql
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/librarybooks",
                        "root", ""); //initialization
               System.out.println("Connect");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(int bookid,String title,String author,int price,String date, String time)
    {
        try {
            st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `bookinfo`  VALUES ('"+bookid + "', '" + title + "', '" +author+ "', '" +price+ "', '"+date+ "', '"+time+ "')");//query
            System.out.println(st.execute());//query execute
            /*if(st.execute())
            {
                System.out.print("Insert");
                //JOptionPane.showMessageDialog(Mydb, "You have successfully inserted");
            } else {
                        //JOptionPane.showMessageDialog(Mydb, "Wrong input");
                        System.out.print("Insert failed");
                    }*/
        }
        catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    public static void main(String args[])
    {
        Mydb d =new Mydb();
        d.insert(1, "The wolf of streets","joy",600,"23-Aug-2007","12:07");
    }
    
}
