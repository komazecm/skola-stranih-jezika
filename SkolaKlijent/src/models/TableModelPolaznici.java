/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Polaznik;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neon
 */
public class TableModelPolaznici extends AbstractTableModel implements Runnable{

    private List<Polaznik> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Telefon", "Email", "Datum upisivanja", "Grupa"};
    private String parametar = "";
    
    public TableModelPolaznici() {
        try {
            lista = ClientController.getInstance().getAllPolaznik();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPolaznici.class.getName()).log(Level.SEVERE, null, ex);
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
        Polaznik p = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(column){
            case 0: return p.getPolaznikID();
            case 1: return p.getIme();
            case 2: return p.getPrezime();
            case 3: return p.getTelefon();
            case 4: return p.getEmail();
            case 5: return sdf.format(p.getDatumUpisivanja());
            case 6: return p.getGrupa();
            
            default: return null;
        }
    }
    
    public Polaznik getSelectedPolaznik(int row){
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
                Logger.getLogger(TableModelPolaznici.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = ClientController.getInstance().getAllPolaznik();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            if(!parametar.equals("")){
                List<Polaznik> novaLista=new ArrayList<>();
                for(Polaznik polaznik: lista)
                    if(polaznik.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || polaznik.getPrezime().toLowerCase().contains(parametar.toLowerCase())
                            || polaznik.getTelefon().toLowerCase().contains(parametar.toLowerCase()) 
                            || polaznik.getEmail().toLowerCase().contains(parametar.toLowerCase())
                            || sdf.format(polaznik.getDatumUpisivanja()).contains(parametar)
                            || polaznik.getGrupa().toString().contains(parametar.toLowerCase()))
                        novaLista.add(polaznik);
                lista = novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    
}