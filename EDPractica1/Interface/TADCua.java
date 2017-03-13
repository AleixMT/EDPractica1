package Interface;
import Exceptions.*;
/**
 * Interface per a definir el contenidor/col·leccio cua.
 * 
 * @author Aleix Marine i Cristina Izquierdo
 *
 */
public abstract interface TADCua {
	/**
	 * Afegeix un enter de la clau a la cua
	 * @pre cert
	 * @post es igual a la cua inicial pero amb el enter e afegit
	 * @param e - enter a afegir
	 * @throws CuaPlena - la cua esta plena i no es pot afegir el valor
	 */
	public void encuar(int e) throws CuaPlena; 
	
	/**
	 * Retorna i elimina el primer de la cua
	 * @pre cert
	 * @post igual a la cua inicial pero sense el primer enter que hi havia guardat
	 * @return l'enter que hi ha el primer de la cua
	 * @throws CuaBuida - la cua esta buida i no hi ha cap enter per a retornar
	 */
	public int desencuar() throws CuaBuida;
	
	/**
	 * Retorna el primer de la cua
	 * @pre cert
	 * @post la cua es igual a la inicial
	 * @return l'enter que hi ha el primer de la cua
	 * @throws CuaBuida - la cua esta buida i no hi ha cap enter per a retornar
	 */
	public int cap() throws CuaBuida;
	
	/**
	 * Retorna si la cua esta buida
	 * @pre cert
	 * @post la cua es igual a la cua inicial
	 * @return cert si la cua esta buida, fals en cas contrari
	 */
	public boolean esBuida();
	
	/**
	 * Retorna el numero d'enters guardats a la cua
	 * @pre cert
	 * @post la cua es igual a la inicial
	 * @return numero d'enters guardats a la cua
	 */
	public int numElem();
	
	/**
	 * Retorna si la cua esta plena
	 * @pre cert
	 * @post la cua es igual a la inicial
	 * @return cert si la cua esta plena, fals en cas contrari
	 */
	public boolean esPlena();
}
