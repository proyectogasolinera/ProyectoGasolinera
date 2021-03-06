package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import modelo.Incidencia;

/**
 * 
 * @author Marcos
 *
 */

public class BD_Incidencia extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Incidencia(){
		super();
	}



	public int add_inc(Incidencia inc){	
		
		
		//Sacamos el numero de admins
		int nAdmins = 0;
		int aleatorio=0;
		String adminAsignado;
		try{
			//Si las filas retorna 1 el usuario ha sido a馻dido, si devuelve 0, el usuario no se a馻dio, si devuelve -1 no se a馻de por algun error de BD 
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery("SELECT count(*) as total from administrador"); 
			while(reg.next()) {
				nAdmins=Integer.parseInt(reg.getString("total"));
						
			}
			
			aleatorio= (int) (Math.random() * nAdmins) + 1;
			adminAsignado="AD"+aleatorio;

		}
		catch ( SQLException e){			
			return -1;
		}
		
		
		
		int nRegistros;
		int max=0;
		//Sacamos la ultima incidencia
		try{
			//Si las filas retorna 1 el usuario ha sido a馻dido, si devuelve 0, el usuario no se a馻dio, si devuelve -1 no se a馻de por algun error de BD 
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery("SELECT substr(cod_incidencia,-1) as total from incidencias"); 
			while(reg.next()) {
				nRegistros=Integer.parseInt(reg.getString("total"));
					if (nRegistros>max)
						max=nRegistros;
						
			}
				
			max=max+1;
		}
		catch ( SQLException e){			
			return -1;
		}
		
		String cadenaSQL="INSERT INTO incidencias VALUES('" +"INC00000"+ max + "','" +
				inc.getDniUsuario()+"','"+ adminAsignado +"','"+ inc.getFechaIncidencia()+"',null,'"+inc.getDescripcion()+"','"+inc.getId_gasolinera()+"')";
		
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
	
	public int updateInc(String inc,LocalDate fecha) {

	    String cadena = "UPDATE incidencias SET Fecha_arreglo= '"+fecha+"' WHERE cod_incidencia = '" + inc + "'";

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
	
	public int borrarIncidencia(String dni){
        String cadenaSQL="DELETE FROM incidencias WHERE dni_usuario=('" +dni+"')";

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
	
	//METODO PARA BORRAR INCIDENCIA POR COD GASOLINERA
	public int borrarIncGas(int id){
        String cadenaSQL="DELETE FROM incidencias WHERE id_gasolinera=('" +id+"')";

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
	
	//METODO PARA MOSTRAR TODAS LAS INCS
	public  Vector<Incidencia> incAllList(){
		String cadenaSQL="SELECT * from incidencias ";
		Vector<Incidencia> listaIncidencias=new Vector<Incidencia>();
		
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_incidencia");
				LocalDate fFalla=f.toLocalDate();
				
				java.sql.Date f1=reg.getDate("fecha_arreglo");
				if(f1!=null) {
					LocalDate fArreglo=f1.toLocalDate();
					listaIncidencias.add(new Incidencia(reg.getString("cod_incidencia"),reg.getString("dni_usuario"),reg.getString("id_admin"),fFalla,fArreglo,reg.getString("Descripcion"),reg.getInt("id_gasolinera")));
				}
				else
					listaIncidencias.add(new Incidencia(reg.getString("cod_incidencia"),reg.getString("dni_usuario"),reg.getString("id_admin"),fFalla,reg.getString("Descripcion"),reg.getInt("id_gasolinera")));
				
			}
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	
	
	
	
	//Metodo para ver todas las incs de un usuario
	public  Vector<Incidencia> incUserList(String dni){
		String cadenaSQL="SELECT * from incidencias WHERE dni_usuario='"+dni+"'";
		Vector<Incidencia> listaIncidencias=new Vector<Incidencia>();
		
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_incidencia");
				LocalDate fFalla=f.toLocalDate();
				java.sql.Date f1=reg.getDate("fecha_arreglo");
				LocalDate fArreglo=f1.toLocalDate();
				listaIncidencias.add(new Incidencia(reg.getString("cod_incidencia"),reg.getString("dni_usuario"),reg.getString("id_admin"),fFalla,fArreglo,reg.getString("Descripcion"),reg.getInt("id_gasolinera")));
				
			}
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	//Buscar Incidencias por usuario o administrador, resueltas o no resueltas
	public  Vector<Incidencia> incUserListResolve(String id,String campo,String entrada){
		String cadenaSQL="SELECT * from incidencias WHERE "+campo+"='"+id+"' and Fecha_arreglo is "+entrada+"";
		Vector<Incidencia> listaIncidencias=new Vector<Incidencia>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_incidencia");
				LocalDate fFalla=f.toLocalDate();
				
				java.sql.Date f1=reg.getDate("fecha_arreglo");
				if(f1!=null) {
					LocalDate fArreglo=f1.toLocalDate();
					listaIncidencias.add(new Incidencia(reg.getString("cod_incidencia"),reg.getString("dni_usuario"),reg.getString("id_admin"),fFalla,fArreglo,reg.getString("Descripcion"),reg.getInt("id_gasolinera")));
				}
				else
					listaIncidencias.add(new Incidencia(reg.getString("cod_incidencia"),reg.getString("dni_usuario"),reg.getString("id_admin"),fFalla,reg.getString("Descripcion"),reg.getInt("id_gasolinera")));
				
			}
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	//Metodo para buscar todas las incidencias asignadas a un administrador
	public  Vector<Incidencia> incAdminList(String cod){
		String cadenaSQL="SELECT * from incidencias WHERE id_admin='"+cod+"'";
		Vector<Incidencia> listaIncidencias=new Vector<Incidencia>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_incidencia");
				LocalDate fFalla=f.toLocalDate();
				java.sql.Date f1=reg.getDate("fecha_arreglo");
				LocalDate fArreglo=f1.toLocalDate();
				listaIncidencias.add(new Incidencia(reg.getString("cod_incidencia"),reg.getString("dni_usuario"),reg.getString("id_admin"),fFalla,fArreglo,reg.getString("Descripcion"),reg.getInt("id_gasolinera")));
				
			}
			s.close();
			this.cerrar();
			return listaIncidencias;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	
}
