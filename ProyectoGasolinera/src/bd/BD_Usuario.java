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
	
	public int add_usuario(Usuario usu){	
		String cadenaSQL="INSERT INTO clientes VALUES('" + usu.getNombre() + "','" +
		usu.getDni()+"','"+ usu.getFechaNacimiento() +"','"+ usu.getCorreo()+"','"+
				usu.getLocalidad()+"','"+usu.getDireccion()+"','"+usu.getCodPostal()+"','"+
				usu.getTelefono()+"','"+usu.getPassword()+"')";
		
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
	
	
	public  Vector<Usuario> userList(String dni){
		String cadenaSQL="SELECT * from clientes WHERE dni_usuario='"+dni+"'";
		Vector<Usuario> listaUsuarios=new Vector<Usuario>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_naci");
				LocalDate fBuena=f.toLocalDate();
				listaUsuarios.add(new Usuario(reg.getString("nombre"),reg.getString("dni_usuario"),fBuena,reg.getString("mail"),reg.getString("localidad"),reg.getString("direccion"),reg.getString("cod_post"),reg.getString("tlf"),reg.getString("password")));
				
			}
			s.close();
		
			this.cerrar();
			return listaUsuarios;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
}
