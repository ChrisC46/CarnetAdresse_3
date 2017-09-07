/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresse;

import ClassObjets.Console;
import ClassObjets.GestionSQL;
import ClassObjets.JFCarnetAdresse;
import ClassObjets.JFSuppContacts;

import java.io.IOException;

/**
 *
 * @author CDI305
 */
public class CarnetAdresseTest {


    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

//        Console maConsole = new Console();
//        GestionSQL gesQl = new GestionSQL();
        
        JFCarnetAdresse swingMenu = new JFCarnetAdresse();
        
        /*
        pour activer le carnet en mode console
        
        gesQl.chargeDriver();

        gesQl.synContact();

        maConsole.gestionContact();
        */
        swingMenu.setVisible(true);
    }
}
