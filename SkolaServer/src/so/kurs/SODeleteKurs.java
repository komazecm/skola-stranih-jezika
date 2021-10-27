/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kurs;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Kurs;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SODeleteKurs extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         if (!(ado instanceof Kurs)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kurs!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }
    
}
