package ClassObjets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionSQL {

    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=CarnetAdresse;user=sa;password=sa";

    CarnetAdresse leCarnet = new CarnetAdresse();
   

    public void chargeDriver() {

        //on charge le driver en memoire
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.err.println("Oops:ClassNotFound: " + ex.getMessage());
        }
    }

    public void synContact() {

        ResultSet res = null;

        try (Connection conx = DriverManager.getConnection(url); Statement stmt = conx.createStatement();) {

            res = stmt.executeQuery("SELECT * FROM CarnetAdresse");

            while (res.next()) {

                Connaissance unContact = null;
                if (res.getInt("typeContact") == 3) {
                    unContact = new Famille();
                } else if (res.getInt("typeContact") == 2) {
                    unContact = new Amis();
                } else {
                    unContact = new Connaissance();
                }
                unContact.setiD(res.getInt("iD"));
                unContact.setNom(res.getString("nom"));
                unContact.setPrenom(res.getString("prenom"));
                unContact.setTelephone(res.getString("telephone"));
                unContact.setAdresseRue(res.getString("adresseRue"));
                unContact.setCodePostal(res.getString("codePostal"));
                unContact.setVille(res.getString("ville"));
                unContact.setEmail(res.getString("Email"));
                if (res.getInt("typeContact") == 2 || res.getInt("typeContact") == 3) {
                    ((Amis) unContact).setTelephoneMobile(res.getString("telephonePortable"));
                }
                if (res.getInt("typeContact") == 3) {
                    ((Famille) unContact).setDateNaissance(res.getString("dateNaissance"));
                }
                leCarnet.ajouter(unContact);
            }
            res.close();
        } catch (SQLException e) {
            System.err.println("Erreur de sync" + e.getMessage());

        }

    }

    public void nouvContact(Connaissance unContact) {
       


        try (Connection connx = DriverManager.getConnection(url); Statement stmt = connx.createStatement();) {

            String nom = unContact.getNom();
            String prenom = unContact.getPrenom();
            String telephone = unContact.getTelephone();
            String adresseRue = unContact.getAdresseRue();
            String codePostal = unContact.getCodePostal();
            String ville = unContact.getVille();
            String email = unContact.getEmail();
            String telephonePortable = "";
            int typeContact = unContact.getTypeContact();
            if (unContact.getTypeContact() == 2 || unContact.getTypeContact() == 3) {
                telephonePortable = ((Amis) unContact).getTelephoneMobile();
            }
            String dateNaissance = "";
            if (unContact.getTypeContact() == 3) {
                dateNaissance = ((Famille) unContact).getDateNaissance();
            }
          String query = "INSERT INTO CarnetAdresse VALUES "
                    + "('" + nom + "','" + prenom + "','" + telephone + "','" + adresseRue + "','" + codePostal + "','" + ville + "','" + email + "','" + typeContact
                    + "','" + telephonePortable
                    + "','" + dateNaissance + "')";
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Erreur nouvContact" + ex.getMessage());
        }
    }

    public void majContact(String colonne, String modif, int index) {
        String query = "UPDATE CarnetAdresse SET " + colonne + "='" + modif + "' WHERE id = '" + (index) + "'";
        try (Connection connx = DriverManager.getConnection(url); Statement stmt = connx.createStatement();) {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Erreur de modification " + ex.getMessage());
        }

    }

    public void suppContact(int index) {
        String query = "DELETE FROM CarnetAdresse WHERE iD = '" + index + "'";
        try (Connection connx = DriverManager.getConnection(url); Statement stmt = connx.createStatement();) {
            stmt.execute(query);
        } catch (SQLException ex) {
            System.err.println("Erreur de suppression" + ex.getMessage());
        }
    }

    public void saveContactBDD() {

        Connection connexion = null;

        //on se connecte au serveur
        try {
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=CarnetAdresse;user=sa;password=sa";
            connexion = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.err.println("Oops:SQL: " + ex.getErrorCode() + "/" + ex.getMessage());
        }

        //on envoi le carnet dans le serveur
        try {
            Statement stmt = connexion.createStatement();

            for (Connaissance mesContacts : leCarnet.getListContacts()) {

                String nom = mesContacts.getNom();
                String prenom = mesContacts.getPrenom();
                String tel = mesContacts.getTelephone();
                String adresse = mesContacts.getAdresseRue();
                String codePostal = mesContacts.getCodePostal();
                String ville = mesContacts.getVille();
                String mail = mesContacts.getEmail();
                int typeContact = mesContacts.getTypeContact();
                String telephonePortable = "?";
                String dateNaissance = "?";
                if (mesContacts.getTypeContact() == 2 || mesContacts.getTypeContact() == 3) {
                    telephonePortable = ((Amis) mesContacts).getTelephoneMobile();
                }
                if (mesContacts.getTypeContact() == 3) {
                    dateNaissance = ((Famille) mesContacts).getDateNaissance();
                }
                String query = "INSERT INTO CarnetAdresse VALUES ('" + nom + "','" + prenom + "','" + tel + "','" + adresse + "','" + codePostal + "','" + ville + "','" + mail + "','" + typeContact + "',"
                        + "'" + telephonePortable + "',"
                        + "'" + dateNaissance + "')";

                int result = stmt.executeUpdate(query);
                System.out.println("result=" + result);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:Statement:" + ex.getErrorCode()
                    + "/" + ex.getMessage());
        }

    }

    public void synchroCarnet() {
        leCarnet.supprimerCarnet();
        chargeDriver();
        synContact();
        
    }
}

//
//    public void deconnexion() {
//
//        try {
//            connexion.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops: Close : " + ex.getErrorCode() + " / " + ex.getMessage());
//        }
//
//    }
//}
