package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Usuario;

public class BD_Usuario extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Usuario(){
		super();
	}
	
	public  int añadir_usuario( Usuario usu){	
		String cadenaSQL="INSERT INTO usuario VALUES('" + usu.getDni() + "','" +
		usu.getContraseña()+"','"+ usu.getNombre() +"',"+ usu.getCorreo()+",'"+
				usu.getFechaNacimiento()+"','"+usu.getLocalidad()+"','"+usu.getTelefono()+"','"+
				usu.getDireccion()+"','"+usu.getCodPostal()+"')";
		
		try{
			//Si las filas retorna 1 el usuario ha sido añadido, si devuelve 0, el usuario no se añadio, si devuelve -1 no se añade por algun error de BD 
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
}
