package modelo;

public class MetodosValidacion {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * Este metodo valida el dni segun el algoritmo de la pagina de la policia
	 * nacional
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarDni(String dni_usuario) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numDNI;
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
		if (firtsNumber == 6 || firtsNumber == 7 || firtsNumber == 9 && tlf.length() == 9) {

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
	public boolean validarPuntos(double puntos) {
		if (puntos > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Este metodo valida el numero de tarjeta del cliente, el cual solo tiene 
	 * numeros y un tamaño de 16 caracteres.
	 * 
	 * @author: Jonay Marichal
	 * 
	 * @version: 10/05/2019/A
	 * 
	 */
	public static boolean validarNumtarjeta(String num_tarj) {
		String numeros = "0123456789";
		if (num_tarj.length() != 16) {
				return false;
		}
		for (int i = 0; i < num_tarj.length(); i++) {
			for (int j = 0; j < numeros.length(); j++) {
				if (numeros.charAt(j) == num_tarj.charAt(i)) {
					return true;

				}
			}

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







