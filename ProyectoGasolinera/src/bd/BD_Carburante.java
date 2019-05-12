package bd;
/**
 * 
 * @author Alejandro del val
 *
 */
import java.sql.*;
import java.util.*;


import modelo.Carburante;


import java.time.LocalDate;

public class BD_Carburante extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;

	//selects
	public  Vector<Carburante> selectCarburante( String tipo,int id){
		String cadenaSQL="SELECT * from carburante WHERE id_gasolinera='"+id+"' and tipo_carbu='"+tipo+"'";
		Vector<Carburante> listadoCarbu=new Vector<Carburante>();
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			while ( reg.next()){
				java.sql.Date f=reg.getDate("fecha_mod");
				LocalDate fecha_mod=f.toLocalDate();
				
				listadoCarbu.add(new Carburante(reg.getString(1),reg.getFloat(2),reg.getInt(3),fecha_mod));
			}
			s.close();
			this.cerrar();
			return listadoCarbu;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	//select para que me saque todos los cargurates con precios de la misma gasolinera
	public  Vector<Carburante> selectCarburante(int id){
		String cadenaSQL="SELECT * from carburante WHERE id_gasolinera='"+id+"'";
		Vector<Carburante> listadoCarbu=new Vector<Carburante>();
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			while ( reg.next()){
				java.sql.Date f=reg.getDate("fecha_mod");
				LocalDate fecha_mod=f.toLocalDate();
				
				listadoCarbu.add(new Carburante(reg.getString(1),reg.getFloat(2),reg.getInt(3),fecha_mod));
			}
			s.close();
			this.cerrar();
			return listadoCarbu;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	// insert
	public int add_carburante(Carburante carbu){	
		String cadenaSQL="INSERT INTO carburante VALUES('" + carbu.getTipo_carbu()+ "','" +
		carbu.getPrecio()+"','"+ carbu.getId_gasolinera() +"','"+ carbu.getFecha_mod()+"')";
		
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
	//delete
	public int borrarCarbu(int id){	
		String cadenaSQL="DELETE FROM carburante WHERE id_gasolinera=('" +id+"')"; 	
		
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
	
	//update precio
	public int updatePrecio( String tipo,int id,float precio,LocalDate fecha_mod) {

	    String cadena = "UPDATE carburante SET precio = '"+precio+"' , fecha_mod= '"+fecha_mod+"' WHERE id_gasolinera='"+id+"' and tipo_carbu='"+tipo+"'";

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
}
