package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

import bd.BD_Conector;
import bd.BD_Usuario;
import modelo.Usuario;


public class MainPrueba {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd"); 
		
		BD_Conector.BD_Ini("aldautomitvebbdd");
		BD_Usuario bda=new BD_Usuario();
		
		System.out.println("Dar de alta usuario");
		
		String dni="43569837W";
		String nombre="Marcos";
		String password="Hola";
		String correo="marcosgrao@gmail.com"; 
		String direccion="Calle Piruleta 8";
		String codPostal="28035";
		String Telefono="683658832";
		String localidad="Madrid";
		String fecha="1996-11-08";
		LocalDate fechaNacimiento=LocalDate.parse(fecha,fechaFormateada);
		
		Usuario usu=new Usuario(nombre,dni,fechaNacimiento,correo,localidad,direccion,codPostal,Telefono,password);
		
		System.out.println(usu.toString());
		int filas=bda.add_usuario(usu);
		
		System.out.println(filas);
		
		String usua="76542322g";
		Vector <Usuario> listado=bda.userList(usua);
		System.out.println("\n\nLISTADO ALUMNOS "+ usua.toUpperCase()+"\n");
		for (int i=0;i<listado.size();i++)									
			System.out.println(listado.get(i).toString());
		
		
	}

}