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

	public void encuar(int e) throws CuaPlena {
		
	}

	public int desencuar() throws CuaBuida {
		return 0;
	}

	public int cap() throws CuaBuida {
		return 0;
	}

	public boolean esBuida() {
		return false;
	}

	public int numElem() {
		return 0;
	}

	public boolean esPlena() {
		return false;
	}

}
