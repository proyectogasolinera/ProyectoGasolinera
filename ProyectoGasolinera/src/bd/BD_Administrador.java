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
