package dominio;

import java.util.ArrayList;

public class Estudiante{
	private String rut;
	private String nombre;
	private String carrera;
	private int semestre;
	private String email;
	private String constraseña;
	
	private ArrayList<Nota> notas;
	private ArrayList<Registro> inscripcion;
	public Estudiante(String rut, String nombre, String carrera, int semestre, String email, String constraseña,
			ArrayList<Nota> notas, ArrayList<Registro> inscripcion) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.semestre = semestre;
		this.email = email;
		this.constraseña = constraseña;
		this.notas = new ArrayList<>();
		this.inscripcion = new ArrayList<>();
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConstraseña() {
		return constraseña;
	}
	public void setConstraseña(String constraseña) {
		this.constraseña = constraseña;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	public ArrayList<Registro> getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(ArrayList<Registro> inscripcion) {
		this.inscripcion = inscripcion;
	}
	public void agregarNota(Nota nota) {
		this.notas.add(nota);
		
	}
	public void agregarRegistro(Registro registro) {
		this.inscripcion.add(registro);
		
	}
	

}
