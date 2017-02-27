package Dades;
import Exceptions.*;

/**
 * Interface per a definir la col�lecci� conjunt d'enters limitats.
 * 
 * @author Professors de l'assignatura 16-17
 *
 */
public interface TADinterface {
	/** 
	 * Afegeix un enter al conjunt mentre hi ha espai, si l'element ja hi �s, no fa res.
	 * @param e - l'enter a afegir al conjunt
	 * @throws conjuntPle - si el conjunt est� ple no es pot afegir l'enter
	 * @throws jaExisteix - si el valor ja hi �s, no es fa res
	 * @throws valorImpossible - casos particulars
	 */
	public void afegir(char c) throws conjuntPle, jaExisteix;
	
	
	char eliminar();
	
	/**
	 * Comprova si el conjunt est� ple
	 * @return cert si el el conjunt est� ple
	 */
	boolean ple();
	
	/**
	 * Retorna el numero d'elements que t� el conjunt
	 * @return numero d'elements que hi ha en el conjunt
	 */
	int getnumElem();
	/**
	 * 
	 * @return
	 */
	int[] getkey();
}
