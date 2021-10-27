/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predavac;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Predavac;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SOGetAllPredavac extends AbstractSO {
    
    private ArrayList<Predavac> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Predavac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Predavac");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaPredavaca 
                = (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<Predavac>) (ArrayList<?>) listaPredavaca;
    }
    
    public ArrayList<Predavac> getLista() {
        return lista;
    }
    
}
