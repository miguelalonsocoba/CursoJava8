package primerejemplodelambda;

/**
 * Interface Sumar. Representa una interface funcional, ya que cuenta con un
 * unico método abstracto.
 * 
 * @author Miguel
 *
 */
@FunctionalInterface
public interface Sumar {

	/**
	 * Suma dos números.
	 * 
	 * @param a integer
	 * @param b integer
	 * @return integer value
	 */
	int suma(int a, int b);

}
