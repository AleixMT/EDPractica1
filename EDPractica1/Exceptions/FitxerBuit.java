package Exceptions;

public class FitxerBuit extends Exception {
	private static final long serialVersionUID = 1L;

	public FitxerBuit(String file){
		super("ERROR: El fitxer "+file+" està buit.");
	}

}
