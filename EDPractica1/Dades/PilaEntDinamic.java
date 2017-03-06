package Dades;

import Exceptions.PilaBuida;

public class PilaEntDinamic implements TADCua{
	private Node cim;
	public PilaEntDinamic(){
		cim=null;
	}
	public void apilar(int e){
		Node nou = new Node(this.cim, e);
		this.cim=nou;
	}

	public int desapilar() throws PilaBuida {
		if (esBuida())
		{
			throw new PilaBuida();
		}
		else
		{
			int value = cim.getValor();
			cim=cim.getAnterior();
			return value;
		}
		
	}

	public int cim() throws PilaBuida {
		return cim.getValor();
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
