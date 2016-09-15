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
public class Main {

    Scanner reader = new Scanner(System.in);
    boolean runAgain = true;
    int runAgainVariable = 1;

    public void main() throws SQLException, ClassNotFoundException {

//        System.out.println("main method works");2
        actionSelection();
    }

    public void actionSelection() throws SQLException, ClassNotFoundException {
        boolean isNumber = false;
        while (runAgain == true) {
           int selection =0; 
            do{ 
            System.out.println("Please Select a choice from the following list"
                    + "by typing the number of the selection");

            System.out.println("1 Add animal to Database");
            System.out.println("2 View Animal in Database");

           
              
              
              if(reader.hasNextInt()) 
                       {
                       
                       selection = reader.nextInt();
                       isNumber = true;
                       
                       }
                    else
                    
                    {
                         
                        System.out.println("Invalid selection, please select an integer");
                        reader.nextLine();
                        isNumber=false;
                        
                        
//                        
                    }
             continue;
             
          }
          
          while (isNumber !=true);
//         System.out.println(isNumber);
            //  (It consumes the \n character) without this 
            //the code skips animal name because reader.nextInt only cares about the 
            //next integer and extranious data in the rest of the line causes the first
            //choice to be skipped otherwise.


            //ensures that he user input is between 1 and 2
            
            
            
            
            
            while (selection < 1 || selection > 2) {
                if (selection < 1 || selection > 2) {
                    System.out.println("Invalid selection, please select a choice from 1-2");
                    
                    
                    reader.next();
                    
                    
                    selection = reader.nextInt();

                }

                    }
                


            
            
            switch (selection) {
                //switch is used instead of a chain of if/else statements so all
                //the code isn't executed, the switch/case allows the application
                //to only use the code for the case that is presented, in this case the 
                // selection that the user makes.
                case 1:
                    AnimalFactory.animalBuilder();

//                   System.out.println("Add Animal Works");
                    break;

                case 2:

                    DatabaseConnection.viewAnimal();
                    break;

            }
            //while loop keeps the app running until the user enters a 0 to exit the application
            System.out.println("Enter 0 to exit, any other integer to perform another action");
            runAgainVariable = reader.nextInt();
            reader.nextLine();
            if (runAgainVariable != 0) {
                runAgain = true;
            } else {
                runAgain = false;
            }
        
            
            } 
            
            
    }
    }


