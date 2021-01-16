package funcionesdealtoorden;

import java.util.function.Function;

/**
 * Class HighOrderFunctions.
 * 
 * @author Miguel
 *
 */
public class HighOrderFunctions implements SumarInterfaz {

	/**
	 * Método principal.
	 * 
	 * @param mac
	 */
	public static void main(String... mac) {
		HighOrderFunctions hof = new HighOrderFunctions();

		// --------------------Función-----------------------
		System.out.println(String.format("Valor de la suma, suma: %s", hof.suma(2, 3)));

		// -------------------Interfaz----------------------
		System.out.println(String.format("Valor de la suma, apply: %s ", hof.apply(2, 4)));

		// -------------------High Order Function----------
		SumarInterfaz sumarInterfaz = new SumarInterfaz() {

			@Override
			public Integer apply(int a, int b) {
				return a + b;
			}
		};
		System.out.println(String.format("Valor de la suma de la función de alto orden: %s",
				hof.sumarHighOrderFunction(sumarInterfaz, 5, 6)));
		
		SumarInterfaz sumarInterfaz2 = (a, b) -> a + b;
		System.out.println(String.format("Valor de la suma de la función de alto orden: %s",
				hof.sumarHighOrderFunction(sumarInterfaz2, 5, 5)));
		
		// -----------------Interfaz Funcional Function<T, R>---------------
		/*
		 * interface Function<T t, R r>
		 * {
		 * 	R apply(T t)
		 * }
		 */
		Function<String, String> covertirAMayusculas = (e) -> e.toUpperCase();
		hof.imprimirMayuscula(covertirAMayusculas, "miguel");
		
	}

	public Integer suma(int a, int b) {
		return a + b;
	}

	@Override
	public Integer apply(int a, int b) {

		return a + b;
	}

	public Integer sumarHighOrderFunction(SumarInterfaz sumar, int a, int b) {
		return sumar.apply(a, b);
	}
	
	public void imprimirMayuscula(Function<String, String> function, String nombre ) {
		System.out.println("Mayusculas: " + function.apply(nombre));
	}

}
