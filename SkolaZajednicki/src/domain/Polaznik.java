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
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Neon
 */
public class Polaznik extends AbstractDomainObject implements Serializable {
    
    private long polaznikID;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private Date datumUpisivanja;
    private Grupa grupa;
    
    public Polaznik() {
    }

    public Polaznik(long polaznikID, String ime, String prezime, String telefon, String email, Date datumUpisivanja, Grupa grupa) {
        this.polaznikID = polaznikID;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumUpisivanja = datumUpisivanja;
        this.grupa = grupa;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public long getPolaznikID() {
        return polaznikID;
    }

    public void setPolaznikID(long polaznikID) {
        this.polaznikID = polaznikID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumUpisivanja() {
        return datumUpisivanja;
    }

    public void setDatumUpisivanja(Date datumUpisivanja) {
        this.datumUpisivanja = datumUpisivanja;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Polaznik other = (Polaznik) obj;
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

    

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Polaznik other = (Polaznik) obj;
//        if (!Objects.equals(this.ime, other.ime)) {
//            return false;
//        }
//        if (!Objects.equals(this.prezime, other.prezime)) {
//            return false;
//        }
//        if (!Objects.equals(this.telefon, other.telefon)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    @Override
    public String nazivTabele() {
        return " polaznik ";
    }

    @Override
    public String alijas() {
        return " po ";
    }

    @Override
    public String join() {
        return " JOIN grupa g ON (g.GrupaID=po.GrupaID) JOIN predavac pr ON (pr.PredavacID=g.PredavacID) JOIN kurs k ON (g.KursID=k.KursID) JOIN tipkursa tk ON (k.TipKursaID=tk.TipKursaID) ";
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
            Polaznik po = new Polaznik(rs.getLong("po.PolaznikID"), rs.getString("po.Ime"),
            rs.getString("po.Prezime"), rs.getString("po.Telefon"), rs.getString("po.Email"), 
            rs.getDate("po.DatumUpisivanja"), g);
            
            lista.add(po);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Telefon, Email, DatumUpisivanja, GrupaID) "; //id je autoincrement
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " PolaznikID = " + polaznikID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" +telefon + "', '" + email + "', '" + new java.sql.Date(datumUpisivanja.getTime()) + "', " + grupa.getGrupaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', " 
                + "Telefon = '" + telefon + "', Email = '" + email + "', DatumUpisivanja='" + new java.sql.Date(datumUpisivanja.getTime()) + "', GrupaID=" + grupa.getGrupaID() + " " ;
    } 
    
}
