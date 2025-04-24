
package rmi.cidade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICidadeService extends Remote {
    Cidade getCidade(String var1) throws RemoteException;

    List<Cidade> getCidades() throws RemoteException;
}
