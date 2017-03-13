package Dades;
import Exceptions.CuaBuida;
import Exceptions.CuaPlena;
import Interface.TADCua;
/**
 * Classe per a implementar una cua FIFO, implementa la interficie abstracta TADCua
 * @author Aleix Marine
 *
 */
public class Cua implements TADCua{
	private int[] cuaFIFO;
	private int cap;
	public Cua(int Elem){
		this.cuaFIFO=new int[Elem]; //el vector d'elements
		this.cap=-1;	//inicialitzem el cap (o últim afegit)
	}
	
	public int desencuar() throws CuaBuida{
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			int aux = this.cuaFIFO[0]; //obtenim el valor del ultim en un auxiliar
			for (int i=0; i<this.cap; i++) //Desplacem tot el vector
			{
				this.cuaFIFO[i]=this.cuaFIFO[i+1];
			}
			this.cap--; //decrementem la posicio del ultim
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
			this.cap++; //aumentem index
			this.cuaFIFO[this.cap]=e; //afegim l'últim
		}
		
	}

	public int cap() throws CuaBuida {
		if (esBuida())
		{
			throw new CuaBuida();
		}
		else
		{
			return this.cuaFIFO[this.cap]; //retornem l'ultim element
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

	public String toString() {	//Per a imprimir tota la cua
		String str ="";
		for (int i=0; i<cuaFIFO.length; i++){
			str=str+cuaFIFO[i];
		}
		return "Cua [cua=" +str+ "]";
	}
	
	public int numElem(){ //el nombre d'elements sempre es la posicio del cap mes 1
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
