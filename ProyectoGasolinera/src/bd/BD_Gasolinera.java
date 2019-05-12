
package bd;
/**
 * 
 * @author Alejandro del val
 *
 */
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import modelo.Administrador;
import modelo.Gasolinera;


import java.time.LocalDate;

public class BD_Gasolinera extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private HashMap<String,String> HMG = new HashMap<String,String>();
	private String cadenaSQL="";


/*fWigo postal
 

public  Vector<Gasolinera> selectGasolinera1 (int cod){
	String cadenaSQL="SELECT * from gasolineras WHERE codpostal='"+cod+"'";
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
*/
// select donde recibe como parametro un campo de tipo entero
public  Vector<Gasolinera> selectGasolinera(int dato , String campo){
	String cadenaSQL="SELECT * from gasolineras WHERE "+campo+" ='"+dato+"'";

	Vector<Gasolinera> listadoGasolinera=new Vector<Gasolinera>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		
		while ( reg.next()){
		
			listadoGasolinera.add(new Gasolinera(reg.getInt(1),reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7),reg.getString(8).charAt(0),reg.getFloat(9),reg.getFloat(10),reg.getString(11)));
		}
		s.close();
		this.cerrar();
		return listadoGasolinera;
	}
	catch ( SQLException e){		
		return null;			
	}
}
//Select donde recibe como parametro 2 campos de tipo String
public  Vector<Gasolinera> selectGasolinera(String dato1,String dato2 , String campo1,String campo2){
	String cadenaSQL="SELECT * from gasolineras WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"'";

	Vector<Gasolinera> listadoGasolinera=new Vector<Gasolinera>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		
		while ( reg.next()){
		
		listadoGasolinera.add(new Gasolinera(reg.getInt(1),reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7),reg.getString(8).charAt(0),reg.getFloat(9),reg.getFloat(10),reg.getString(11)));
		}
		s.close();
		this.cerrar();
		return listadoGasolinera;
	}
	catch ( SQLException e){		
		return null;			
	}
}
//Select donde recibe como parametro 1 campo de tipo String 
public  Vector<Gasolinera> selectGasolinera(String dato , String campo){
	cadenaSQL="SELECT * from gasolineras WHERE "+campo+" ='"+dato+"'";
	System.out.println(cadenaSQL);
	Vector<Gasolinera> listadoGasolinera=new Vector<Gasolinera>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		
		while ( reg.next()){
		
		listadoGasolinera.add(new Gasolinera(reg.getInt(1),reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7),reg.getString(8).charAt(0),reg.getFloat(9),reg.getFloat(10),reg.getString(11)));
		}
		s.close();
		this.cerrar();
		return listadoGasolinera;
	}
	catch ( SQLException e){		
		return null;			
	}
}
//select donde recibe como pararamtro 2 campos 1 de tipo String y otro de tipo int
/*
public  Vector<Gasolinera> selectGasolinera(String dato1,int dato2 , String campo1,String campo2){
	String cadenaSQL="SELECT * from gasolineras WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"'";

	Vector<Gasolinera> listadoGasolinera=new Vector<Gasolinera>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		
		while ( reg.next()){
		
		listadoGasolinera.add(new Gasolinera(reg.getInt(1),reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7),reg.getString(8).charAt(0),reg.getFloat(9),reg.getFloat(10),reg.getString(11)));
		}
		s.close();
		this.cerrar();
		return listadoGasolinera;
	}
	catch ( SQLException e){		
		return null;			
	}
}
*/
//Inserts
public int add_Gasolinera(Gasolinera gas){	
	String cadenaSQL="INSERT INTO gasolineras (empresa,provincia,municipio,localidad,codpostal,direccion,margen,longitud,latitud,Horario) VALUES('"+gas.getEmpresa()+"','"+ gas.getProvincia() +"','"+ gas.getMunicipio()+"','"+
			gas.getLocalidad()+"','"+gas.getCodpostal()+"','"+gas.getDireccion()+"','"+
			gas.getMargen()+"','"+gas.getLongitud()+"','"+ gas.getLatitud()+"','"+ gas.getHorario()+"')";
	
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
//Delete
public int borrarGas(int id){	
	String cadenaSQL="DELETE FROM gasolineras WHERE id_gasolinera=('" +id+"')"; 	
	
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

//Metodos HashMap
	public void addHMG(String campo, String dato){
	
	    if (HMG.containsKey(campo)) {
	        System.out.println("No se puede introducir el producto. El c�digo esta repetido.");
	        
	    } else {
	        HMG.put(campo, dato);       
	        System.out.println("Dato capturado correctamente");
	    }
	}
	
	public void reset(){
		HMG.clear();
	}
	public void mostrarHMG() {
	    String clave;
	    Iterator productos =HMG.entrySet().iterator();
	    System.out.println("Hay los siguientes productos:");
	    Map.Entry<String, String> producto;
	    while (productos.hasNext()){
	        	producto=(Map.Entry<String, String>) productos.next();
	        	System.out.println("clave" + " - " + producto.getKey() );
	        	System.out.println("valor" + " - " + producto.getValue() );
	    }        
	}
	
	public  Vector<Gasolinera> selectGasolineraHM(){ //se puede optimizr con size
		String campo1="",campo2="",campo3="";
		String dato1="",dato2="",dato3="";
		int i=1;
		   Iterator gasolineras =HMG.entrySet().iterator();


		    Map.Entry<String, String> gasolinera;
		    while (gasolineras.hasNext()){
		        	gasolinera=(Map.Entry<String, String>) gasolineras.next();
		        
		        	if (i==1){
		        		campo1=gasolinera.getKey();
		        		dato1=gasolinera.getValue();
		        		 cadenaSQL="SELECT * from gasolineras WHERE "+campo1+" ='"+dato1+"'";
		        	}
		        	if (i==2){
		        		campo2=gasolinera.getKey();
		        		dato2=gasolinera.getValue();
		        		cadenaSQL="SELECT * from gasolineras WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"'";
		        	}
		        	if (i==3){
		        		campo3=gasolinera.getKey();
		        		dato3=gasolinera.getValue();
		        		cadenaSQL="SELECT * from gasolineras WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"' and "+campo3+" = '"+dato3+"' ";
		        	}
		        	i++;
		        	
		    }
		Vector<Gasolinera> listadoGasolinera=new Vector<Gasolinera>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
		
			
			while ( reg.next()){
			
			listadoGasolinera.add(new Gasolinera(reg.getInt(1),reg.getString(2),reg.getString(3),reg.getString(4),reg.getString(5),reg.getString(6),reg.getString(7),reg.getString(8).charAt(0),reg.getFloat(9),reg.getFloat(10),reg.getString(11)));
			}
			reset();
			s.close();
			this.cerrar();
			return listadoGasolinera;

		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	
}