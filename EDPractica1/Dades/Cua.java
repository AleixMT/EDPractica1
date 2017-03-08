package Dades;
import java.util.Arrays;
import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Interface.TADCua;
/**
 * Classe per a implementar una cua FIFO
 * @author Aleix Marine
 *
 */
public class Cua implements TADCua{
	private int[] cuaFIFO;
	private int cap;
	public Cua(int Elem){
		this.cuaFIFO=new int[Elem];
		this.cap=-1;
	}
	
	public int desencuar() throws CuaBuida{
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			int aux = this.cuaFIFO[0];
			for (int i=0; i<this.cap; i++)
			{
				this.cuaFIFO[i]=this.cuaFIFO[i+1];
			}
			this.cap--;
			return (aux);
		}
		
	}

	public void encuar(int e) throws CuaPlena {
		if (esPlena())
		{
			throw new CuaPlena(e);
		}
		else
		{
			this.cap++;
			this.cuaFIFO[this.cap]=e;
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			return this.cuaFIFO[this.cap];
		}
	}

	public boolean esBuida() {
		return this.cap==-1;
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
			return this.cap+1;
		}
	}
	
}
