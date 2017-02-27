package Interface;

import Exceptions.*;

/**
 * Interface per a definir la col·lecció conjunt d'enters limitats.
 * 
 * @author Professors de l'assignatura 16-17
 *
 */
public interface TADh {
	/** 
	 * Afegeix un enter al conjunt mentre hi ha espai, si l'element ja hi és, no fa res.
	 * @param e - l'enter a afegir al conjunt
	 * @throws conjuntPle - si el conjunt està ple no es pot afegir l'enter
	 * @throws jaExisteix - si el valor ja hi és, no es fa res
	 * @throws valorImpossible - casos particulars
	 */
	void afegir(int e) throws conjuntPle, jaExisteix, valorImpossible;
	
	/**
	 * Elimina un valor del conjunt
	 * @param e - l'enter a eliminar del conjunt
	 * @throws valorImpossible - casos particulars
	 */
	void eliminar(int e) throws valorImpossible;
	
	/** 
	 * Comprova si un enter pertany al conjunt
	 * @param e - l'enter a comprovar
	 * @return cert si l'enter pertany i fals en cas contrari
	 */
	boolean pertany(int e);
	
	/**
	 * Comprova si el conjunt està ple
	 * @return cert si el el conjunt està ple
	 */
	boolean ple();
	
	/**
	 * Retorna el numero d'elements que té el conjunt
	 * @return numero d'elements que hi ha en el conjunt
	 */
	int numElems();
}