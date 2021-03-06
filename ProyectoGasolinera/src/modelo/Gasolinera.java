package modelo;

import java.util.HashMap;
import java.util.Iterator;

//Problema tipo de datos del modelo no coincidQen con el tipo de datos la base de datos 
public class Gasolinera {
	private int id_gasolinera;
	private String empresa;
	private String provincia;
	private String municipio;
	private String localidad;
	private String codpostal;
	private String direccion;
	private char margen;
	private float longitud;
	private float latitud;
	private String horario;
	

	
	public Gasolinera(int id_gasolinera, String empresa, String provincia, String municipio, String localidad,
			String codpostal, String direccion, char margen, float longitud, float latitud, String Horario) {
		super();
		this.id_gasolinera = id_gasolinera;
		this.empresa = empresa;
		this.provincia = provincia;
		this.municipio = municipio;
		this.localidad = localidad;
		this.codpostal = codpostal;
		this.direccion = direccion;
		this.margen = margen;
		this.longitud = longitud;
		this.latitud = latitud;
		this.horario = Horario;
	}

	@Override
	public String toString() {
		return "Gasolinera: id_gasolinera=" + id_gasolinera + ", empresa=" + empresa + ", provincia=" + provincia
				+ ", municipio=" + municipio + ", localidad=" + localidad + ", codpostal=" + codpostal + ", direccion="
				+ direccion + ", margen=" + margen + ", longitud=" + longitud + ", latitud=" + latitud + ", Horario="
				+ horario;
	}

	public int getId_gasolinera() {
		return id_gasolinera;
	}

	public void setId_gasolinera(int id_gasolinera) {
		this.id_gasolinera = id_gasolinera;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public char getMargen() {
		return margen;
	}

	public void setMargen(char margen) {
		this.margen = margen;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		horario = horario;
	}
	

	
}
