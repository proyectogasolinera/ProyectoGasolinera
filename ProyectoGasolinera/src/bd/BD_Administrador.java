package bd;

/**
 * 
 * @author Alejandro del val
 *
 */
import java.sql.*;
import java.util.*;
import modelo.Administrador;
import modelo.Usuario;

import java.time.LocalDate;

public class BD_Administrador extends BD_Conector{
	private static Statement s;	
	private static ResultSet reg;
	private HashMap<String,String> HMA = new HashMap<String,String>();
	private String cadenaSQL;
//insert
	public int add_admin(Administrador admin){
		
		
		int nRegistros = 0;
		int num=0;
		try{
			//Si las filas retorna 1 el usuario ha sido a馻dido, si devuelve 0, el usuario no se a馻dio, si devuelve -1 no se a馻de por algun error de BD 
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery("SELECT count(*) as total from administrador"); 
			while(reg.next()) {
				nRegistros=Integer.parseInt(reg.getString("total"));
						
			}
			
			num=nRegistros+1;

		}
		catch ( SQLException e){			
			return -1;
		}
		
		
		
		
		String cadenaSQL="INSERT INTO administrador VALUES('" + "AD"+num+ "','" +
		admin.getNombre_admin()+"','"+ admin.getPassword() +"','"+ admin.getDni()+"','"+
				admin.getCorreo()+"','"+admin.getTelefono()+"','"+admin.getDireccion()+"','"+
				admin.getCodPostal()+"','"+admin.getFechaAlt()+"')";
		
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


//Select
public  Vector<Administrador> selectAdmin(String dni){
	String cadenaSQL="SELECT * from administrador WHERE dni='"+dni+"'";
	Vector<Administrador> listadoAdmin=new Vector<Administrador>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		while ( reg.next()){
			java.sql.Date f=reg.getDate("Fecha_alta");
			LocalDate f_alta=f.toLocalDate();
			listadoAdmin.add(new Administrador(reg.getString("id_admin")
					,reg.getString("Nombre_admin"),reg.getString("Password")
					,reg.getString("dni"),reg.getString("Correo_admin")
					,reg.getString("Tlfono_admin"),reg.getString("Direccion_admin"),reg.getString("cod_post"),f_alta));
		}
		s.close();
		this.cerrar();
		return listadoAdmin;
	}
	catch ( SQLException e){		
		return null;			
	}
}

public  Vector<Administrador> selectAdminId(String id){
	String cadenaSQL="SELECT * from administrador WHERE id_admin='"+id+"'";
	Vector<Administrador> listadoAdmin=new Vector<Administrador>();
	try{
		this.abrir();
		s=c.createStatement();
		reg=s.executeQuery(cadenaSQL);
		while ( reg.next()){
			java.sql.Date f=reg.getDate("Fecha_alta");
			LocalDate f_alta=f.toLocalDate();
			listadoAdmin.add(new Administrador(reg.getString("id_admin")
					,reg.getString("Nombre_admin"),reg.getString("Password")
					,reg.getString("dni"),reg.getString("Correo_admin")
					,reg.getString("Tlfono_admin"),reg.getString("Direccion_admin"),reg.getString("codpostal"),f_alta));
		}
		s.close();
		this.cerrar();
		return listadoAdmin;
	}
	catch ( SQLException e){		
		return null;			
	}
}









//update
/*
public int updateAdmin(String direccion,String id) {

    String cadena = "UPDATE administrador  SET Direccion_admin = '"+direccion+"' WHERE id_admin = '" + id + "'";

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
*/

//metodo update para cambiar tipos de datos Strings
public int updateAdminS(String id,String campo,String cambio) {

    String cadena = "UPDATE administrador SET "+campo+" = '"+cambio+"' WHERE id_admin = '" + id + "'";

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

//delete
public int borrarAdmin(String id){	
	String cadenaSQL="DELETE FROM administrador WHERE id_admin=('" +id+"')"; 	
	
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
	public void addHMA(String campo, String dato){
	
	    if (HMA.containsKey(campo)) {
	        System.out.println("No se puede introducir el producto. El c�digo esta repetido.");
	        
	    } else {
	        HMA.put(campo, dato);       
	        System.out.println("Dato capturado correctamente");
	    }
	}
	
	public void reset(){
		HMA.clear();
	}
	public void mostrarHMA() {
	    String clave;
	    Iterator productos =HMA.entrySet().iterator();
	    System.out.println("Hay los siguientes campos:");
	    Map.Entry<String, String> producto;
	    while (productos.hasNext()){
	        	producto=(Map.Entry<String, String>) productos.next();
	        	System.out.println("clave" + " - " + producto.getKey() );
	        	System.out.println("valor" + " - " + producto.getValue() );
	    }        
	}
	

	public  Vector<Administrador> selectAdminHM(){ //se puede optimizr con size
		String campo1="",campo2="",campo3="";
		String dato1="",dato2="",dato3="";
		int i=1;
		   Iterator administradores =HMA.entrySet().iterator();


		    Map.Entry<String, String> administrador;
		    while (administradores.hasNext()){
		        	administrador=(Map.Entry<String, String>) administradores.next();
		        
		        	if (i==1){
		        		campo1=administrador.getKey();
		        		dato1=administrador.getValue();
		        		 cadenaSQL="SELECT * from administrador WHERE "+campo1+" ='"+dato1+"'";
		        	}
		        	if (i==2){
		        		campo2=administrador.getKey();
		        		dato2=administrador.getValue();
		        		cadenaSQL="SELECT * from administrador WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"'";
		        	}
		        	if (i==3){
		        		campo3=administrador.getKey();
		        		dato3=administrador.getValue();
		        		cadenaSQL="SELECT * from administrador WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"' and "+campo3+" = '"+dato3+"' ";
		        	}
		        	i++;
		        	
		    }
		    
		Vector<Administrador> listadoAdmin=new Vector<Administrador>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			
			
			while ( reg.next()){
				java.sql.Date f=reg.getDate("Fecha_alta");
				LocalDate f_alta=f.toLocalDate();
				listadoAdmin.add(new Administrador(reg.getString("id_admin")
						,reg.getString("Nombre_admin"),reg.getString("Password")
						,reg.getString("dni"),reg.getString("Correo_admin")
						,reg.getString("Tlfono_admin"),reg.getString("Direccion_admin"),reg.getString("cod_post"),f_alta));
			}
			reset();
			s.close();
			this.cerrar();
			return listadoAdmin;

		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	public boolean isAdmin(String id, String pass) {
		boolean existe=false;
		String cadenaSQL="SELECT id_admin from administrador WHERE id_admin='"+id+"' AND Password='"+pass+"'";
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
