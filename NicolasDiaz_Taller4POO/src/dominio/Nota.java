package dominio;

public class Nota {
	private String rut;
	private String codigoAsignatura;
	private String calificacion;
	private String estado;
	private String semestre;
	public Nota(String rut, String codigoAsignatura, String calificacion, String estado, String semestre) {
		this.rut = rut;
		this.codigoAsignatura = codigoAsignatura;
		this.calificacion = calificacion;
		this.estado = estado;
		this.semestre = semestre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getCodigoAsignatura() {
		return codigoAsignatura;
	}
	public void setCodigoAsignatura(String codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
}
