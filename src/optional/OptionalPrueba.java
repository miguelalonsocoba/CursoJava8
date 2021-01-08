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
		// probarOptional(null);
		orElseOptional(null);
	}

	/**
	 * Comprueba que el dato que recibe como parametro no sea null.
	 * 
	 * @param nombre
	 */
	public static void probarOptional(String nombre) {
		System.out.println(nombre.length());
	}

	/**
	 * Crea un Optional.
	 */
	public static void crearOptional() {
		Optional<String> optional = Optional.empty();
		optional.get();
	}

	public static void orElseOptional(String nombre) {
		Optional<String> optional = Optional.ofNullable(nombre);// Acepta un valor nulo en la variable, para despues
																// asignarle un por defecto.
		// Optional<String> optional2 = Optional.of(nombre);

		String nombreOfNullable = optional.orElse("Vacio");
		// String nombreOf = optional2.orElse("Vacio");
		System.out.println(nombreOfNullable);
		// System.out.println(nombreOf);
	}

}
