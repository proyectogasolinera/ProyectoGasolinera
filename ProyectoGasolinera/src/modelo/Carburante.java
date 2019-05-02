package modelo;

import java.time.*;

public class Carburante {

	private String tipo_carbu;
	private float precio;
	private int id_gasolinera;
	private LocalDate fecha_mod;
	
	public Carburante(String tipo_carbu, float precio, int id_gasolinera, LocalDate fecha_mod) {
		super();
		this.tipo_carbu = tipo_carbu;
		this.precio = precio;
		this.id_gasolinera = id_gasolinera;
		this.fecha_mod = fecha_mod;
	}
	
	
	@Override
	public String toString() {
		return "carburante: tipo_carbu=" + tipo_carbu + ", precio=" + precio + ", id_gasolinera=" + id_gasolinera
				+ ", fecha_mod=" + fecha_mod;
	}


	public String getTipo_carbu() {
		return tipo_carbu;
	}
	public void setTipo_carbu(String tipo_carbu) {
		this.tipo_carbu = tipo_carbu;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getId_gasolinera() {
		return id_gasolinera;
	}
	public void setId_gasolinera(int id_gasolinera) {
		this.id_gasolinera = id_gasolinera;
	}
	public LocalDate getFecha_mod() {
		return fecha_mod;
	}
	public void setFecha_mod(LocalDate fecha_mod) {
		this.fecha_mod = fecha_mod;
	}
	
	
}	