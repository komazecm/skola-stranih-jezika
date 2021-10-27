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
import so.AbstractSO;

/**
 *
 * @author Neon
 */
public class SODeleteTipKursa extends AbstractSO {
    
   @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         if (!(ado instanceof TipKursa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipKursa");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    } 
    
    
}
