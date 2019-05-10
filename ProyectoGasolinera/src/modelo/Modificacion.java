package modelo;

import java.time.LocalDate;

public class Modificacion {
	
	private int cod_mod;
	private String tipo;
	private LocalDate fecha;
	private String id_admin;
	private int id_gasolinera;
	/*
	 * 
	 * Tipo de modificaciones: 
	 *	- modificacion de precio [M
	 * 	- modificacion de datos gasolinera Mod
	 *
	 */
	
	public Modificacion(int cod_mod, String tipo, LocalDate fecha, String id_admin, int id_gasolinera) {
		super();
		this.cod_mod = cod_mod;
		this.tipo = tipo;
		this.fecha = fecha;
		this.id_admin = id_admin;
		this.id_gasolinera = id_gasolinera;
	}
	
	
	@Override
	public String toString() {
		return "Modificacion: cod_mod=" + cod_mod + ", tipo=" + tipo + ", fecha=" + fecha + ", id_admin=" + id_admin
				+ ", id_gasolinera=" + id_gasolinera;
	}

	public int getCodMod() {
		return cod_mod;
	}
	public void setCodMod(int cod_mod) {
		this.cod_mod = cod_mod;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getId_admin() {
		return id_admin;
	}
	public void setId_admin(String id_admin) {
		this.id_admin = id_admin;
	}
	public int getId_gasolinera() {
		return id_gasolinera;
	}
	public void setId_gasolinera(int id_gasolinera) {
		this.id_gasolinera = id_gasolinera;
	}

	
	
}