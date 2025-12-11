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
	
	
	
	
}
