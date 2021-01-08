package primerejemplodelambda;

/**
 * Interface Sumar. Representa una interface funcional, ya que cuenta con un
 * unico m�todo abstracto.
 * 
 * @author Miguel
 *
 */
@FunctionalInterface
public interface Sumar {

	/**
	 * Suma dos n�meros.
	 * 
	 * @param a integer
	 * @param b integer
	 * @return integer value
	 */
	int suma(int a, int b);

}
