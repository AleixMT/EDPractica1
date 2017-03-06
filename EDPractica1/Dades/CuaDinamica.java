package Dades;

import Exceptions.PilaBuida;
import Interface.TADCua;

public class CuaDinamica implements TADCua{
	private Node cim;
	public CuaDinamica(){
		cim=null;
	}
	public void encuar(int e){
		Node nou = new Node(this.cim, e);
		this.cim=nou;
	}

	public int desencuar() throws PilaBuida {
		if (esBuida())
		{
			throw new PilaBuida();
		}
		else
		{
			Node aux=this.cim;
			if (aux.getAnterior()==null)
			{
				int r = cim.getValor();
				cim=null;
				return r;
			}
			while (aux.getAnterior().getAnterior()!=null)
			{
				aux=aux.getAnterior();
			}
			int value = aux.getAnterior().getValor();
			aux.setAnterior(null);
			return value;
		}
		
	}

	public int cap() throws PilaBuida {
		if (esBuida())
		{
			throw new PilaBuida();
		}
		else
		{
			return cim.getValor();
		}
	}

	public boolean esBuida() {
		return (cim == null);
	}

	public int numElem() {
		if (esBuida()) return 0;
		Node aux=this.cim;
		int numero=0;
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
