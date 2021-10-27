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
import java.util.Objects;

/**
 *
 * @author Neon
 */
public class Kurs extends AbstractDomainObject implements Serializable{
    
    private long kursID;
    private String nazivKursa;
    private double mesecnaCena;
    private TipKursa tipKursa;

    public Kurs() {
        tipKursa = new TipKursa();
    }

    public Kurs(long kursID, String nazivKursa, double mesecnaCena, TipKursa tipKursa) {
        this.kursID = kursID;
        this.nazivKursa = nazivKursa;
        this.mesecnaCena = mesecnaCena;
        this.tipKursa = tipKursa;
    }

    public TipKursa getTipKursa() {
        return tipKursa;
    }

    public void setTipKursa(TipKursa tipKursa) {
        this.tipKursa = tipKursa;
    }

    public long getKursID() {
        return kursID;
    }

    public void setKursID(long kursID) {
        this.kursID = kursID;
    }

    public String getNazivKursa() {
        return nazivKursa;
    }

    public void setNazivKursa(String nazivKursa) {
        this.nazivKursa = nazivKursa;
    }

    public double getMesecnaCena() {
        return mesecnaCena;
    }

    public void setMesecnaCena(double mesecnaCena) {
        this.mesecnaCena = mesecnaCena;
    }

    @Override
    public String toString() {
        return nazivKursa;
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
        final Kurs other = (Kurs) obj;
        if (!Objects.equals(this.nazivKursa, other.nazivKursa)) {
            return false;
        }
        if (!Objects.equals(this.tipKursa, other.tipKursa)) {
            return false;
        }
        return true;
    }

    

    
    
    @Override
    public String nazivTabele() {
        return " kurs ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
//        return "";
        
        return " JOIN tipkursa tk on (tk.TipKursaID=k.TipKursaID) " ;
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            TipKursa tk = new TipKursa(rs.getLong("tk.TipKursaID"), rs.getString("tk.Jezik"), rs.getString("tk.Nivo"));
            Kurs k = new Kurs(rs.getLong("k.KursID"),
                    rs.getString("k.Naziv"), rs.getDouble("k.MesecnaCena"), 
                    tk);
            
            lista.add(k);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Naziv, MesecnaCena, TipKursaID) "; //KursID je isto autoincrement
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KursID = " + kursID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivKursa + "', '" + mesecnaCena + "', "
                + "'" + tipKursa.getTipKursaID() + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Naziv = '" + nazivKursa + "', MesecnaCena = " + mesecnaCena + ", " 
                + "TipKursaID = " + tipKursa.getTipKursaID() + " ";
    }
    
    
}
