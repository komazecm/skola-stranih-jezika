/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
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
public class TableModelAdministratori extends AbstractTableModel implements Runnable{

    private List<Administrator> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Username"};
    private String parametar = "";
    
    public TableModelAdministratori() {
        try {
            lista = ClientController.getInstance().getAllAdministrator();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAdministratori.class.getName()).log(Level.SEVERE, null, ex);
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
            case 0: return a.getAdministratorID();
            case 1: return a.getImeAdministratora();
            case 2: return a.getPrezimeAdministratora();
            case 3: return a.getUsername();
            
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
                Logger.getLogger(TableModelAdministratori.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = ClientController.getInstance().getAllAdministrator();
            if(!parametar.equals("")){
                List<Administrator> novaLista=new ArrayList<>();
                for(Administrator a: lista)
                    if(a.getImeAdministratora().toLowerCase().contains(parametar.toLowerCase())
                            || a.getPrezimeAdministratora().toLowerCase().contains(parametar.toLowerCase())
                            || a.getUsername().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(a);
                lista=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    
}

