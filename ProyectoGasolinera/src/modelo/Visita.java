package modelo;

import java.time.LocalDate;

public class Visita { 
	private String DniUsuario; 
	private LocalDate fechaVisita;  
	private String id_gasolinera;
	private double precio;
	private String tipoPago;
	
	public Visita(String dniUsuario, LocalDate fechaVisita, String id_gasolinera, double precio, String tipoPago) {
		super();
		DniUsuario = dniUsuario;
		this.fechaVisita = fechaVisita;
		this.id_gasolinera = id_gasolinera;
		this.precio = precio;
		this.tipoPago = tipoPago;
	}

	public String getDniUsuario() {
		return DniUsuario;
	}

	public LocalDate getFechaVisita() {
		return fechaVisita;
	}

	public String getId_gasolinera() {
		return id_gasolinera;
	}

	public double getPrecio() {
		return precio;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	@Override
	public String toString() {
		return "Visita [Dni Usuario=" + DniUsuario + ", fecha Visita=" + fechaVisita + ", id_gasolinera=" + id_gasolinera
				+ ", precio=" + precio + ", tipo de Pago=" + tipoPago + "]";
	}
	
	
}

