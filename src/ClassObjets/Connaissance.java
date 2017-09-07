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
public class Connaissance {
    
    
    private int iD;
    private String nom;
    private String prenom;
    private String adresseRue;
    private String codePostal;
    private String ville;
    private String telephone;
    private String email;
    private int typeContact;

    //constructor
    public Connaissance() {
    }

    public Connaissance(String nom, String prenom, String adresseRue, String codePostal, String ville, String telephone, String email, int typeContact) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseRue = adresseRue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.typeContact = typeContact;
    }
    
    
    public int getiD() {    
        return iD;
    }

    //setters & Getters
    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getTypeContact() {
        return 1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseRue() {
        return adresseRue;
    }

    public void setAdresseRue(String adresseRue) {
        this.adresseRue = adresseRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }
    
    

    public void setEmail(String email) {
        this.email = email;
    }

    public Vector gerVector () {
        Vector v = new Vector ();
        Amis a = new Amis();
        v.add(this);
        v.add(this.nom);
        v.add(this.prenom);
        v.add(this.telephone);
        v.add(this.adresseRue);
        v.add(this.codePostal);
        v.add(this.ville);
        v.add(this.email);
        v.add(this.typeContact);
        v.add(this.iD);
        if (typeContact == 2){
      
        }
       
        
        return v;
    }
    
    
    @Override
    public String toString() {
        return /*"\n\nnom : " +*/ prenom/* + "\nprenom : " */+" "+ nom /*+ "\nadresse : " + adresseRue + "\ncodePostal : " + codePostal + "\nville : " + ville + "\ntelephone : " + telephone + "\nemail : " + email*/;
    }

}
