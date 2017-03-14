package Dades;

import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Interface.TADCua;
/**
 * Classe per a implementar una cua circular, implementa la interficie abstracte TADCua
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
			if (primer%cuaCir.length==0) primer=0; //si hem arribat al final de la cua, tornem al principi
			cuaCir[primer] = e; //afegim el nou element a la seguent posicio
			numElem++; //augmentem el numero d'elements
		}
	}

	public int desencuar() throws CuaBuida {
		if (esBuida()) throw new CuaBuida(); //comprovem que la cua no estigui buida
		else{
			
			int aux = cuaCir[ultim]; //guardem l'ultim de la cua
			ultim++; //augmentem l'index per a eliminar la ultima posicio
			numElem--; //reduim el numero d'elements
			if (ultim%cuaCir.length==0); ultim=0; //si hem arribat al final de la cua, tornem al inici
			return aux; //retornem el element que hem desencuat
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida()) throw new CuaBuida();
		else{
			return cuaCir[primer]; //retornem el primer (ultim afegit)
		}
	}

	public boolean esBuida() { //retornara cert si el numero d'elements es 0 (buida)
		return numElem==0;
	}

	public int numElem() { //retornem el numero d'elements
		return numElem;
	}

	public boolean esPlena() {  //si el numero d'elements es igual a la llargada de la cua, esta plena
		return numElem==cuaCir.length;
	}

}
