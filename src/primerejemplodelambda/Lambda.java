package primerejemplodelambda;

/**
 * Class Lambda.
 * @author Miguel
 *
 */
public class Lambda implements PorDefecto {

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
		
		Sumar sumar = new Sumar() {
			
			@Override
			public int suma(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println(String.format("Resultado de la suma, con funcion anonima: %s", sumar.suma(10, 10)));
		
		Sumar sumar2 = (a,b) -> a+b;
		System.out.println(String.format("Resultado de la suma, con lambda: %s", sumar2.suma(12, 8)));
		
		Sumar sumar3 = (a, b) -> {
			a = b * b;
			a = a + b;
			System.out.println(String.format("Valor actual de la suma3: %s", a));
			return a;
		};
		
		System.out.println(String.format("Resultado de la suma3: %s", sumar3.suma(2, 2)));
		
		Lambda lambda = new Lambda();
		System.out.println(lambda.nombrePorDefecto("Miguel"));
		
		}

	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}
	
	

}