package Exceptions;

public class Cadenabuida extends Exception {
	private static final long serialVersionUID = 1L;

	public Cadenabuida(){
		super("ERROR : Cadena buida, introdueix un caràcter");
	}
}
