package logica;
import dominio.*;
public class TipoFactory {
	public static Usuario crearUsuario(String tipo,String nombre,String contraseña,String carrera, int semestre , String correo,String area ,String rut) {
		switch (tipo) {
		case "Estudiante":
			return new Estudiante( rut,  nombre,  carrera,  semestre,  correo,  contraseña);
		case "Coordinador":
			return new Coordinador( nombre, contraseña, "Coordinador",area);
		default :
			return null;
		}
	}
	
	
}
