/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neon
 */
public class TipKursa extends AbstractDomainObject implements Serializable {
    
    private long tipKursaID;
    private String jezik;
    private String nivo;

    public TipKursa() {
    }

    public TipKursa(long tipKursaID, String jezik, String nivo) {
        this.tipKursaID = tipKursaID;
        this.jezik = jezik;
        this.nivo = nivo;
    }

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }

    public long getTipKursaID() {
        return tipKursaID;
    }

    public void setTipKursaID(long tipKursaID) {
        this.tipKursaID = tipKursaID;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    @Override
    public String toString() {
        return jezik + ", nivo " + nivo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipKursa other = (TipKursa) obj;
        if (this.tipKursaID != other.tipKursaID) {
            return false;
        }
        return true;
    }
    
    

    
    
//    @Override
//    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
//        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
//        
//        while(rs.next()){
//            Administrator a = new Administrator(rs.getLong("AdministratorID"),
//                    rs.getString("Ime"), rs.getString("Prezime"), 
//                    rs.getString("Username"), rs.getString("Password"));
//            
//            lista.add(a);
//        }
//        
//        rs.close();
//        return lista;
//        
//    }

    @Override
    public String nazivTabele() {
        return " tipKursa ";
    }

    @Override
    public String alijas() {
        return " tk ";
    }

    @Override
    public String join() {
        return "";
//        return nazivTabele() + alijas() + " on (" + alijas() + "=";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            TipKursa tk = new TipKursa(rs.getLong("TipKursaID"),
                    rs.getString("Jezik"), rs.getString("Nivo"));
            
            lista.add(tk);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Jezik, Nivo) "; //bez ID-a jer je on autoinkrement
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TipKursaID = " + tipKursaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + jezik + "', '" + nivo + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Jezik = '" + jezik + "', Nivo = '" + nivo + "' ";
    }
    
}
