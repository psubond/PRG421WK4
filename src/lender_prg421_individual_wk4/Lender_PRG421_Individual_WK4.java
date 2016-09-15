/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lender_prg421_individual_wk4;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author psubond
 */
public class Lender_PRG421_Individual_WK4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         {
   Main mainclass = new Main();
             try {
                 mainclass.main();
             } catch (SQLException ex) {
                 Logger.getLogger(Lender_PRG421_Individual_WK4.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Lender_PRG421_Individual_WK4.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
}
}