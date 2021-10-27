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
public class Predavac extends AbstractDomainObject implements Serializable {
    
    private long predavacID;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;

    public Predavac() {
    }

    public Predavac(long predavacID, String ime, String prezime, String telefon, String email) {
        this.predavacID = predavacID;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPredavacID() {
        return predavacID;
    }

    public void setPredavacID(long predavacID) {
        this.predavacID = predavacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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
        final Predavac other = (Predavac) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.telefon, other.telefon)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return " predavac ";
    }

    @Override
    public String alijas() {
        return " pr ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            Predavac p = new Predavac(rs.getLong("PredavacID"), rs.getString("Ime"),
            rs.getString("Prezime"), rs.getString("Telefon"), rs.getString("Email"));
            
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Telefon, Email) "; //id je autoincrement
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " PredavacID = " + predavacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" +telefon + "', '" + email + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', " 
                + "Telefon = '" + telefon + "', Email = '" + email + "' ";
    }
    
    
    
}
