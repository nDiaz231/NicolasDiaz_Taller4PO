package dominio;

import java.util.ArrayList;

public class Curso {
	private String nrc;
	private String nombre;
	private int semestre;
	private String area;
	private ArrayList<String> prerrequisitos;
	public Curso(String nrc, String nombre, int semestre, String area, ArrayList<String> prerrequisitos) {
		this.nrc = nrc;
		this.nombre = nombre;
		this.semestre = semestre;
		this.area = area;
		this.prerrequisitos = new ArrayList<>();
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public ArrayList<String> getPrerrequisitos() {
		return prerrequisitos;
	}
	public void setPrerrequisitos(ArrayList<String> prerrequisitos) {
		this.prerrequisitos = prerrequisitos;
	}
	
	public void agregarPre(String pre) {
		this.prerrequisitos.add(pre);
	}
	
}
