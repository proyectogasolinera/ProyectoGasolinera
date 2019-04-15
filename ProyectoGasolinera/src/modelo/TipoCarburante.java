
public class TipoCarburante {

	private String idGasolinera;
	private String nombreCarburante;
	private float precio;
	
	public TipoCarburante(String idGasolinera, String nombreCarburante, float precio) {
		super();
		this.idGasolinera = idGasolinera;
		this.nombreCarburante = nombreCarburante;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "idGasolinera=" + idGasolinera + ", nombreCarburante=" + nombreCarburante + ", precio="
				+ precio;
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
	
	
	
	
	
}
