/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import FormAdministrator.FormNoviAdministrator;
import FormAdministrator.FormPretragaAdministratora;
import FormKurs.FormNoviKurs;
import forms.*;
import FormKurs.FormPretragaKursa;
import FormPolaznik.FormNoviPolaznik;
import FormPolaznik.FormPretragaPolaznika;
import FormPredavac.FormNoviPredavac;
import FormPredavac.FormPretragaPredavaca;
import com.sun.security.ntlm.Client;
import controller.ClientController;
import domain.Administrator;
import domain.Grupa;
import domain.Kurs;
import domain.Polaznik;
import domain.Predavac;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelGrupe;
import session.Session;

/**
 *
 * @author Neon
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        vratiKurseve();
        vratiPredavace();
        TableModelGrupe model = new TableModelGrupe();
        Thread th = new Thread(model);
        th.start();
        tblGrupa.setModel(model);
        Administrator a = Session.getInstance().getTrenutnoUlogovaniAdministrator();
        lblUlogovani.setText("Trenutno ulogovani administrator: "
                + a.getImeAdministratora() + " " + a.getPrezimeAdministratora());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        lblUlogovani = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNazivGrupe = new javax.swing.JTextField();
        txtMaxBrojPolaznika = new javax.swing.JTextField();
        cbKurs = new javax.swing.JComboBox();
        cbPredavac = new javax.swing.JComboBox();
        btnDodajGrupu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrupa = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();
        btnObrisiGrupu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAdministratori = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jmKursevi = new javax.swing.JMenu();
        jmiNoviKurs = new javax.swing.JMenuItem();
        jmiPretragaKurseva = new javax.swing.JMenuItem();
        jmPredavaci = new javax.swing.JMenu();
        jmiNoviPredavac = new javax.swing.JMenuItem();
        jmiPretragaPredavaca = new javax.swing.JMenuItem();
        jmPolaznici = new javax.swing.JMenu();
        jmiNoviPolaznik = new javax.swing.JMenuItem();
        jmiPretragaPolaznika = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenu5.setText("jMenu5");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        lblUlogovani.setText("Ulogovani");

        jLabel1.setText("Naziv grupe:");

        jLabel2.setText("Maksimalan broj polaznika:");

        jLabel3.setText("Kurs:");

        jLabel4.setText("Predavac:");

        cbKurs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPredavac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodajGrupu.setText("Dodaj grupu");
        btnDodajGrupu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajGrupuActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga grupa:"));

        jLabel5.setText("Pretraga:");

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        tblGrupa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblGrupa);

        btnDetalji.setText("Detalji grupe");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        btnObrisiGrupu.setText("Obrisi izabranu grupu");
        btnObrisiGrupu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiGrupuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisiGrupu, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiGrupu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jmAdministratori.setText("Administratori");

        jMenuItem9.setText("Novi administrator");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmAdministratori.add(jMenuItem9);

        jMenuItem10.setText("Pretraga administratora");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jmAdministratori.add(jMenuItem10);

        jMenuBar1.add(jmAdministratori);

        jmKursevi.setText("Kursevi");

        jmiNoviKurs.setText("Novi kurs");
        jmiNoviKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNoviKursActionPerformed(evt);
            }
        });
        jmKursevi.add(jmiNoviKurs);

        jmiPretragaKurseva.setText("Pretraga kurseva");
        jmiPretragaKurseva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaKursevaActionPerformed(evt);
            }
        });
        jmKursevi.add(jmiPretragaKurseva);

        jMenuBar1.add(jmKursevi);

        jmPredavaci.setText("Predavaci");

        jmiNoviPredavac.setText("Novi predavac");
        jmiNoviPredavac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNoviPredavacActionPerformed(evt);
            }
        });
        jmPredavaci.add(jmiNoviPredavac);

        jmiPretragaPredavaca.setText("Pretraga predavaca");
        jmiPretragaPredavaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaPredavacaActionPerformed(evt);
            }
        });
        jmPredavaci.add(jmiPretragaPredavaca);

        jMenuBar1.add(jmPredavaci);

        jmPolaznici.setText("Polaznici");

        jmiNoviPolaznik.setText("Novi polaznik");
        jmiNoviPolaznik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNoviPolaznikActionPerformed(evt);
            }
        });
        jmPolaznici.add(jmiNoviPolaznik);

        jmiPretragaPolaznika.setText("Pretraga polaznika");
        jmiPretragaPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaPolaznikaActionPerformed(evt);
            }
        });
        jmPolaznici.add(jmiPretragaPolaznika);

        jMenuBar1.add(jmPolaznici);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbKurs, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaxBrojPolaznika, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNazivGrupe, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbPredavac, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(444, 444, 444)
                                .addComponent(btnDodajGrupu, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblUlogovani)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(583, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblUlogovani)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNazivGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxBrojPolaznika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPredavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addComponent(btnDodajGrupu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormNoviAdministrator(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormPretragaAdministratora(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jmiNoviKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNoviKursActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormNoviKurs(this, true).setVisible(true);
            osveziTabelu();
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jmiNoviKursActionPerformed

    private void jmiPretragaKursevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaKursevaActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormPretragaKursa(this, true).setVisible(true);
            osveziTabelu();
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jmiPretragaKursevaActionPerformed

    private void jmiPretragaPredavacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaPredavacaActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormPretragaPredavaca(this, true).setVisible(true);
            osveziTabelu();
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jmiPretragaPredavacaActionPerformed

    private void jmiNoviPredavacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNoviPredavacActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormNoviPredavac(this, true).setVisible(true);
            osveziTabelu();
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jmiNoviPredavacActionPerformed

    private void jmiNoviPolaznikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNoviPolaznikActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormNoviPolaznik(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jmiNoviPolaznikActionPerformed

    private void jmiPretragaPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaPolaznikaActionPerformed
        if (Session.getInstance().getTrenutnoUlogovaniAdministrator().getAdministratorID() == 1) {
            new FormPretragaPolaznika(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nemate pristup ovoj operaciji!");
        }
    }//GEN-LAST:event_jmiPretragaPolaznikaActionPerformed


    private void btnDodajGrupuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajGrupuActionPerformed
        try {
            if (txtNazivGrupe.getText().isEmpty() || txtMaxBrojPolaznika.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }

            String nazivGrupe = txtNazivGrupe.getText();

            try {
                int maxBrojPolaznika = Integer.parseInt(txtMaxBrojPolaznika.getText());
                Kurs k = (Kurs) cbKurs.getSelectedItem();
                Predavac p = (Predavac) cbPredavac.getSelectedItem();

                Grupa g = new Grupa(-1, nazivGrupe, maxBrojPolaznika, k, p);

                ArrayList<Grupa> listaGrupa = ClientController.getInstance().getAllGrupa();
                for (Grupa grupa : listaGrupa) {
                    if (grupa.equals(g)) {
                        JOptionPane.showMessageDialog(this, "Grupa vec postoji!");
                        return;
                    }
                }

                ClientController.getInstance().addGrupa(g);
                JOptionPane.showMessageDialog(this, "Uspesno dodata grupa.");
                txtMaxBrojPolaznika.setText("");
                txtNazivGrupe.setText("");

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "U polje za maksimalni broj polaznika morate uneti broj!");
                return;
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNoviPredavac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajGrupuActionPerformed

    private void btnObrisiGrupuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiGrupuActionPerformed
        try {
            TableModelGrupe model = (TableModelGrupe) tblGrupa.getModel();
            int row = tblGrupa.getSelectedRow();
            if (row < 0) {
                return;
            }

            model.obrisiGrupu(row, this);
            
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnObrisiGrupuActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int row = tblGrupa.getSelectedRow();
        if (row >= 0) {
            Grupa g
                    = ((TableModelGrupe) tblGrupa.getModel()).getSelectedGrupa(row);
            new FormIzmenaGrupe(this, rootPaneCheckingEnabled, g).setVisible(true);
           
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String param = txtPretraga.getText();
        ((TableModelGrupe) tblGrupa.getModel()).setParametar(param);

    }//GEN-LAST:event_txtPretragaKeyReleased

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnDodajGrupu;
    private javax.swing.JButton btnObrisiGrupu;
    private javax.swing.JComboBox cbKurs;
    private javax.swing.JComboBox cbPredavac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmAdministratori;
    private javax.swing.JMenu jmKursevi;
    private javax.swing.JMenu jmPolaznici;
    private javax.swing.JMenu jmPredavaci;
    private javax.swing.JMenuItem jmiNoviKurs;
    private javax.swing.JMenuItem jmiNoviPolaznik;
    private javax.swing.JMenuItem jmiNoviPredavac;
    private javax.swing.JMenuItem jmiPretragaKurseva;
    private javax.swing.JMenuItem jmiPretragaPolaznika;
    private javax.swing.JMenuItem jmiPretragaPredavaca;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JTable tblGrupa;
    private javax.swing.JTextField txtMaxBrojPolaznika;
    private javax.swing.JTextField txtNazivGrupe;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void vratiKurseve() {
        ArrayList<Kurs> listaKurseva = new ArrayList<>();

        try {
            listaKurseva = ClientController.getInstance().getAllKurs();
            cbKurs.removeAllItems();
            for (Kurs kurs : listaKurseva) {
                cbKurs.addItem(kurs);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vratiPredavace() {
        ArrayList<Predavac> listaPredavaca = new ArrayList<>();

        try {
            listaPredavaca = ClientController.getInstance().getAllPredavac();
            cbPredavac.removeAllItems();
            for (Predavac predavac : listaPredavaca) {
                cbPredavac.addItem(predavac);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void osveziTabelu() {
        vratiPredavace();
        vratiKurseve();
//        TableModelGrupe model = (TableModelGrupe) tblGrupa.getModel();
//        model.fireTableDataChanged();
    }

}
