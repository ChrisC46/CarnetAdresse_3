/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjets;

import java.util.Vector;

/**
 *
 * @author CDI305
 */
public class Famille extends Amis {

  

    private String dateNaissance;

    //constructor
    public Famille() {
    }

    public Famille(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

   
    
    
   

    @Override
    public int getTypeContact() {
        return 3;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Vector gerVector () {
        Vector v = new Vector();
        v.add(this);
        v.add(this.dateNaissance);
        return v;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "\ndateNaissance : " + dateNaissance;
//    }

}
