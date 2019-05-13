package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import bd.BD_Administrador;
import bd.BD_Conector;
import bd.BD_Cuenta;
import bd.BD_Incidencia;
import bd.BD_Usuario;
import bd.BD_Visita;
import modelo.Usuario;

public class MainAdmin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd");
		
		BD_Conector.BD_Ini("aldautomotivebbdd");
		BD_Usuario bdu=new BD_Usuario();
		BD_Visita bdv=new BD_Visita();
		BD_Incidencia bdi=new BD_Incidencia();
		BD_Cuenta bdc=new BD_Cuenta();
		BD_Administrador bda=new BD_Administrador();
		
		String tipo,dni,password,nombre,fecha,correo,dni_usu,localidad,direccion,codPostal,telefono,campo = null,cambio;
		int opc,opc1;
		
		System.out.println("-----Hola! Bienvenido-----");
		do {
			System.out.println("¿Quien eres?(admin/cliente)");
			tipo = sc.nextLine();
			if(!tipo.equalsIgnoreCase("admin") && !tipo.equalsIgnoreCase("cliente"))
				System.out.println("Introducido incorrecto");
		}while(!tipo.equalsIgnoreCase("admin") && !tipo.equalsIgnoreCase("cliente"));
		
		switch (tipo) {
		case "ADMIN":
		case "admin":
			//do {
				System.out.println("Introduce el DNI del adninistrador:");
				dni=sc.nextLine();
				System.out.println("Introduce el password:");
				dni=sc.nextLine();
			//}while(null);
			do {
				System.out.println("---Elige un campo---");
				System.out.println("1.Modificar Administrardor\n2.Gestionar Cliente\n3.Mostrar Visitas\n4.Gestionar Incidencias");
				System.out.println("5.Gestionar Cuentas\n6.Modificar dato Gasolinera\n7.Gestionar Carburante\n8.Mostrar Modificacion");
				System.out.println("9.Salir");
				opc=sc.nextInt();
				switch(opc) {
				case 1:
					do {
						System.out.println("Seleccione opcion deseada:\n 1.mostrar Administrador.\n 2.Insertar nuevo Administrador");
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
						System.out.println("Seleccione opcion deseada:\n 1.mostrar Cliente.\n 2.Insertar nuevo Cliente");
						System.out.println(" 3.Elimina Cliente\n 4.Modificar datos Cliente\n 5.Salir");
						opc=sc.nextInt();
						switch(opc) {
						
						//Mostrar usuario
						case 1:
							sc.nextLine();
							System.out.println("Introduce dni usuario para buscar");
							dni_usu=sc.nextLine();
							Vector <Usuario> listadoUser=bdu.userList(dni_usu);
							System.out.println("\n\nLISTADO USUARIO "+ dni_usu.toUpperCase()+"\n");
							for (int i=0;i<listadoUser.size();i++)									
								System.out.println(listadoUser.get(i).toString());
							break;
						
						//Añadir usuario	
						case 2:
							sc.nextLine();
							System.out.println("Introduzca el nombre del usuario");
							nombre=sc.nextLine();
							System.out.println("Introduzca el DNI del usuario");
							dni_usu=sc.nextLine();
							System.out.println("Introduzca fecha de nacimiento del usuario en formato (YYYY-MM-DD)");
							fecha=sc.nextLine();
							LocalDate fechaNacimiento=LocalDate.parse(fecha,fechaFormateada);
							System.out.println("Introduzca correo electronico del usuario");
							correo=sc.nextLine();
							System.out.println("Introduzca localidad del usuario");
							localidad=sc.nextLine();
							System.out.println("Introduzca la direccion del usuario");
							direccion=sc.nextLine();
							System.out.println("Introduzca el cod postal del usuario");
							codPostal=sc.nextLine();
							System.out.println("Introduzca el telefono del usuario");
							telefono=sc.nextLine();
							System.out.println("Introduzca contraseña para el usuario");
							password=sc.nextLine();
							
							Usuario usu=new Usuario(nombre,dni_usu,fechaNacimiento,correo,localidad,direccion,codPostal,telefono,password);
							
							System.out.println(usu.toString());
							int filas=bdu.add_usuario(usu);
							if(filas==1)
								System.out.println("Usuario añadido con exito");
							else
								System.out.println("Error - "+filas);
							
							break;
							
						//Eliminar usuario	
						case 3:
							sc.nextLine();
							System.out.println("DNI");
							dni_usu=sc.nextLine();
							
							//Eliminamos la cuenta
							filas=bdc.borrarCuenta(dni_usu);
							if(filas==1)
								System.out.println("Se elimina la cuenta");
							else
								System.out.println("Error - "+filas);
							
							//Eliminamos visitas
							filas=bdv.borrarVisita(dni_usu);
							if(filas==1)
								System.out.println("Visita eliminada con exito");
							else
								System.out.println("Error - "+filas);
			
							
							//Eliminamos incidencias
							filas=bdi.borrarIncidencia(dni_usu);
							if(filas==1)
								System.out.println("Incidencia eliminada con exito");
							else
								System.out.println("Error - "+filas);
							
							//Finalmente eliminamos el usuario							
							filas=bdu.borrarUser(dni_usu);
							if(filas==1)
								System.out.println("Usuario eliminado con exito");
							else
								System.out.println("Error - "+filas);
							
							break;
							
						//Modificar datos de usuario, Mail,Direccion,Cod_postal,password y localidad
						case 4:
							sc.nextLine();
							System.out.println("Introduce dni del user a modificar");
							dni_usu=sc.nextLine();
							System.out.println("Que campo desea modificar ?");
							System.out.println("1.Correo electronico");
							System.out.println("2.Password");
							System.out.println("3.Localidad");
							System.out.println("4.Direccion");
							System.out.println("5.Cod_Postal");
							opc1=sc.nextInt();
							
							switch(opc1) {
								case 1:
									campo="mail";
									break;
								case 2:
									campo="password";
									break;
								case 3:
									campo="localidad";
									break;
								case 4:
									campo="direccion";
									break;
								case 5:
									campo="cod_postal";
									break;
							}
							sc.nextLine();	
							System.out.println("Introduce nuevo registro");
							cambio=sc.nextLine();
							
							filas=bdu.updateUser(dni_usu, campo, cambio);
							if(filas==1)
								System.out.println("Cambio realizado");
							else
								System.out.println("Error - "+filas);
							
							break;
							
						//Salir	
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
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar incidencias\n 2.Arregla una incidencia\n 3.Salir");
						opc=sc.nextInt();
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
					break;
				case 7:
					break;
				case 8:
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
			//do {
			System.out.println("Introduce el DNI del usuario:");
			dni=sc.nextLine();
			System.out.println("Introduce el password:");
			dni=sc.nextLine();
		//}while(null);
			do {
				System.out.println("1.Búsqueda Gasolinera\n2.Opcion Incidencia\n3.Consulta Cuentas");
				System.out.println("4.Salir");
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
						System.out.println("Seleccione opcion deseada:\n 1.Reporta incidencia\n 2.anular incidencia\n 3.Salir");
						opc=sc.nextInt();
					}while(opc!=3);
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
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opcion incorrecta");
				}
			}while(opc!=4);
			break;
		}

	}

}
