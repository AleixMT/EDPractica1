package Aplicacio;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import Exceptions.*;
import Interface.*;
import Dades.*;

public class Aplicacio {
	//Cal ordenar les classes (estan mesclades les del sego i tercer lab) ja qu ehi ha mlt codi aprofitable,
	// pero en general es tracta de aprofitar la interficie del programa del segon lab i les classes del tercer, 
	// cambiant la pila per una cua

	static Scanner teclat=new Scanner(System.in);
	
	public static TADCua menu(){//ARREGLAR EL PROBLEMA DELS TAD
		int opt=0;
		TADCua tad = null;
		while (tad==null) //mentre que el usuari no indiqui l'estructura
		{
			for (int i=0; i<100; i++) System.out.println("\n");
			System.out.println("Which version do you want to use?");
			System.out.println("1.-Static memory");
			System.out.println("2.-Memoria estatica, cua circular sobre un vector.");
			System.out.println("3.-Memoria dinamica (punters/referencies).");
			System.out.println("4.-Utilitzar una estructura de les java.util.collection");
			try
			{
				opt=teclat.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Has introduit una cadena incorrecta, torna-ho a intentar");
			}
			for (int i=0; i<100; i++) System.out.println("\n"); //cls
			switch(opt) {
			//esto falta ponerlo con los tad (el nombre) 	
			case 1: Cua cua=new Cua(99999); opt=1; break;
				case 2: CuaCircular cuaCir=new CuaCircular(99999); opt=2;break; 
				case 3: CuaDinamica cuaDin=new CuaDinamica();opt=3;break;
				case 4: JavaUtil javaUtil=new JavaUtil();opt=4;break;
				default: System.out.println("Oops, opcio incorrecta, torna-ho a intentar!");
			}
		}
		return tad; //RETORNA LA INSTANCIA TIPUS CUA
	}
	
	public static void clau(TADCua tad) throws CuaPlena{
		boolean correct=false;
		System.out.println("Introdueix el nombre de digits de la clau");
		int digits=0;
		while (!correct)
		{
			try
			{
				digits = teclat.nextInt();
				correct=true;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Has introduit una cadena incorrecta, torna-ho a intentar");
			}
		}
		int opt=0;
		System.out.println("Introdueix cada digit de la clau apretant intro quan acabis d'escriure cada caracter");
		while (opt<digits)
		{
			try
			{
			   tad.encuar(teclat.nextInt());  //encua directament la clau al tad corresponent
	           opt++;
			}
            catch (InputMismatchException e)
			{
				System.out.println("Has introduit una cadena incorrecta, torna-ho a intentar");
			}
		}
		 
	}
	
	public static char[] llegirFitxer() throws FileNotFoundException{
		String file = null;
		String str = null;
		try{
		System.out.println("introdueix el nom del fitxer");
		teclat.nextLine();
		file = teclat.nextLine();
		}
		catch (InputMismatchException e){
			System.out.println("Has introduit un nom incorrecte, torna-ho a intentar");
		}
		
		BufferedReader br= new BufferedReader(new FileReader(file));
		try{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			str = sb.toString();
		br.close();	
		}catch (FileNotFoundException e){
			System.out.println("No s'ha trobat el fitxer.");
		}catch (IOException e){
			System.out.println("Error amb el fitxer.");
		}
		System.out.println("Missatge original: "+str);
		return str.toCharArray(); //passem el string a un char array per a poder encriptar/desencriptar
	}
	
	
	public static void options(char[] msg){ //aqui et falta fer lo de encriptar/desencriptar
		boolean correct = false;
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		int opt=0;
		while (!correct){
			System.out.println("Vols encriptar o desencriptar? (introdueix 1 o 2)");
			opt=teclat.nextInt(); 
			for (int m=0; m<100; m++) System.out.println("\n"); //cls
			if (opt==1||opt==2) correct=true;
			else System.out.println("Oops, no has introduit be el codi, torna-ho a intentar:");
		}
		ti = System.nanoTime(); //capturar temps inicial
		if (opt==2)
		{
			//desencriptar
		}
		else
		{
			//encriptar
		}
		tf = System.nanoTime(); //capturar temps final
		String str = new String(msg); //convertir de char[] a String	
		System.out.println("El missatge final es: "+str+"El temps que ha trigat es: "+(ti-tf)); //aqui he puesto el msg final pero si te lo quieres meter tu dentro del if a tu bola
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, CuaPlena {
		char[] msg = null;
		TADCua tad = null;
		menu(); //preguntem al usuari quina estructura vol
		clau(tad); //obtenir clau
		msg = llegirFitxer(); //li passem l'array on volem que ens guardi el missatge
		options(msg);	//li passem el missatge del fitxer	
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
