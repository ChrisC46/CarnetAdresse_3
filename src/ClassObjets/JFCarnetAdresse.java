/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassObjets;

/**
 *
 * @author CDI305
 */
public class JFCarnetAdresse extends javax.swing.JFrame {

    /**
     * Creates new form JFCarnetAdresse
     */
    public JFCarnetAdresse() {
        initComponents();
        gSql.chargeDriver();
        gSql.synContact();

    }

    GestionSQL gSql = new GestionSQL();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAffichage = new javax.swing.JButton();
        jButtonAjoutContact = new javax.swing.JButton();
        jButtonModifContact = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Mon carnet");
        setBackground(new java.awt.Color(0, 51, 102));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU D'ACCUEIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("ici faite votre choix");
        jPanel1.setLayout(null);

        jButtonAffichage.setBackground(new java.awt.Color(0, 102, 153));
        jButtonAffichage.setText("Afficher les contacts");
        jButtonAffichage.setToolTipText("Cliquez pour afficher les contacts");
        jButtonAffichage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAffichageActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAffichage);
        jButtonAffichage.setBounds(20, 90, 220, 40);

        jButtonAjoutContact.setBackground(new java.awt.Color(0, 102, 153));
        jButtonAjoutContact.setText("Ajouter un contact");
        jButtonAjoutContact.setToolTipText("Cliquez pour ajouter un contact");
        jButtonAjoutContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutContactActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAjoutContact);
        jButtonAjoutContact.setBounds(140, 190, 220, 40);

        jButtonModifContact.setBackground(new java.awt.Color(0, 102, 153));
        jButtonModifContact.setText("Modifier/Supprimer un contact");
        jButtonModifContact.setToolTipText("Cliquez pour modifier un contact");
        jButtonModifContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifContactActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModifContact);
        jButtonModifContact.setBounds(250, 300, 220, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 40, 500, 460);

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CARNET D'ADRESSE");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 220, 30);

        setSize(new java.awt.Dimension(551, 549));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjoutContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutContactActionPerformed
        JFAjoutContact ajout = new JFAjoutContact();
        ajout.setVisible(true);
    }//GEN-LAST:event_jButtonAjoutContactActionPerformed

    private void jButtonModifContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifContactActionPerformed
        JFSuppContacts supmodif = new JFSuppContacts();
        supmodif.setVisible(true);
    }//GEN-LAST:event_jButtonModifContactActionPerformed

    private void jButtonAffichageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAffichageActionPerformed
        JFAffichage affichage = new JFAffichage();
        affichage.setVisible(true);
    }//GEN-LAST:event_jButtonAffichageActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAffichage;
    private javax.swing.JButton jButtonAjoutContact;
    private javax.swing.JButton jButtonModifContact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
