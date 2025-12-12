package logica;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.*;

public class SistemaEspecifico {
	private static SistemaEspecifico instance;
	
	private ArrayList<Administrador> administradores;
	private ArrayList<Coordinador> coordinador;
	private ArrayList<Estudiante> estudiante;
	private ArrayList<Curso> cursos;
	private ArrayList<Certificacion> certificaciones;
	
	private SistemaEspecifico() throws FileNotFoundException {
		this.administradores = new ArrayList<>();
		this.coordinador = new ArrayList<>();
		this.estudiante = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.certificaciones = new ArrayList<>();
		
		
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
		cargarEstudiantes();		
		cargarCertificacion();
		cargarAsignaturaCertificacion();
		cargarNotas();
		cargarRegistro();
		
	}

	
	private void cargarRegistro() throws FileNotFoundException {
		File arch = new File("registro.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");	
			String rut = datos[0];
			String id = datos[1];
			String fecha = datos[2];
			String estado = datos[3];
			int progreso = Integer.parseInt(datos[4]);
			Registro r = new Registro(rut,id,fecha,estado,progreso);
			
			Estudiante e = buscarEstudiante(rut);
			
			e.agregarRegistro(r);
			
		}
		s.close();
	}

	private void cargarNotas() throws FileNotFoundException {
		File arch = new File("notas.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");		
			String rut = datos[0];
			String codigo = datos[1];
			double calificacion = Double.parseDouble(datos[2]);
			String estado = datos[3];
			String semestre = datos[4];
			
			Nota n = new Nota(rut,codigo,calificacion,estado,semestre);
			
			Estudiante e = buscarEstudiante(rut);
			
			if(e != null) {
				e.agregarNota(n);
			}
		
		}
		s.close();
	}

	public Estudiante buscarEstudiante(String rut) {
		for(Estudiante e : estudiante) {
			if(e.getRut().equalsIgnoreCase(rut)) {
				return e;
			}
		}
		return null;
	}

	private void cargarAsignaturaCertificacion() throws FileNotFoundException {
		File arch = new File("asignaturas_certificaciones.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");
			String id = datos[0];
			String nrc = datos[1];
			
			Certificacion c = buscarCertificacion(id);
			
			if (c != null) {
				c.agregarCurso(nrc);
			}
		}
		s.close();
	}

	private Certificacion buscarCertificacion(String id) {
		for(Certificacion c : certificaciones) {
			if (c.getId().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}

	private void cargarCertificacion() throws FileNotFoundException {
		File arch = new File("certificaciones.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");
			
			String id = datos[0];
			String nombre = datos[1];
			String descripcion = datos[2];
			int requisitos = Integer.parseInt(datos[3]);
			int validez = Integer.parseInt(datos[4]);
			
			Certificacion c = new Certificacion(id,nombre,descripcion,requisitos,validez);
			certificaciones.add(c);
			
		}
		s.close();
		
	}

	private void cargarEstudiantes() throws FileNotFoundException {
		File arch = new File("estudiantes.txt");
		Scanner s = new Scanner(arch);
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String [] datos = linea.split(";");
			String rut = datos[0];
			String nombre = datos[1];
			String carrera= datos[2];
			int semestre = Integer.parseInt(datos[3]);
			String correo = datos[4];
			String constraseña = datos[5];
			Estudiante e = new Estudiante (rut,nombre,carrera,semestre,correo,constraseña);
			estudiante.add(e);
		}
		s.close();
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
				coordinador.add(c);
			}else {
				Administrador a = new Administrador(nombre,contraseña,rol);
				administradores.add(a);
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
			if (datos.length>=5) {
				Curso c = new Curso(ncr,nombre,semestre,creditos,area);
			if (datos.length > 5){
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
	
	
	public Object verificacion(String rut,String constraseña) {
		for(Administrador u : administradores) {
			if(u.getNombre().equalsIgnoreCase(rut) && u.getConstraseña().equalsIgnoreCase(constraseña)) {
				return u;
			}
		for(Coordinador c : coordinador) {
			if(c.getNombre().equalsIgnoreCase(rut) && c.getConstraseña().equalsIgnoreCase(constraseña)) {
				return c;
			}
		}
		for (Estudiante e : estudiante) {
			if(e.getRut().equalsIgnoreCase(rut) && e.getConstraseña().equalsIgnoreCase(constraseña))
			return e;
		}
		
	}
		return null;
}
	
	public Coordinador buscarCoordinador(String nombre) {
		for(Coordinador c: coordinador) {
			if(c.getNombre().equalsIgnoreCase(nombre)) {
				return c;
			}
		}
		return null;
	}
	
	public Administrador buscarAdmin(String nombre) {
		for(Administrador a : administradores) {
			if(a.getNombre().equalsIgnoreCase(nombre)) {
				return a;
			}
		}
		return null;
	}
}
