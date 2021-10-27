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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Neon
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void addAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.ADD_ADMINISTRATOR, administrator);
    }

    public void addTipKursa(TipKursa tipKursa) throws Exception {
        sendRequest(Operation.ADD_TIP_KURSA, tipKursa);
    }

    public void addKurs(Kurs kurs) throws Exception {
        sendRequest(Operation.ADD_KURS, kurs);
    }

    public void addPolaznik(Polaznik polaznik) throws Exception {
        sendRequest(Operation.ADD_POLAZNIK, polaznik);
    }

    public void addPredavac(Predavac predavac) throws Exception {
        sendRequest(Operation.ADD_PREDAVAC, predavac);
    }

    public void addGrupa(Grupa grupa) throws Exception {
        sendRequest(Operation.ADD_GRUPA, grupa);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.DELETE_ADMINISTRATOR, administrator);
    }

    public void deleteTipKursa(TipKursa tipKursa) throws Exception {
        sendRequest(Operation.DELETE_TIP_KURSA, tipKursa);
    }

    public void deleteKurs(Kurs kurs) throws Exception {
        sendRequest(Operation.DELETE_KURS, kurs);
    }

    public void deletePolaznik(Polaznik polaznik) throws Exception {
        sendRequest(Operation.DELETE_POLAZNIK, polaznik);
    }

    public void deletePredavac(Predavac predavac) throws Exception {
        sendRequest(Operation.DELETE_PREDAVAC, predavac);
    }

    public void deleteGrupa(Grupa grupa) throws Exception {
        sendRequest(Operation.DELETE_GRUPA, grupa);
    }

    public void editAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.EDIT_ADMINISTRATOR, administrator);
    }

    public void editTipKursa(TipKursa tipKursa) throws Exception {
        sendRequest(Operation.EDIT_TIP_KURSA, tipKursa);
    }

    public void editKurs(Kurs kurs) throws Exception {
        sendRequest(Operation.EDIT_KURS, kurs);
    }

    public void editPolaznik(Polaznik polaznik) throws Exception {
        sendRequest(Operation.EDIT_POLAZNIK, polaznik);
    }

    public void editPredavac(Predavac predavac) throws Exception {
        sendRequest(Operation.EDIT_PREDAVAC, predavac);
    }

    public void editGrupa(Grupa grupa) throws Exception {
        sendRequest(Operation.EDIT_GRUPA, grupa);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }

    public ArrayList<TipKursa> getAllTipKursa() throws Exception {
        return (ArrayList<TipKursa>) sendRequest(Operation.GET_ALL_TIP_KURSA, null);
    }

    public ArrayList<Kurs> getAllKurs() throws Exception {
        return (ArrayList<Kurs>) sendRequest(Operation.GET_ALL_KURS, null);
    }

    public ArrayList<Polaznik> getAllPolaznik() throws Exception {
        return (ArrayList<Polaznik>) sendRequest(Operation.GET_ALL_POLAZNIK, null);
    }

    public ArrayList<Predavac> getAllPredavac() throws Exception {
        return (ArrayList<Predavac>) sendRequest(Operation.GET_ALL_PREDAVAC, null);
    }

    public ArrayList<Grupa> getAllGrupa() throws Exception {
        return (ArrayList<Grupa>) sendRequest(Operation.GET_ALL_GRUPA, null);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());        
        out.writeObject(req);            
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
       
        //
        Response res = (Response) in.readObject();            
       
        //
        if (res.getResponseStatus().equals(ResponseStatus.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }
}
