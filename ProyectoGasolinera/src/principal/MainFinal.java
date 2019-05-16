package principal;

import java.util.*;

import bd.BD_Administrador;
import bd.BD_Conector;
import bd.BD_Usuario;
/**
 *  
 * @author Weize
 *
 */
public class MainFinal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BD_Conector.BD_Ini("aldautomitvebbdd");
		BD_Usuario bdu=new BD_Usuario();
		BD_Administrador bda=new BD_Administrador();
		String tipo,id,password,dni;
		String nombreAdmin,nombreUsu;
		int opc;
		System.out.println("---Hola! Bienvenido al nuestro aplicacion---");
		do {
			System.out.println("¿Quien eres?(admin/cliente)");
			tipo = sc.nextLine();
			if(!tipo.equalsIgnoreCase("admin") && !tipo.equalsIgnoreCase("cliente"))
				System.out.println("Introducido incorrecto, por favor introduce de nuevo");
		}while(!tipo.equalsIgnoreCase("admin") && !tipo.equalsIgnoreCase("cliente"));
		
		switch (tipo) {
		case "ADMIN":
		case "admin":
				System.out.println("Introduce el ID del adninistrador:");
				id=sc.nextLine();
				System.out.println("Introduce el password:");
				password = sc.nextLine();
			
			do { 
				System.out.println("---Elige un campo---");
				System.out.println("1.Gestionar Administrardor\n2.Gestionar Cliente\n3.Mostrar Visitas\n4.Gestionar Incidencias");
				System.out.println("5.Gestionar Cuentas\n6.Gestionar dato Gasolinera\n7.Gestionar Carburante\n8.Mostrar Modificacion");
				System.out.println("9.Salir");
				opc=sc.nextInt();
				switch(opc) {
				case 1:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar Administrador.\n 2.Insertar nuevo Administrador");
						System.out.println(" 3.Borrar administrador\n 4.Modificar datos Administrador\n 5.Salir");
						opc=sc.nextInt();
						switch(opc) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					break;
				case 2:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar Cliente.\n 2.Insertar nuevo Cliente");
						System.out.println(" 3.Elimina Cliente\n 4.Modificar datos Cliente\n 5.Salir");
						opc=sc.nextInt();
						switch(opc) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					break;
				case 3:
					System.out.println("--Todas las visitas--");
					
					break;
				case 4:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar todas las incidencias");
						System.out.println(" 2.Mostrar todas sus incidencias, resueltas o no\n 3.Arregla una incidencia\n 4.Salir");
						opc=sc.nextInt();
						switch(opc) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=3);
					break;
				case 5:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Inserta una cuenta\n 2.Cancelar una cuenta\n 3.Asociar una cuenta a un cliente");
						System.out.println(" 4.Mostrar todas las cuentas\n 5.Salir");
					    opc=sc.nextInt();
						switch(opc) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					break;
				case 6:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Consultar Gasolinera\n 2.Insertar nueva Gasolinera");
						System.out.println(" 3.Borrar Gasolinera\n 4.Modificar datos Gasolinera\n 5.Salir");
					    opc=sc.nextInt();
						switch(opc) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					break;
				case 7:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Buscar carburante\n 2.Insertar nuevo carburante");
						System.out.println(" 3.Modificar precio carburante\n 4.Borrar carburante gasolinera\n 5.Salir");
					    opc=sc.nextInt();
						switch(opc) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					break;
				case 8:
					System.out.println("--Todos los modificaciones--");
					break;
				case 9:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opcion incorrecta");
				}
			}while(opc!=9);
			break;
			
		case "CLIENTE":
		case "cliente":
				System.out.println("Introduce el DNI del usuario:");
				dni=sc.nextLine();
				System.out.println("Introduce el password:");
				password = sc.nextLine();
			do {
				System.out.println("1.Búsqueda Gasolinera\n2.Opcion Incidencia\n3.Consulta Cuentas\n4.Perfil Usuario");
				System.out.println("5.Salir");
				opc=sc.nextInt();
				switch(opc) {
				case 1:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.consulta empresa\n 2.consulta ubicacion");
						System.out.println(" 3.consulta precio\n 4.consulta codigo postal\n 5.Salir");
						opc=sc.nextInt();
					}while(opc!=5);
					switch(opc) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
					break;
				case 2:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Reporta incidencia\n 2.Anular incidencia\n 3.Mostrar incidencia\n 4.Salir");
						opc=sc.nextInt();
					}while(opc!=3);
					switch(opc) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
					break;
				case 3:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.mostrar cuenta\n 2.consultar saldo\n 3.consultar puntos\n 4.Salir");
						opc=sc.nextInt();
					}while(opc!=4);
					switch(opc) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4: 
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
					break;
				case 4:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar dato perfil\n 2.Modificar datos\n 3.Salir");
						opc=sc.nextInt();
					}while(opc!=4);
					switch(opc) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
					break;
				case 5:
					System.out.println("Gracias por tu visita,Adios!");
					break;
				default:
					System.out.println("Opcion incorrecta");
				}
			}while(opc!=4); 
			break;
		}

	}

}
