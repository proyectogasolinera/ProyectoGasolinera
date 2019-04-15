package modelo;

import java.time.LocalDate;

public class Administrador {

	private String nombre;
	private String dni;
	private String password;
	private String codPostal;
	private String direccion;
	private String correo;
	private String telefono;
	private LocalDate fechaAlt;
	private String id_Administrador;

	public Administrador(String nombre, String dni, String password, String codPostal, String direccion, String correo,
			String telefono, LocalDate fechaAlt, String id_Administrador) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.password = password;
		this.codPostal = codPostal;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.fechaAlt = fechaAlt;
		this.id_Administrador = id_Administrador;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", dni=" + dni + ", password=" + password + ", codPostal=" + codPostal
				+ ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", fechaAlt="
				+ fechaAlt + ", id_Administrador=" + id_Administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaAlt() {
		return fechaAlt;
	}

	public void setFechaAlt(LocalDate fechaAlt) {
		this.fechaAlt = fechaAlt;
	}

	public String getId_Administrador() {
		return id_Administrador;
	}

	public void setId_Administrador(String id_Administrador) {
		this.id_Administrador = id_Administrador;
	}

}
