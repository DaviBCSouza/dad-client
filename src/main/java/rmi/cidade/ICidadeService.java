package rmi.cidade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICidadeService extends Remote {
    List<Cidade> getCidades() throws RemoteException;
    Cidade getCidade(String cidade) throws RemoteException;
}

