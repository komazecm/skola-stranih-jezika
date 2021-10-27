/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Grupa;
import domain.Kurs;
import domain.Polaznik;
import domain.Predavac;
import domain.TipKursa;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Neon
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.ADD_ADMINISTRATOR:
                    ServerController.getInstance().addAdministrator((Administrator) req.getData());
                    break;
                case Operation.ADD_TIP_KURSA:
                    ServerController.getInstance().addTipKursa((TipKursa) req.getData());
                    break;
                case Operation.ADD_KURS:
                    ServerController.getInstance().addKurs((Kurs) req.getData());
                    break;
                case Operation.ADD_POLAZNIK:
                    ServerController.getInstance().addPolaznik((Polaznik) req.getData());
                    break;
                case Operation.ADD_PREDAVAC:
                    ServerController.getInstance().addPredavac((Predavac) req.getData());
                    break;
                case Operation.ADD_GRUPA:
                    ServerController.getInstance().addGrupa((Grupa) req.getData());
                    break;
                case Operation.DELETE_ADMINISTRATOR:
                    ServerController.getInstance().deleteAdministrator((Administrator) req.getData());
                    break;
                case Operation.DELETE_TIP_KURSA:
                    ServerController.getInstance().deleteTipKursa((TipKursa) req.getData());
                    break;
                case Operation.DELETE_KURS:
                    ServerController.getInstance().deleteKurs((Kurs) req.getData());
                    break;
                case Operation.DELETE_POLAZNIK:
                    ServerController.getInstance().deletePolaznik((Polaznik) req.getData());
                    break;
                case Operation.DELETE_PREDAVAC:
                    ServerController.getInstance().deletePredavac((Predavac) req.getData());
                    break;
                case Operation.DELETE_GRUPA:
                    ServerController.getInstance().deleteGrupa((Grupa) req.getData());
                    break;    
                case Operation.EDIT_ADMINISTRATOR:
                    ServerController.getInstance().editAdministrator((Administrator) req.getData());
                    break;
                case Operation.EDIT_TIP_KURSA:
                    ServerController.getInstance().editTipKursa((TipKursa) req.getData());
                    break;
                case Operation.EDIT_KURS:
                    ServerController.getInstance().editKurs((Kurs) req.getData());
                    break;
                case Operation.EDIT_POLAZNIK:
                    ServerController.getInstance().editPolaznik((Polaznik) req.getData());
                    break;
                case Operation.EDIT_PREDAVAC:
                    ServerController.getInstance().editPredavac((Predavac) req.getData());
                    break;
                case Operation.EDIT_GRUPA:
                    ServerController.getInstance().editGrupa((Grupa) req.getData());
                    break;    
                case Operation.GET_ALL_ADMINISTRATOR:
                    res.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_TIP_KURSA:
                    res.setData(ServerController.getInstance().getAllTipKursa());
                    break;
                case Operation.GET_ALL_KURS:
                    res.setData(ServerController.getInstance().getAllKurs());
                    break;
                case Operation.GET_ALL_POLAZNIK:
                    res.setData(ServerController.getInstance().getAllPolaznik());
                    break;
                case Operation.GET_ALL_PREDAVAC:
                    res.setData(ServerController.getInstance().getAllPredavac());
                    break;
                 case Operation.GET_ALL_GRUPA:
                    res.setData(ServerController.getInstance().getAllGrupa());
                    break;    
                case Operation.LOGIN:
                    ArrayList<Administrator> lista = ServerController.getInstance().getAllAdministrator();
                    Administrator a = (Administrator) req.getData();
                    for (Administrator administrator : lista) {
                        if (administrator.getUsername().equals(a.getUsername()) && 
                                administrator.getPassword().equals(a.getPassword())) {
                            res.setData(administrator);
                        }
                    }
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji administrator sa tim podacima.");
                    } else {
                        break;
                    }
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setData(null);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }

}
