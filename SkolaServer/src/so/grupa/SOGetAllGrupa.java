/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.grupa;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Grupa;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SOGetAllGrupa extends AbstractSO {
    
    private ArrayList<Grupa> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Grupa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Grupa");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaGrupa 
                = (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<Grupa>) (ArrayList<?>) listaGrupa;
    }
    
    public ArrayList<Grupa> getLista() {
        return lista;
    }
    
}
