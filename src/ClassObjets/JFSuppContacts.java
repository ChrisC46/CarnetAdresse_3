/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjets;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author CDI305
 */
public class JFSuppContacts extends javax.swing.JFrame {

    /**
     * Creates new form JFSuppContacts
     */
    public JFSuppContacts() {
        initComponents();
       
    }

    GestionSQL gSql = new GestionSQL();
    CarnetAdresse leCarnet = new CarnetAdresse();

    private DefaultComboBoxModel initContactModel() {
        return new DefaultComboBoxModel(initleCarnet());
    }

    private Vector initleCarnet() {
        Vector v = new Vector();
        return leCarnet.getListContacts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonSupprimer = new javax.swing.JButton();
        jComboBoxCarnet = new javax.swing.JComboBox();
        jButtonModifier = new javax.swing.JButton();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelAdresseRue = new javax.swing.JLabel();
        jLabelTelMobile = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTelephone = new javax.swing.JTextField();
        jTextFieldAdresseRue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodePostal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldVille = new javax.swing.JTextField();
        jTextFieldTelMobile = new javax.swing.JTextField();
        jLabelDateNaissance = new javax.swing.JLabel();
        jTextFieldDateNaissance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modifier / Supprimer un contact", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(null);

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSupprimer);
        jButtonSupprimer.setBounds(320, 420, 170, 30);

        jComboBoxCarnet.setModel(initContactModel());
        jComboBoxCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCarnetActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCarnet);
        jComboBoxCarnet.setBounds(180, 30, 200, 50);

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonModifier);
        jButtonModifier.setBounds(100, 420, 160, 30);

        jLabelNom.setText("Nom :");
        jPanel2.add(jLabelNom);
        jLabelNom.setBounds(20, 90, 60, 30);

        jLabelPrenom.setText("Prenom :");
        jPanel2.add(jLabelPrenom);
        jLabelPrenom.setBounds(250, 90, 100, 30);

        jLabel5.setText("Telephone : ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 150, 120, 30);

        jLabelAdresseRue.setText("Adresse :");
        jPanel2.add(jLabelAdresseRue);
        jLabelAdresseRue.setBounds(250, 150, 150, 30);

        jLabelTelMobile.setText("Tel Mobile :");
        jPanel2.add(jLabelTelMobile);
        jLabelTelMobile.setBounds(250, 280, 120, 30);

        jTextFieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldNom);
        jTextFieldNom.setBounds(60, 120, 170, 30);

        jTextFieldPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrenomActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldPrenom);
        jTextFieldPrenom.setBounds(310, 120, 230, 30);

        jLabel2.setText("Selectionner le contact :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 30, 120, 50);

        jTextFieldTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelephoneActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldTelephone);
        jTextFieldTelephone.setBounds(60, 180, 170, 30);

        jTextFieldAdresseRue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdresseRueActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldAdresseRue);
        jTextFieldAdresseRue.setBounds(310, 180, 230, 30);

        jLabel3.setText("CodePostal :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 220, 160, 30);

        jTextFieldCodePostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodePostalActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldCodePostal);
        jTextFieldCodePostal.setBounds(60, 250, 170, 30);

        jLabel4.setText("Ville :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(260, 220, 150, 30);

        jTextFieldVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVilleActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldVille);
        jTextFieldVille.setBounds(310, 250, 230, 30);

        jTextFieldTelMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelMobileActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldTelMobile);
        jTextFieldTelMobile.setBounds(310, 310, 230, 30);

        jLabelDateNaissance.setText("Date de naissance :");
        jPanel2.add(jLabelDateNaissance);
        jLabelDateNaissance.setBounds(150, 340, 170, 30);

        jTextFieldDateNaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateNaissanceActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldDateNaissance);
        jTextFieldDateNaissance.setBounds(170, 370, 230, 30);

        jLabel8.setText("Email :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 280, 120, 30);

        jTextFieldMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMailActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldMail);
        jTextFieldMail.setBounds(60, 310, 170, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 10, 590, 460);

        setSize(new java.awt.Dimension(614, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
       int result = JOptionPane.showConfirmDialog(null, "confirmez la suppression du contact selectionné", "Suppression Contact", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (result == JOptionPane.CANCEL_OPTION) {
            
        } if(result == JOptionPane.OK_OPTION) {
            Connaissance unContact = null;
            unContact = (Connaissance) jComboBoxCarnet.getSelectedItem();
            gSql.suppContact(unContact.getiD());
            synchroCarnet();
            nettoyage();
        }
        if(result == JOptionPane.CLOSED_OPTION)
            nettoyage();
    }//GEN-LAST:event_jButtonSupprimerActionPerformed
   
    private void jComboBoxCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCarnetActionPerformed

        Connaissance unContact = null;
        unContact = (Connaissance) jComboBoxCarnet.getSelectedItem();

        if (unContact.getTypeContact() == 2 || unContact.getTypeContact() == 3) {
            jTextFieldTelMobile.setVisible(true);
            jLabelTelMobile.setVisible(true);
            jTextFieldDateNaissance.setVisible(false);
            jLabelDateNaissance.setVisible(false);
        }
        if (unContact.getTypeContact() == 3) {
            jTextFieldTelMobile.setVisible(true);
            jLabelTelMobile.setVisible(true);
            jTextFieldDateNaissance.setVisible(true);
            jLabelDateNaissance.setVisible(true);
        } else {
            jTextFieldTelMobile.setVisible(false);
            jLabelTelMobile.setVisible(false);
            jTextFieldDateNaissance.setVisible(false);
            jLabelDateNaissance.setVisible(false);
        }

        jTextFieldNom.setText(unContact.getNom());
        jTextFieldPrenom.setText(unContact.getPrenom());
        jTextFieldTelephone.setText(unContact.getTelephone());
        jTextFieldAdresseRue.setText(unContact.getAdresseRue());
        jTextFieldCodePostal.setText(unContact.getCodePostal());
        jTextFieldVille.setText(unContact.getVille());
        jTextFieldMail.setText(unContact.getEmail());
        if (unContact.getTypeContact() == 2 || unContact.getTypeContact() == 3) {
            jTextFieldTelMobile.setText(((Amis) unContact).getTelephoneMobile());

        }
        if (unContact.getTypeContact() == 3) {
            jTextFieldDateNaissance.setText(((Famille) unContact).getDateNaissance());
        }
    }//GEN-LAST:event_jComboBoxCarnetActionPerformed

    public void synchroCarnet() {
        leCarnet.supprimerCarnet();
        gSql.chargeDriver();
        gSql.synContact();
        jComboBoxCarnet.setModel(initContactModel());
    }

    public void nettoyage() {
        jTextFieldNom.setText("");
        jTextFieldPrenom.setText("");
        jTextFieldTelephone.setText("");
        jTextFieldAdresseRue.setText("");
        jTextFieldCodePostal.setText("");
        jTextFieldVille.setText("");
        jTextFieldMail.setText("");
        jTextFieldTelMobile.setText("");
        jTextFieldDateNaissance.setText("");
    }

    private void jTextFieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomActionPerformed

    private void jTextFieldPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrenomActionPerformed

    private void jTextFieldTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelephoneActionPerformed

    private void jTextFieldTelMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelMobileActionPerformed

    private void jTextFieldAdresseRueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdresseRueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdresseRueActionPerformed

    private void jTextFieldCodePostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodePostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodePostalActionPerformed

    private void jTextFieldVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVilleActionPerformed

    private void jTextFieldDateNaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateNaissanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateNaissanceActionPerformed
    String colonne = null;
    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        // TODO add your handling code here:
        Connaissance unContact = null;
        unContact = (Connaissance) jComboBoxCarnet.getSelectedItem();

        colonne = "Nom";
        String nom = jTextFieldNom.getText();
        gSql.majContact(colonne, nom, unContact.getiD());

        colonne = "Prenom";
        String prenom = jTextFieldPrenom.getText();
        gSql.majContact(colonne, prenom, unContact.getiD());

        colonne = "Telephone";
        String telephone = jTextFieldTelephone.getText();
        gSql.majContact(colonne, telephone, unContact.getiD());

        colonne = "AdresseRue";
        String adresse = jTextFieldAdresseRue.getText();
        gSql.majContact(colonne, adresse, unContact.getiD());

        colonne = "CodePostal";
        String codePostal = jTextFieldCodePostal.getText();
        gSql.majContact(colonne, codePostal, unContact.getiD());

        colonne = "Ville";
        String ville = jTextFieldVille.getText();
        gSql.majContact(colonne, ville, unContact.getiD());

        colonne = "Email";
        String mail = jTextFieldMail.getText();
        gSql.majContact(colonne, mail, unContact.getiD());

        if (unContact.getTypeContact() == 2 || unContact.getTypeContact() == 3) {
            colonne = "TelephonePortable";
            String telPortable = jTextFieldTelMobile.getText();
            gSql.majContact(colonne, telPortable, unContact.getiD());

        }
        if (unContact.getTypeContact() == 3) {
            jTextFieldDateNaissance.setText(((Famille) unContact).getDateNaissance());
            colonne = "DateNaissance";
            String dateNaissance = jTextFieldDateNaissance.getText();
            gSql.majContact(colonne, dateNaissance, unContact.getiD());
        }

        synchroCarnet();
        nettoyage();
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jTextFieldMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMailActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBoxCarnet;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAdresseRue;
    private javax.swing.JLabel jLabelDateNaissance;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelTelMobile;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldAdresseRue;
    private javax.swing.JTextField jTextFieldCodePostal;
    private javax.swing.JTextField jTextFieldDateNaissance;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldTelMobile;
    private javax.swing.JTextField jTextFieldTelephone;
    private javax.swing.JTextField jTextFieldVille;
    // End of variables declaration//GEN-END:variables
}
