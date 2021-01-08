package referenciasametodos;

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
	}

}
