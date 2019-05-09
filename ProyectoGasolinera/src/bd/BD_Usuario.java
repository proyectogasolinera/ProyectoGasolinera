package bd;

/**
 * 
 * @author Marcos
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import modelo.Usuario;

public class BD_Usuario extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Usuario(){
		super();
	}
	
	//Metodo para a�adir usuarios
	public int add_usuario(Usuario usu){	
		String cadenaSQL="INSERT INTO clientes VALUES('" + usu.getNombre() + "','" +
		usu.getDni()+"','"+ usu.getFechaNacimiento() +"','"+ usu.getMail()+"','"+
				usu.getLocalidad()+"','"+usu.getDireccion()+"','"+usu.getCodPostal()+"','"+
				usu.getTelefono()+"','"+usu.getPassword()+"')";
		
		try{
			//Si las ilas retorna 1 el usuario ha sido a馻dido, si devuelve 0, el usuario no se a馻dio, si devuelve -1 no se a馻de por algun error de BD 
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
	
	//Update de campo a elegir por el usuario, el usuario solo puede cambiar, Mail,Direccion,Cod_postal,password y localidad
	public int updateUser(String dni,String campo,String cambio) {

	    String cadena = "UPDATE clientes SET "+campo+" = '"+cambio+"' WHERE dni_usuario = '" + dni + "'";

	    try{
	        this.abrir();
	        s=c.createStatement();
	        int filas=s.executeUpdate(cadena);
	        s.close();
	        this.cerrar();
	        return filas;
	    }
	    catch ( SQLException e){
	        return -1;
	    }

	}
	
	//Metodo para eliminar usuarios.
	public int borrarUser(String dni){
        String cadenaSQL="DELETE FROM clientes WHERE dni_usuario=('" +dni+"')";

        try{
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
	
	//Select de todos los campos de cliente menos password
	public  Vector<Usuario> userList(String dni){
		String cadenaSQL="SELECT nombre,dni_usuario,fecha_naci,mail,localidad,direccion,cod_post,tlf,password from clientes WHERE dni_usuario='"+dni+"'";
		Vector<Usuario> listaUsuarios=new Vector<Usuario>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_naci");
				LocalDate fBuena=f.toLocalDate();
				listaUsuarios.add(new Usuario(reg.getString("nombre"),reg.getString("dni_usuario"),fBuena,reg.getString("mail"),reg.getString("localidad"),reg.getString("direccion"),reg.getString("cod_post"),reg.getString("tlf")));
				
			}
			s.close();
		
			this.cerrar();
			return listaUsuarios;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	public boolean isUser(String dni, String pass) {
		boolean existe=false;
		String cadenaSQL="SELECT dni_usuario from clientes WHERE dni_usuario='"+dni+"' AND password='"+pass+"'";
		this.abrir();
		try {
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		if (reg.next())
			existe=true;
		s.close();		
		this.cerrar();
		return existe;
		}
		catch ( SQLException e){		
			return false;			
		}
	}
}
