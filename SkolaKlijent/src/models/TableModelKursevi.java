/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Kurs;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neon
 */
public class TableModelKursevi extends AbstractTableModel implements Runnable{

    private List<Kurs> lista;
    private String[] kolone = {"ID", "Naziv", "Mesecna cena", "Tip kursa"};
    private String parametar = "";
    
    public TableModelKursevi() {
        try {
            lista = ClientController.getInstance().getAllKurs();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKursevi.class.getName()).log(Level.SEVERE, null, ex);
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
        Kurs k = lista.get(row);
        
        switch(column){
            case 0: return k.getKursID();
            case 1: return k.getNazivKursa();
            case 2: return k.getMesecnaCena();
            case 3: return k.getTipKursa();
            
            default: return null;
        }
    }
    
    public Kurs getSelectedKurs(int row){
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
            lista = ClientController.getInstance().getAllKurs();
            if(!parametar.equals("")){
                List<Kurs> novaLista=new ArrayList<>();
                for(Kurs kurs: lista)
                    if(kurs.getNazivKursa().toLowerCase().contains(parametar.toLowerCase())
                            || kurs.getTipKursa().toString().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(kurs);
                lista=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    
}

