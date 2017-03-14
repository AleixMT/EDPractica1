package Dades;

import Exceptions.CuaBuida;
import Interface.TADCua;
/**
 * Classe per a implementar una cua dinamica, implementa la interficie abstracte TADCua
 * @author Aleix Marine
 *
 */
public class CuaDinamica implements TADCua{
	private Node ultim;
	private Node primer;
	private int numElem;
	public CuaDinamica(){
		ultim=null;
		primer=null;
		numElem=0;
	}
	public void encuar(int e){
		this.ultim = new Node(this.ultim, e); //afegim un nou element a la cua amb la classe Node
		if (primer==null) this.primer=this.ultim; //si el primer encara no s'ha inicilitzat vol dir que estem al principi, llavors sera igual al ultim
		numElem++;
	}

	public int desencuar() throws CuaBuida {
		if (esBuida())
		{
			throw new CuaBuida(); //comprovem que la cua no estigui buida
		}
		else
		{
			int aux = this.primer.getValor(); //agafem el valor del primer, el que desencuarem
			this.primer = this.primer.getAnterior(); //movem el punter al anterior, per eliminar el que hi havia al primer
			numElem--;
			return aux; //retornem el que hem desencuat
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida())
		{
			throw new CuaBuida(); //comprovem que no estigui buida
		}
		else
		{
			return this.ultim.getValor(); //retornem l'ultim element afegit
		}
	}

	public boolean esBuida() {
		return (ultim == null); //si l'ultim es null vol dir que no hi ha cap element a la cua
	}

	public int numElem() {
		if (esBuida()) return 0;
		return numElem; //en cas de que no estigui buida, retornem el numElem
	}

	public boolean esPlena() {//mai podra ser plena per la propia implementacio, anem creant segons necessitem
		return false;
	}

}
