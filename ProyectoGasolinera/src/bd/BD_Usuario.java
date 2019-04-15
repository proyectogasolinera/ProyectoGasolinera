package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Usuario;

public class BD_Usuario extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Usuario(){
		super();
	}
	
	public  int a馻dir_usuario(Usuario usu){	
		String cadenaSQL="INSERT INTO usuario VALUES('" + usu.getDni() + "','" +
		usu.getPassword()+"','"+ usu.getNombre() +"',"+ usu.getCorreo()+",'"+
				usu.getFechaNacimiento()+"','"+usu.getLocalidad()+"','"+usu.getTelefono()+"','"+
				usu.getDireccion()+"','"+usu.getCodPostal()+"')";
		
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
}
