/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Grupa;
import domain.Kurs;
import domain.Polaznik;
import forms.FormIzmenaGrupe;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neon
 */
public class TableModelListaPolaznika extends AbstractTableModel implements Runnable{

    private List<Polaznik> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Telefon", "Email", "Datum upisivanja"};
    private String parametar = "";
    private Grupa g;
    
    public TableModelListaPolaznika(Grupa g) {
        try {
            lista = new ArrayList<>();
            this.g = g;
            ArrayList<Polaznik> sviPolaznici = ClientController.getInstance().getAllPolaznik();
            //sad prodjem kroz listu i u atribut lista ubacujem samo one cijaje grupaid jednaka ovoj grupi:
            for (Polaznik polaznik : sviPolaznici) {
                if(polaznik.getGrupa().getGrupaID() == g.getGrupaID()){
                    lista.add(polaznik);
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(TableModelListaPolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Polaznik> getLista(){
        return lista;
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
                    Thread.sleep(4000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelListaPolaznika.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = new ArrayList<>(); //ispraznim listu 
            ArrayList<Polaznik> sviPolaznici = ClientController.getInstance().getAllPolaznik();
            //sad prodjem kroz listu i u atribut lista ubacujem samo one cijaje grupaid jednaka ovoj grupi:
            for (Polaznik polaznik : sviPolaznici) {
                if(polaznik.getGrupa().getGrupaID() == g.getGrupaID()){
                    lista.add(polaznik);
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//            if(!parametar.equals("")){
//                List<Polaznik> novaLista=new ArrayList<>();
//                for(Polaznik polaznik: lista)
//                    if(polaznik.getIme().toLowerCase().contains(parametar.toLowerCase())
//                            || polaznik.getPrezime().toLowerCase().contains(parametar.toLowerCase())
//                            || polaznik.getTelefon().toLowerCase().contains(parametar.toLowerCase()) 
//                            || polaznik.getEmail().toLowerCase().contains(parametar.toLowerCase())
//                            || sdf.format(polaznik.getDatumUpisivanja()).contains(parametar))
//                        novaLista.add(polaznik);
//                lista = novaLista;
//            }else{
//                
//            }
//            for (Polaznik p : lista) {
//                List<Polaznik> novaLista=new ArrayList<>();
//                if(p.getGrupa().getGrupaID() == g.getGrupaID()){
//                    novaLista.add(p);
//                }
//            }
            fireTableDataChanged();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void obrisiPolaznika(int row, FormIzmenaGrupe izmenaGrupeForm) {
        if(row <= 0) {
            return;
        }
        Polaznik p = lista.get(row);
        
        try {            
            ClientController.getInstance().deletePolaznik(p);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(izmenaGrupeForm, "Neuspesno brisanje polaznika.");
            Logger.getLogger(TableModelListaPolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(izmenaGrupeForm, "Izabran polaznik je uspesno obrisan.");
//        lista.remove(row);
        fireTableDataChanged();
    }
    
}


