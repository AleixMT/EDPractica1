package Dades;
import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Interface.TADCua;
import java.*;
/**
 * Classe per a implementar una cua amb llibreries de java util
 * @author Cristina Izquierdo
 *
 */

public class JavaUtil implements TADCua{

	@Override
	public void encuar(int e) throws CuaPlena {
		
	}

	@Override
	public int desencuar() throws CuaBuida {
		return 0;
	}

	@Override
	public int cap() throws CuaBuida {
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
