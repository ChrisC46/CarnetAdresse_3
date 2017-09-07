/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CDI305
 */
public class JFAffichage extends javax.swing.JFrame {

    /**
     * Creates new form JFAffichage
     */
    public JFAffichage() {
        initComponents();
    }

    GestionSQL gSql = new GestionSQL();
    CarnetAdresse leCarnet = new CarnetAdresse();

//    private DefaultTableModel initTableModel() {
//    return new DefaultTableModel(initCarnetVector());
//    }
//    
//    private Vector initCarnetVector () {
//        Vector v = new Vector();
//        return leCarnet.getListContacts();
//    }
    private DefaultTableModel initTableModel() {
        Vector v = new Vector();
        v.add("iD");
        v.add("Nom");
        v.add("Prenom");
        v.add("Telephone");
        v.add("AdresseRue");
        v.add("CodePostal");
        v.add("Ville");
        v.add("Email");
        v.add("TypeContact");
        v.add("TelephonePortable");
        v.add("DateNaissance");

        return new javax.swing.table.DefaultTableModel(initCarnetVector(), v);
    }

    private Vector initCarnetVector() {
        Vector v = new Vector();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops:C :" + ex.getMessage(), "creation Driver", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Oops:ClassNotFound:" + ex.getMessage());
        }

        Connection connexion = null;

        try {
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=CarnetAdresse;user=sa;password=Bidibulle";

            connexion = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops:Connect :" + ex.getErrorCode(), "creation Driver", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Oops:Connect:" + ex.getErrorCode()
//                    + "/" + ex.getMessage());
            return v;
        }

        String query = "SELECT * FROM CarnetAdresse";
        try {
            Statement stmt = connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Connaissance c = new Connaissance(rs.getString("Nom"),
                        rs.getString("Prenom"), rs.getString("Telephone"),
                        rs.getString("AdresseRue"), rs.getString("CodePostal"),
                        rs.getString("Ville"),
                        rs.getString("Email"),
                        rs.getInt("TypeContact"));
                v.add(c.gerVector());

                Amis a = new Amis(rs.getString("TelephonePortable"));
                v.add(a.gerVector());
                Famille f = new Famille(rs.getString("DateNaissance"));
                v.add(f.gerVector());
                
                
//                Vector vv = new Vector();
//
////                vv.add(rs.getString("Pays"));
//                vv.add(new Pays(rs.getString("Pays"),
//                        rs.getString("A2"),
//                        rs.getString("A3"),
//                        rs.getInt("Number")));
//
//                vv.add(rs.getString("A2"));
//                vv.add(rs.getString("A3"));
//                vv.add(rs.getString("Number"));
//
//                v.add(vv);
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops:SQL :" + ex.getErrorCode() + ":" + ex.getMessage(), "creation Driver", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Oops:SQL:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

        try {
            connexion.close();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Oops:Close :" + ex.getErrorCode() + ":" + ex.getMessage(), "creation Driver", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Oops:Close:" + ex.getErrorCode() + ":" + ex.getMessage());
            return v;
        }

//        System.out.println("Done!");
        return v;

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(null);

        jTable1.setModel(initTableModel());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 680, 460);

        setSize(new java.awt.Dimension(715, 515));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAffichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAffichage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
