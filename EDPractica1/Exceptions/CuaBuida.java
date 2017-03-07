package Exceptions;
/**
 * Excepcio en cas de que la cua estigui buida
 * @author Cristina Izquierdo i Aleix
 *
 */
public class CuaBuida extends Exception {
	private static final long serialVersionUID = 1L;

	public CuaBuida(){
		super("ERROR : Cua buida");
	}

}
