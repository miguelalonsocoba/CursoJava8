package stream;

/**
 * Class User.
 * @author Miguel
 *
 */
public class User {
	
	/** The id.  */
	private int id;
	
	/** The nombre. */
	private String nombre;

	public User(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
