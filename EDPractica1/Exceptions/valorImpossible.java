package Exceptions;

public class valorImpossible extends Exception {
	private static final long serialVersionUID = 1L;

	public valorImpossible(int e){
		super("ERROR : El valor "+e+" no té sentit o és massa gran \n");
	}

}
