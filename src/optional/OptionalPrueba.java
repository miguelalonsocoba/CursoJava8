package optional;

import java.util.Optional;

/**
 * Class OptionalPrueba.
 * 
 * @author Miguel
 *
 */
public class OptionalPrueba {

	public static void main(String[] args) {
		probarOptional(null);
	}

	/**
	 * Comprueba que el dato que recibe como parametro no sea null.
	 * 
	 * @param nombre
	 */
	public static void probarOptional(String nombre) {
		System.out.println(nombre.length());
	}
	
	public static void crearOptional() {
		Optional<String> optional = Optional.empty();
	}

}
