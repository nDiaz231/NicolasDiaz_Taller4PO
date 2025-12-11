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
	
	

}
