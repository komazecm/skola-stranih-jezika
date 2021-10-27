/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ServerController;
import domain.Administrator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neon
 */
public class TableModelUlogovaniAdministratori extends AbstractTableModel implements Runnable{

    private List<Administrator> lista;
    private String[] kolone = {"Korisnicno ime", "Ime", "Prezime"};
    private String parametar = "";
    
    public TableModelUlogovaniAdministratori() {
        try {
            lista = ServerController.getInstance().getAllAdministrator();
        } catch (Exception ex) {
            Logger.getLogger(TableModelUlogovaniAdministratori.class.getName()).log(Level.SEVERE, null, ex);
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
        Administrator a = lista.get(row);
        
        switch(column){
            case 0: return a.getUsername();
            case 1: return a.getImeAdministratora();
            case 2: return a.getPrezimeAdministratora();
            
            default: return null;
        }
    }
    
    public Administrator getSelectedAdministrator(int row){
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
                Logger.getLogger(TableModelUlogovaniAdministratori.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void osveziTabelu() {
        try{
//            lista.add();            
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}

