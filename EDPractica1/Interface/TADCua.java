package Interface;
import Exceptions.*;
/**
 * Interface per a definir el contenidor/col�lecci� pila d'enters.
 * 
 * @author Professors de l'assignatura 16-17
 *
 */
public interface TADCua {
	/**
	 * Afegeix un enter a la pila
	 * @param e - enter a afegir
	 * @throws PilaPlena - la pila est� plena i no es pot afegir el valor
	 */
	public void encuar(int e) throws PilaPlena; 
	
	/**
	 * Retorna i elimina el cim de la pila
	 * @return l'enter que hi ha al cim de la pila
	 * @throws PilaBuida - la pila est� buida i no hi ha cap enter per a retornar
	 */
	public int desencuar() throws PilaBuida;
	
	/**
	 * Retorna el cim de la pila
	 * @return l'enter que hi ha al cim de la pila
	 * @throws PilaBuida - la pila est� buida i no hi ha cap enter per a retornar
	 */
	public int cap() throws PilaBuida;
	
	/**
	 * Retorna si la pila est� buida
	 * @return cert si la pila est� buida, fals en cas contrari
	 */
	public boolean esBuida();
	
	/**
	 * Retorna el numero d'enters guardats a la pila
	 * @return numero d'enters guardats a la pila
	 */
	public int numElem();
	
	/**
	 * Retorna si la pila est� plena
	 * @return cert si la pila est� plena, fals en cas contrari
	 */
	public boolean esPlena();
}
