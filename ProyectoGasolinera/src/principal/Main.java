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
		Vector<Gasolinera> listaGas;
		int op;
		int filas;
		String campo1="";
		int datoN=0;
		String datoS1="";
		String datoS2="";
		String campo2="";
		//datos admin
		String id_admin;
		String nombre_admin;
		String password;
		String dni_adm;
		String correo;
		String telefono;
		String direccion;
		String codpostal;
		//datos Gasolinera
		int id_Gas;
		
		String empresa;
		String provincia;
		String municipio;
		String localidad;
		int codPostalGas;
		
		char margen;
		float longitud;
		float latitud;
		String horario;
		//datos Carburantes
	
		 String tipo;
		 float precio;
		 int id_gasolinera;
		LocalDate fecha_modP;
		//datos Modificacion
		 int cod_mod;
		String tipo_mod;
		 LocalDate fecha_mod;
		
		

		
		
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
			System.out.println("11. Modificar precio carburante");
			System.out.println("12.Borrar carburante Gasolinera");
			System.out.println("-------Opciones Modificacion---------");
			System.out.println("13. Ver modificaciones");
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
				 codpostal=sc.nextLine();	 
				 LocalDate fechaAlt=LocalDate.now();
				 
				 Administrador admin=new Administrador(id_admin,nombre_admin,password,dni_adm,correo,telefono,direccion,codpostal,fechaAlt);
				 filas=bdA.add_admin(admin);
				 if(filas==1){
						System.out.println("Administrador nuevo introduccido");
				 		System.out.println(admin.toString());
				 }
					else
						System.out.println("Error - "+filas);
					
					break;
				 
			case 3:
				sc.nextLine();
				System.out.println("Introducce identificador del administrador a borrar");
				id_admin=sc.nextLine();
				filas=bdA.borrarAdmin(id_admin);
				if(filas==1){
					System.out.println("Administrador Borrado Correctamente");
				}
				else
					System.out.println("Error - "+filas);
				break;
			case 4:
				sc.nextLine();
				System.out.println("identificador del administrador:");
				id_admin=sc.nextLine();
				System.out.println("campo que desea cambiar:");
				campo1=sc.nextLine();
				System.out.println("Nuevo valor de "+campo1);
				String nuevoValor;
				nuevoValor=sc.nextLine();
				filas=bdA.updateAdminS(id_admin,campo1,nuevoValor);
				if(filas==1){
					System.out.println("Datos cambiados correctamente");
				}
				else
					System.out.println("Error - "+filas);
				
				break;
			case 5:
				int op2;
				do{
					System.out.println("CASOS DE FILTRADO");
					System.out.println("1.Para filtrar");
					op2=sc.nextInt();
					switch(op2){
					case 1:
						
						System.out.println("Campo de busqueda 1.identificador gasolinera, 2.codigo postal 3.Marca 4.Municipio 5.Marca y Municipio,6.Codigo postal y Marca");
						int op3=sc.nextInt();
						if (op3==1){
							campo1="id_gasolinera";
							System.out.println("identificador Gasolinera: ");
							datoN=sc.nextInt();
							listaGas=bdG.selectGasolinera(datoN,campo1);
						}
						else{
							if(op3==2){
								campo1="codpostal";
								System.out.println("Codigo postal: ");
								datoN=sc.nextInt();
								listaGas=bdG.selectGasolinera(datoN,campo1);
							}
								else{
									if (op3==3){
										sc.nextLine();
										campo1="empresa";
										System.out.println("Marca");
										datoS1=sc.nextLine();
										listaGas=bdG.selectGasolinera(datoS1,campo1);
									}
									else{
										if (op3==4){
											sc.nextLine();
											campo1="municipio";
											System.out.println("Municipio:");
											datoS1=sc.nextLine();
											listaGas=bdG.selectGasolinera(datoS1,campo1);
										}
										else{
											if (op3==5){
												sc.nextLine();
												campo1="municipio";
												System.out.println("Municipio:");
												datoS1=sc.nextLine();
												campo2="empresa";
												System.out.println("Empresa");
												datoS2=sc.nextLine();
												listaGas=bdG.selectGasolinera(datoS1, datoS2, campo1, campo2);
											}
											else {
												if (op3==6){
													sc.nextLine();
													campo1="empresa";
													System.out.println("Empresa:");
													datoS1=sc.nextLine();
													campo2="codpostal";
													System.out.println("Codigo postal:");
													datoN=sc.nextInt();
													listaGas=bdG.selectGasolinera(datoS1, datoN, campo1, campo2);
												}
												else {
													break;
												}
											}
										}
									}
							
						}
						
						}
					
					
						for(int i=0; i<listaGas.size();i++){
							System.out.println(listaGas.get(i).toString());
						}
						
						break;
					}
					
				}while(op2!=100);
			
				
				break;
			case 6:
				sc.nextLine();
				System.out.println("Marca: ");
				empresa=sc.nextLine();
				System.out.println("provincia:");
				provincia=sc.nextLine();
				System.out.println("Municipio:");
				 municipio=sc.nextLine();
				 System.out.println("Localidad:");
				 localidad=sc.nextLine();
				 System.out.println("Codigo postal:");
				 codpostal=sc.nextLine();
				 sc.nextLine();
				 System.out.println("Direccion:");
				 direccion=sc.nextLine();
				System.out.println("Margen");
				margen=sc.nextLine().charAt(0);
				System.out.println("longitud");
				longitud=sc.nextFloat();
				System.out.println("latitud");
				latitud=sc.nextFloat();
				sc.nextLine();
				System.out.println("Horario");
				horario=sc.nextLine();
				Gasolinera gas=new Gasolinera(0,empresa,provincia,municipio,
						localidad,codpostal,direccion,margen,longitud,latitud,horario);
				filas=bdG.add_Gasolinera(gas);
				 if(filas==1){
						System.out.println("Gasolinera nueva introduccida");
				 		System.out.println(gas.toString());
				 }
					else
						System.out.println("Error - "+filas);
					
				break;
			
			case 7:
				System.out.println("Identificador de Gasolinera a Borrar");
				id_Gas=sc.nextInt();
				filas=bdG.borrarGas(id_Gas);
				if(filas==1){
					System.out.println("Gasolinera Borrado Correctamente");
				}
				else
					System.out.println("Error - "+filas);
				
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
					 //Introduccion automatica en la tabla de modificaciones 
				//	int filas2= bdM.add_modificacion(cod_mod,tipo_mod,fecha_mod,id_admin,id_gasolinera);
					 
				 }
				break;
			case 11:
				sc.nextLine();
				System.out.println("Carburante que quieres modificar:");
				tipo=sc.nextLine();
				System.out.println("identificador de gasolinera en la que quieres modificar");
				id_gasolinera=sc.nextInt();
				System.out.println("nuevo precio");
				precio=sc.nextFloat();
				fecha_mod=LocalDate.now();
				filas=bdC.updatePrecio(tipo, id_gasolinera, precio, fecha_mod);
				if(filas==1){
					System.out.println("Datos cambiados correctamente");
				}
				else
					System.out.println("Error - "+filas);
				
				
				
				
				break;
			case 12:
				sc.nextLine();
			
				System.out.println(" id Gasolinera quieres borrar el carburante:");
				id_Gas=sc.nextInt();
				filas=bdC.borrarCarbu(id_Gas);
				if(filas!=-1){
					System.out.println("Error - "+filas);
				}
				else
					System.out.println("Borrado Correctamente");
					
				
				break;
				
				
				

			
			}
		}while(op!=77);
	}

}
