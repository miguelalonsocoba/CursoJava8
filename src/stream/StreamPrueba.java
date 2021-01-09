package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class StreamPrueba.
 * Un Stream representa una secuencia de elementos. Por ejemplo una lista que admite distintos tipos
 * de operaciones para realizar calculos sobre dichos elementos.
 * Un Stream es un conjunto de funciones que se ejecutan de manera anidada.
 * Los Stream son envoltorios al rededor de una fuente de datos que permiten operar con esa fuente de datos y 
 * realizar el procesamiento mesivo sea conveniente y rapido.
 * @author Miguel
 *
 */
public class StreamPrueba {
	
	/** Lista de Usuarios. */
	private static List<User> users;
	
	/**
	 * Método main.
	 * @param mac
	 */
	public static void main(String... mac) {
		setUpUser();
		Stream<List<User>> stream = Stream.of(users); // Se crea un Stream.
		users.stream(); // Otra forma de crear un Stream.
		
		users.stream().forEach((user) -> user.setNombre(user.getNombre() + " Apellido"));
		
		imprimirLista();
		
		stream.close();
	}
	
	/**
	 * Se unicializa la lista y se cargan valores.
	 */
	private static void setUpUser() {
		users = new ArrayList<>();
		users.add(new User(1, "Jose"));
		users.add(new User(2, "Mario Moreno"));
		users.add(new User(3, "Pilar"));
		users.add(new User(4, "Pacheco"));
		users.add(new User(5, "Felipe"));
		users.add(new User(6, "Margarita"));
	}
	
	private static void imprimirLista() {
		users.stream().forEach((user) -> System.out.println(user.getId() + " " + user.getNombre()));
	}

}
