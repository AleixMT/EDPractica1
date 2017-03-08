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
	int primer, ultim, numElem;
	
	
	public CuaCircular (int MAX_ELEM){
		this.cuaCir = new int[MAX_ELEM];
		this.primer = -1;
		this.ultim = 0;
		this.numElem = 0;
	}
	//encuem pel primer i desencuem pel ultim
	public void encuar(int e) throws CuaPlena{
		if (esPlena()) throw new CuaPlena(e);
		else{
			primer++;
			if (primer%cuaCir.length==0); primer=0;
			cuaCir[primer] = e; //afegim el nou element a la seguent posicio
			numElem++;
		}
	}

	public int desencuar() throws CuaBuida {
		if (esBuida()) throw new CuaBuida();
		else{
			
			int aux = cuaCir[ultim];
			ultim++;
			numElem--;
			if (ultim%cuaCir.length==0); ultim=0; 
			return aux;
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida()) throw new CuaBuida();
		else{
			return cuaCir[primer]; //retornem el primer (ultim afegit)
		}
	}

	public boolean esBuida() {
		return numElem==0;
	}

	public int numElem() {
		return numElem;
	}

	public boolean esPlena() { 
		return numElem==cuaCir.length;
	}

}
