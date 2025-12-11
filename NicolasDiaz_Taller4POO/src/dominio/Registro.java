package dominio;

public class Registro {
	private String rut;
	private String id;
	private String fechaDeRegistro;
	private String estado;
	private int progreso;
	public Registro(String rut, String id, String fechaDeRegistro, String estado, int progreso) {
		this.rut = rut;
		this.id = id;
		this.fechaDeRegistro = fechaDeRegistro;
		this.estado = estado;
		this.progreso = progreso;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFechaDeRegistro() {
		return fechaDeRegistro;
	}
	public void setFechaDeRegistro(String fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getProgreso() {
		return progreso;
	}
	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}
	
}
