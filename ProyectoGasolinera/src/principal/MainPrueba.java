package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

import bd.BD_Conector;
import bd.BD_Usuario;
import bd.BD_Visita;
import modelo.Usuario;
import modelo.Visita;


public class MainPrueba {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd"); 
		
		BD_Conector.BD_Ini("aldautomitvebbdd");
		BD_Usuario bdu=new BD_Usuario();
		BD_Visita bdv=new BD_Visita();
		
		
		int opc;
		String dni_usu;
		
		do {
			System.out.println("1.Dar de alta usuario");
			System.out.println("2.Buscar usuario");
			opc=sc.nextInt();
			
			switch(opc) {
				case 1:
					sc.nextLine();
					System.out.println("Introduce Nombre");
					String nombre=sc.nextLine();
					System.out.println("Introduce DNI");
					String dni=sc.nextLine();
					System.out.println("Introduce fecha de nacimiento");
					String fecha=sc.nextLine();
					LocalDate fechaNacimiento=LocalDate.parse(fecha,fechaFormateada);
					System.out.println("Introduce correo");
					String correo=sc.nextLine();
					System.out.println("Introduce localidad");
					String localidad=sc.nextLine();
					System.out.println("Introduce direccion");
					String direccion=sc.nextLine();
					System.out.println("Introduce codPostal");
					String codPostal=sc.nextLine();
					System.out.println("Introduce Telefono");
					String Telefono=sc.nextLine();
					System.out.println("Introduce password");
					String password=sc.nextLine();
					
					Usuario usu=new Usuario(nombre,dni,fechaNacimiento,correo,localidad,direccion,codPostal,Telefono,password);
					
					System.out.println(usu.toString());
					int filas=bdu.add_usuario(usu);
					if(filas==1)
						System.out.println("Usuario añadido con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
				case 2:
					sc.nextLine();
					System.out.println("Introduce dni usuario para buscar");
					dni_usu=sc.nextLine();
					Vector <Usuario> listadoUser=bdu.userList(dni_usu);
					System.out.println("\n\nLISTADO ALUMNOS "+ dni_usu.toUpperCase()+"\n");
					for (int i=0;i<listadoUser.size();i++)									
						System.out.println(listadoUser.get(i).toString());
					break;
				case 3:
					sc.nextLine();
					System.out.println("Introduce dni");
					dni=sc.nextLine();
					System.out.println("Introduce fecha de visita");
					fecha=sc.nextLine();
					LocalDate fcha=LocalDate.parse(fecha,fechaFormateada);
					System.out.println("Introduce tipo de pago");
					String tipo=sc.nextLine();
					System.out.println("Introduce id_gasolinera");
					int id=sc.nextInt();
					System.out.println("Introduce precio");
					double precio=sc.nextDouble();
					
					Visita visit=new Visita(dni,fcha,tipo,id,precio);
					
					System.out.println(visit.toString());
					filas=bdv.add_visita(visit);
					if(filas==1)
						System.out.println("Usuario añadido con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 4:
					sc.nextLine();
					System.out.println("Introduce dni usuario para buscar");
					dni_usu=sc.nextLine();
					Vector<Visita> listadoVisita=bdv.visitList(dni_usu);
					System.out.println("\n\nLISTADO ALUMNOS "+ dni_usu.toUpperCase()+"\n");
					for (int i=0;i<listadoVisita.size();i++)									
						System.out.println(listadoVisita.get(i).toString());
					break;
					
			}
			
		}while(opc!=10);

		
		
		
		
		
		
		
		
		
		
	}

}