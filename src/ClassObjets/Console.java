/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Iterator;
import javax.swing.JTextField;

/**
 *
 * @author cdi305
 */
public class Console {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    private int index;
    private CarnetAdresse leCarnet = new CarnetAdresse();

    // methode general pour faire fonctionner le carnet d'adresse
    public void gestionContact() throws IOException {

        boolean continuer = true;

        while (continuer) {

            menuAccueil();
            switch (choixSwitch()) {
                case 1:
                    afficherUnContact();
                    break;
                case 2:
                    ajouterContact();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    supprimerUnContact();
                    break;
                case 5:
                    auRevoir();
                    continuer = false;
                    break;
                case 6:
                    leCarnet.supprimerCarnet();
                    break;
                default:
                    choixValide();
                    break;

            }

        }

    }

    //methode pour afficher un contact
    public void afficherUnContact() throws IOException {

        afficherContact();

        switch (choixSwitch()) {
            case 0:
                affichageVector();
                break;
            case 1:
                String nomAfficher = nomAfficher();
                int index = 0;
                int indexRecherche = -1;
                Iterator<Connaissance> itConnaissance = leCarnet.getListContacts().iterator();
                while (itConnaissance.hasNext()) {
                    if (itConnaissance.next().getNom().equalsIgnoreCase(nomAfficher)) {
                        indexRecherche = index;
                    }
                    index = index + 1;
                }
                if (indexRecherche != -1) {
                    System.out.println(leCarnet.getListContacts().get(indexRecherche));
                } else {
                    nomInconnu();
                }
                break;
            case 2:
                leCarnet.trisCarnetNom();
                break;
            case 3:
                leCarnet.trisCarnetCodePostal();
                break;
            case 4:
                leCarnet.trisCarnetType();
                break;
            case 5:
                break;
            default:
                choixValide();
                break;
        }

    }

    private void affichageVector() {
        for (Connaissance unContact : leCarnet.getListContacts()) {
            System.out.println("\n--Contact numéro : " + unContact.getiD()
                    + "\n--Type : " + unContact.getClass().getSimpleName() + "\n" + unContact);
        }
    }

    //methode pour ajouter un contact
    public void ajouterContact() throws IOException {

        menuAjoutContact();

        switch (choixSwitch()) {

            case 1:
                Connaissance uneConnaissance = new Connaissance();
                entreeContact(uneConnaissance);
                break;
            case 2:
                Amis unAmis = new Amis();
                entreeContact(unAmis);
                break;
            case 3:
                Famille maFamille = new Famille();
                entreeContact(maFamille);
                break;
            case 4:
                gestionContact();
                break;
            default:
                choixValide();
                break;
        }
    }

    //methode pour modifier
    private void modifier() throws IOException {
        GestionSQL gSql = new GestionSQL();
        gSql.synchroCarnet();
        System.out.println("Entrez le numero du contact à modifier : ");
        String indexS = br.readLine();
        index = Integer.valueOf(indexS);
        for (Connaissance unContact : leCarnet.getListContacts()) {
            if (unContact.getiD() == index) {
                modifierContact(unContact);
            }
        }

    }

    public void modifierContact(Connaissance unContact) throws IOException {
        GestionSQL gSql = new GestionSQL();
        modifContact();

        choixModification();
        if (unContact.getTypeContact() == 3) {
            choixFamille();
        } else if (unContact.getTypeContact() == 2) {
            choixAmis();
        } else if (unContact.getTypeContact() == 1) {
            choixConnaissance();
        } else {
            nomInconnu();
        }

        String colonne = null;

        switch (choixSwitch()) {
            case 1:
                colonne = "Nom";
                System.out.println("Veuillez entrer le nom");
                String nom = br.readLine();
                unContact.setNom(nom);
                gSql.majContact(colonne, nom, index);
                break;
            case 2:
                colonne = "Prenom";
                System.out.println("Veuillez entrer le prenom");
                String prenom = br.readLine();
                unContact.setPrenom(prenom);
                gSql.majContact(colonne, prenom, index);
                break;
            case 3:
                colonne = "Telephone";
                System.out.println("Veuillez entrer le telephone");
                String telephone = br.readLine();
                unContact.setTelephone(telephone);
                gSql.majContact(colonne, telephone, index);
                break;
            case 4:
                colonne = "AdresseRue";
                System.out.println("Veuillez entrer l'adresse (numéro et nom de la rue)");
                String adresse = br.readLine();
                unContact.setAdresseRue(adresse);
                gSql.majContact(colonne, adresse, index);
                break;
            case 5:
                colonne = "CodePostal";
                System.out.println("Veuillez entrer le code postal");
                String codePostal = br.readLine();
                unContact.setCodePostal(codePostal);
                gSql.majContact(colonne, codePostal, index);
                break;
            case 6:
                colonne = "Ville";
                System.out.println("Veuillez entre la ville");
                String ville = br.readLine();
                unContact.setVille(ville);
                gSql.majContact(colonne, ville, index);
                break;
            case 7:
                colonne ="Email";
                System.out.println("Veuillez entrer l'adresse mail");
                String mail = br.readLine();
                unContact.setEmail(mail);
                gSql.majContact(colonne, mail, index);
                break;
            case 8:
                colonne = "TelephonePortable";
                if (unContact.getTypeContact() == 2) {
                    System.out.println("Veuillez entre le telephone portable");
                    String telephonePortable = br.readLine();
                    ((Amis) unContact).setTelephoneMobile(telephonePortable());
                }
                break;
            case 9:
                if (unContact.getTypeContact() == 3) {
                    ((Famille) unContact).setDateNaissance(dateNaissance());
                }
                break;
            default:
                choixValide();
                break;

        }
    }

    //methode pour supprimer un contact
    public void supprimerUnContact() throws IOException {

        GestionSQL gSql = new GestionSQL();
        System.out.println("Entrez l'index du contact à supprimer : ");
        String index2 = br.readLine();
        index = Integer.valueOf(index2);

        gSql.suppContact(index);
    }


    /*
     _____________________________________________________________________________________
     */
    public String nom() throws IOException {
        System.out.println("Veuillez entrer le nom");
        String nom = br.readLine();
        return nom;
    }

    public String prenom() throws IOException {
        System.out.println("Veuillez entrer le prenom");
        String prenom = br.readLine();
        return prenom;
    }

    public String telephone() throws IOException {
        System.out.println("Veuillez entrer le telphone");
        String telephone = br.readLine();
        return telephone;
    }

    public String adresse() throws IOException {
        System.out.println("Veuillez entrer l'adresse (numéro et nom de la rue)");
        String adresse = br.readLine();
        return adresse;
    }

    public String codePostal() throws IOException {
        System.out.println("Veuillez entrer le code postal");
        String codePostal = br.readLine();
        return codePostal;
    }

    public String ville() throws IOException {
        System.out.println("Veuillez entre la ville");
        String ville = br.readLine();
        return ville;
    }

    public String mail() throws IOException {
        System.out.println("Veuillez entrer l'adresse mail");
        String mail = br.readLine();
        return mail;
    }

    public String telephonePortable() throws IOException {
        System.out.println("Veuillez entre le telephone portable");
        String telephonePortable = br.readLine();
        return telephonePortable;
    }

    public String dateNaissance() throws IOException {
        System.out.println("Veuillez entrer la date de naissance");
        String dateNaissance = br.readLine();
        return dateNaissance;
    }

    /*
     _____________________________________________________________________________________
     */
    public Connaissance entreeContact(Connaissance unContact) throws IOException {
       
        GestionSQL gesQl = new GestionSQL();

        unContact.setNom(nom());
        
        unContact.setPrenom(prenom());
        unContact.setTelephone(telephone());
        if ((unContact.getNom().isEmpty())
                || (unContact.getPrenom().isEmpty())
                || (unContact.getTelephone().isEmpty())) {
            infoMinimum();
            gestionContact();
        }
        unContact.setAdresseRue(adresse());
        unContact.setCodePostal(codePostal());
        unContact.setVille(ville());
        unContact.setEmail(mail());

        if (unContact.getTypeContact() == 2 || unContact.getTypeContact() == 3) {
            ((Amis) unContact).setTelephoneMobile(telephonePortable());
        }
        if (unContact.getTypeContact() == 3) {
            ((Famille) unContact).setDateNaissance(dateNaissance());
        }
        gesQl.nouvContact(unContact);
        leCarnet.ajouter(unContact);

        return unContact;
    }

    public void menuAccueil() {
        System.out.println("#################################");
        System.out.println("##  Votre carnet d'adresse :   ##");
        System.out.println("##  Que souhaitez vous faire ? ##");
        System.out.println("##  1-Affichage des contact    ##");
        System.out.println("##  2-Ajouter un contact       ##");
        System.out.println("##  3-Modifier un contact      ##");
        System.out.println("##  4-Supprimer un contact     ##");
        System.out.println("##  5-Quitter le carnet        ##");
        System.out.println("##  6-Supprimer Vector (vider) ##");
        System.out.println("#################################");
    }

    public void menuAjoutContact() {
        System.out.println("##################################");
        System.out.println("## 1 - inserer connaissance     ##");
        System.out.println("## 2 - inserer amis             ##");
        System.out.println("## 3 - inserer famille          ##");
        System.out.println("## 4 - Menu principal           ##");
        System.out.println("##################################");
    }

    public int choixSwitch() throws IOException {
        String choixUtil = br.readLine();
        int choixUtilisateur = Integer.valueOf(choixUtil);
        return choixUtilisateur;
    }

    public void choixValide() {
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        System.out.println("§ Veuillez faire un choix valide §");
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
    }

    public void afficherContact() {
        System.out.println("#############################################");
        System.out.println("## Afficher un contacts                    ##");
        System.out.println("## 0 - Afficher le carnet                  ##");
        System.out.println("## 1 - Afficher un contact                 ##");
        System.out.println("## 2 - Afficher carnet par nom             ##");
        System.out.println("## 3 - afficher carnet par code postal     ##");
        System.out.println("## 4 - Afficher carnet par type de contact ##");
        System.out.println("## 5 - Menu principal                      ##");
        System.out.println("#############################################");
    }

    public String nomAfficher() throws IOException {
        System.out.println("###########################################");
        System.out.println("## Entrez le nom du contact              ##");
        System.out.println("###########################################");
        String nomAfficher = br.readLine();
        return nomAfficher;
    }

    public void nomInconnu() {
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        System.out.println("§ Ce nom n'est pas dans le carnet d'adresse §");
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
    }

    public void infoMinimum() {
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        System.out.println("§ Veuillez entrer au minimum le nom, prénom et telephone §");
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
    }

    public void modifContact() {
        System.out.println("##############################################################");
        System.out.println("##                  Modifier un contact                     ##");
        System.out.println("##############################################################");
    }

    public void choixModification() {
        System.out.println("####################################");
        System.out.println("## Que souhaitez vous modifier ?  ##");
        System.out.println("####################################");
    }

    public void choixFamille() {

        System.out.println("###################################");
        System.out.println("## 1 - le nom                    ##");
        System.out.println("## 2 - le prénom                 ##");
        System.out.println("## 3 - le telephone              ##");
        System.out.println("## 4 - l'adresse                 ##");
        System.out.println("## 5 - le code postal            ##");
        System.out.println("## 6 - la ville                  ##");
        System.out.println("## 7 - l'adresse mail            ##");
        System.out.println("## 8 - le telephone portable     ##");
        System.out.println("## 9 - la date de naissance      ##");
        System.out.println("###################################");
    }

    public void choixAmis() {

        System.out.println("###################################");
        System.out.println("## 1 - le nom                    ##");
        System.out.println("## 2 - le prénom                 ##");
        System.out.println("## 3 - le telephone              ##");
        System.out.println("## 4 - l'adresse                 ##");
        System.out.println("## 5 - le code postal            ##");
        System.out.println("## 6 - la ville                  ##");
        System.out.println("## 7 - l'adresse mail            ##");
        System.out.println("## 8 - le telephone portable     ##");
        System.out.println("###################################");
    }

    public void choixConnaissance() {

        System.out.println("###################################");
        System.out.println("## 1 - le nom                    ##");
        System.out.println("## 2 - le prénom                 ##");
        System.out.println("## 3 - le telephone              ##");
        System.out.println("## 4 - l'adresse                 ##");
        System.out.println("## 5 - le code postal            ##");
        System.out.println("## 6 - la ville                  ##");
        System.out.println("## 7 - l'adresse mail            ##");
        System.out.println("###################################");
    }

    public void supprContact() {
        System.out.println("#############################################");
        System.out.println("##          Supprimer un contact           ##");
        System.out.println("## Quel contact souhaitez vous supprimer ? ##");
        System.out.println("#############################################");
    }

    public void auRevoir() {
        System.out.println("#############################################");
        System.out.println("##         Au revoir, à bientôt            ##");
        System.out.println("#############################################");
    }

    public void chargeDriver() {
        //on charge le driver en memoire
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:ClassNotFound: " + ex.getMessage());
        }
    }

//    public void saveContactBDD() {
//
//        Connection connexion = null;
//
//        //on se connecte au serveur
//        try {
//            String url = "jdbc:sqlserver://localhost:1433;"
//                    + "databaseName=CarnetAdresse;user=sa;password=Bidibulle";
//            connexion = DriverManager.getConnection(url);
//        } catch (SQLException ex) {
//            System.err.println("Oops:SQL: " + ex.getErrorCode() + "/" + ex.getMessage());
//        }
//
//        //on envoi le carnet dans le serveur
//        try {
//            Statement stmt = connexion.createStatement();
//
//            for (Connaissance mesContacts : leCarnet.getListContacts()) {
//
//                String nom = mesContacts.getNom();
//                String prenom = mesContacts.getPrenom();
//                String tel = mesContacts.getTelephone();
//                String adresse = mesContacts.getAdresseRue();
//                String codePostal = mesContacts.getCodePostal();
//                String ville = mesContacts.getVille();
//                String mail = mesContacts.getEmail();
//                int typeContact = mesContacts.getTypeContact();
//                String telephonePortable = "?";
//                String dateNaissance = "?";
//                if (mesContacts.getTypeContact() == 2 || mesContacts.getTypeContact() == 3) {
//                    telephonePortable = ((Amis) mesContacts).getTelephoneMobile();
//                }
//                if (mesContacts.getTypeContact() == 3) {
//                    dateNaissance = ((Famille) mesContacts).getDateNaissance();
//                }
//                String query = "INSERT INTO CarnetAdresse VALUES ('" + nom + "','" + prenom + "','" + tel + "','" + adresse + "','" + codePostal + "','" + ville + "','" + mail + "','" + typeContact + "',"
//                        + "'" + telephonePortable + "',"
//                        + "'" + dateNaissance + "')";
//
//                int result = stmt.executeUpdate(query);
//                System.out.println("result=" + result);
//            }
//            stmt.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops:Statement:" + ex.getErrorCode()
//                    + "/" + ex.getMessage());
//        }
//        //on ferme la connexion au serveur
//        try {
//            connexion.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops:Close: " + ex.getErrorCode() + "/" + ex.getMessage());
//        }
//
//    }
//    public void retourContactBDD() {
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (ClassNotFoundException ex) {
//            System.err.println("Oops:ClassNotFound:" + ex.getMessage());
//        }
//
//        Connection connexion = null;
//
//        try {
//            String url = "jdbc:sqlserver://localhost:1433;"
//                    + "databaseName=CarnetAdresse;user=sa;password=sa";
//
//            connexion = DriverManager.getConnection(url);
//        } catch (SQLException ex) {
//            System.err.println("Oops:Connect:" + ex.getErrorCode()
//                    + "/" + ex.getMessage());
//            return;
//        }
//
//        try {
//            Statement stmt = connexion.createStatement(
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//
//            String query = "SELECT * FROM CarnetAdresse;";
//
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                System.out.println(rs.getString("nom") + "/"
//                        + rs.getString("prenom") + "/"
//                        + rs.getString("telephone") + "/"
//                        + rs.getString("") + "/"
//                        + rs.getString("CodePostal") + "/"
//                        + rs.getString("Ville") + "/"
//                        + rs.getString("Email") + "/"
//                        + rs.getString("TypeContact") + "/"
//                        + rs.getString("TelephonePortable") + "/"
//                        + rs.getString("DateNaissance"));
//
//            }
//
//            rs.close();
//            stmt.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops:Statement:" + ex.getErrorCode()
//                    + "/" + ex.getMessage());
//        }
//
//        try {
//            connexion.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops:Close:" + ex.getErrorCode()
//                    + "/" + ex.getMessage());
//        }
//
//        System.out.println("Done!");
//
//    }
}
