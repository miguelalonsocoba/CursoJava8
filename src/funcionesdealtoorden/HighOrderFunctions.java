package funcionesdealtoorden;

/**
 * Class HighOrderFunctions.
 * 
 * @author Miguel
 *
 */
public class HighOrderFunctions implements SumarInterfaz {

	/**
	 * M�todo principal.
	 * 
	 * @param mac
	 */
	public static void main(String... mac) {
		HighOrderFunctions hof = new HighOrderFunctions();

		// --------------------Funci�n-----------------------
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
		System.out.println(String.format("Valor de la suma de la funci�n de alto orden: %s",
				hof.sumarHighOrderFunction(sumarInterfaz, 5, 6)));
		
		SumarInterfaz sumarInterfaz2 = (a, b) -> a + b;
		System.out.println(String.format("Valor de la suma de la funci�n de alto orden: %s",
				hof.sumarHighOrderFunction(sumarInterfaz2, 5, 5)));
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

}
