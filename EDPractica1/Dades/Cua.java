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
	private int cua;
	
	public Cua(int Elem){
		this.cap=-1;
		this.cua=-1;
		this.cuaFIFO=new int[Elem];
	}
	
	public int desencuar() throws CuaBuida{
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			this.cua++;
			return (this.cuaFIFO[this.cua-1]);
		}
		
	}

	public void encuar(int e) throws CuaPlena {
		if (esPlena())
		{
			throw new CuaPlena(e);
		}
		else
		{
			if ((this.cap==this.cua)&&this.cua==-1) this.cua++;
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
