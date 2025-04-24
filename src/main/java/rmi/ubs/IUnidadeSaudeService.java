package rmi.ubs;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUnidadeSaudeService extends Remote {
    List<UnidadeSaude> getAll() throws RemoteException;
    UnidadeSaude getByCNES(String cnes) throws RemoteException;
}
