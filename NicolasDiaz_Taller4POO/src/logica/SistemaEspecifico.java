package logica;
import java.util.ArrayList;

import dominio.*;

public class SistemaEspecifico {
	private static SistemaEspecifico instance;
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Estudiante> estudiante;
	private ArrayList<Curso> cursos;
	private ArrayList<Certificacion> certifcaciones;
	private SistemaEspecifico() {
		this.usuarios = new ArrayList<>();
		this.estudiante = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.certifcaciones = new ArrayList<>();
		
		
		cargarTxt();
	}

	public static SistemaEspecifico getInstance() {
		if(instance == null) {
			instance = new SistemaEspecifico();
		}
		return instance;
	}
	private void cargarTxt() {
		
	}
	
	
}
