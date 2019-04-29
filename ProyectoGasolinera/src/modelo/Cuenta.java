package modelo;

import java.time.LocalDate;
 /**
  * 
  * @author Weize
  *
  */
public class Cuenta {  
	private String numTarjeta;
	private String DniTitular; 
	private double saldo;
	private int punto;
	private String tipoCuenta;
	private LocalDate fechaAlt;
	
	public Cuenta(String numTarjeta, String dniTitular, double saldo, int punto, String tipoCuenta) {
		super();
		this.numTarjeta = numTarjeta;
		DniTitular = dniTitular;
		this.saldo = saldo;
		this.punto = punto;
		this.tipoCuenta = tipoCuenta;
		LocalDate fecha=LocalDate.now();
		this.fechaAlt = fecha;
	}
	
	
	public Cuenta(String numTarjeta, String dniTitular, double saldo, int punto, String tipoCuenta,LocalDate fecha) {
		super();
		this.numTarjeta = numTarjeta;
		DniTitular = dniTitular;
		this.saldo = saldo;
		this.punto = punto;
		this.tipoCuenta = tipoCuenta;
		this.fechaAlt = fecha;
	}


	public String getNumTarjeta() {
		return numTarjeta;
	}
	public String getDniTitular() {
		return DniTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public int getPunto() {
		return punto;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public LocalDate getFechaAlt() {
		return fechaAlt;
	}
	@Override
	public String toString() {
		return "Cuenta [numero de Tarjeta=" + numTarjeta + ", Dni Titular=" + DniTitular + ", saldo=" + saldo + ", punto="
				+ punto + ", tipo de cuenta=" + tipoCuenta + ", fecha Alta=" + fechaAlt + "]";
	}
	
	
}

