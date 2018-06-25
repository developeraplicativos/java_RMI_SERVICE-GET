package cliente;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
	public static Mensagem gerente;
	/*public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, InterruptedException {
		// TODO Auto-generated method stub
		gerente = (Mensagem) Naming.lookup("msg");
//		verifica("adm");
//		System.out.println( gerente.hello(" emerosn
		verifica(null);

	}*/
	public Main() throws MalformedURLException, RemoteException, NotBoundException {
		gerente = (Mensagem) Naming.lookup("msg");
//		verifica("adm");
//		System.out.println( gerente.hello(" emerosn
//		verifica(null);
	}
	public static void verifica(String nome, char[] senha) throws IOException {
//		System.out.println(nome);
		if(gerente.verify(nome, senha)) {
			System.out.println( "seja bem vindo! ");
		}else {
			System.out.println( "senha ou login errado! " );
		}
		
	}

}
