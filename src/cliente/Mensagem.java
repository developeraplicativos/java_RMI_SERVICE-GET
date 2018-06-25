package cliente;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensagem extends Remote {
	public String hello(String nome) throws RemoteException;
	public Boolean verify(String nome, char[] senha) throws RemoteException, IOException;
}
