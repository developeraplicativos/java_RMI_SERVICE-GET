package conn;


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


//import cliente.Main;

import java.lang.Object;

public class Conn {
	private static int HTTP_COD_SUCESSO = 200;
	public static Object obj;
	static Map<Integer, Usuario> mymap;


	public static void main(String[] args) {
		Conn();
	}
	
	public static Map Conn() {

		
		try {

			//http://www.json-generator.com/api/json/get/cpkEsIOjyq?indent=2
	        URL url = new URL("http://bijully.com/point.php?usuarios");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	
	        if (con.getResponseCode() != HTTP_COD_SUCESSO) {
	            throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	
	        String s = null;
	        String n = null;
	        int numero = 0;
	        Usuario us = null;
	        String[] continuacao;
	        String[] finalizando;        
	        String[] conjunto;
	        String[] usuario = null;
	        String[] senha = null;
	         mymap = new HashMap<Integer, Usuario>();

	        while ((s=br.readLine())!=null)
	            {
	        		n += s;
		
	        	}

				n = n.replace("null[{", "");
				n = n.replace("}]", "");
				n = n.replace(" ", "");

				continuacao = n.split("},");
				for(int i=0; i <continuacao.length; i++) {
					finalizando = continuacao[i].split(","); 

					for(String g:finalizando) {
						if(g.contains("nome")) {
							usuario = g.split(":");
						}else if(g.contains("senha")) {
							senha = g.split(":");	
						}
					}
					
					us = new Usuario(usuario[1].replaceAll("\"", ""),senha[1].replaceAll("\"", ""));
					mymap.put(i, us);

				}

							
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	return mymap;

	}
	public Map<Integer, Usuario> getListaUsuario() {
		return this.mymap;
		
	}
	public static Boolean verifyUsuario(String nome) {

		for(int i=0; i < mymap.size();i++) {
			
			System.out.println(mymap.get(i).getUsuario());
			if( mymap.get(i).getUsuario().equals(nome) ) {
				return true;
			}
		}
		return false;
	}
}


