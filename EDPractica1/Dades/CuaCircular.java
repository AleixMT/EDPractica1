package Dades;

import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Interface.TADCua;
/**
 * Classe per a implementar una cua circular
 * @author Cristina Izquierdo
 *
 */
public class CuaCircular implements TADCua{
	int[] cuaCir;
	int primer, numElem, MAX_ELEM;
	
	
	public CuaCircular (int MAX_ELEM){
		this.cuaCir = new int[MAX_ELEM];
		this.MAX_ELEM = MAX_ELEM;
		this.primer = 0;
		this.numElem = 0;
	}
	
	public void encuar(int e) throws CuaPlena{
		if (numElem == MAX_ELEM) throw new CuaPlena(e);
		else{
			cuaCir[primer++] = e; //afegim el nou element a la seguent posicio
			primer = (primer+1)%MAX_ELEM; //tornem a calcular la posicio
			numElem++;
		}
	}

	public int desencuar() throws CuaBuida {
		if (esBuida()) throw new CuaBuida();
		else{
			int pos=(primer+numElem)%MAX_ELEM;
			int value = cuaCir[pos]; //retornem el que hi havia primer
			primer=(primer++)%MAX_ELEM;
			numElem--;
			return value;
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida()) throw new CuaBuida();
		else{
			int pos=(primer+numElem)%MAX_ELEM;
			return cuaCir[pos]; //retornem el primer
		}
	}

	public boolean esBuida() {
		boolean buida=false;
		if (primer==0 && numElem==0) buida = true;
		return buida;
	}

	public int numElem() {
		return numElem;
	}

	public boolean esPlena() { 
		boolean ple = false;
		if (MAX_ELEM == numElem) ple= true;
		return ple;
	}

}
