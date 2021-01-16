package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
	 * Método main.
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

		// FlatMap.
		System.out.println("------------FlatNap--------------");
		List<List<String>> nombreVariasListas = new ArrayList<List<String>>(
				Arrays.asList(new ArrayList<String>(Arrays.asList("Alberto", "Maria", "Pedro")),
						new ArrayList<String>(Arrays.asList("Monica", "Pablo"))));

		List<String> nombreUnicaLista = nombreVariasListas.stream().flatMap((lis) -> lis.stream())
				.collect(Collectors.toList());
		nombreUnicaLista.stream().forEach((nombre) -> System.out.println(String.format("Nombre: %s", nombre)));

		// Peek
		System.out.println("-----------------------PEEK---------------------");
		setUpUser();
		List<User> users2 = users.stream().peek((usuario) -> usuario.setNombre(usuario.getNombre() + " Apellido"))
				.collect(Collectors.toList());

		users2.stream().forEach((us) -> System.out.println(String.format("Nombre: %s", us.getNombre())));

		// Count
		System.out.println("------------------Count---------------------");
		setUpUser();
		Long numeroFiltrado = users.stream().filter((e) -> e.getId() < 3).count();
		System.out.println(String.format("Número filtrado: %s", numeroFiltrado));

		// Skip and Limit.
		System.out.println("-----------------------Skip and Limit-----------------------");
		String[] abc = { "a", "b", "c", "d", "f", "g", "h", "i", "j" };
		List<String> abcFiltrado = Arrays.stream(abc).skip(2).limit(4).collect(Collectors.toList());
		abcFiltrado.stream().forEach((e) -> System.out.println(String.format("ABC Fitrado: %s", e)));

		// Sorted
		System.out.println("-----------------------------Sorted-----------------------------");
		setUpUser();
		List<User> usersSorted = users.stream().sorted(Comparator.comparing(User::getNombre))
				.collect(Collectors.toList());
		usersSorted.stream().forEach((e) -> System.out.println(String.format("Nombre: %s", e.getNombre())));

		// Min y Max.
		System.out.println("--------------------Min y Max-----------------");
		setUpUser();
		User userMin = users.stream().min(Comparator.comparing(User::getId)).orElse(null);
		System.out.println(String.format("Usuario minimo: %s", userMin));

		User userMax = users.stream().max(Comparator.comparing(User::getId)).orElse(null);
		System.out.println(String.format("Usuario maximo: %s", userMax));

		// Distinct.
		System.out.println("----------------------Distinct----------------------");
		String[] abc1 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "a", "c" };
		List<String> abcFilter1 = Arrays.stream(abc1).distinct().collect(Collectors.toList());
		abcFilter1.stream().forEach((e) -> System.out.println(String.format("Elemento: %s", e)));

		// allMatch, anyMatch, noneMatch.
		System.out.println("--------------allMatch, anyMatch, noneMatch.----------------------");
		List<Integer> numberList = Arrays.asList(100, 300, 900, 5000);

		Boolean allMatch = numberList.stream().allMatch((e) -> e > 301);
		System.out.println(String.format("AllMatch Value: %s", allMatch));

		Boolean anyMatch = numberList.stream().anyMatch((e) -> e > 301);
		System.out.println(String.format("AnyMatch value: %s", anyMatch));

		Boolean noneMatch = numberList.stream().noneMatch((e) -> e > 4000);
		System.out.println(String.format("NoneMatch Value; %s", noneMatch));

		// Sum Avarege range.
		System.out.println("-----------------Sum Avereage range--------------------");
		setUpUser();

		double result = users.stream().mapToInt(User::getId).average().orElse(0);
		System.out.println(String.format("Avarege (Media): %s", result));

		result = users.stream().mapToInt(User::getId).sum();
		System.out.println(String.format("Suma: %s", result));
		System.out.println(IntStream.range(0, 100).sum());

		// Reduce
		System.out.println("-------------------------Reduce--------------------------");
		setUpUser();
		int suma = users.stream().mapToInt(User::getId).reduce(0, Integer::sum);
		System.out.println(String.format("Valor de la Suma: %s", suma));

		// Joining
		System.out.println("------------------------Joining---------------------------");
		setUpUser();
		String names = users.stream().map(User::getNombre).collect(Collectors.joining(" - ")).toString();
		System.out.println(String.format("Nombre> %s", names));

		// toSet
		System.out.println("--------------------------toSet-----------------");
		setUpUser();
		Set<String> setNames = users.stream().map(User::getNombre).collect(Collectors.toSet());
		setNames.stream().forEach((e) -> System.out.println(String.format("Nombre: %s", e)));

		// sumamrizingDouble
		System.out.println("----------------SummarizingDouble------------");
		setUpUser();
		DoubleSummaryStatistics statistics = users.stream().collect(Collectors.summarizingDouble(User::getId));
		System.out.println("Average: " + statistics.getAverage() + " Valor Maximo: " + statistics.getMax()
				+ " Valor Minimo: " + statistics.getMin() + " Número de elementos: " + statistics.getCount() + " Suma: "
				+ statistics.getSum());

		DoubleSummaryStatistics statistics1 = users.stream().mapToDouble(User::getId).summaryStatistics();
		System.out.println("Average: " + statistics1.getAverage() + " Valor Maximo: " + statistics1.getMax()
				+ " Valor Minimo: " + statistics1.getMin() + " Número de elementos: " + statistics1.getCount()
				+ " Suma: " + statistics1.getSum());

		// partitioningBy
		System.out.println("-------------------------partitioningBy-----------------------------");
		setUpUser();
		List<Integer> numeros = Arrays.asList(5, 7, 34, 56, 67, 94);
		Map<Boolean, List<Integer>> esMayor = numeros.stream().collect(Collectors.partitioningBy((e) -> e > 10));
		esMayor.get(true).stream().forEach((e) -> System.out.println(String.format("Numero mayor: %s", e)));
		esMayor.get(false).stream().forEach((e) -> System.out.println(String.format("Numero menor: %s", e)));

		// gruopingBy
		System.out.println("---------------groupingBy---------------");
		setUpUser();
		Map<Character, List<User>> grupoAlfabeticoMap = users.stream()
				.collect(Collectors.groupingBy((e) -> new Character(e.getNombre().charAt(0))));
		grupoAlfabeticoMap.get('M').stream()
				.forEach((e) -> System.out.println(String.format("Value: %s", e.getNombre())));
		grupoAlfabeticoMap.get('J').stream()
				.forEach((e) -> System.out.println(String.format("Value: %s", e.getNombre())));
		grupoAlfabeticoMap.get('P').stream()
				.forEach((e) -> System.out.println(String.format("Value: %s", e.getNombre())));
		grupoAlfabeticoMap.get('F').stream()
				.forEach((e) -> System.out.println(String.format("Value: %s", e.getNombre())));
		
		// mapping
		System.out.println("----------------mapping---------------------");
		setUpUser();
		List<String> personas = users.stream()
				.collect(Collectors.mapping(User::getNombre, Collectors.toList()));
		personas.stream().forEach((e) -> System.out.println(String.format("Persona: %s", e)));
		
		// stream paralelo
		System.out.println("--------------------Stream Paralelo-----------------------");
		setUpUser();
		Long tiempo1 = System.currentTimeMillis();
		listaStrings.stream().forEach((e) -> convertirAMayusculas(e));
		Long tiempo2 = System.currentTimeMillis();
		System.out.println("Normal: " + (tiempo1 - tiempo2));
		
		tiempo1 = System.currentTimeMillis();
		listaStrings.parallelStream().forEach((e) -> convertirAMayusculas(e));
		tiempo2 = System.currentTimeMillis();
		System.out.println("Paralelo: " + (tiempo1 - tiempo2));

		stream.close();
	}
	
	private static String convertirAMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		return nombre.toUpperCase();
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
