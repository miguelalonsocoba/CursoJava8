package referenciasametodos;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ReferenciaMetodo.
 * @author Miguel
 *
 */
public class ReferenciaMetodo {
	
	public static void main(String[] args) {
		
		/////////Referencia a método estatico.
		Trabajo trabajo = new Trabajo() {
			
			@Override
			public void accion() {
				User.referenciaAMetodoEstatico();
				
			}
		};
		trabajo.accion();
		
		Trabajo trabajoLamda = () -> User.referenciaAMetodoEstatico();
		trabajoLamda.accion();
		
		Trabajo trabajoMetodoReferencia = User::referenciaAMetodoEstatico;
		trabajoMetodoReferencia.accion();
		
		///////////Referencia a un método de instancia de un objeto en particular.
		User user = new User("Miguel");
		Trabajo trabajoLambda1 = () -> user.referenciaAMetodoParticular();
		trabajoLambda1.accion();
		
		Trabajo trabajoMetodoReferencia1 = user::referenciaAMetodoParticular;
		trabajoMetodoReferencia1.accion();
		
		////////// Referencia a un método de instancia de un objeto arbitrario de un tipo particular.
		TrabajoString trabajoStringLambda = (palabra) -> {
			System.out.println(String.format("La palabra es: %s", palabra));
			return palabra.toUpperCase();
		};
		System.out.println(String.format("La palabra convertida en mayuscula: %s", trabajoStringLambda.accion("Hello")));
		
		TrabajoString trabajoStringReferenciaMetodo = String::toUpperCase;
		System.out.println(String.format("Palabra en mayuscula: %s", trabajoStringReferenciaMetodo.accion("bye")));
		
		//--------------- Otro ejemplo.
		/// Lambda.
		List<User> users = new ArrayList<>();
		users.add(new User("Pedro"));
		users.add(new User("Alberto"));
		users.add(new User("Mariana"));
		users.add(new User("Lorenzo"));
		users.forEach(nombre -> nombre.mostrarNombre());
		System.out.println("---------------------------");
		
		/// Referencia a método.
		users.forEach(User::mostrarNombre);
		
		///////////////// Referencia a un Constructor.
		
		//Forma de Clase anonima.
		IUser user2 = new IUser() {
			
			@Override
			public User crear(String nombre) {
				return new User(nombre);
			}
		};
		User user3 = user2.crear("Anacleta");
		user3.mostrarNombre();
		
		// Forma con Lambda.
		IUser user4 = (nombre) -> new User(nombre);
		User user5 = user4.crear("Ponciano");
		user5.mostrarNombre();
		
		// Forma Referencia a un Constructor.
		IUser user6 = User::new;
		User user7 = user6.crear("Manzanero");
		user7.mostrarNombre();
	}

}
