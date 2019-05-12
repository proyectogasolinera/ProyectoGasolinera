package modelo;

import java.time.LocalDate;

public class Administrador {
	
	private String id_admin;
	private String Nombre_admin;
	private String Password;
	private String dni;
	private String correo;
	private String telefono;
	private String direccion;
	private String codPostal;
	private LocalDate fechaAlt;
	
	
	
	
	public Administrador( String Nombre_admin, String Password, String dni, String correo,
			String telefono,String direccion,String codPostal) {
		super();
		this.Nombre_admin = Nombre_admin;
		this.Password = Password;
		this.dni = dni;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.fechaAlt = LocalDate.now();
		
	}
	
	
	public Administrador(String id_admin, String Nombre_admin, String Password, String dni, String correo,
			String telefono,String direccion,String codPostal,LocalDate fechaAlt) {
		super();
		this.id_admin = id_admin;
		this.Nombre_admin = Nombre_admin;
		this.Password = Password;
		this.dni = dni;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.fechaAlt = fechaAlt;
		
	}

	@Override
	public String toString() {
		return "Administrador: id_admin=" + id_admin + ", Nombre_admin=" + Nombre_admin + ", Password=" + Password
				+ ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", codPostal=" + codPostal + ", fechaAlt=" + fechaAlt ;
	}

	public String getId_admin() {
		return id_admin;
	}

	public void setId_admin(String id_admin) {
		this.id_admin = id_admin;
	}

	public String getNombre_admin() {
		return Nombre_admin;
	}

	public void setNombre_admin(String nombre_admin) {
		Nombre_admin = nombre_admin;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public LocalDate getFechaAlt() {
		return fechaAlt;
	}

	public void setFechaAlt(LocalDate fechaAlt) {
		this.fechaAlt = fechaAlt;
	}

	
	

	
}