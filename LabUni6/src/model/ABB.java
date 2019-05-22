package model;

import Exception.EspectadorNoExisteException;

public class ABB {
	
private Espectador raiz;
	
	private int peso;
	
	public ABB() {
		raiz=null;
		peso=0;
	}
	
	public void add(Espectador actual, Espectador nuevo) {
		if(raiz==null) {
			nuevo.setPosX(500);
			nuevo.setPosY(25);
			raiz=nuevo;
			peso+=1;
		}else {
			if(nuevo.getId()<=actual.getId()) {
				if(actual.getIzq()==null) {
					nuevo.setPosX(actual.getPosX()-actual.getDistancia());
					nuevo.setPosY(actual.getPosY()+50);
					actual.setIzq(nuevo);
					peso+=1;
				}else {
					add(actual.getIzq(), nuevo);
				}
			}else {
				if(actual.getDer()==null) {
					nuevo.setPosX(actual.getPosX()+actual.getDistancia());
					nuevo.setPosY(actual.getPosY()+50);
					actual.setDer(nuevo);
					peso+=1;
				}else {
					add(actual.getDer(), nuevo);
				}
			}
		}
	}

	public Espectador buscar(Espectador actual, long id) throws EspectadorNoExisteException {
		if(actual.getId()==id) {
			return actual;
		}else {
			if(id<actual.getId()) {
				if(actual.getIzq()!=null) {
					return buscar(actual.getIzq(), id);
				}else {
					throw new EspectadorNoExisteException(id);
				}
			}else {
				if(actual.getDer()!=null) {
					return buscar(actual.getDer(), id);
				}else {
					throw new EspectadorNoExisteException(id);
				}
			}
		}
	}
	
	public Espectador getRaiz() {
		return raiz;
	}

	public void setRaiz(Espectador raiz) {
		this.raiz = raiz;
	}
	
	public boolean vacio(Espectador a) {
		return (a==null);
	}
	
	public Espectador getIzqArbol(Espectador a) {
		if(a.getIzq() == null){
			return null;
		}else{
			return a.getIzq();
		}
	}
	
	public Espectador getDerArbol(Espectador a) {
		if(a.getDer() == null){
			return null;
		}else{
			return a.getDer();
		}
	}
	
	public void inorden(Espectador a){
		if(!vacio(a)){
			inorden(getIzqArbol(a));
			System.out.print(a.getName()+" ");
			inorden(getDerArbol(a));
		}           
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
