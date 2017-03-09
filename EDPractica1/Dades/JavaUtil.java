package Dades;
import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Interface.TADCua;
import java.util.*;
/**
 * Classe per a implementar una cua amb llibreries de java util, implementa la interficie abstracte TADCua
 * @author Cristina Izquierdo i Aleix Marine
 *
 */

public class JavaUtil implements TADCua{
	private ArrayDeque<Integer> tad;
	

	public JavaUtil() {
		this.tad = new ArrayDeque<Integer>();
	}

	public void encuar(int e) throws CuaPlena {
		tad.addFirst(e); //afegim pel primer
	}

	public int desencuar() throws CuaBuida {
		return tad.removeLast(); //treiem pel final
	}

	public int cap() throws CuaBuida { //el primer de la llista
		return tad.element();
	}

	public boolean esBuida() {
		return tad.isEmpty();
	}

	public int numElem() {
		return tad.size();
	}

	public boolean esPlena() {
		return false; //mai sera plena, segons la implementacio
	}

}
