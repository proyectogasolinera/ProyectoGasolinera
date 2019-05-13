package bd;
/**
 * 
 * @author Alejandro del val
 *
 */
import java.sql.*;
import java.util.*;

import modelo.Carburante;
import modelo.Modificacion;
import java.time.LocalDate;

public class BD_Modificacion extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private String cadenaSQL;
	
//selects
	//Select donde recibe como parametro 1 campo de tipo String 
		public  Vector<Modificacion> selectModificacion(String dato , String campo){
			cadenaSQL="SELECT * from modificaciones WHERE "+campo+" ='"+dato+"'";
			System.out.println(cadenaSQL);
			Vector<Modificacion> listadoModificaciones=new Vector<Modificacion>();
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				
				while ( reg.next()){
					java.sql.Date f=reg.getDate("fecha");
					LocalDate fBuena=f.toLocalDate();
					listadoModificaciones.add(new Modificacion (reg.getInt(1),reg.getString(2),fBuena,reg.getString(4),reg.getInt(5)));
				}
				s.close();
				this.cerrar();
				return listadoModificaciones;
			}
			catch ( SQLException e){		
				return null;			
			}
		}
		//select donde recibe como pararamtro 2 campos 1 de tipo String y otro de tipo int
		
		public  Vector<Modificacion> selectModificacion(String dato1,int dato2 , String campo1,String campo2){
			String cadenaSQL="SELECT * from modificaciones WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"'";

			Vector<Modificacion> listadoModificaciones=new Vector<Modificacion>();
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				
				while ( reg.next()){
					java.sql.Date f=reg.getDate("fecha");
					LocalDate fBuena=f.toLocalDate();
					listadoModificaciones.add(new Modificacion (reg.getInt(1),reg.getString(2),fBuena,reg.getString(4),reg.getInt(5)));
				}
				s.close();
				this.cerrar();
				return listadoModificaciones;
			}
			catch ( SQLException e){		
				return null;			
			}
		}
		
		// select donde recibe como parametro un campo de tipo entero
		public  Vector<Modificacion> selectModicaciones(int dato , String campo){
			String cadenaSQL="SELECT * from modificaciones WHERE "+campo+" ='"+dato+"'";

			Vector<Modificacion> listadoModificaciones=new Vector<Modificacion>();
			try{
				this.abrir();
				s=c.createStatement();
				reg=s.executeQuery(cadenaSQL);
				
				while ( reg.next()){
					java.sql.Date f=reg.getDate("fecha");
					LocalDate fBuena=f.toLocalDate();
					listadoModificaciones.add(new Modificacion (reg.getInt(1),reg.getString(2),fBuena,reg.getString(4),reg.getInt(5)));
				}
				s.close();
				this.cerrar();
				return listadoModificaciones;
			}
			catch ( SQLException e){		
				return null;			
			}
		}

//INSERT
	public int add_modificacion(Modificacion mod){	
		String cadenaSQL="INSERT INTO modificaciones VALUES('" + mod.getCodMod()+ "','" +
		mod.getTipo()+"','"+ mod.getFecha() +"','"+ mod.getId_admin()+"','"+ mod.getId_gasolinera()+"')";
		
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
}
