/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lender_prg421_individual_wk4;

//imported all sql to avoid any issues with imports.  
//importing individual sql librarys was causing issues
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author psubond
 */
public class DatabaseConnection {

    public static void viewAnimal() throws SQLException, ClassNotFoundException {

        Scanner reader = new Scanner(System.in);
        boolean isNumber = false;

        int selection1 = 0;
        do {
            System.out.println("Please Select a choice from the following list"
                    + "by typing the number of the selection");

            System.out.println("1 View list of all animals");
            System.out.println("2 View specific animal");

            if (reader.hasNextInt()) {

                selection1 = reader.nextInt();
                isNumber = true;
                reader.nextLine();
            } else {

                System.out.println("Invalid selection, please select an integer");
                reader.nextLine();
                isNumber = false;

//                        
            }
            continue;

        } while (isNumber != true);
        while (selection1 < 1 || selection1 > 2) {
            if (selection1 < 1 || selection1 > 2) {
                System.out.println("Invalid selection, please select a choice from 1-2");
                selection1 = reader.nextInt();

            }

        }
        
        //must have Ucanaccess 3.0.6 jar library
        // availible from http://ucanaccess.sourceforge.net/site.html
        //library files are in the zip file that this project is included in, they
        //just need to be added to a custom library in net beans to allow them to work
        String url = "jdbc:ucanaccess://animals1.accdb";
        //establishes connection to database
        Connection con = (Connection) DriverManager.getConnection(url);

        //casts statement so that sql queries can be performed
        Statement stmt = (Statement) con.createStatement();
       
        switch (selection1) {

            case 1:

                PreparedStatement ps = null;
                ResultSet rs = stmt.executeQuery("Select * from animals");

                try {

                    //while loop will continue to query until the result set is out of data,
                    //then continues to the next row until all data has been displayed.
                    while (rs.next()) {
                        //Looney tunes characters are copywrited by Warner Brothers.  Looney Tunes Animals 
                        //populate the database.
                        System.out.println("Animal Name: " + rs.getString(2));
//                        

                    }

                    //catches exceptions and prints the reason for the crash
                } catch (SQLException sqle) {
                    //prints whole stack trace to allow user to more easily figure out why it's crashing
                    sqle.printStackTrace();

                } //closes connections to avoid resource issues with leaving database connection
                //open
                finally {
                    if (rs != null) {

                        rs.close();
                    }
                    if (ps != null) {

                        ps.close();
                    }
                    if (con != null) {

                        con.close();
                    }

                }
                break;
            case 2:
//                reader= new Scanner(System.in);
                ps = null;
                System.out.println("please type the name of the animal you would like"
                        + "to view, if you do not know the names of the animals in "
                        + "database, please use menu to view list of animals");

                String selectedAnimal = reader.nextLine();
//System.out.println("testrun");
                //querys the database for input from user.  If query comes back null, no data is displayed
                rs = stmt.executeQuery("SELECT * FROM animals WHERE animalName='" + selectedAnimal + "';");
                try {
                    //while loop iterates through result set, printing out the data to the user
                    while (rs.next()) {
                        //Looney tunes characters are copywrited by Warner Brothers.  Looney Tunes Animals 
                        //populate the database.
                        //prints out the attributes of the animal that was queried
                        System.out.println("Animal Name: " + rs.getString(3));
                        System.out.println("Color: " + rs.getString(4));
                        System.out.println("Number of Legs: " + rs.getString(5));
                        System.out.println("Can Fly: " + rs.getString(6));

                    }
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                } //closes connections to avoid resource issues with leaving database connection
                //open
                finally {
                    if (rs != null) {

                        rs.close();
                    }
                    if (ps != null) {

                        ps.close();
                    }
                    if (con != null) {

                        con.close();
                    }

                }
                break;

        }

    }

    public static void saveAnimal(String animalName1, String species, String color, String legs, Boolean flys) throws SQLException {

        String url = "jdbc:ucanaccess://animals1.accdb";
        Connection con = (Connection) DriverManager.getConnection(url);

//prepared statement is used to prevent sql injection.  withouth this the user
//could potentially drop tabels and other actions
//sends the data entered by the user to the database
        PreparedStatement stmt = con.prepareStatement("INSERT INTO animals  (animalName,"
                + " species, color, legs, Flys) VALUES  ('" + animalName1 + "', '" + species + "', '" + color + "', '" + legs + "', '" + flys + "');");

        stmt.executeUpdate();

    }

}
