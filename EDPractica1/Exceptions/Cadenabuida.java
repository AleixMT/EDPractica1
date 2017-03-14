package Exceptions;
/**
 * Excepcio per a controlar que no s'introdueixi una cadena buida
 * @author Aleix i Cristina
 *
 */
public class Cadenabuida extends Exception {
	private static final long serialVersionUID = 1L;

	public Cadenabuida(){
		super("ERROR : Cadena buida, introdueix un caracter");
	}
}
