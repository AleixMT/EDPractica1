package Dades;

import java.util.Arrays;

import Exceptions.PilaBuida;
import Exceptions.PilaPlena;

public class Cua implements TADCua{
	private int[] cuaFIFO;
	private int cap;
	private int cua;
	
	public Cua(int Elem){
		this.cap=-1;
		this.cua=-1;
		this.cuaFIFO=new int[Elem];
	}
	
	public int desencuar() throws PilaBuida{
		if (esBuida())
		{
			throw new PilaBuida();
		}
		else
		{
			this.cua++;
			return (this.cuaFIFO[this.cua--]);
		}
		
	}

	public void encuar(int e) throws PilaPlena {
		if (esPlena())
		{
			throw new PilaPlena(e);
		}
		else
		{
			this.cap++;
			this.cuaFIFO[this.cap]=e;
		}
		
	}

	public int cap() throws PilaBuida {
		if (esBuida())
		{
			throw new PilaBuida();
		}
		else
		{
			return this.cuaFIFO[this.cap];
		}
	}

	public boolean esBuida() {
		if (this.cap<this.cua||((this.cap==this.cua)&&this.cua==-1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean esPlena() {
		if ((this.cap+1)==this.cuaFIFO.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String toString() {
		return "Cua [cua=" + Arrays.toString(cuaFIFO) + "]";
	}
	
	public int numElem(){
		if (esBuida())
		{
			return 0;
		}
		else
		{
			return this.cap-this.cua;
		}
	}
	
}
