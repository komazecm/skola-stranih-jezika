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
public class Grupa extends AbstractDomainObject implements Serializable {
    
    private long grupaID;
    private String nazivGrupe;
    private int maxBrojPolaznika;
    private Kurs kurs;
    private Predavac predavac;

    public Grupa() {
    }

    public Grupa(long grupaID, String nazivGrupe, int maxBrojPolaznika, Kurs kurs, Predavac predavac) {
        this.grupaID = grupaID;
        this.nazivGrupe = nazivGrupe;
        this.maxBrojPolaznika = maxBrojPolaznika;
        this.kurs = kurs;
        this.predavac = predavac;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public long getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(long grupaID) {
        this.grupaID = grupaID;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }

    public int getMaxBrojPolaznika() {
        return maxBrojPolaznika;
    }

    public void setMaxBrojPolaznika(int maxBrojPolaznika) {
        this.maxBrojPolaznika = maxBrojPolaznika;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    @Override
    public String toString() {
        return nazivGrupe + ", " + kurs.getNazivKursa();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Grupa other = (Grupa) obj;
        if (!Objects.equals(this.nazivGrupe, other.nazivGrupe)) {
            return false;
        }
        if (!Objects.equals(this.kurs, other.kurs)) {
            return false;
        }
        return true;
    }
    

    
    
    @Override
    public String nazivTabele() {
        return " grupa ";
    }

    @Override
    public String alijas() {
        return " g ";
    }

    @Override
    public String join() {
        return " JOIN predavac pr ON (pr.PredavacID=g.PredavacID) JOIN kurs k ON (g.KursID=k.KursID) JOIN tipkursa tk ON (k.TipKursaID=tk.TipKursaID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            TipKursa tk = new TipKursa(rs.getLong("tk.TipKursaID"), rs.getString("tk.jezik"), rs.getString("tk.nivo"));
            Kurs k = new Kurs(rs.getLong("k.kursID"), rs.getString("k.naziv"), rs.getDouble("k.mesecnaCena"), tk);
            Predavac p = new Predavac(rs.getLong("pr.predavacID"), rs.getString("pr.ime"), rs.getString("pr.prezime"),
                rs.getString("pr.telefon"), rs.getString("pr.email"));
            Grupa g = new Grupa(rs.getLong("g.GrupaID"),
                    rs.getString("g.NazivGrupe"), rs.getInt("g.MaxBrojPolaznika"), 
                    k, p);
            
            lista.add(g);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivGrupe, MaxBrojPolaznika, PredavacID, KursID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " GrupaID = " + grupaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivGrupe + "', " + maxBrojPolaznika + ", "
                + ""+ predavac.getPredavacID() + ", "  + kurs.getKursID() +  " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " NazivGrupe = '" + nazivGrupe + "', MaxBrojPolaznika = " + maxBrojPolaznika + ", " 
                + "PredavacID = " + predavac.getPredavacID() + ", KursID = " + kurs.getKursID() + " ";
    }
    
}
