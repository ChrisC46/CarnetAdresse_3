
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjets;

import Tris.TrisCodePostal;
import Tris.TrisNom;
import Tris.TrisType;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author cdi305
 */
public class CarnetAdresse {
    
     private static Vector<Connaissance> listContacts = new Vector();


    public Vector<Connaissance> getListContacts() {
        return listContacts;
    }

    public void setListContacts(Vector<Connaissance> listContacts) {
        this.listContacts = listContacts;
    }
     
    public void ajouter (Connaissance unContact){
       listContacts.add(unContact);
   }
    
   public void supprimer (Connaissance unContact){
       listContacts.remove(unContact);
   }
   
   public void supprimerCarnet () {
       listContacts.removeAllElements();
   }
   
   
     
    //methode de tris par nom
    public void trisCarnetNom() {
        TrisNom trisNom1 = new TrisNom();
        Collections.sort(listContacts, trisNom1);
        for (Connaissance uneConnaissance : listContacts) {
            System.out.println(uneConnaissance);
        }
    }
    
      //methode de tris par code postal
    public void trisCarnetCodePostal() {
        TrisCodePostal trisCodePostal1 = new TrisCodePostal();
        Collections.sort(listContacts, trisCodePostal1);
        for (Connaissance uneConnaissance : listContacts) {
            System.out.println(uneConnaissance);
        }
    }
    
    //methode de tris par type
    public void trisCarnetType() {
        TrisType trisType1 = new TrisType();
        Collections.sort(listContacts, trisType1);
        for (Connaissance uneConnaissance : listContacts) {
            System.out.println(uneConnaissance);
        }

    }
}
