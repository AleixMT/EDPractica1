package Interface;
import Exceptions.*;
/**
 * Interface abstracte per a definir el contenidor cua.
 * 
 * @author Aleix Marine i Cristina Izquierdo
 *
 */
public abstract interface TADCua {
	/**
	 * Afegeix un enter de la clau al principi de la cua
	 * @param e - enter a afegir
	 * @throws CuaPlena - la cua esta plena i no es pot afegir el valor
	 */
	public void encuar(int e) throws CuaPlena; 
	
	/**
	 * Retorna i elimina el final de la cua
	 * @return l'enter que hi ha el ultim de la cua
	 * @throws CuaBuida - la cua esta buida i no hi ha cap enter per a retornar
	 */
	public int desencuar() throws CuaBuida;
	
	/**
	 * Retorna el primer de la cua
	 * @return l'enter que hi ha el primer de la cua
	 * @throws CuaBuida - la cua esta buida i no hi ha cap enter per a retornar
	 */
	public int cap() throws CuaBuida;
	
	/**
	 * Retorna si la cua esta buida
	 * @return cert si la cua esta buida, fals en cas contrari
	 */
	public boolean esBuida();
	
	/**
	 * Retorna el numero d'enters guardats a la cua
	 * @return numero d'enters guardats a la cua
	 */
	public int numElem();
	
	/**
	 * Retorna si la cua esta plena
	 * @return cert si la cua esta plena, fals en cas contrari
	 */
	public boolean esPlena();
}
