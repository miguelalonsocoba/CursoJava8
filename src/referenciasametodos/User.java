package referenciasametodos;

/**
 * Class User.
 * @author Miguel
 *
 */
public class User {
	
	private String nombre;
	
	public User(String nombre) {
		this.nombre = nombre;
	}
	
	public static void referenciaAMetodoEstatico() {
		System.out.println("Probando Referencia a Método Estatico.");
	}
	
	public void referenciaAMetodoParticular() {
		System.out.println("Probando Referencia a Método de Objeto Particular.");
	}
	
	public void mostrarNombre() {
		System.out.println(nombre);
	}

}
