
public class Gasolinera {
	private int id_Gasolinera;
	private String provincia;
	private String municipio;
	private String localidad;
	private String codPostal;
	private String direccion;
	private String margen;
	private float longitud;
	private float latitud;
	private String rotulo;
	private String tipoVenta;
	private String horario;

	public Gasolinera(int id_Gasolinera, String provincia, String municipio, String localidad, String codPostal,
			String direccion, String margen, float longitud, float latitud, String rotulo, String tipoVenta,
			String horario) {
		super();
		this.id_Gasolinera = id_Gasolinera;
		this.provincia = provincia;
		this.municipio = municipio;
		this.localidad = localidad;
		this.codPostal = codPostal;
		this.direccion = direccion;
		this.margen = margen;
		this.longitud = longitud;
		this.latitud = latitud;
		this.rotulo = rotulo;
		this.tipoVenta = tipoVenta;
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "id_Gasolinera=" + id_Gasolinera + ", provincia=" + provincia + ", municipio=" + municipio
				+ ", localidad=" + localidad + ", codPostal=" + codPostal + ", direccion=" + direccion + ", margen="
				+ margen + ", longitud=" + longitud + ", latitud=" + latitud + ", rotulo=" + rotulo + ", tipoVenta="
				+ tipoVenta + ", horario=" + horario;
	}

	public int getId_Gasolinera() {
		return id_Gasolinera;
	}

	public void setId_Gasolinera(int id_Gasolinera) {
		this.id_Gasolinera = id_Gasolinera;
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

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMargen() {
		return margen;
	}

	public void setMargen(String margen) {
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

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
}
