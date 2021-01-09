package stream;

import java.util.ArrayList;
import java.util.List;

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
	
	private static List<User> users;
	
	public static void main(String... mac) {
		
	}
	
	private static void setUpUser() {
		users = new ArrayList<>();
		users.add(new User(1, "Jose"));
		users.add(new User(2, "Mario Moreno"));
		users.add(new User(3, "Pilar"));
		users.add(new User(4, "Pacheco"));
		users.add(new User(5, "Felipe"));
		users.add(new User(6, "Margarita"));
	}

}
