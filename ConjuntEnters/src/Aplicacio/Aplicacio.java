package Aplicacio;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;
import Exceptions.*;
import Dades.*;

public class Aplicacio {

	static Scanner teclat=new Scanner(System.in);
	
	public static void main(String[] args) throws conjuntPle, jaExisteix, IOException {
		TAD tad=null;
		boolean correct=false;
		//long tempsi, tempsf; // temps per a mesurar l'eficiencia de l'algorisme
		System.out.println("Introdueix el nombre de digits de la clau");
		int digits=0;
		while (!correct)
		{
			try
			{
				digits = teclat.nextInt(); //necessita exceptions
				correct=true;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Has introduit una cadena incorrecta, torna-ho a intentar");
			}

		}
		int[] clau=new int[digits];
		correct=false;
		System.out.println("Introdueix cada digit de la clau apretant intro quan acabis d'escriure cada carácter");
		int opt=0;
		while (opt<digits)
		{
			clau[opt]= teclat.nextInt();
            opt++;
		}
		opt=0;
		while (tad==null)
		{
			for (int i=0; i<100; i++) System.out.println("\n");
			System.out.println("Which version do you want to use?");
			System.out.println("1.-Static memori");
			System.out.println("2.-Memòria estàtica, cua circular sobre un vector.");
			System.out.println("3.-Memòria dinàmica (punters/referències).");
			System.out.println("4.-Utilitzar una estructura de les java.util.collection");
			opt=teclat.nextInt(); //necessita excepcions
			for (int i=0; i<100; i++) System.out.println("\n"); //cls
			switch(opt) {
				case 1: tad=new TADqueue(99999, clau); break;
				//case 2: cjt=new ConjEntersOrd(numElem);break;
				//case 3: cjt=new ConjEntersAltres(MAX_VALOR);break; 
				//case 4: 
				default: System.out.println("Oops, wrong option, try again!");
			}
		}
		
	
	
		//de moment ho estic  fent amb cadenes per la entrada estandard, la entrada
		//per fitxers la implementare en un altre moment
		int i=0;
		System.out.println("introduce msg");
		teclat.nextLine();
		String str = teclat.nextLine();
		char[] msg;
		msg = str.toCharArray();
		System.out.println(msg);
		while (i<msg.length)
		{
			tad.afegir(msg[i]);
			i++;
		}
		i=0;
		System.out.println(tad.getMsg());
		while (i<msg.length)
		{
			msg[i]=tad.eliminar();
			i++;
		}
		System.out.println(msg);
		while (!correct){
			System.out.println("What do you want to do? Crypt or decrypt? (introduce 1 or 2)");
			opt=teclat.nextInt(); //falten excepcions
			for (int m=0; m<100; m++) System.out.println("\n"); //cls
			if (opt==1||opt==2) correct=true;
			else System.out.println("Oops, wrong option, try again!");

			//comprovacions de que existeix el fitxer, mismatch de tipus, de mida de fitxer etc excpecions implementar
		}
		if (opt==2)
		{
			System.out.println("Introduce the (name of the file) message you want to decrypt:");

		}
		else
		{
			System.out.println("Introduce the (name of the file) you want to crypt:");
		}
		
		
	}
}
		/*
		 * 
		 *
		String name="";
		// a continuaci� generarem num nros aleatoris entre 0-99.999 i els afegirem al conjunt
		int num=200000;
		tempsi=System.nanoTime();
		omplirConjunt(cjt, num);
		tempsf=System.nanoTime();
		System.out.println("Afegir "+num+" enters al conjunt ha tardat: "+(tempsf-tempsi)+" ns");
		
		// a continuaci� generarem num nros aleatoris entre 0-99.999 i comprovarem si estan al conjunt
		num=200000;
		tempsi=System.nanoTime();
		consultarConjunt(cjt,num);
		tempsf=System.nanoTime();
		System.out.println("Consultar si els "+num+" enters estan al conjunt ha tardat: "+(tempsf-tempsi)+" ns");
		
		
		
		// afegim alguns valors especifics per assegurar-nos que hi son
		try {
			cjt.afegir(2016);
		} catch (conjuntPle exc) {
			System.out.println(exc);
		} catch (jaExisteix exc) {
			System.out.println(exc);
		} catch (valorImpossible exc) {
			System.out.println(exc);
		}
		
		// treiem alguns valors especifics per assegurar-nos que no hi son
		try {
			cjt.eliminar(2015);
		} catch (valorImpossible exc) {
			System.out.println(exc);
		}
		
		if (cjt.pertany(2016)) System.out.println("L'enter 2016 si pertany al conjunt");
		if (!cjt.pertany(2015)) System.out.println("L'enter 2015 no pertany al conjunt");
		
		/* afegir les intruccions per a eliminar tamb� num valors generats aleatoriament i controlar el temps
		 * que tardem en fer-ho en cada una de les opcions implementades. 
		 *
		
	}
	
	public static void omplirConjunt(TADqueue cjt, int num) {
		int e;
		int numPle=0, numHiEs=0, numImpos=0;
		for (int i=0; i<num; i++) {
			e = (int) (Math.random()*MAX_VALOR);
			try {
				cjt.afegir(e);
			} catch (conjuntPle exc) {
				numPle++;
			} catch (jaExisteix exc) {
				numHiEs++;
			} catch (valorImpossible exc) {
				numImpos++;
			}
		}
		System.out.println("Numero de vegades que han saltat les excepcions de conjuntPle: "+numPle+", jaExisteix: "+numHiEs+", valorImpossible: "+numImpos);
	}
	
	public static void consultarConjunt(TADqueue cjt, int num) {
		int e, numSI=0, numNO=0;
		for (int i=0; i<num; i++) {
			e = (int) (Math.random()*MAX_VALOR);
			if (cjt.pertany(e)) numSI++;
			else numNO++;
		}
		System.out.println("Dels "+num+" numeros consultats, "+numSI+" s'han trobat al conjunt i "+numNO+" no hi son");
	}
	
	public static int mostraOpcionsConjunt() {
		System.out.println("Quin tipus de conjunt vols implementar?");
		System.out.println("1. Conjunt amb valors no ordenats");
		System.out.println("2. Conjunt amb valors ordenats");
		System.out.println("3. Conjunt altre");
		return(llegirEnter(3));
	}
	
	public static int llegirEnter(int max) {
		int aux=0;
		boolean llegit=false;
		while (!llegit) {
			try {
				aux=Integer.parseInt(teclat.nextLine());
				if ((aux>max)||(aux<1)) throw new NumberFormatException();
				llegit=true;
			}
			catch(NumberFormatException e) {
				System.out.println("Has d'indicar un valor numeric entre 1 i "+max);
			}
		}
		
		return(aux);
	}

}*/
