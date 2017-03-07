package Dades;

import Exceptions.PilaBuida;
import Exceptions.PilaPlena;
import Interface.TADCua;
import java.*;

public class JavaUtil implements TADCua{

	@Override
	public void encuar(int e) throws PilaPlena {
		
	}

	@Override
	public int desencuar() throws PilaBuida {
		return 0;
	}

	@Override
	public int cap() throws PilaBuida {
		return 0;
	}

	@Override
	public boolean esBuida() {
		return false;
	}

	@Override
	public int numElem() {
		return 0;
	}

	@Override
	public boolean esPlena() {
		return false;
	}

}
