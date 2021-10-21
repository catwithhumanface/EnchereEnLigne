/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package enchere.vue;

import enchere.controler.GestionMembresControler;
import enchere.model.Membre;
import enchere.model.MembreClient;
import enchere.model.MembreServiceCommercial;
import enchere.model.MembreServiceInformatique;
import enchere.model.MembreServiceJuridique;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joohyunann
 */
public class Index extends javax.swing.JFrame {
    private GestionMembresControler membreControler;
    private Membre membre;
    private javax.swing.JLabel jLabelPrenom;
    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        membreControler = new GestionMembresControler();
        jButtonStats.setVisible(false);
        jButtonMisEnVente.setVisible(false);
        jButtonConsulterMesParticipations.setVisible(false);
    }
    
    public Index(Membre membre){
        initComponents();
        jButtonConnexion.setVisible(false);
        jButtonSinscrire.setVisible(false);
        jButtonMisEnVente.setVisible(false);
        this.membre = membre;
        jButtonStats.setVisible(false);
        jButtonConsulterMesParticipations.setVisible(false);
        if(this.membre instanceof MembreServiceCommercial){
            jButtonStats.setVisible(true);
        }else if(this.membre instanceof MembreClient){
            jButtonConsulterMesParticipations.setVisible(true);
            jButtonMisEnVente.setVisible(true);
        }
        
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelAccueil = new javax.swing.JPanel();
        jButtonConnexion = new javax.swing.JButton();
        jButtonSinscrire = new javax.swing.JButton();
        jButtonConsulteEncheres = new javax.swing.JButton();
        jButtonStats = new javax.swing.JButton();
        jButtonMisEnVente = new javax.swing.JButton();
        jButtonConsulterMesParticipations = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelAccueil.setBackground(new java.awt.Color(0, 153, 153));

        jButtonConnexion.setText("Connexion");
        jButtonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnexionActionPerformed(evt);
            }
        });

        jButtonSinscrire.setText("S'inscrire");
        jButtonSinscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSinscrireActionPerformed(evt);
            }
        });

        jButtonConsulteEncheres.setText("Consulter toutes les encheres en cours");
        jButtonConsulteEncheres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsulteEncheresActionPerformed(evt);
            }
        });

        jButtonStats.setText("Consulter les statistiques");
        jButtonStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatsActionPerformed(evt);
            }
        });

        jButtonMisEnVente.setText("Mettre en vente d'un objet");
        jButtonMisEnVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMisEnVenteActionPerformed(evt);
            }
        });

        jButtonConsulterMesParticipations.setText("Consulter mes participations aux encheres");
        jButtonConsulterMesParticipations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsulterMesParticipationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAccueilLayout = new javax.swing.GroupLayout(jPanelAccueil);
        jPanelAccueil.setLayout(jPanelAccueilLayout);
        jPanelAccueilLayout.setHorizontalGroup(
            jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccueilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccueilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonSinscrire))
                    .addComponent(jButtonConnexion))
                .addGap(17, 17, 17))
            .addGroup(jPanelAccueilLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonMisEnVente)
                    .addComponent(jButtonStats))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelAccueilLayout.createSequentialGroup()
                .addGroup(jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccueilLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButtonConsulteEncheres))
                    .addGroup(jPanelAccueilLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButtonConsulterMesParticipations)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanelAccueilLayout.setVerticalGroup(
            jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccueilLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonConnexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSinscrire)
                .addGap(29, 29, 29)
                .addComponent(jButtonConsulterMesParticipations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConsulteEncheres)
                .addGap(18, 18, 18)
                .addComponent(jButtonMisEnVente)
                .addGap(18, 18, 18)
                .addComponent(jButtonStats)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAccueil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsulteEncheresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsulteEncheresActionPerformed
        ConsulterEncheres consulterEncheres;
        if(membre!=null){
            consulterEncheres = new ConsulterEncheres(membre);
        }else{
            consulterEncheres = new ConsulterEncheres();
        }
        consulterEncheres.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConsulteEncheresActionPerformed

    private void jButtonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnexionActionPerformed

        Connexion c = new Connexion();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConnexionActionPerformed

    private void jButtonSinscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSinscrireActionPerformed
        Inscription inscription = new Inscription();
        inscription.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSinscrireActionPerformed

    private void jButtonStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatsActionPerformed
        try {
            // TODO add your handling code here:
            StatsVue statVue= new StatsVue();
            statVue.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonStatsActionPerformed

    private void jButtonMisEnVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMisEnVenteActionPerformed
        // TODO add your handling code here:
        MisEnVente misEnvente = new MisEnVente((MembreClient)this.membre);
        misEnvente.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonMisEnVenteActionPerformed

    private void jButtonConsulterMesParticipationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsulterMesParticipationsActionPerformed
        // TODO add your handling code here:
        ConsulterMesEncheres consulterMesEncheres = new ConsulterMesEncheres((MembreClient)this.membre);
        consulterMesEncheres.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConsulterMesParticipationsActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JButton jButtonConsulteEncheres;
    private javax.swing.JButton jButtonConsulterMesParticipations;
    private javax.swing.JButton jButtonMisEnVente;
    private javax.swing.JButton jButtonSinscrire;
    private javax.swing.JButton jButtonStats;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAccueil;
    // End of variables declaration//GEN-END:variables
}

