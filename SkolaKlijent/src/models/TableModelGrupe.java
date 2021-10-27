/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Grupa;
import domain.Polaznik;
import forms.MainForm;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neon
 */
public class TableModelGrupe extends AbstractTableModel implements Runnable{

    private List<Grupa> lista;
    private String[] kolone = {"ID", "Naziv grupe", "Max broj polaznika", "Predavac", "Kurs"};
    private String parametar = "";
    
    public TableModelGrupe() {
        try {
            lista = ClientController.getInstance().getAllGrupa();
        } catch (Exception ex) {
            Logger.getLogger(TableModelGrupe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Grupa g = lista.get(row);
        
        switch(column){
            case 0: return g.getGrupaID();
            case 1: return g.getNazivGrupe();
            case 2: return g.getMaxBrojPolaznika();
            case 3: return g.getPredavac();
            case 4: return g.getKurs();
            
            default: return null;
        }
    }
    
    public Grupa getSelectedGrupa(int row){
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(5000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelGrupe.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = ClientController.getInstance().getAllGrupa();
            if(!parametar.equals("")){
                List<Grupa> novaLista=new ArrayList<>();
                for(Grupa g: lista)
                    if(g.getNazivGrupe().toLowerCase().contains(parametar.toLowerCase())
                            || g.getPredavac().toString().toLowerCase().contains(parametar.toLowerCase())
                            || g.getKurs().toString().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(g);
                lista=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public void obrisiGrupu(int row, JFrame mainform) {
        Grupa g = lista.get(row);
        
        try {
            ArrayList<Polaznik> listaPolaznika = ClientController.getInstance().getAllPolaznik();
            for (Polaznik p : listaPolaznika) {
                if (p.getGrupa().getGrupaID() == g.getGrupaID()) {
                    JOptionPane.showMessageDialog(mainform,"Ne mozete obrisati grupu u kojoj ima aktivnih polaznika!");
                    return;
                }
            }
            
            ClientController.getInstance().deleteGrupa(g);
        } catch (Exception ex) {
            Logger.getLogger(TableModelGrupe.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(mainform, "Izabrana grupa je uspesno obrisana.");
//        lista.remove(row);
        fireTableDataChanged();
        
    }
    
}