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
	
//selects
	

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
