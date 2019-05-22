package model;

public class Espectador {
	
	private long id;
	private String name;
	private String gender;
	private String avatar;

	private boolean inscrito;
	
	private Espectador der;
	private Espectador izq;
	
	private int posX;
	private int posY;
	private int distancia;
	public Espectador(long id, String name, String gender, String avatar) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.avatar = avatar;
		
		setInscrito(false);
		
		posX=0;
		posY=0;
		distancia=100;
		der=null;
		izq=null;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public boolean isInscrito() {
		return inscrito;
	}
	public void setInscrito(boolean inscrito) {
		this.inscrito = inscrito;
	}
	public Espectador getDer() {
		return der;
	}
	public void setDer(Espectador der) {
		this.der = der;
	}
	public Espectador getIzq() {
		return izq;
	}
	public void setIzq(Espectador izq) {
		this.izq = izq;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public boolean esHoja() {
		return (getDer()==null && getIzq()==null);
	}
	
	
}
