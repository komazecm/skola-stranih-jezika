/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Neon
 */
public class Administrator extends AbstractDomainObject implements Serializable {
    
    private long administratorID;
    private String imeAdministratora;
    private String prezimeAdministratora;
    private String username;
    private String password;

    public Administrator() {
    }

    public Administrator(long administratorID, String imeAdministratora, String prezimeAdministratora, String username, String password) {
        this.administratorID = administratorID;
        this.imeAdministratora = imeAdministratora;
        this.prezimeAdministratora = prezimeAdministratora;
        this.username = username;
        this.password = password;
    }

    public long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(long administratorID) {
        this.administratorID = administratorID;
    }

    public String getImeAdministratora() {
        return imeAdministratora;
    }

    public void setImeAdministratora(String imeAdministratora) {
        this.imeAdministratora = imeAdministratora;
    }

    public String getPrezimeAdministratora() {
        return prezimeAdministratora;
    }

    public void setPrezimeAdministratora(String prezimeAdministratora) {
        this.prezimeAdministratora = prezimeAdministratora;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return imeAdministratora + " " + prezimeAdministratora;
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
        final Administrator other = (Administrator) obj;
        if (this.administratorID != other.administratorID) {
            return false;
        }
        if (!Objects.equals(this.imeAdministratora, other.imeAdministratora)) {
            return false;
        }
        if (!Objects.equals(this.prezimeAdministratora, other.prezimeAdministratora)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " administrator ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"), 
                    rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
            
            lista.add(a);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, KorisnickoIme, Lozinka) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " AdministratorID = " + administratorID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeAdministratora + "', '" + prezimeAdministratora + "', "
                + "'" + username + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + imeAdministratora + "', Prezime = '" + prezimeAdministratora + "', " 
                + "KorisnickoIme = '" + username + "', Lozinka = '" + password + "' ";
    }
    
    
}
