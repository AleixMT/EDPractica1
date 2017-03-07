package Dades;

import Exceptions.PilaBuida;
import Exceptions.PilaPlena;
import Interface.TADCua;

public class CuaCircular implements TADCua{
	int[] cuaCir;
	int primer, numElem, MAX_ELEM, ultim;
	
	
	public CuaCircular (int MAX_ELEM){
		this.cuaCir = new int[MAX_ELEM];
		this.MAX_ELEM = MAX_ELEM;
		this.primer = 0;
		this.ultim = 0;
		this.numElem = 0;
	}
	
	@Override
	public void encuar(int e) throws PilaPlena{
		
	}

	@Override
	public int desencuar() throws PilaBuida {
		if (esBuida()) throw new PilaBuida();
		else{
			int pos=(primer+numElem)%MAX_ELEM;
			int value = cuaCir[pos]; //retornem el que hi havia primer
			primer=(primer++)%MAX_ELEM;
			numElem--;
			return value;
		}
		
	}

	@Override
	public int cap() throws PilaBuida {
		if (esBuida()) throw new PilaBuida();
		else{
			int pos=(primer+numElem)%MAX_ELEM;
			return cuaCir[pos]; //retornem el primer
		}
	}

	@Override
	public boolean esBuida() {
		boolean buida=false;
		if (primer==0 && numElem==0) buida = true;
		return buida;
	}

	@Override
	public int numElem() {
		return numElem;
	}

	@Override
	public boolean esPlena() { 
		boolean ple = false;
		if (MAX_ELEM == numElem) ple= true;
		return ple;
	}

}
