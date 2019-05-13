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
import modelo.Administrador;
import modelo.Incidencia;
import modelo.Usuario;
import modelo.Visita;

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
		
		String tipo,idAdmin,password,nombre,fecha,correo,dni_usu,localidad,direccion,codPostal,telefono,campo = null,cambio,codInc;
		int opc,opc1,opc2,idGasolinera,filas;
		boolean login=false;
		
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
			
			//EL ADMINISTRADOR SE LOGUEA
			do {
				System.out.println("Introduce el id del adninistrador:");
				idAdmin=sc.nextLine();
				System.out.println("Introduce el password:");
				password=sc.nextLine();
				login=bda.isAdmin(idAdmin, password);
				if(login)
					System.out.println("Bienvenido");
				else
					System.out.println("Datos de administrador incorrecto");
				}while(login==false);
			
			do {
				System.out.println("---Elige un campo---");
				System.out.println("1.Gestionar Administrardor\n2.Gestionar Cliente\n3.Mostrar Visitas\n4.Gestionar Incidencias");
				System.out.println("5.Gestionar Cuentas\n6.Modificar dato Gasolinera\n7.Gestionar Carburante\n8.Mostrar Modificacion");
				System.out.println("9.Salir");
				opc=sc.nextInt();
				System.out.println("--------------------------------------------");
				switch(opc) {
				case 1:
					do {
						System.out.println("MENU ADMINISTRADOR\n");
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar sus datos de administrador.\n 2.Modificar sus datos persolanes");
						System.out.println(" 3.Insertar nuevo administrador\n 4.Borrar administrador\n 5.Salir");
						System.out.println("--------------------------------------------");
						opc=sc.nextInt();
						switch(opc) {
						
						//MOSTRAR DATOS DEL ADMINISTRADOR LOGUEADO
						case 1:
							System.out.println("--------------------------------------------------------------------------------------------------------------");
							Vector <Administrador> datosAdmin=bda.selectAdminId(idAdmin);
							System.out.println("SUS DATOS DE ADMINISTRADOR\n");
							for (int i=0;i<datosAdmin.size();i++)									
								System.out.println(datosAdmin.get(i).toString());
							System.out.println("--------------------------------------------------------------------------------------------------------------");
							break;
							
						//MODIFICAR DATOS DEL ADMINISTRADOR LOGUEADO
						case 2:
							sc.nextLine();
							System.out.println("--------------------------------------------");
							System.out.println("Que campo desea modificar ?");
							System.out.println("1.Cambiar password\n2.Cambiar correo\n3.Cambiar telefono\n4.Cambiar direccion\n5.Cambiar codigo postal");
							System.out.println("--------------------------------------------");
							opc1=sc.nextInt();
							
							switch(opc1) {
								case 1:
									campo="Password";
									break;
								case 2:
									campo="Correo_admin";
									break;
								case 3:
									campo="Tlfono_admin";
									break;
								case 4:
									campo="Direccion_admin";
									break;
								case 5:
									campo="cod_post";
									break;
								default:
									System.out.println("Opcion incorrecta");
							}
							
							sc.nextLine();
							System.out.println("Introduce nuevo registro");
							cambio=sc.nextLine();
							
							filas=bda.updateAdminS(idAdmin, campo, cambio);
							if(filas==1)
								System.out.println(campo+" se ha modificado correctamente");
							else
								System.out.println("Error - el campo"+campo+" no se ha podido modificar");
							
							System.out.println("--------------------------------------------");
							break;
						//METODO PARA AÑADIR ADMINISTRADOR
						case 3:
							sc.nextLine();
							System.out.println("Introduce Nombre");
							nombre=sc.nextLine();
							System.out.println("Introduce password");
							password=sc.nextLine();
							System.out.println("Introduce DNI");
							dni_usu=sc.nextLine();
							System.out.println("Introduce correo electronico");
							correo=sc.nextLine();
							System.out.println("Introduce telefono");
							telefono=sc.nextLine();
							System.out.println("Introduce direccion");
							direccion=sc.nextLine();
							System.out.println("Introduce codigo postal");
							codPostal=sc.nextLine();
	
							
							Administrador admin=new Administrador(nombre,password,dni_usu,correo,telefono,direccion,codPostal);
							
							filas=bda.add_admin(admin);
							if(filas==1)
								System.out.println("Administrador añadido con exito");
							else
								System.out.println("Error - el administrador no ha podido ser añadido");
							
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
						System.out.println("MENU CLIENTES\n");
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar todos los clientes\n 2.Insertar nuevo Cliente");
						System.out.println(" 3.Elimina Cliente\n 4.Modificar datos Cliente\n 5.Salir");
						System.out.println("--------------------------------------------");
						opc=sc.nextInt();
						switch(opc) {
						
						//Mostrar usuario
						case 1:
							sc.nextLine();
							Vector <Usuario> listadoUser=bdu.userAllList();
							System.out.println("--------------------------------------------");
							System.out.println("LISTADO DE USUARIOS\n");
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
							filas=bdu.add_usuario(usu);
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
								System.out.println("Error - no se han podido eliminar cuentas");
							
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
					do {
						System.out.println("MENU VISITAS\n");
						System.out.println("1.Ver todas las visitas");
						System.out.println("2.Ver las visitas de una gasolinera determinada");
						System.out.println("3.Ver visitas de un usuario determinado");
						System.out.println("4.Ver visitas de un usuario determinado a una gasolinera determinada");
						System.out.println("5.Salir");
						System.out.println("--------------------------------------------");
						opc1=sc.nextInt();
						
						switch(opc1) {
						
							//METODO PARA BUSCAR TODAS LAS VISITAS
							case 1:
								System.out.println("--Todas las visitas--");
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								Vector<Visita> listadoVisita=bdv.visitList();
								for (int i=0;i<listadoVisita.size();i++)									
									System.out.println(listadoVisita.get(i).toString());
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								break;
							
							//METODO PARA BUSCAR VISITAS DE UNA GASOLINERA
							case 2:
								System.out.println("Introduce codigo de la gasolinera");
								idGasolinera=sc.nextInt();
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								System.out.println("--Visitas a la gasolinera "+idGasolinera+"--\n");
								Vector<Visita> listadoGasVisita=bdv.visitGasList(idGasolinera);
								for (int i=0;i<listadoGasVisita.size();i++) 
									System.out.println(listadoGasVisita.get(i).toString());
									
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								break;							
							
							//METODO PARA BUSCAR LAS VISITAS DE UN USUARIO
							case 3:
								sc.nextLine();
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								System.out.println("VISITAS DE UN USUARIO DETERMINADO");
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								System.out.println("Introduce DNI del usuario");
								dni_usu=sc.nextLine();
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								Vector<Visita> listadoUserVisita=bdv.visitUserList(dni_usu);
								for (int i=0;i<listadoUserVisita.size();i++) 
									System.out.println(listadoUserVisita.get(i).toString());
									
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								break;
							
							//METODO PARA BUSCAR VISITAS DE UN USUARIO A UNA GASOLINERA
							case 4:
								sc.nextLine();
								System.out.println("Introduzca dni de usuario a buscar");
								dni_usu=sc.nextLine();
								System.out.println("Introduzca id de gasolinera");
								idGasolinera=sc.nextInt();
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								
								Vector<Visita> listaVisita=bdv.visitListGas(dni_usu, idGasolinera);
								System.out.println("LISTADO VISITAS DE "+ dni_usu.toUpperCase()+" a la gasolinera "+idGasolinera);
								for (int i=0;i<listaVisita.size();i++)									
									System.out.println(listaVisita.get(i).toString());				
								
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								break;							
							case 5:
								break;
							default:
								System.out.println("Opcion incorrecta");
						
						}
						
					}while (opc1!=5);
					break;
				case 4:
					do {
						System.out.println("MENU INCIDENCIAS\n");
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar todas las incidencias\n 2.Mostrar todas sus incidencias, resueltas o no\n 3.Arregla una incidencia\n 4.Salir");
						System.out.println("--------------------------------------------");
						opc=sc.nextInt();
						switch(opc) {
						
							//METODO PARA MOSTRAR TODAS LAS INCIDENCIAS
							case 1:
								sc.nextLine();
								System.out.println("LISTADO COMPLETO DE INCIDENCIAS\n");
								Vector<Incidencia> listadoIncidenciasCompleto=bdi.incAllList();
								
								for (int i=0;i<listadoIncidenciasCompleto.size();i++)									
									System.out.println(listadoIncidenciasCompleto.get(i).toString());
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								break;
								
								
							//METODO PARA BUSCAR INCIDENCIAS DEL ADMINISTRADOR LOGUEADO ESTEN RESUELTAS O NO	
							case 2:
								sc.nextLine();
								campo="id_admin";
								System.out.println("Esta resuelta la incidencia?");
								System.out.println("1.Si");
								System.out.println("2.No");
								opc2=sc.nextInt();
								String entrada;
									if(opc2==1)
										entrada="not null";
									else
										entrada="null";
									System.out.println("--------------------------------------------------------------------------------------------------------------");
								Vector<Incidencia> listaIncidenciasAdmin=bdi.incUserListResolve(idAdmin,campo,entrada);
								System.out.println("LISTADO DE INCIDENCIAS DEL ADMINISTRADOR "+idAdmin+"\n");
								for (int i=0;i<listaIncidenciasAdmin.size();i++)									
									System.out.println(listaIncidenciasAdmin.get(i).toString());
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								break;
								
								
							//METODO PARA ARREGLAR UNA INCIDENCIA
							case 3:
								sc.nextLine();
								campo="id_admin";
								Vector<Incidencia> lista3=bdi.incUserListResolve(idAdmin,campo,"null");
								System.out.println("LISTADO DE INCIDENCIAS NO RESUELTAS DEL ADMINISTRADOR "+idAdmin);
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								for (int i=0;i<lista3.size();i++)									
									System.out.println(lista3.get(i).toString());
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								System.out.println("Introduce cod de incidencia que quiere resolver");
								codInc=sc.nextLine();
								
								LocalDate fechaArreglo=LocalDate.now();
								
								filas=bdi.updateInc(codInc, fechaArreglo);
								if(filas==1)
									System.out.println("La incidencia "+codInc+" se ha resuelto con exito");
								else
									System.out.println("Error - "+filas);
								
								break;
								
							case 4:
								break;
							default:
								System.out.println("Opcion incorrecta");
						}
					}while(opc!=4);
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
			idAdmin=sc.nextLine();
			System.out.println("Introduce el password:");
			idAdmin=sc.nextLine();
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
