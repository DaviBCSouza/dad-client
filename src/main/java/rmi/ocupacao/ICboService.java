package rmi.ocupacao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICboService extends Remote {
    List<Cbo> getListCbo() throws RemoteException;

    Cbo getCbo(String var1) throws RemoteException;
}
