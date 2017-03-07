package Exceptions;
/**
 * Excepcio en cas de que la cua estigui plena
 * @author Cristina Izquierdo i Aleix Marine
 *
 */
public class CuaPlena extends Exception {
	private static final long serialVersionUID = 1L;

	public CuaPlena(int e){
		super("ERROR : Cua plena i no podem afegir el valor "+e);
	}

}
