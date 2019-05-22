package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Evento {
	
	private ABB arbol;
	private ListaParticipante lista;
	
	public Evento() {
		arbol=new ABB();
		lista=new ListaParticipante();
	}
	
	public void cargarDatos(File ruta) throws NumberFormatException, IOException{
		BufferedReader lector = new BufferedReader(new FileReader(ruta));
		String linea;			
		while((linea=lector.readLine())!=null) {
			String[] arr=linea.split(",");
			arbol.add(arbol.getRaiz(), new Espectador(Long.parseLong(arr[0]), arr[1], arr[2], arr[3]));
		}
		lector.close();
		agregarALista(0);
	}
	
	
	public void crearLista(int x) {
		SecureRandom ran=new SecureRandom();
		try {
			if(arbol.buscar(arbol.getRaiz(), (1+ran.nextInt(1000))).isInscrito()==false) {
				lista.add(lista.getFirst(), arbol.buscar(arbol.getRaiz(), (1+ran.nextInt(1000))));
			}else {
				agregarALista(x);
			}
		}catch(Exception e) {
			agregarALista(x);
		}
		agregarALista(x++);
	}
	
	public void agregarALista(int c) {
		if(c<(arbol.getPeso()/2)) {
			crearLista(c);
		}
	}
	
	public void rutasEspectadores(Espectador actual, ArrayList<Espectador> names){
		if(actual!=null ) {
			names.add(actual);
			rutasEspectadores(actual.getIzq(), names);
			rutasEspectadores(actual.getDer(), names);
		}
	}
	
	public ArrayList<Espectador> espectadores(){
		ArrayList<Espectador> names = new ArrayList<Espectador>();
		rutasEspectadores(getArbol().getRaiz(), names);
		return names;
	}

	public ABB getArbol() {
		return arbol;
	}

	public void setArbol(ABB arbol) {
		this.arbol = arbol;
	}

	public ListaParticipante getLista() {
		return lista;
	}

	public void setLista(ListaParticipante lista) {
		this.lista = lista;
	}
	

}
