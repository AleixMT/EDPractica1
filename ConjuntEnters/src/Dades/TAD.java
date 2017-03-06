package Dades;

import Interface.TADinterface;

public abstract class TAD implements TADinterface {
	protected char[] Msg;
	protected int[] key;
	protected int numElem;
	protected int numKeys;
	/**
	 * La part comú de codi que tenen les tres implementacions son un apuntador i una taula de 
	 * caracters. També tots tindran accés a una clau
	 * 
	 * @param num
	 */
	public TAD(int num, int[] key) {
		this.Msg=new char[num];
		this.key=key;
		this.numElem=0;
		this.numKeys=0;
	}
	
	public int getnumElem(){
		return this.numElem;
	}
	public int[] getKey(){
		return(this.key);
	}
	
	/**
	 * Aquest métode hauria d'anar desactivat a la versió definitiva (privat)
	 * Retorna l'element del missatge passat per parametre
	 * @param num
	 * @return
	 */
	public char[] getMsg(){
		return this.Msg;
	}
	
	public int[] getkey(){
		return this.key;
	}
	
	public boolean ple(){
		return (this.numElem==this.Msg.length);
	}
}
