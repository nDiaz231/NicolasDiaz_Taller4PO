package dominio;

public class Coordinador extends Usuario{
	private String info;

	public Coordinador(String nombre, String constraseña, String rol, String info) {
		super(nombre, constraseña, rol);
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public boolean verificacion(String nombre1, String contraseña1) {
		return nombre.equals(nombre1) && constraseña.equalsIgnoreCase(contraseña1);
	}
	public Coordinador esteCoordinador() {
		return this;
	}
	public boolean coordinador() {
		return true;
	}
	

}
