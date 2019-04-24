

package modelo;

import java.time.LocalDate;
   
/**
 * 
 * @author Weize
 *
 */
public class Usuario {
	private String dni;
	private String nombre;
	private String password;
	private String correo; 
	private String direccion;
	private String codPostal;
	private String Telefono;
	private String localidad;
	private LocalDate fechaNacimiento;
	
	public Usuario(String dni, String nombre, String password, String correo, String direccion, String codPostal,
			String telefono, String localidad, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
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

	public String getCorreo() {
		return correo;
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
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", contrase帽a=" + password + ", correo=" + correo
				+ ", direccion=" + direccion + ", codigo Postal=" + codPostal + ", Telefono=" + Telefono + ", localidad="
				+ localidad + ", fecha Nacimiento=" + fechaNacimiento + "]";
	}
	
	
	
}
