package funcionesdealtoorden;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		
		// -------------Interfaz Funcional BiFunction<T,U,R>-------------
		/*
		 * interface BiFunction<T,U,R>
		 * {
		 * 		R apply (T t, U u)
		 * }
		 */
		//---------------Interfaz Funcional Predicate<T>-----------------------
		/*
		 * interface Predicate<T>
		 * {
		 * 		Boolean test(T t)
		 * }
		 */
		List<Integer> numeros = Arrays.asList(6, 23, -5, 4, 68, -9, -67, 46);
		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar;
		filtrar = (lista, predicado) -> lista.stream().filter((e) -> predicado.test(e)).collect(Collectors.toList());
		System.out.println(filtrar.apply(numeros, (e) -> e > 0));
		
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
