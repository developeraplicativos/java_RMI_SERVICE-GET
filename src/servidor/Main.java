package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {
	public static void main (String[] args) throws RemoteException, MalformedURLException {
		Gestor gestor = new Gestor();
		Naming.rebind("msg", gestor);
		Naming.rebind("verify", gestor);
	}
}
