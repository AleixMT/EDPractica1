package Exceptions;
/**
 * Excepcio en cas de que s'introdueixi un valor incorrecte en la clau
 * @author Cristina i Aleix
 *
 */
public class valorImpossible extends Exception {
	private static final long serialVersionUID = 1L;

	public valorImpossible(int e){
		super("ERROR : El valor "+e+" no te sentit o es massa gran \n");
	}

}
