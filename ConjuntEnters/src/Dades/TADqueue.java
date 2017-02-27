package Dades;
import Exceptions.*;

public class TADqueue extends TAD {
	public TADqueue(int num, int[] key) {
		super(num, key); 
	}
	
	public void afegir(char c) throws conjuntPle, jaExisteix {
		if (this.numElem<this.Msg.length) {
			this.Msg[this.numElem]=(char)((int)c+this.key[this.numKeys]);
			this.numElem++;
			this.numKeys++;
			if (this.numKeys==this.key.length) this.numKeys=0;
		}
		else
		{
			throw new conjuntPle();
		}
	}
	
	public char eliminar() {
		if (this.numElem!=-1)
		{
			this.numKeys--;
			if (this.numKeys==-1) this.numKeys=this.key.length-1;
			return (char)((int)this.Msg[this.numElem]-this.key[this.numKeys]);
		}
		else
		{
	//		throw new conjuntBuit();
			return 'e';
		}
	}
}
/**
 * 
 *
	public boolean pertany(int e) {
		if (posicio(e)!=-1) return(true);
		else return(false);
	}
	
	private int posicio(int e) {	
		/* cerca dicotomica *
		
		int ini=0, fi=numElem-1, mig=0;
		boolean trobat=false;
		while ((!trobat) && (ini<=fi)){
			mig=(ini+fi)/2;
			if (enters[mig]==e) trobat=true;
			else if (enters[mig]<e) {
				ini=mig+1;
			} else {
				fi=mig-1;
			}
		}
		if (trobat) return(mig);
		else return(-1);
		 
	}
}*/
