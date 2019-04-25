package modelo;

import java.time.LocalDate;
/**
 * 
 * @author Weize
 *
 */
public class Visita { 
	
	private String DniUsuario; 
	private LocalDate fechaVisita; 
	private String tipoPago;
	private int id_gasolinera;
	private double precio; //se puede omitir dependiendo si realiza pago en efectivo
	
	
	public Visita(String dniUsuario, LocalDate fechaVisita,String tipoPago, int id_gasolinera, double precio ) {
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

	public int getId_gasolinera() {
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

