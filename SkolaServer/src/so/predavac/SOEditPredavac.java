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
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SOEditPredavac extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Predavac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Predavac");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().update(ado);
    }
    
}