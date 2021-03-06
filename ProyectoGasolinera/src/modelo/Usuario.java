

package modelo;

import java.time.LocalDate;
   
/**
 * 
 * @author Weize
 *
 */
public class Usuario {
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private String mail;
	private String localidad;
	private String direccion;
	private String codPostal;
	private String Telefono;
	private String password;	
	
	
	public Usuario(String nombre, String dni, LocalDate fechaNacimiento, String mail, String localidad, String direccion,
			String codPostal, String telefono, String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.password = password;
		this.mail = mail;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.Telefono = telefono;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//Costructor para sacar todos los datos por select menos password
	public Usuario(String nombre, String dni, LocalDate fechaNacimiento, String mail, String localidad, String direccion,
			String codPostal, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.mail = mail;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.Telefono = telefono;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public String getTelefono() {
		return Telefono;
	}

	public String getLocalidad() {
		return localidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", password=" + password + ", correo=" + mail
				+ ", direccion=" + direccion + ", codigo Postal=" + codPostal + ", Telefono=" + Telefono + ", localidad="
				+ localidad + ", fecha Nacimiento=" + fechaNacimiento + "]";
	}
	
	
	
}
