package primerejemplodelambda;

/**
 * Class Lambda.
 * @author Miguel
 *
 */
public class Lambda {

	/**
	 * Main method
	 * @param mac
	 */
	public static void main(String... mac) {
		
		// Ejempplo - Función anonima...
		MiNombre miNombreAnonima = new MiNombre() {

			/**
			 * Return my name.
			 */
			@Override
			public String miNombre() {
				return "Miguel Anonimo";
			}
		};
		
		System.out.println(miNombreAnonima.miNombre());
		
		// Ejemplo - Lambda...
		MiNombre miNombreLambda = () -> "Miguel Lambda";
		
		System.out.println(miNombreLambda.miNombre());
		}

}