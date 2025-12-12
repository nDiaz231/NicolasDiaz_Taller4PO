package logica;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.*;

public class SistemaEspecifico {
	private static SistemaEspecifico instance;
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Estudiante> estudiante;
	private ArrayList<Curso> cursos;
	private ArrayList<Certificacion> certifcaciones;
	
	private SistemaEspecifico() throws FileNotFoundException {
		this.usuarios = new ArrayList<>();
		this.estudiante = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.certifcaciones = new ArrayList<>();
		
		
		cargarTxt();
	}

	public static SistemaEspecifico getInstance() throws FileNotFoundException {
		if(instance == null) {
			instance = new SistemaEspecifico();
		}
		return instance;
	}
	private void cargarTxt() throws FileNotFoundException {
		cargarCursos();
		cargarUsuarios();
		
		
	}

	
	private void cargarUsuarios() throws FileNotFoundException {
		File arch = new File("usuarios.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");
			String nombre = datos[0];
			String contraseña = datos[1];
			String rol = datos[2];
			if (rol.equalsIgnoreCase("Coordinador")) {
				String dato = datos[3];
				Coordinador c = new Coordinador(nombre,contraseña,rol,dato);
				usuarios.add(c);
			}else {
				Administrador a = new Administrador(nombre,contraseña,rol);
				usuarios.add(a);
			}
		}
		s.close();
	}

	private void cargarCursos() throws FileNotFoundException {
		File arch = new File("cursos.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");
			String ncr = datos[0];
			String nombre = datos[1];
			int semestre = Integer.parseInt(datos[2]);
			int creditos = Integer.parseInt(datos[3]);
			String area = datos[4];
			if (datos.length==5) {
				Curso c = new Curso(ncr,nombre,semestre,creditos,area);
			if (datos.length < 5){
				String[] prerequisitos = datos[5].split(",");
				for (String pre : prerequisitos) {
					c.agregarPre(pre);
				}
			}
			
			cursos.add(c);
		}
		
		
	}
	
	s.close();
	}
}
