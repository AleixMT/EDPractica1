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
	public CuaDinamica(){
		ultim=null;
		primer=null;
	}
	public void encuar(int e){
		this.ultim = new Node(this.ultim, e);
		if (primer==null) this.primer=this.ultim;
	}

	public int desencuar() throws CuaBuida {
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			int aux = this.primer.getValor();
			this.primer = this.primer.getAnterior();
			return aux;
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			return this.ultim.getValor();
		}
	}

	public boolean esBuida() {
		return (ultim == null);
	}

	public int numElem() {
		if (esBuida()) return 0;
		Node aux=this.primer;
		int numero;
		for (numero=0;aux!=null; numero++)
		{
			aux=aux.getAnterior();
		}
		return numero;
	}

	public boolean esPlena() {
		return false;
	}

}
