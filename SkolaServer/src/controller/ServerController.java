/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Grupa;
import domain.Kurs;
import domain.Polaznik;
import domain.Predavac;
import domain.TipKursa;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOAddAdministrator;
import so.administrator.SODeleteAdministrator;
import so.administrator.SOEditAdministrator;
import so.administrator.SOGetAllAdministrator;
import so.grupa.SOAddGrupa;
import so.grupa.SODeleteGrupa;
import so.grupa.SOEditGrupa;
import so.grupa.SOGetAllGrupa;
import so.kurs.SOAddKurs;
import so.kurs.SODeleteKurs;
import so.kurs.SOEditKurs;
import so.kurs.SOGetAllKurs;
import so.polaznik.SOAddPolaznik;
import so.polaznik.SODeletePolaznik;
import so.polaznik.SOEditPolaznik;
import so.polaznik.SOGetAllPolaznik;
import so.predavac.SOAddPredavac;
import so.predavac.SODeletePredavac;
import so.predavac.SOEditPredavac;
import so.predavac.SOGetAllPredavac;
import so.tipKursa.SOAddTipKursa;
import so.tipKursa.SODeleteTipKursa;
import so.tipKursa.SOEditTipKursa;
import so.tipKursa.SOGetAllTipKursa;
import transfer.util.Operation;
/**
 *
 * @author Neon
 */
public class ServerController {
    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if(instance==null)
            instance=new ServerController();
        return instance;
    }

    public void addAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SOAddAdministrator();
        aso.templateExecute(administrator);
    }

    public void addTipKursa(TipKursa tipKursa) throws Exception{
        AbstractSO aso=new SOAddTipKursa();
        aso.templateExecute(tipKursa);
    }

    public void addKurs(Kurs kurs) throws Exception{
        AbstractSO aso=new SOAddKurs();
        aso.templateExecute(kurs);
    }

    public void addPolaznik(Polaznik polaznik) throws Exception{
        AbstractSO aso=new SOAddPolaznik();
        aso.templateExecute(polaznik);
    }

    public void addPredavac(Predavac predavac) throws Exception{
        AbstractSO aso=new SOAddPredavac();
        aso.templateExecute(predavac);
    }
    
     public void addGrupa(Grupa grupa) throws Exception{
        AbstractSO aso=new SOAddGrupa();
        aso.templateExecute(grupa);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SODeleteAdministrator();
        aso.templateExecute(administrator);
    }

    public void deleteTipKursa(TipKursa tipKursa) throws Exception{
        AbstractSO aso=new SODeleteTipKursa();
        aso.templateExecute(tipKursa);
    }

    public void deleteKurs(Kurs kurs) throws Exception{
        AbstractSO aso=new SODeleteKurs();
        aso.templateExecute(kurs);
    }

    public void deletePolaznik(Polaznik polaznik) throws Exception{
        AbstractSO aso=new SODeletePolaznik();
        aso.templateExecute(polaznik);
    }

    public void deletePredavac(Predavac predavac) throws Exception{
        AbstractSO aso=new SODeletePredavac();
        aso.templateExecute(predavac);
    }
    
    public void deleteGrupa(Grupa grupa) throws Exception{
        AbstractSO aso=new SODeleteGrupa();
        aso.templateExecute(grupa);
    }

    public void editAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SOEditAdministrator();
        aso.templateExecute(administrator);
    }

    public void editTipKursa(TipKursa tipKursa) throws Exception{
        AbstractSO aso=new SOEditTipKursa();
        aso.templateExecute(tipKursa);
    }

    public void editKurs(Kurs kurs) throws Exception{
        AbstractSO aso=new SOEditKurs();
        aso.templateExecute(kurs);
    }

    public void editPolaznik(Polaznik polaznik) throws Exception{
        AbstractSO aso=new SOEditPolaznik();
        aso.templateExecute(polaznik);
    }
    
    public void editPredavac(Predavac predavac) throws Exception{
        AbstractSO aso=new SOEditPredavac();
        aso.templateExecute(predavac);
    }

    public void editGrupa(Grupa grupa) throws Exception{
        AbstractSO aso=new SOEditGrupa();
        aso.templateExecute(grupa);
    }
    
    public ArrayList<Administrator> getAllAdministrator() throws Exception{
        SOGetAllAdministrator so=new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<TipKursa> getAllTipKursa() throws Exception{
        SOGetAllTipKursa so=new SOGetAllTipKursa();
        so.templateExecute(new TipKursa());
        return so.getLista();
    }

    public ArrayList<Kurs> getAllKurs() throws Exception{
        SOGetAllKurs so=new SOGetAllKurs();
        so.templateExecute(new Kurs());
        return so.getLista();
    }

    public ArrayList<Polaznik> getAllPolaznik() throws Exception{
        SOGetAllPolaznik so=new SOGetAllPolaznik();
        so.templateExecute(new Polaznik());
        return so.getLista();
    }

    public ArrayList<Predavac> getAllPredavac() throws Exception{
        SOGetAllPredavac so=new SOGetAllPredavac();
        so.templateExecute(new Predavac());
        return so.getLista();
    }
    
    public ArrayList<Grupa> getAllGrupa() throws Exception{
        SOGetAllGrupa so=new SOGetAllGrupa();
        so.templateExecute(new Grupa());
        return so.getLista();
    }
    
}
