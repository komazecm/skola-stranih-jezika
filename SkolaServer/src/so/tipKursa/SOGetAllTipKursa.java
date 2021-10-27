/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipKursa;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.TipKursa;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SOGetAllTipKursa extends AbstractSO {
    
    private ArrayList<TipKursa> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipKursa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipKursa");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaTipovaKurseva 
                = (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<TipKursa>) (ArrayList<?>) listaTipovaKurseva;
    }
    
    public ArrayList<TipKursa> getLista() {
        return lista;
    }
    
}