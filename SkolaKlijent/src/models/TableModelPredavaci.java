/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Administrator;
import domain.Predavac;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neon
 */
public class TableModelPredavaci extends AbstractTableModel implements Runnable{

    private List<Predavac> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Telefon", "Email"};
    private String parametar = "";
    
    public TableModelPredavaci() {
        try {
            lista = ClientController.getInstance().getAllPredavac();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPredavaci.class.getName()).log(Level.SEVERE, null, ex);
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
        Predavac p = lista.get(row);
        
        switch(column){
            case 0: return p.getPredavacID();
            case 1: return p.getIme();
            case 2: return p.getPrezime();
            case 3: return p.getTelefon();
            case 4: return p.getEmail();
            
            default: return null;
        }
    }
    
    public Predavac getSelectedPredavac(int row){
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
                Logger.getLogger(TableModelPredavaci.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = ClientController.getInstance().getAllPredavac();
            if(!parametar.equals("")){
                List<Predavac> novaLista=new ArrayList<>();
                for(Predavac predavac: lista)
                    if(predavac.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || predavac.getPrezime().toLowerCase().contains(parametar.toLowerCase())
                            || predavac.getTelefon().toLowerCase().contains(parametar.toLowerCase()) 
                            || predavac.getEmail().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(predavac);
                lista = novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    
}