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

public class Amis extends Connaissance {

    private String telephoneMobile;
    

    //constructor
    public Amis() {
    }

    public Amis(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    
    @Override
    public int getTypeContact() {
        return 2;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public Vector gerVector (){
        Vector v = new Vector ();
        v.add(this);
        v.add(this.telephoneMobile);
        return v;
        
    }
//    @Override
//    public String toString() {
//        return super.toString() + "\ntelephoneMobile : " + telephoneMobile;
//    }

}
