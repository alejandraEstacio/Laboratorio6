package model;

public class ListaParticipante {
	
	private Espectador first;
	private int size;
	
	public ListaParticipante() {
		first=null;
		size=0;
	}
	
	public Espectador getFirst() {
		return first;
	}
	
	public void setCabeza(Espectador first) {
		this.first=first;
	}
	
	public void add(Espectador actual, Espectador nuevo) {
		if(first==null) {
			first=nuevo;
			size++;
		}else if(actual.getDer()==null) {
			actual.setDer(nuevo);
		}else {
			add(actual.getDer(), nuevo);
		}
	}

	public Espectador buscar(Espectador actual, long id) {
		if(actual==null) {
			return null;
		}else if(actual.getId()==id) {
			return actual;
		}else {
			return buscar(actual.getDer(), id);
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
