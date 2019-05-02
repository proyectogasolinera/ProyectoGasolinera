package bd;
/**
 * 
 * @author Alejandro del val
 *
 */
import java.sql.*;
import java.util.*;

import modelo.Administrador;
import modelo.Gasolinera;


import java.time.LocalDate;

public class BD_Gasolinera extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;



//
public  Vector<Gasolinera> selectGasolinera(int id){
	String cadenaSQL="SELECT * from gasolineras WHERE id_gasolinera='"+id+"'";
	Vector<Gasolinera> listadoGasolinera=new Vector<Gasolinera>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		while ( reg.next()){
		
		listadoGasolinera.add(new Gasolinera(reg.getInt(1),reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getInt(6),reg.getString(7),reg.getString(8).charAt(0),reg.getFloat(9),reg.getFloat(10),reg.getString(11)));
		}
		s.close();
		this.cerrar();
		return listadoGasolinera;
	}
	catch ( SQLException e){		
		return null;			
	}
}
}