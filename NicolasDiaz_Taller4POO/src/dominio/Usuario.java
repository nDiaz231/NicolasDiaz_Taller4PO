package dominio;

public abstract class Usuario {
	protected String nombre;
	protected String constraseña;
	protected String rol;
	
	public Usuario(String nombre, String constraseña, String rol) {
		this.nombre = nombre;
		this.constraseña = constraseña;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConstraseña() {
		return constraseña;
	}

	public void setConstraseña(String constraseña) {
		this.constraseña = constraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	public abstract boolean verificacion(String nombre1, String contraseña1);
	
	
	//Creamos booleans para ver que tipo de usuario son
	public boolean coordinador() {
		return false;
	}
	public boolean administrador() {
		return false;
	}
	public boolean estudiante() {
		return false;
	}
	//creamos Objetos de cada usuario para luego devolverlo cuando queramos
	public Estudiante esteEstudiante() {
		return null;
	}
	
	public Administrador esteAdmin() {
		return null;
	}
	
	public Coordinador esteCoordinador() {
		return null;
	}
	
	
	
}
