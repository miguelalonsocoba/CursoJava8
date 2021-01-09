package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class StreamPrueba. Un Stream representa una secuencia de elementos. Por
 * ejemplo una lista que admite distintos tipos de operaciones para realizar
 * calculos sobre dichos elementos. Un Stream es un conjunto de funciones que se
 * ejecutan de manera anidada. Los Stream son envoltorios al rededor de una
 * fuente de datos que permiten operar con esa fuente de datos y realizar el
 * procesamiento mesivo sea conveniente y rapido.
 * 
 * @author Miguel
 *
 */
public class StreamPrueba {

	/** Lista de Usuarios. */
	private static List<User> users;

	/**
	 * M�todo main.
	 * 
	 * @param mac
	 */
	public static void main(String... mac) {
		setUpUser();
		Stream<List<User>> stream = Stream.of(users); // Se crea un Stream.
		users.stream(); // Otra forma de crear un Stream.

		// ForEach.
		users.stream().forEach((user) -> user.setNombre(user.getNombre() + " Apellido"));

		imprimirLista();

		// Map y Collectors.toList.
		List<String> listaStrings = users.stream().map((usuario) -> usuario.getNombre()).collect(Collectors.toList());
		listaStrings.stream().forEach((nombre) -> System.out.println(String.format("Nombre: %s", nombre)));

		// Filter.
		System.out.println("------------Filter--------------");
		setUpUser();
		List<User> userFilter = users.stream().filter((usuario) -> usuario.getNombre() != "Mario Moreno")
				.filter((usuario) -> usuario.getId() < 3).collect(Collectors.toList());
		userFilter.stream().forEach((user) -> System.out
				.println(String.format("Nombre filtrado: %s", user.getId() + " " + user.getNombre())));

		// FindFirst.
		System.out.println("------------FindFirst--------------");
		setUpUser();
		User user = users.stream().filter((u) -> u.getNombre().equals("Pacheco")).findFirst().orElse(null);
		System.out.println(user.getId() + " " + user.getNombre());

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
		users.add(new User(7, "Pacheco"));
	}

	private static void imprimirLista() {
		users.stream().forEach((user) -> System.out.println(user.getId() + " " + user.getNombre()));
	}

}
