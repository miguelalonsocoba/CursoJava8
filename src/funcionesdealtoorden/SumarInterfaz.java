package funcionesdealtoorden;

/**
 * Interface SumarInterfaz.
 * @author Miguel
 *
 */
@FunctionalInterface
public interface SumarInterfaz {
	
	/**
	 * M�todo que suma dos valores.
	 * @param a
	 * @param b
	 * @return Integer object
	 */
	Integer apply(int a, int b);

}
