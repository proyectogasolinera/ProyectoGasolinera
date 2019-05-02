package principal;
/**
 * 
 * @author Alejandro del val
 *
 */
import modelo.*;
import bd.*;

import java.time.LocalDate;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		BD_Conector.BD_Ini("aldautomotivebbdd");
		BD_Administrador bdA= new BD_Administrador();
		int op;
		String dni_adm;
		String id_admin;
		String Nombre_admin;
		String Password;
		String correo;
		String telefono;
		String direccion;
		String codPostal;
		LocalDate fechaAlt;
		
		
		do{
			System.out.println("Seleccione opcion deseada:\n 1: mostrar Administrador.\n 2: Insertar nuevo Administrador");
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
				

			
			}
		}while(op!=11);
	}

}
