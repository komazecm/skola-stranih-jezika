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
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SOAddGrupa extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Grupa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Grupa");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
}
