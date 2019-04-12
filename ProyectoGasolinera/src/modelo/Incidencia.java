package modelo;

import java.time.LocalDate;
 
public class Incidencia {
	private String cod_incid;
	private String DniUsuario;
	private String id_admin;
	private int id_gasolinera;
	private String descripcion; 
	private LocalDate fechaIncidencia;
	private LocalDate fechaArreglo;  
	
	public Incidencia(String cod_incid, String dniUsuario, String id_admin, int id_gasolinera, String descripcion,
			LocalDate fechaIncidencia, LocalDate fechaArreglo) {
		super();
		this.cod_incid = cod_incid;
		DniUsuario = dniUsuario;
		this.id_admin = id_admin;
		this.id_gasolinera = id_gasolinera;
		this.descripcion = descripcion;
		this.fechaIncidencia = fechaIncidencia;
		this.fechaArreglo = fechaArreglo;
	}

	public String getCod_incid() {
		return cod_incid;
	}

	public String getDniUsuario() {
		return DniUsuario;
	}

	public String getId_admin() {
		return id_admin;
	}

	public int getId_gasolinera() {
		return id_gasolinera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public LocalDate getFechaIncidencia() {
		return fechaIncidencia;
	}

	public LocalDate getFechaArreglo() {
		return fechaArreglo;
	}

	@Override
	public String toString() {
		return "Incidencia [codigo de incidencia=" + cod_incid + ", Dni Usuario=" + DniUsuario + ", id_admin=" + id_admin
				+ ", id_gasolinera=" + id_gasolinera + ", descripcion=" + descripcion + ", fecha Incidencia="
				+ fechaIncidencia + ", fecha Arreglo=" + fechaArreglo + "]";
	}
	
	
}

