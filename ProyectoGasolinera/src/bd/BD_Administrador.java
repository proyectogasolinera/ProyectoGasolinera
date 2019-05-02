package bd;

/**
 * 
 * @author Alejandro del val
 *
 */
import java.sql.*;
import java.util.*;
import modelo.Administrador;

import java.time.LocalDate;

public class BD_Administrador extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	
	
	public int add_admin(Administrador admin){	
		String cadenaSQL="INSERT INTO administrador VALUES('" + admin.getId_admin() + "','" +
		admin.getNombre_admin()+"','"+ admin.getPassword() +"','"+ admin.getDni()+"','"+
				admin.getCorreo()+"','"+admin.getTelefono()+"','"+admin.getDireccion()+"','"+
				admin.getCodPostal()+"','"+admin.getFechaAlt()+"')";
		
		try{
			//Si las filas retorna 1 el usuario ha sido a馻dido, si devuelve 0, el usuario no se a馻dio, si devuelve -1 no se a馻de por algun error de BD 
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
		
			s.close();
			this.cerrar();
			return filas;
			
			}
			catch ( SQLException e){			
				return -1;
			}
	
	}


//Select
public  Vector<Administrador> selectAdmin(String dni){
	String cadenaSQL="SELECT * from administrador WHERE dni='"+dni+"'";
	Vector<Administrador> listadoAdmin=new Vector<Administrador>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		while ( reg.next()){
			java.sql.Date f=reg.getDate("Fecha_alta");
			LocalDate f_alta=f.toLocalDate();
			listadoAdmin.add(new Administrador(reg.getString("id_admin"),reg.getString("Nombre_admin"),reg.getString("Password"),reg.getString("dni"),reg.getString("Correo_admin"),reg.getString("Tlfono_admin"),reg.getString("Direccion_admin"),reg.getString("cod_post"),f_alta));
		}
		s.close();
		this.cerrar();
		return listadoAdmin;
	}
	catch ( SQLException e){		
		return null;			
	}
}
}
