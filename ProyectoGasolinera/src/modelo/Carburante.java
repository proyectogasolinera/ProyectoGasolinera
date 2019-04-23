package modelo;

import java.time.LocalDate;

public class Carburante {

	private String idGasolinera;
	private String nombreCarburante;
	private float precio;
	private LocalDate fecha_mod;
	
	public Carburante(String idGasolinera, String nombreCarburante, float precio,LocalDate fecha_mod) {
		super();
		this.idGasolinera = idGasolinera;
		this.nombreCarburante = nombreCarburante;
		this.precio = precio;
		this.fecha_mod= fecha_mod;
	}

	public LocalDate getFecha_mod() {
		return fecha_mod;
	}

	public void setFecha_mod(LocalDate fecha_mod) {
		this.fecha_mod = fecha_mod;
	}


	public String getIdGasolinera() {
		return idGasolinera;
	}

	public void setIdGasolinera(String idGasolinera) {
		this.idGasolinera = idGasolinera;
	}

	public String getNombreCarburante() {
		return nombreCarburante;
	}

	public void setNombreCarburante(String nombreCarburante) {
		this.nombreCarburante = nombreCarburante;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Carburante [idGasolinera=" + idGasolinera + ", nombreCarburante=" + nombreCarburante + ", precio="
				+ precio + ", fecha_mod=" + fecha_mod + "]";
	}
	
	
	
	
	
	
	
}
