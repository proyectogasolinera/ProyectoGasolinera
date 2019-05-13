
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


import modelo.Usuario;

public class BD_Usuario extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	private HashMap<String,String> HMU = new HashMap<String,String>();
	private String cadenaSQL;
	public BD_Usuario(){
		super();
	}
	
	//Metodo para añadir usuarios
	public int add_usuario(Usuario usu){	
		String cadenaSQL="INSERT INTO clientes VALUES('" + usu.getNombre() + "','" +
		usu.getDni()+"','"+ usu.getFechaNacimiento() +"','"+ usu.getMail()+"','"+
				usu.getLocalidad()+"','"+usu.getDireccion()+"','"+usu.getCodPostal()+"','"+
				usu.getTelefono()+"','"+usu.getPassword()+"')";
		
		try{
			//Si las ilas retorna 1 el usuario ha sido aé¦»dido, si devuelve 0, el usuario no se aé¦»dio, si devuelve -1 no se aé¦»de por algun error de BD 
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
	
	//Update de campo a elegir por el usuario, el usuario solo puede cambiar, 
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
	
	//Metodo para eliminar usuarios.
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
	
	//Select de todos los campos de cliente menos password
	public  Vector<Usuario> userList(String dni){
		String cadenaSQL="SELECT nombre,dni_usuario,fecha_naci,mail,localidad,direccion,cod_post,tlf,password from clientes WHERE dni_usuario='"+dni+"'";
		Vector<Usuario> listaUsuarios=new Vector<Usuario>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_naci");
				LocalDate fBuena=f.toLocalDate();
				listaUsuarios.add(new Usuario(reg.getString("nombre"),reg.getString("dni_usuario"),fBuena,reg.getString("mail"),reg.getString("localidad"),reg.getString("direccion"),reg.getString("cod_post"),reg.getString("tlf")));
				
			}
			s.close();
		
			this.cerrar();
			return listaUsuarios;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	public boolean isUser(String dni, String pass) {
		boolean existe=false;
		String cadenaSQL="SELECT dni_usuario from clientes WHERE dni_usuario='"+dni+"' AND password='"+pass+"'";
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
	//Metodos HashMap
		public void addHMU(String campo, String dato){
		
		    if (HMU.containsKey(campo)) {
		        System.out.println("No se puede introducir el producto. El código esta repetido.");
		        
		    } else {
		        HMU.put(campo, dato);       
		        System.out.println("Dato capturado correctamente");
		    }
		}
		
		public void reset(){
			HMU.clear();
		}
		public void mostrarHMA() {
		    String clave;
		    Iterator usuarios =HMU.entrySet().iterator();
		    System.out.println("Hay los siguientes campos:");
		    Map.Entry<String, String> usuario;
		    while (usuarios.hasNext()){
		        	usuario=(Map.Entry<String, String>) usuarios.next();
		        	System.out.println("clave" + " - " + usuario.getKey() );
		        	System.out.println("valor" + " - " + usuario.getValue() );
		    }        
		}
		public  Vector<Usuario> selectUserHM(){ //se puede optimizr con size
			String campo1="",campo2="",campo3="";
			String dato1="",dato2="",dato3="";
			int i=1;
			   Iterator usuarios =HMU.entrySet().iterator();
			   
			    Map.Entry<String, String> usuario;
			    
			    while (usuarios.hasNext()){
			        	usuario=(Map.Entry<String, String>) usuarios.next();
			        
			        	if (i==1){
			        		campo1=usuario.getKey();
			        		dato1=usuario.getValue();
			        		 cadenaSQL="SELECT * from clientes WHERE "+campo1+" ='"+dato1+"'";
			        	}
			        	if (i==2){
			        		campo2=usuario.getKey();
			        		dato2=usuario.getValue();
			        		cadenaSQL="SELECT * from clientes WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"'";
			        	}
			        	if (i==3){
			        		campo3=usuario.getKey();
			        		dato3=usuario.getValue();
			        		cadenaSQL="SELECT * from clientes WHERE "+campo1+"  ='"+dato1+"' and "+campo2+"  ='"+dato2+"' and "+campo3+" = '"+dato3+"' ";
			        	}
			        	i++;
			        	
			    }
			    Vector<Usuario> listadoUser=new Vector<Usuario>();
				try{
					this.abrir();
					s=c.createStatement();
					reg=s.executeQuery(cadenaSQL);
					
					
					while ( reg.next()){
						// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
						java.sql.Date f=reg.getDate("fecha_naci");
						LocalDate fBuena=f.toLocalDate();
						listadoUser.add(new Usuario(reg.getString("nombre"),reg.getString("dni_usuario"),fBuena,reg.getString("mail"),reg.getString("localidad"),reg.getString("direccion"),reg.getString("cod_post"),reg.getString("tlf")));
						
					}
					reset();
					s.close();
					this.cerrar();
					return listadoUser;

				}
				catch ( SQLException e){		
					return null;			
				}

		}
	
}

