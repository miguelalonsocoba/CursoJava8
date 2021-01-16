package funcionesdealtoorden;

/**
 * Class HighOrderFunctions.
 * @author Miguel
 *
 */
public class HighOrderFunctions implements SumarInterfaz {
	
	/**
	 * Método principal.
	 * @param mac
	 */
	public static void main (String... mac) {
		HighOrderFunctions hof = new HighOrderFunctions();
		
		System.out.println(String.format("Valor de la suma, suma: %s", hof.suma(2, 3)));
		System.out.println(String.format("Valor de la suma, apply: %s ", hof.apply(2, 4)));
	}
	
	public Integer suma(int a, int b) {
		return a + b;
	}

	@Override
	public Integer apply(int a, int b) {
		
		return a + b;
	}
  
}
