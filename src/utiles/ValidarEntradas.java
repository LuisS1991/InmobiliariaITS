package utiles;

public class ValidarEntradas {

	
	public static boolean ValidarEntreadaNumerica(String entradaTexto) {
		if(entradaTexto.matches("^[+-]?[0-9]+[.]?+[0-9]+|[+-]?[0-9]")) {
			return true;
		}
		return false;
	}//fin metodo
	
	public static boolean ValidarEntreadaString(String entradaTexto) {
		if(entradaTexto.matches("^[a-zA-Z].*")) {
			return true;
		}
		return false;
	}//fin metodo
	
	public static boolean ValidarEntreadaEmail(String email) {
		if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			return true;
		}
		return false;
	}//fin metodo


}
