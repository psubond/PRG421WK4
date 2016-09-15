/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lender_prg421_individual_wk4;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author psubond
 */
public class AnimalFactory {
//builds the animal and sends the objects back to the DatabaseConnection class so that save
    //animal method can package it up and save it to database
    public static void animalBuilder() throws SQLException {
        Scanner reader = new Scanner(System.in);
//        System.out.println("animalBuilder method works");

        System.out.println("Enter the Name of your Animal");
        String animalName1 = reader.nextLine();

        System.out.println("Enter the Species of your Animal");
        String species = reader.nextLine();

        System.out.println("What color is your animal");
        String color = reader.nextLine();

        System.out.println("How many Legs does your animal have");
        String legs = reader.nextLine();

        System.out.println("Does your animal fly?  (enter 0 for yes any other integer for no)");
        int flySelection = reader.nextInt();

        boolean flys = false;

        if (flySelection != 0) {
            flys = false;
//        DatabaseConnection.saveAnimal(name, species, color, legs, flys);
        } else {
            flys = true;
//            DatabaseConnection.saveAnimal(name, species, color, legs, flys);

        }

        DatabaseConnection.saveAnimal(animalName1, species, color, legs, flys);

    }

}
