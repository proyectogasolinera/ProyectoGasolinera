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

	//select 
	public  Vector<Carburante> selectCarburante( String tipo,int id){
		String cadenaSQL="SELECT * from carburantes WHERE id_gasolinera='"+id+"' and tipo_carbu='"+tipo+"'";
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
}
