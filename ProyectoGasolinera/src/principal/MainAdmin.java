package principal;

/**
 * @author: Marcos Grao
 */



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import bd.BD_Administrador;
import bd.BD_Carburante;
import bd.BD_Conector;
import bd.BD_Cuenta;
import bd.BD_Gasolinera;
import bd.BD_Incidencia;
import bd.BD_Modificacion;
import bd.BD_Usuario;
import bd.BD_Visita;
import modelo.Administrador;
import modelo.Carburante;
import modelo.Cuenta;
import modelo.Gasolinera;
import modelo.Incidencia;
import modelo.Modificacion;
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
		BD_Gasolinera bdG=new BD_Gasolinera();
		BD_Modificacion bdm=new BD_Modificacion();
		BD_Carburante bdcar=new BD_Carburante();
		
		String tipo,idAdmin,password,nombre,fecha,correo,
		dni_usu,localidad,direccion,codPostal,telefono,campo = null,
		cambio = null,codInc,tipoCuenta,numTarjeta,dato,empresa,provincia,municipio,horario;
		char margen;
		float longitud,latitud,precio;
		int opc,opc1,opc2,idGasolinera,filas,puntos,h,id;
		boolean login=false;
		double saldo;
		
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
				System.out.println("5.Gestionar Cuentas\n6.Gestionar Gasolinera\n7.Gestionar Carburante\n8.Menu Modificaciones");
				System.out.println("9.Salir");
				opc=sc.nextInt();
				System.out.println("--------------------------------------------");
				switch(opc) {
				//MENU ADMINISTRADOR
				case 1:
					do {
						System.out.println("MENU ADMINISTRADOR\n");
						System.out.println("Seleccione opcion deseada:\n 1.Mostrar sus datos de administrador.\n 2.Modificar sus datos persolanes");
						System.out.println(" 3.Insertar nuevo administrador\n 4.Salir");
						System.out.println("--------------------------------------------");
						opc=sc.nextInt();
						switch(opc) {
						
						//MOSTRAR DATOS DEL ADMINISTRADOR LOGUEADO
						case 1:
							sc.nextLine();
							Vector <Administrador> listadoAdmin=bda.selectAdminId(idAdmin);
							for (int i=0;i<listadoAdmin.size();i++)									
								System.out.println(listadoAdmin.get(i).toString());

							System.out.println("--------------------------------------------");
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
									sc.nextLine();
									campo="Password";
									do {
									System.out.println("Introduce nueva password");
									cambio=sc.nextLine();
									}while(validarPassword(cambio)==false);
									break;
								case 2:
									sc.nextLine();
									campo="Correo_admin";
									do {
									System.out.println("Introduce nueva direccionde correo electronico");
									cambio=sc.nextLine();
									}while(validarEmail(cambio)==false);
									break;
								case 3:
									sc.nextLine();
									campo="Tlfono_admin";
									do {
									System.out.println("Introduce nuevo telefono");
									cambio=sc.nextLine();
									}while(validarTelefono(cambio)==false);
									break;
								case 4:
									sc.nextLine();
									campo="Direccion_admin";
									System.out.println("Introduce nueva direccion");
									cambio=sc.nextLine();
									break;
								case 5:
									sc.nextLine();
									campo="cod_post";
									do {
									System.out.println("Introduce nuevo codigo postal");
									cambio=sc.nextLine();
									}while(validarCodpostal(cambio)==false);
									break;
								default:
									System.out.println("Opcion incorrecta");
							}
							
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
							
							do {
							System.out.println("Introduce password");
							password=sc.nextLine();
							}while(validarPassword(password)==false);
							
							do {
							System.out.println("Introduce DNI");
							dni_usu=sc.nextLine();
							}while(validarDni(dni_usu)==false);
							
							do {
							System.out.println("Introduce correo electronico");
							correo=sc.nextLine();
							}while(validarEmail(correo)==false);
								
							do {
							System.out.println("Introduce telefono");
							telefono=sc.nextLine();
							}while(validarTelefono(telefono)==false);
							
							System.out.println("Introduce direccion");
							direccion=sc.nextLine();
							
							do {
							System.out.println("Introduce codigo postal");
							codPostal=sc.nextLine();
							}while(validarCodpostal(codPostal)==false);
							
							Administrador admin=new Administrador(nombre,password,dni_usu,correo,telefono,direccion,codPostal);
							
							filas=bda.add_admin(admin);
							if(filas==1)
								System.out.println("Administrador añadido con exito");
							else
								System.out.println("Error - el administrador no ha podido ser añadido");
							System.out.println("--------------------------------------------\n");
							break;
						case 4:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=4);
					break;
				//MENU CLIENTES
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
							System.out.println("--------------------------------------------\n");
							break;
						
						//Añadir usuario	
						case 2:
							sc.nextLine();
							System.out.println("Introduzca el nombre del usuario");
							nombre=sc.nextLine();
							
							do {
							System.out.println("Introduzca el DNI del usuario");
							dni_usu=sc.nextLine();
							}while(validarDni(dni_usu)==false);
							
							System.out.println("Introduzca fecha de nacimiento del usuario en formato (YYYY-MM-DD)");
							fecha=sc.nextLine();
							LocalDate fechaNacimiento=LocalDate.parse(fecha,fechaFormateada);
							
							do {
							System.out.println("Introduzca correo electronico del usuario");
							correo=sc.nextLine();
							}while(validarEmail(correo)==false);
							
							System.out.println("Introduzca localidad del usuario");
							localidad=sc.nextLine();
							
							System.out.println("Introduzca la direccion del usuario");
							direccion=sc.nextLine();
							
							do {
							System.out.println("Introduzca el cod postal del usuario");
							codPostal=sc.nextLine();
							}while(validarCodpostal(codPostal)==false);
							
							do {
							System.out.println("Introduzca el telefono del usuario");
							telefono=sc.nextLine();
							}while(validarTelefono(telefono)==false);
							
							do {
							System.out.println("Introduzca contraseña para el usuario");
							password=sc.nextLine();
							}while(validarPassword(password)==false);
							
							Usuario usu=new Usuario(nombre,dni_usu,fechaNacimiento,correo,localidad,direccion,codPostal,telefono,password);
							
							System.out.println(usu.toString());
							filas=bdu.add_usuario(usu);
							if(filas==1)
								System.out.println("Usuario añadido con exito");
							else
								System.out.println("Error - El usuario no ha podido ser añadido, intentelo de nuevo");
							System.out.println("--------------------------------------------\n");
							break;
							
						//Eliminar usuario	
						case 3:
							sc.nextLine();
							System.out.println("DNI");
							dni_usu=sc.nextLine();
							
							//Eliminamos la cuenta
							filas=bdc.borrarCuenta(dni_usu);
							if(filas==1)
								System.out.println("Cuentas eliminadas con exito");
						
							
							//Eliminamos visitas
							filas=bdv.borrarVisita(dni_usu);
							if(filas==1)
								System.out.println("Visitas eliminadas con exito");
							
							
							//Eliminamos incidencias
							filas=bdi.borrarIncidencia(dni_usu);
							if(filas==1)
								System.out.println("Incidencias eliminadas con exito");
						
							
							//Finalmente eliminamos el usuario							
							filas=bdu.borrarUser(dni_usu);
							if(filas==1)
								System.out.println("\nUsuario eliminado con exito");
							else
								System.out.println("Error - El usuario no se ha podido eliminar en este momento");
							System.out.println("--------------------------------------------\n");
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
									sc.nextLine();
									campo="mail";
									do {
										System.out.println("Introduce nuevo email");
										cambio=sc.nextLine();
									}while(validarEmail(cambio)==false);
									break;
								case 2:
									sc.nextLine();
									campo="password";
									do {
										System.out.println("Introduce nueva contraseña");
										cambio=sc.nextLine();
									}while(validarPassword(cambio)==false);
									break;
								case 3:
									sc.nextLine();
									campo="localidad";
									System.out.println("Introduce nueva localidad");
									cambio=sc.nextLine();
									break;
								case 4:
									sc.nextLine();
									campo="direccion";
									System.out.println("Introduce nueva direccion");
									cambio=sc.nextLine();
									break;
								case 5:
									sc.nextLine();
									campo="cod_post";
									do {
										System.out.println("Introduce nuevo cod_postal");
										cambio=sc.nextLine();
									}while(validarCodpostal(cambio)==false);
									break;
							}

							
							filas=bdu.updateUser(dni_usu, campo, cambio);
							if(filas==1)
								System.out.println("Cambio realizado");
							else
								System.out.println("Error - "+filas);
							System.out.println("--------------------------------------------\n");
							break;
							
						//Salir	
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					break;
				//MENU VISITAS
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
				//MENU INCIDENCIAS
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
				//MENU CUENTAS
				case 5:
					do {
						System.out.println("MENU CUENTAS\n");
						System.out.println("Seleccione opcion deseada:\n 1.Inserta una cuenta\n 2.Cancelar una cuenta\n 3.Buscar cuenta por usuario");
						System.out.println(" 4.Mostrar todas las cuentas\n 5.Salir");
						System.out.println("--------------------------------------------");
					    opc=sc.nextInt();
						switch(opc) {
						
						//METODO PARA AÑADIR CUENTA
						case 1:
							sc.nextLine();
							System.out.println("INSERTAR NUEVA CUENTA\n");
							
							do {
							System.out.println("Introduzca DNI de usuario");
							dni_usu=sc.nextLine();
							}while(validarDni(dni_usu)==false);
							
							do {
							System.out.println("Introduzca saldo para la cuenta");
							saldo=sc.nextDouble();
							}while(validarSaldo(saldo)==false);
							
							do {
							System.out.println("Introduzca puntos de la cuenta");
							puntos=sc.nextInt();
							}while(validarPuntos(puntos)==false);
							
							sc.nextLine();
							System.out.println("Introduzca tipo de cuenta - (A/B/C)");
							tipo=sc.nextLine();
							
							System.out.println("--------------------------------------------");
							
							Cuenta cuenta=new Cuenta(dni_usu,saldo,puntos,tipo);
							

							filas=bdc.add_cuenta(cuenta);
							if(filas==1) {
								System.out.println("Cuenta añadida con exito\n");
								System.out.println(cuenta.toString());
							}
							else
								System.out.println("Error - la cuenta no se ha podido añadir");
							
							System.out.println("--------------------------------------------");
							break;
							
						//METODO PARA ELIMINAR CUENTA
						case 2:
							sc.nextLine();
							System.out.println("Introduce DNI del usuario");
							dni_usu=sc.nextLine();
							System.out.println("--------------------------------------------");
							System.out.println("ESTAS SON LAS CUENTAS DEL USUARIO "+dni_usu+"\n");
							Vector<Cuenta> listaCuentas=bdc.cuentaList(dni_usu);
							for (int i=0;i<listaCuentas.size();i++)									
								System.out.println(listaCuentas.get(i).toString());
							System.out.println("--------------------------------------------");
							System.out.println("Quiere borrar alguna ?\n1.Si\n2.No");
							opc1=sc.nextInt();
							if(opc1==1) {
								sc.nextLine();
								System.out.println("Introduce numero tarjeta de la cuenta que desea eliminar");
								numTarjeta=sc.nextLine();
								filas=bdc.borrarCuentaTarjeta(numTarjeta);
								if(filas==1)
									System.out.println("La cuenta con tarjeta "+numTarjeta+" perteneciente al usuario "+dni_usu+" se ha eliminado con exito");
								else
									System.out.println("Error - La cuenta se ha podido eliminar, intentelo de nuevo mas tarde");
							}
							else {
								System.out.println("--------------------------------------------");
								break;
							}
						
							System.out.println("--------------------------------------------");
							break;
							
						//METODO PARA MOSTRAR CUENTAS DE CADA USUARIO
						case 3:
							sc.nextLine();
							System.out.println("Introduce DNI del usuario");
							dni_usu=sc.nextLine();
							System.out.println("--------------------------------------------");
							System.out.println("ESTAS SON LAS CUENTAS DEL USUARIO "+dni_usu+"\n");
							Vector<Cuenta> listaCuentasUser=bdc.cuentaList(dni_usu);
							for (int i=0;i<listaCuentasUser.size();i++)									
								System.out.println(listaCuentasUser.get(i).toString());
							
							System.out.println("--------------------------------------------");
							break;
							
						//MOSTRAR TODAS LAS CUENTAS
						case 4:
							System.out.println("ESTAS SON TODAS LAS CUENTAS\n ");
							Vector<Cuenta> listaCuentasCompleta=bdc.cuentaAllList();
							for (int i=0;i<listaCuentasCompleta.size();i++)	
								System.out.println(listaCuentasCompleta.get(i).toString());
							System.out.println("--------------------------------------------");
							break;
						case 5:
							break;
						default:
							System.out.println("Opcion incorrecta");
						}
					}while(opc!=5);
					System.out.println("--------------------------------------------");
					break;
				//MENU GASOLINERA
				case 6:
					sc.nextLine();
					do {
					System.out.println("MENU GASOLINERA\n");
					System.out.println("1.Añadir gasolinera\n2.Mostrar gasolinera\n3.Eliminar gasolinera\n4.Salir");
					System.out.println("--------------------------------------------");
					opc1=sc.nextInt();
						switch(opc1) {
						
							//METODO PARA AÑADIR GASOLINERA
							case 1:
								sc.nextLine();
								System.out.println("Marca: ");
								empresa=sc.nextLine();
								
								do {
								System.out.println("provincia:");
								provincia=sc.nextLine();
								}while(validarProvincia(provincia)==false);
								
								System.out.println("Municipio:");
								municipio=sc.nextLine();
								System.out.println("Localidad:");
								localidad=sc.nextLine();
								
								do {
								System.out.println("Codigo postal:");
								codPostal=sc.nextLine();
								}while(validarCodpostal(codPostal)==false);
								
								System.out.println("Direccion:");
								direccion=sc.nextLine();
								
								do {
								System.out.println("Margen");
								margen=sc.nextLine().charAt(0);
								}while(validarMargen(margen)==false);
								
								System.out.println("longitud");
								longitud=sc.nextFloat();
								System.out.println("latitud");
								latitud=sc.nextFloat();
								sc.nextLine();
								System.out.println("Horario");
								horario=sc.nextLine();
								Gasolinera gas=new Gasolinera(0,empresa,provincia,municipio,
										localidad,codPostal,direccion,margen,longitud,latitud,horario);
								filas=bdG.add_Gasolinera(gas);
								if(filas==1){
										//Agregamos modificacion tipo ADD
									 	int maxGasolinera=bdG.maxGasolinera();
									 	Modificacion mod=new Modificacion("ADD",idAdmin,maxGasolinera);
										filas=bdm.add_modificacion(mod);
										System.out.println("Gasolinera añadida con exito");
								 	
								 }
								 	else
										System.out.println("Error - la gasolinera no se ha podido dar de alta, intentelo mas tarde");
								 
								System.out.println("--------------------------------------------");
								break;
							
								
							//MOSTRAR DATOS DE GASOLINERAS
							case 2:
								sc.nextLine();
								do {
								System.out.println("--------------------------------------------");
								System.out.println("Campos por los que desea filtrar:");
								System.out.println("1.empresa");
								System.out.println("2.Municipio");
								System.out.println("3.codigo postal");
								System.out.println("Campos por los que desea filtrar:");
								opc2=sc.nextInt();
								switch (opc2) {
								case 1:
									sc.nextLine();
									campo="empresa";
									System.out.println("empresa:");
									dato=sc.nextLine();
									bdG.addHMG(campo, dato);
									break;
								case 2:
									sc.nextLine();
									campo="municipio";
									System.out.println("municipio:");
									dato=sc.nextLine();
									bdG.addHMG(campo, dato);
									break;
								
								
								case 3:
									sc.nextLine();
									campo="codpostal";
									System.out.println("codigo postal:");
									dato=sc.nextLine();
									bdG.addHMG(campo, dato);
									break;
								
								}
								System.out.println("--------------------------------------------");
								System.out.println("desea introduccir otro filtro 1/si 2/no");
								h=sc.nextInt();
								}while(h!=2);
								System.out.println("--------------------------------------------");
								bdG.mostrarHMG();
								Vector<Gasolinera> listaGasHM=bdG.selectGasolineraHM();
								for(int i=0; i<listaGasHM.size();i++){
									System.out.println(listaGasHM.get(i).toString());
								}
								System.out.println("--------------------------------------------\n");
								break;
								
							//METODO PARA BORRAR GASOLINERAS
							case 3:
								System.out.println("Introduce id gasolinera a eliminar");
								id=sc.nextInt();
								System.out.println("--------------------------------------------");
								//Borramos incidencias.								
								filas=bdi.borrarIncGas(id);
								if(filas==1)
									System.out.println("Se eliminan las incidencias de la gasolinera "+id+"\n");
		
								//Borramos las visitas
								filas=bdv.borrarVisitaGas(id);
								if(filas==1)
									System.out.println("Se han borrado las visitas a la gasolinera"+id+"\n");
								
								//Borramos las modificaciones
								filas=bdm.borrarModGas(id);
								if(filas==1)
									System.out.println("Se han borrado las visitas a la gasolinera "+id+"\n");
								
								//Eliminamos carburantes
								filas=bdcar.borrarCarbu(id);
								if(filas==1)
									System.out.println("Se han borrado los carburantes de la gasolinera "+id+"\n");
				
								
								//Finalmente borramos gasolinera
								filas=bdG.borrarGas(id);
								if(filas==1)
									System.out.println("La gasolinera "+id+" se ha eliminado correctamente");
								else
									System.out.println("Error - La gasolinera no se ha podido borrar, intentelo en otro momento");
								System.out.println("--------------------------------------------\n");
								break;
							case 4:
								break;
							default:
								System.out.println("Opcion incorrecta");
							}
					}while(opc1!=4);
					break;
					
				//CARBURANTES
				case 7:
					do {
					System.out.println("MENU CARBURANTE\n");
					System.out.println("1.Mostrar carburantes de una gasolinera");
					System.out.println("2.Modificar precio carburante de una gasolinera");
					System.out.println("3.Insertar precio carburante");
					System.out.println("4.Salir");
					System.out.println("--------------------------------------------");
					opc1=sc.nextInt();
					switch(opc1) {
					
						//METODO PARA MOSTRAR TIPOS DE GASOLINA DE UNA GASOLINERA CONCRETA
						case 1:
							System.out.println("Introduzca id de gasolinera que desea filtrar");
							id=sc.nextInt();
							System.out.println("--------------------------------------------");
							System.out.println("TIPOS DE GASOLINA ESTACION NUMERO "+id+"\n");
							Vector<Carburante> listaCarburanteTotal=bdcar.selectAllCarburante(id);
							for (int i=0;i<listaCarburanteTotal.size();i++)	
								System.out.println(listaCarburanteTotal.get(i).toString());
							
							System.out.println("--------------------------------------------\n");
							break;
							
						//METODO PARA CAMBIAR PRECIO DE CARBURANTE
						case 2:
							System.out.println("Identificador de gasolinera en la que quieres modificar");
							id=sc.nextInt();
							sc.nextLine();
							System.out.println("Carburante que quieres modificar:");
							tipo=sc.nextLine();
							System.out.println("Introduzca nuevo precio");
							precio=sc.nextFloat();
							LocalDate fechaMod=LocalDate.now();
							filas=bdcar.updatePrecio(tipo, id, precio, fechaMod);
							if(filas==1){
								Modificacion mod=new Modificacion("M-GAS",idAdmin,id);
								filas=bdm.add_modificacion(mod);
								System.out.println("Datos cambiados correctamente");
								
							}
							else
								System.out.println("Error - no se ha podido modificar el carbutante");
							
							System.out.println("--------------------------------------------\n");
							break;
							
						case 3:
							System.out.println("Introduzca id de gasolinera");
							id=sc.nextInt();
							System.out.println("Que tipo de gasolina desea insertar ?\n1.Gasoleo A\n2.Gasoleo B\n3.Gasolina 95\n4.Gasolina 98");
							fechaMod=LocalDate.now();
							opc1=sc.nextInt();
							switch(opc1) {
								case 1:
									campo="Gasoleo A";
									break;
								case 2:
									campo="Gasoleo B";
									break;
								case 3:
									campo="Gasolina 95";
									break;
								case 4:
									campo="Gasolina 98";
									break;
								case 5:
									break;
								default:
									System.out.println("Opcion incorrecta");
							
							}
							System.out.println("Introduzca precio del carburante");
							precio=sc.nextFloat();
							Carburante carbu=new Carburante(campo,precio,id,fechaMod);
							filas=bdcar.add_carburante(carbu);
							 if(filas==1) {
								 Modificacion mod=new Modificacion("A-GAS",idAdmin,id);
								 filas=bdm.add_modificacion(mod);
								 System.out.println("Carburante añadido con exito");
							 }
							 else
								 System.out.println("Error - No se ha podido añadir el carburante");
			
							System.out.println("--------------------------------------------\n");	 
							break;
						case 4:
							break;
						default:
							System.out.println("Opcion incorrecta");
					
					
					}
					}while(opc1!=4);
					break;
				case 8:
					do {
					System.out.println("MENU MODIFICACIONES\n");
					System.out.println("1.Mostrar todas las modificaciones");
					System.out.println("2.Mostrar modificaciones de una gasolinera");
					System.out.println("3.Salir");
					System.out.println("--------------------------------------------");
					opc1=sc.nextInt();
					switch(opc1) {
					
						//MOSTRAR TODAS LAS MODIFICACIONES
						case 1:
							System.out.println("--------------------------------------------");
							System.out.println("ESTAS SON TODAS LAS MODIFICACIONES REALIZADAS\n ");
							Vector<Modificacion> listaModCompleta=bdm.selectModificacionAll();
							for (int i=0;i<listaModCompleta.size();i++)	
								System.out.println(listaModCompleta.get(i).toString());
							System.out.println("--------------------------------------------");
							break;
						case 2:
							System.out.println("Introduzca el id de la gasolinera por la que quiere filtrar");
							id=sc.nextInt();
							System.out.println("--------------------------------------------");
							System.out.println("ESTAS SON TODAS LAS MODIFICACIONES REALIZADAS EN LA GASOLINERA "+id+"\n ");
							Vector<Modificacion> listaModGas=bdm.selectModificacionGas(id);
							for (int i=0;i<listaModGas.size();i++)	
								System.out.println(listaModGas.get(i).toString());
							System.out.println("--------------------------------------------");
							break;
						case 3:
							break;
						default:
							System.out.println("Opcion incorrecta");
						
					}
					}while(opc1!=3);
					
					break;
				case 9:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opcion incorrecta");
				}
			}while(opc!=9);
			break;
			
		
		}

	}
	
	
	//METODOS VALIDACION
	
	public static boolean validarDni(String dni_usuario) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numDNI;
		if(dni_usuario.length()<=1)
			return false;
		char letraDNI = dni_usuario.charAt(dni_usuario.length() - 1);
		numDNI = Integer.parseInt(dni_usuario.substring(0, dni_usuario.length() - 1));
		if (letras.charAt(numDNI % 23) == letraDNI) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Este metodo valida el nie segun el algoritmo de la pagina de la policia
	 * nacional
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarNie(String nie) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numNIE;
		String nuevaLetra = "";
		char Primeraletra = nie.charAt(0);
		if (Primeraletra == 'X') {
			nuevaLetra = "0";
		}
		if (Primeraletra == 'Y') {
			nuevaLetra = "1";
		}
		if (Primeraletra == 'Z') {
			nuevaLetra = "2";
		}
		char letraNIE = nie.charAt(nie.length() - 1);
		numNIE = Integer.parseInt(nuevaLetra + nie.substring(1, nie.length() - 1));
		if (letras.charAt((numNIE) % 23) == letraNIE) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Este metodo valida los numeros de telefono con los prefijos de España
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarTelefono(String tlf) {
		char firtsNumber = tlf.charAt(0);
		if (firtsNumber == 6 || firtsNumber == 7 || firtsNumber == 9) { 
			if(tlf.length() == 9)
				return true;
		}
		return false;
	}

	/**
	 * 
	 * Este metodo valida los email de cualquier dominio.
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarEmail(String email) {
		char[] caracteres = { '(', ')', '[', ']', '\\', ',', ';', ':', '<', '>', ' ' };
		int pos1 = email.indexOf("@"), pos2 = (email.indexOf("@", pos1 + 1)), punto = email.indexOf('.');
		char caracter = email.charAt(email.length() - 1), caracter1 = email.charAt(0);
		for (int i = 0; i < email.length(); i++) {
			for (int j = 0; j < caracteres.length; j++) {
				if (email.charAt(i) == caracteres[j]) {
					return false;
				}
			}
		}
		if (pos1 != -1) {
			if (pos2 == -1)
				if (punto != -1)
					if (caracter != '.')
						if (caracter1 != '@')
							return true;
		}
		return false;

	}

	/**
	 * 
	 * Este metodo valida los codigos postales de la comunidad de Madrid
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarCodpostal(String cod_postal) {
		String numeros = "0123456789";
		if (cod_postal.length() != 5) {
			return false;
		}
		for (int i = 0; i < cod_postal.length(); i++) {
			for (int x = 0; x < numeros.length(); x++) {
				if (numeros.charAt(x) != cod_postal.charAt(i)) {
					if (!cod_postal.substring(0, 2).equalsIgnoreCase("28"))
						return false;
				}
			}

		}

		return true;
	}

	/**
	 * 
	 * Este metodo valida la contraseña de acceso a la base de datos,donde es
	 * obligatorio poner una mayuscula y un numero por lo menos
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarPassword(String password) {
		String numeros = "0123456789";
		String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int contnum = 0, contletra = 0;
		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < abecedario.length(); j++) {
				if (abecedario.charAt(j) == password.charAt(i)) {
					contletra++;
				}
			}
		}
		for (int i = 0; i < password.length(); i++) {
			for (int x = 0; x < numeros.length(); x++) {
				if (numeros.charAt(x) == password.charAt(i)) {
					contnum++;
				}
			}
		}
		if (contletra >= 1) {
			if (contnum >= 1)
				return true;
		}
		return false;
	}

	/**
	 * 
	 * Este metodo valida el saldo de las cuentas que tienen los clientes en la base
	 * de datos
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarSaldo(double Saldo) {
		if (Saldo > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Este metodo valida los puntos que tienen los clientes al realizar compras en
	 * las distintas gasolineras
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarPuntos(double puntos) {
		if (puntos > 0) {
			return true;
		}
		return false;
	}


	/**
	 * 
	 * Este metodo valida la provincia, la cual solo puede ser Madrid.
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarProvincia(String provincia) {
	String Validador = "Madrid";
		if (provincia.equalsIgnoreCase(Validador)) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * Este metodo valida que el margen introducido por el administrador solo sean 
	 * las opciones de las que dispone una gasolinera
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarMargen(char margen) {
		char[] letras = { 'd', 'D', 'I', 'i', 'n', 'N' };
		for (int i = 0; i < letras.length; i++) {
			if (margen == letras[i]) {
				return true;
			}

		}
		return false;
	}

}
