package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

import bd.BD_Conector;
import bd.BD_Cuenta;
import bd.BD_Incidencia;
import bd.BD_Usuario;
import bd.BD_Visita;
import modelo.Cuenta;
import modelo.Incidencia;
import modelo.Usuario;
import modelo.Visita;


public class MainPrueba {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("yyyy-LL-dd"); 
		
		BD_Conector.BD_Ini("aldautomotivebbdd");
		BD_Usuario bdu=new BD_Usuario();
		BD_Visita bdv=new BD_Visita();
		BD_Incidencia bdi=new BD_Incidencia();
		BD_Cuenta bdc=new BD_Cuenta();
		
		int opc;
		String dni_usu;
		
		do {
			System.out.println("1.Dar de alta usuario");
			System.out.println("2.Buscar usuario");
			System.out.println("3.Dar de alta visita");
			System.out.println("4.Buscar visita");
			System.out.println("5.Añadir incidencia");
			System.out.println("6.Buscar incidencias");
			System.out.println("7.Añadir cuenta");
			System.out.println("8.Buscar cuenta");
			System.out.println("9.Eliminar usuario");
			System.out.println("10.Eliminar visita");
			System.out.println("11.Eliminar incidencia");
			System.out.println("12.Eliminar cuentas");
			System.out.println("13.Actualiar usuario");
			
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
					System.out.println("\n\nLISTADO USUARIO "+ dni_usu.toUpperCase()+"\n");
					for (int i=0;i<listadoUser.size();i++)									
						System.out.println(listadoUser.get(i).toString());
					break;
				case 3:
					sc.nextLine();
					System.out.println("Introduce dni");
					dni=sc.nextLine();
					System.out.println("Introduce tipo de pago");
					String tipo=sc.nextLine();
					System.out.println("Introduce id_gasolinera");
					int id=sc.nextInt();
					System.out.println("Introduce precio");
					double precio=sc.nextDouble();
					
				
					
					
					Visita visit=new Visita(dni,tipo,id,precio);
					
					System.out.println(visit.toString());
					filas=bdv.add_visita(visit);
					if(filas==1)
						System.out.println("Visita añadida con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 4:
					sc.nextLine();
					System.out.println("Introduce dni usuario para buscar");
					dni_usu=sc.nextLine();
					Vector<Visita> listadoVisita=bdv.visitList(dni_usu);
					System.out.println("\n\nLISTADO VISITAS DE "+ dni_usu.toUpperCase()+"\n");
					for (int i=0;i<listadoVisita.size();i++)									
						System.out.println(listadoVisita.get(i).toString());
					break;
				case 5:
					sc.nextLine();
					System.out.println("Introduce cod inc");
					String cod=sc.nextLine();
					System.out.println("Introduce DNI usuario");
					dni=sc.nextLine();
					System.out.println("Introduce id_admin");
					String id_admin=sc.nextLine();
					System.out.println("Descibe problema");
					String descripcion=sc.nextLine();
					System.out.println("Introduce id_gasolinera");
					id=sc.nextInt();
					
					LocalDate fcha1=LocalDate.now();
					LocalDate fcha2=LocalDate.now();
					
					Incidencia inc=new Incidencia(cod,dni,id_admin,fcha1,fcha2,descripcion,id);
					
					System.out.println(inc.toString());
					filas=bdi.add_inc(inc);
					if(filas==1)
						System.out.println("INC añadida con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
				case 6:
					sc.nextLine();
					System.out.println("Introduce dni usuario para buscar");
					dni_usu=sc.nextLine();
					Vector<Incidencia> listadoIncidencias=bdi.incUserList(dni_usu);
					System.out.println("\n\nLISTADO INCIDENCIAS DE "+ dni_usu.toUpperCase()+"\n");
					for (int i=0;i<listadoIncidencias.size();i++)									
						System.out.println(listadoIncidencias.get(i).toString());
					break;
					
				//Metodos Cuentas
				case 7:
					sc.nextLine();
					System.out.println("Num tarjeta");
					String num_tarj=sc.nextLine();
					System.out.println("DNI");
					dni=sc.nextLine();
					System.out.println("Saldo");
					Double saldo=sc.nextDouble();
					System.out.println("Puntos");
					int puntos=sc.nextInt();
					sc.nextLine();
					System.out.println("Tipo cuenta");
					tipo=sc.nextLine();
					
					Cuenta cuenta=new Cuenta(num_tarj,dni,saldo,puntos,tipo);
					
					System.out.println(cuenta.toString());
					filas=bdc.add_cuenta(cuenta);
					if(filas==1)
						System.out.println("Cuenta añadida con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 8:
					sc.nextLine();
					System.out.println("Introduce dni usuario para buscar");
					dni_usu=sc.nextLine();
					Vector<Cuenta> lista=bdc.cuentaList(dni_usu);
					System.out.println("\n\nLISTADO CUENTAS DE "+ dni_usu.toUpperCase()+"\n");
					for (int i=0;i<lista.size();i++)									
						System.out.println(lista.get(i).toString());
					break;	
					
				case 9:
					sc.nextLine();
					System.out.println("DNI");
					dni=sc.nextLine();
					
					filas=bdu.borrarUser(dni);
					if(filas==1)
						System.out.println("Usuario eliminado con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
				
				case 10:
					
					sc.nextLine();
					System.out.println("DNI");
					dni=sc.nextLine();
					System.out.println("Gasolinera");
					int codigo=sc.nextInt();
					sc.nextLine();
					System.out.println("Fecha");
					fecha=sc.nextLine();
					LocalDate fechaVisita=LocalDate.parse(fecha,fechaFormateada);
					
					
					filas=bdv.borrarVisita(dni,codigo,fechaVisita);
					if(filas==1)
						System.out.println("Visita eliminada con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 11:
					
					sc.nextLine();
					System.out.println("DNI");
					dni=sc.nextLine();
					
					filas=bdi.borrarIncidencia(dni);
					if(filas==1)
						System.out.println("Incidencia eliminada con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 12:
					
					sc.nextLine();
					System.out.println("DNI");
					dni=sc.nextLine();
					
					filas=bdc.borrarCuenta(dni);
					if(filas==1)
						System.out.println("Cuenta eliminada con exito");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 13:
					sc.nextLine();
					System.out.println("Introduce dni del user a modificar");
					dni=sc.nextLine();
					System.out.println("Que campo desea modificar ?");
					String campo=sc.nextLine();
					System.out.println("Introduce nuevo registro");
					String cambio=sc.nextLine();
					
					filas=bdu.updateUser(dni, campo, cambio);
					if(filas==1)
						System.out.println("Cambio realizado");
					else
						System.out.println("Error - "+filas);
					
					break;
					
				case 14:
					sc.nextLine();
					System.out.println("Introduce INC a modificar");
					String inci=sc.nextLine();
					System.out.println("Introduce nuevo registro");
					fecha=sc.nextLine();
					LocalDate fechita=LocalDate.parse(fecha,fechaFormateada);
					
					filas=bdi.updateInc(inci, fechita);
					if(filas==1)
						System.out.println("Cambio realizado");
					else
						System.out.println("Error - "+filas);
					
					break;	
					
				case 15:
					sc.nextLine();
					System.out.println("cod admin");
					cod=sc.nextLine();
					Vector<Incidencia> lista1=bdi.incAdminList(cod);
					System.out.println("\n\nLISTADO INCIDENCIAS");
					for (int i=0;i<lista1.size();i++)									
						System.out.println(lista1.get(i).toString());
					break;
					
				case 16:
					sc.nextLine();
					System.out.println("cod admin");
					cod=sc.nextLine();
					System.out.println("Esta resuelta?");
					System.out.println("1.Si");
					System.out.println("2.No");
					int decision=sc.nextInt();
					String entrada;
					if(decision==1)
						entrada="not null";
					else
						entrada="null";
						
					Vector<Incidencia> lista2=bdi.incAdminListResolve(cod,entrada);
					System.out.println("\n\nLISTADO INCIDENCIAS");
					for (int i=0;i<lista2.size();i++)									
						System.out.println(lista2.get(i).toString());
					break;
					
				case 17:
					sc.nextLine();
					System.out.println("dni");
					dni=sc.nextLine();
					System.out.println("Esta resuelta?");
					System.out.println("1.Si");
					System.out.println("2.No");
					decision=sc.nextInt();
					if(decision==1)
						entrada="not null";
					else
						entrada="null";
						
					Vector<Incidencia> lista3=bdi.incUserListResolve(dni, entrada);
					System.out.println("\n\nLISTADO INCIDENCIAS");
					for (int i=0;i<lista3.size();i++)									
						System.out.println(lista3.get(i).toString());
					break;
				
					
					
					
					
			}
			
		}while(opc!=20);

		
		
		
		
		
		
		
		
		
		
	}

}