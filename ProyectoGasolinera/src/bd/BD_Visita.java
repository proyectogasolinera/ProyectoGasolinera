package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;


import modelo.Visita;

/**
 * 
 * @author Marcos
 *
 */

//BD_Visita
public class BD_Visita extends BD_Conector {
	
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Visita(){
		super();
	}
	
	
	public int add_visita(Visita visit){	
		String cadenaSQL="INSERT INTO visitas VALUES('" + visit.getDniUsuario() +"','"+visit.getFechaVisita()+"','"+ visit.getTipoPago() +"','"+ visit.getId_gasolinera()+"','"+
				visit.getPrecio()+"')";
		
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
	
	public int borrarVisita(String dni,int cod,LocalDate fecha){
        String cadenaSQL="DELETE FROM visitas WHERE dni_usuario=('" +dni+"')and id_gasolinera=('"+cod+"') and fecha_visita=('"+fecha+"')";

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
	
	public  Vector<Visita> visitList(String dni){
		String cadenaSQL="SELECT * from visitas WHERE dni_usuario='"+dni+"'";
		Vector<Visita> listaVisitas=new Vector<Visita>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				java.sql.Date f=reg.getDate("fecha_visita");
				LocalDate fBuena=f.toLocalDate();
				listaVisitas.add(new Visita(reg.getString("dni_usuario"),fBuena,reg.getString("tipo_pago"),reg.getInt("id_gasolinera"),reg.getDouble("total")));
				
			}
			s.close();
			this.cerrar();
			return listaVisitas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
}	


