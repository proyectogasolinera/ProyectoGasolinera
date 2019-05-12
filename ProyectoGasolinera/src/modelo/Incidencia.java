package modelo;

import java.time.LocalDate;
 /**
  * 
  * @author Weize
  *
  */
public class Incidencia {
	private String cod_incid;
	private String DniUsuario;
	private String id_admin;
	private LocalDate fechaIncidencia;
	private LocalDate fechaArreglo;
	private String descripcion;
	private int id_gasolinera; 
	 
	
	//Costructor de nueva incidencia
	public Incidencia(String dniUsuario, String descripcion,int id_gasolinera) {
		super();
		DniUsuario = dniUsuario;
		this.id_gasolinera = id_gasolinera;
		this.descripcion = descripcion;
		this.fechaIncidencia = LocalDate.now();
		this.fechaArreglo = null;
	}
	
	//Costructor para sacar informacion de las incidencias resueltas
	public Incidencia(String cod_incid, String dniUsuario, String id_admin, LocalDate fechaIncidencia,LocalDate fechaArreglo,String descripcion,int id_gasolinera) {
		super();
		this.cod_incid = cod_incid;
		DniUsuario = dniUsuario;
		this.id_admin = id_admin;
		this.id_gasolinera = id_gasolinera;
		this.descripcion = descripcion;
		this.fechaIncidencia = fechaIncidencia;
		this.fechaArreglo=fechaArreglo;
	}
	
	public Incidencia(String cod_incid, String dniUsuario, String id_admin, LocalDate fechaIncidencia,String descripcion,int id_gasolinera) {
		super();
		this.cod_incid = cod_incid;
		DniUsuario = dniUsuario;
		this.id_admin = id_admin;
		this.id_gasolinera = id_gasolinera;
		this.descripcion = descripcion;
		this.fechaIncidencia = fechaIncidencia;
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

