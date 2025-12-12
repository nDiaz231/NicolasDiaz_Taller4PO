package dominio;

import java.util.ArrayList;

public class Certificacion {
	private String id;
	private String nombre;
	private String descripcion;
	private int requisitos;
	private int añosValidez;
	private ArrayList<String> listCursos;
	public Certificacion(String id, String nombre, String descripcion, int requisitos, int añosValidez
			) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.añosValidez = añosValidez;
		this.listCursos = new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(int requisitos) {
		this.requisitos = requisitos;
	}
	public int getAñosValidez() {
		return añosValidez;
	}
	public void setAñosValidez(int añosValidez) {
		this.añosValidez = añosValidez;
	}
	public ArrayList<String> getListCursos() {
		return listCursos;
	}
	public void setListCursos(ArrayList<String> listCursos) {
		this.listCursos = listCursos;
	}
	public void agregarCurso(String nrc) {
		this.listCursos.add(nrc);
	}

}
