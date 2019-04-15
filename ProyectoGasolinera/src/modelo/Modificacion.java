package modelo;

import java.time.LocalDate;

public class Modificacion {
	private int id_Gasolinera;
	private String id_Admin;
	private LocalDate fechaMod;
	private String codMod;
	private String tipoMod;

	public Modificacion(int id_Gasolinera, String id_Admin, LocalDate fechaMod, String codMod, String tipoMod) {
		super();
		this.id_Gasolinera = id_Gasolinera;
		this.id_Admin = id_Admin;
		this.fechaMod = fechaMod;
		this.codMod = codMod;
		this.tipoMod = tipoMod;
	}

	@Override
	public String toString() {
		return "id_Gasolinera=" + id_Gasolinera + ", id_Admin=" + id_Admin + ", fechaMod=" + fechaMod + ", codMod="
				+ codMod + ", tipoMod=" + tipoMod;
	}

	public int getId_Gasolinera() {
		return id_Gasolinera;
	}

	public void setId_Gasolinera(int id_Gasolinera) {
		this.id_Gasolinera = id_Gasolinera;
	}

	public String getId_Admin() {
		return id_Admin;
	}

	public void setId_Admin(String id_Admin) {
		this.id_Admin = id_Admin;
	}

	public LocalDate getFechaMod() {
		return fechaMod;
	}

	public void setFechaMod(LocalDate fechaMod) {
		this.fechaMod = fechaMod;
	}

	public String getCodMod() {
		return codMod;
	}

	public void setCodMod(String codMod) {
		this.codMod = codMod;
	}

	public String getTipoMod() {
		return tipoMod;
	}

	public void setTipoMod(String tipoMod) {
		this.tipoMod = tipoMod;
	}

}
