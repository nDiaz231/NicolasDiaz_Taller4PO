package dominio;

public class Administrador extends Usuario{

	public Administrador(String nombre, String constraseña, String rol) {
		super(nombre, constraseña, rol);
	}

	@Override
	public boolean verificacion(String nombre1, String contraseña1) {
		return nombre.equals(nombre1) && constraseña.equalsIgnoreCase(contraseña1);
	}
	public Administrador esteAdmin() {
		return this;
	}
	public boolean administrador() {
		return true;
	}

}
