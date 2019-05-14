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
	
	
	
	public  Vector<Modificacion> selectModificacionAll(){
		cadenaSQL="SELECT * from modificaciones";
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
	
	
	//Select que recibe id gasolinera y devuelve sus modificaciones
	public  Vector<Modificacion> selectModificacionGas(int id){
		cadenaSQL="SELECT * from modificaciones WHERE id_gasolinera=('" +id+"')";
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
		
		int modMax=0;
		try{
			//Si las filas retorna 1 el usuario ha sido a馻dido, si devuelve 0, el usuario no se a馻dio, si devuelve -1 no se a馻de por algun error de BD 
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery("SELECT max(cod_mod) as total from modificaciones"); 
			while(reg.next()) {
				modMax=Integer.parseInt(reg.getString("total"));
						
			}
			modMax++;
		

		}
		catch ( SQLException e){			
			return -1;
		}
		
		String cadenaSQL="INSERT INTO modificaciones VALUES('" + modMax+ "','" +
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
	
	public int borrarModGas(int id){
        String cadenaSQL="DELETE FROM modificaciones WHERE id_gasolinera=('" +id+"')";

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
