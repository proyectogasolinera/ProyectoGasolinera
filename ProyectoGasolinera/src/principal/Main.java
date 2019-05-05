package principal;
/**
 * 
 * @author Alejandro del val
 *
 */
import modelo.*;
import bd.*;
import java.time.format.DateTimeFormatter;
import java.time.format.*;
import java.time.LocalDate;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		BD_Conector.BD_Ini("aldautomotivebbdd");
		//DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");
		BD_Administrador bdA= new BD_Administrador();
		BD_Gasolinera bdG=new BD_Gasolinera();
		BD_Carburante bdC=new BD_Carburante();
		BD_Modificacion bdM=new BD_Modificacion();
		int op;
		int filas;
		//datos admin
		String id_admin;
		String nombre_admin;
		String password;
		String dni_adm;
		String correo;
		String telefono;
		String direccion;
		String codPostal;
		//datos Gasolinera
		int id_Gas;
		//datos Carburantes
	
		 String tipo;
		 float precio;
		 int id_gasolinera;
		LocalDate fecha_modP;
		//datos Modificacion
		 int cod_mod;
		String tipo_mod;
		 LocalDate fecha_mod;
		 //String id_admin;
		 //int id_gasolinera;
		

		
		
		do{
			System.out.println("*******************************");
			System.out.println("-------Opciones Administrardor--------");
			System.out.println("Seleccione opcion deseada:\n 1: mostrar Administrador.\n 2: Insertar nuevo Administrador\n 3.Borrar administrador\n 4.Modificar datos Administrador");
			System.out.println("************************");
			System.out.println("-------Opciones Gasolinera---------");
			System.out.println("\n 5:Seleccione Gasolinera\n 6: Insertar nueva Gasolinera\n 7: Borrar Gasolinera\n 8:Modificar datos Gasolinera");
			System.out.println("************************");
			System.out.println("-------Opciones Carburantes---------");
			System.out.println("9.Buscar Carburante");
			System.out.println("10.Insertar nuevo carburante");
			System.out.println("11. Modificar precio carburaante");
			System.out.println("12.Borrar carburante Gasolinera");
			System.out.println("-------Opciones Modificacion---------");
			op=sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("Introduzca dni administrado:");
				sc.nextLine();
				dni_adm=sc.nextLine();
				Vector <Administrador> listaAdmin=bdA.selectAdmin(dni_adm);
				for (int i=0;i<listaAdmin.size();i++)									
					System.out.println(listaAdmin.get(i).toString());
				break;
			case 2:
				sc.nextLine();
				System.out.println("Introducce datos nuevo Administrador");
				System.out.println("*******************");
				System.out.println("Identificador administrado: ");
				id_admin=sc.nextLine();
				System.out.println("Nombre:");
				nombre_admin=sc.nextLine();
				System.out.println("Password:");
				password=sc.nextLine();
				System.out.println("dni:");
				 dni_adm=sc.nextLine();
				 System.out.println("Correo electronico:");
				 correo=sc.nextLine();
				 System.out.println("Telefono:");
				 telefono=sc.nextLine();
				 System.out.println("dirrecion:");
				 direccion=sc.nextLine();
				 System.out.println("Codigo postal:");
				 codPostal=sc.nextLine();	 
				 LocalDate fechaAlt=LocalDate.now();
				 
				 Administrador admin=new Administrador(id_admin,nombre_admin,password,dni_adm,correo,telefono,direccion,codPostal,fechaAlt);
				 filas=bdA.add_admin(admin);
				 if(filas==1){
						System.out.println("Administrador nuevo introduccido");
				 		System.out.println(admin.toString());
				 }
					else
						System.out.println("Error - "+filas);
					
					break;
				 
			case 3:
				break;
			case 4:
				break;
			case 5:
				sc.nextLine();
				System.out.println("identificador Gasolinera: ");
				id_Gas=sc.nextInt();
				Vector<Gasolinera> listaGas=bdG.selectGasolinera(id_Gas);
				for(int i=0; i<listaGas.size();i++){
					System.out.println(listaGas.get(i).toString());
				}
				break;
			case 9:
				sc.nextLine();
				System.out.println("Tipo de carburante a buscar:");
				tipo=sc.nextLine();
				System.out.println("Identificador de la Gasolinera:");
				id_Gas=sc.nextInt();
				Vector<Carburante> listaCarbu= bdC.selectCarburante(tipo,id_Gas);
				for(int i=0; i<listaCarbu.size();i++){
					System.out.println(listaCarbu.get(i).toString());
				}
				break;
			case 10:
				System.out.println("Tipo de carburante: ");
				sc.nextLine();
				tipo=sc.nextLine();
				System.out.println("Precio del "+tipo);
				precio=sc.nextFloat();
				System.out.println("Identificador Gasolinera");
				id_gasolinera=sc.nextInt();
				fecha_modP=LocalDate.now();
				Carburante carbu=new Carburante(tipo,precio,id_gasolinera,fecha_modP);
				filas=bdC.add_carburante(carbu);
				 if(filas==-1){
					 System.out.println("Se ha producido un error interno");
				 }
				 else{
					 System.out.println("Carburante "+tipo+" introduccido ");
					 //Introduccion automatica en la tabla modificaciones 
					int filas2= bdM.add_modificacion(cod_mod,tipo_mod,fecha_mod,id_admin,id_gasolinera);
					 
				 }
				break;
				
				
				

			
			}
		}while(op!=11);
	}

}
