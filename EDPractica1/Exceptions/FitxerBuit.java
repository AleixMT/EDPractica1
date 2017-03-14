package Exceptions;
/**
 * Excepcio en cas de que el fitxer donat estigui buit
 * @author Cristina i Aleix
 *
 */
public class FitxerBuit extends Exception {
	private static final long serialVersionUID = 1L;

	public FitxerBuit(String file){
		super("ERROR: El fitxer "+file+" esta  buit.");
	}

}
