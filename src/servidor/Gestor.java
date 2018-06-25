package servidor;


import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Map;

import cliente.Mensagem;
import conn.Conn;
import conn.Usuario;


//import Conn;
public class Gestor extends UnicastRemoteObject implements Mensagem{

	
	protected Gestor() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
	}
	private static final long serialVersionUID = 1L;

	@Override
	public String hello(String nome) throws RemoteException {
		// TODO Auto-generated method stub

		return "vai dormir"+ nome;
	}
	@Override
	public Boolean verify(String nome, char[] senha) throws IOException {
		Conn c = new Conn();
		Map resposta = c.Conn();
		
		for(int i=0; i < resposta.size(); i++) {
			Usuario us = (Usuario) resposta.get(i);
			char[] senhaChar = us.getSenha().toCharArray();
			if( us.getUsuario().equals(nome) && Arrays.equals(senhaChar, senha)) {
				return true;
			};
			
		}

		return false;
		
	}
	
	

}
