package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import modelo.Cuenta;


/**
 * 
 * @author Marcos
 *
 */

public class BD_Cuenta extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Cuenta(){
		super();
	}
	
	public int add_cuenta(Cuenta cuenta){
		
		
		String cadenaSQL="INSERT INTO cuentas VALUES('" + cuenta.getNumTarjeta()+"','" +
		cuenta.getDniTitular()+"','"+ cuenta.getSaldo() +"','"+ cuenta.getPunto()+"','"+
				cuenta.getTipoCuenta()+"','"+cuenta.getFechaAlt()+"')";
		
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
	
	//Update de campo a elegir por el usuario, el usuario solo puede cambiar, Mail,Direccion,Cod_postal,password y localidad
		public int updateCuenta(String dni,String campo,String cambio) {

		    String cadena = "UPDATE cuentas SET "+campo+" = '"+cambio+"' WHERE dni_usuario = '" + dni + "'";

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
	
	
	public int borrarCuenta(String dni){
        String cadenaSQL="DELETE FROM cuentas WHERE dni_usuario=('" +dni+"')";

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
	
	//borra una cuenta con la tarjeta introducida
	public int borrarCuentaTarjeta(String tarjeta){
        String cadenaSQL="DELETE FROM cuentas WHERE num_tarj=('" +tarjeta+"')";

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
	
	public  Vector<Cuenta> cuentaList(String dni){
		String cadenaSQL="SELECT * from cuentas WHERE dni_usuario='"+dni+"'";
		Vector<Cuenta> listaCuentas=new Vector<Cuenta>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_alta");
				LocalDate fBuena=f.toLocalDate();
				listaCuentas.add(new Cuenta(reg.getString("num_tarj"),reg.getString("dni_usuario"),reg.getDouble("Saldo"),reg.getInt("Puntos"),reg.getString("Tipo_cuenta"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaCuentas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
	public  Vector<Cuenta> cuentaAllList(){
		String cadenaSQL="SELECT * from cuentas";
		Vector<Cuenta> listaCuentas=new Vector<Cuenta>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_alta");
				LocalDate fBuena=f.toLocalDate();
				listaCuentas.add(new Cuenta(reg.getString("num_tarj"),reg.getString("dni_usuario"),reg.getDouble("Saldo"),reg.getInt("Puntos"),reg.getString("Tipo_cuenta"),fBuena));
				
			}
			s.close();
			this.cerrar();
			return listaCuentas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	

}
