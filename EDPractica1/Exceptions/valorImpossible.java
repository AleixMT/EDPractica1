package Exceptions;

public class valorImpossible extends Exception {
	private static final long serialVersionUID = 1L;

	public valorImpossible(int e){
		super("ERROR : El valor "+e+" NO el puc gestionar, es massa gran per la implementacio feta");
	}

}
