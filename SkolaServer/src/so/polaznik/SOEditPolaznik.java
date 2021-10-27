/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.polaznik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Polaznik;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SOEditPolaznik extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Polaznik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Polaznik");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().update(ado);
    }
    
}
