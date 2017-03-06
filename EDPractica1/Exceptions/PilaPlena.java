package Exceptions;

public class PilaPlena extends Exception {
	private static final long serialVersionUID = 1L;

	public PilaPlena(int e){
		super("ERROR : Pila plena i no podem afegir el valor "+e);
	}

}
