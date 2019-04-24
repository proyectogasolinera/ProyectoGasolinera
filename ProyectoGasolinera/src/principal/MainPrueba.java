package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
		String direccion="C/Piruleta 8";
		String codPostal="28035";
		String Telefono="683658832";
		String localidad="Madrid";
		String fecha="1996-11-08";
		LocalDate fechaNacimiento=LocalDate.parse(fecha,fechaFormateada);
		
		Usuario usu=new Usuario(dni,nombre,password,correo,direccion,codPostal,Telefono,localidad,fechaNacimiento);			
		int filas=bda.add_usuario(usu);
		
		System.out.println(filas);
		
	}

}