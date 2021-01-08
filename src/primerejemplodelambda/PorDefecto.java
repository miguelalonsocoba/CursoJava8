package primerejemplodelambda;

/**
 * Interface PorDefecto.
 * 
 * @author Miguel
 *
 */
@FunctionalInterface
public interface PorDefecto {

	/**
	 * Muestra el nombre que reciba como parametro.
	 * 
	 * @param nombre string
	 */
	void mostrarNombre(String nombre);
	
	default String nombrePorDefecto(String nombre) {
		return nombre + " Default";
	}

}
