/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controller.ClientController;
import domain.Grupa;
import domain.Polaznik;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.TableModelListaPolaznika;

/**
 *
 * @author Neon
 */
public class FormDodajPolaznika extends javax.swing.JDialog {

    /**
     * Creates new form FormDodajPolaznika
     */
    private Grupa g;
    
    public FormDodajPolaznika(java.awt.Frame parent, boolean modal, Grupa g) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.g = g;
        lblGrupa.setText(g.toString());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDatumUpisivanja = new javax.swing.JTextField();
        btnOtkazi = new javax.swing.JButton();
        btnDodajPolaznika = new javax.swing.JButton();
        lblGrupa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Telefon:");

        jLabel4.setText("Email:");

        jLabel5.setText("Datum upisivanja: (dd.MM.yyyy)");

        txtDatumUpisivanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumUpisivanjaActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnDodajPolaznika.setText("Dodaj polaznika");
        btnDodajPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPolaznikaActionPerformed(evt);
            }
        });

        lblGrupa.setText("Grupa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(btnDodajPolaznika, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(116, 116, 116)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumUpisivanja)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblGrupa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblGrupa)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDatumUpisivanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnDodajPolaznika))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatumUpisivanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumUpisivanjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumUpisivanjaActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnDodajPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPolaznikaActionPerformed
         try {
            
            if (txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty()
                    || txtEmail.getText().isEmpty() || txtTelefon.getText().isEmpty()
                    || txtDatumUpisivanja.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }

            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            String email = txtEmail.getText();
            String telefon = txtTelefon.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            if (!email.endsWith(".com") && !email.endsWith(".rs")) {
                JOptionPane.showMessageDialog(this, "Email mora biti u odgovarajucem formatu!");
                return;
            }
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Email mora biti u odgovarajucem formatu!");
                return;
            }

            try {
                int tel = Integer.parseInt(telefon);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Telefon mora biti unet bez +,- i slicno. Primer: 0615010235");
                return;
            }
            
            try {
                Date datumUpisivanja = sdf.parse(txtDatumUpisivanja.getText());
                
                //validacija za datum:
                if(datumUpisivanja.after(new Date())){
                    JOptionPane.showMessageDialog(this, "Datum upisa moze biti najkasnije danas.");
                    return;
                }
                
                Polaznik p = new Polaznik(-1, ime, prezime, telefon, email, datumUpisivanja, this.g);

                ArrayList<Polaznik> listaPolaznika = ClientController.getInstance().getAllPolaznik();

                for (Polaznik polaznik : listaPolaznika) {
                    if (polaznik.equals(p) || polaznik.getEmail().equals(p.getEmail())) {
                        JOptionPane.showMessageDialog(this, "Polaznik vec postoji!");
                        return;
                    }
                }
                
                ClientController.getInstance().addPolaznik(p);
                JOptionPane.showMessageDialog(this, "Uspesno dodat polaznik.");
                this.dispose();
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(this, "Datum mora biti u formatu dd.MM.yyyy!");
                return;
            }

        } catch (Exception ex) {
            Logger.getLogger(FormDodajPolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajPolaznikaActionPerformed

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
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
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
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDodajPolaznika.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPolaznika;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblGrupa;
    private javax.swing.JTextField txtDatumUpisivanja;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
