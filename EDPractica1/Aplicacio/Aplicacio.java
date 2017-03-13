package Aplicacio;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import Exceptions.*;
import Interface.*;
import Dades.*;
/**
 * Classe principal del programa, des de la qual es controlaran i es fara la crida als diferents metodes
 * @author Cristina Izquierdo Lozano i Aleix Marine Tena
 *
 */
public class Aplicacio {
	
	static Scanner teclat=new Scanner(System.in);
	/**
	 * Metode per a interactuar amb l'usuari sobre la implementacio que desitja utilitzar
	 * @return instancia del tipus TADCua
	 */
	public static TADCua menu(){ //mostra el menu i inicialitza el TAD
		boolean correct=false;
		String clau="";
		int num=0;
		int[] aux = new int[1000];
		while (!correct)	//llegim la clau
		{
			System.out.println("Introdueix els digits de la clau");
			clau=teclat.nextLine();
			String[] nombres = clau.split(""); //dividim la clau en strings de un sol numero
			try
			{
				if (clau.isEmpty()) throw new Cadenabuida(); //salta excepcio si esta� buida
				for (int i=0; i<nombres.length; i++)
				{
					aux[i]=Integer.parseInt(nombres[i]); //convertim string d'un sol nombre a enter, en un vector d'enters
					if (aux[i]<1) throw new valorImpossible(aux[i]);
					num++;
				}
				correct=true;
			}
			catch (NumberFormatException e) //s'introdueix un caracter o simbol
			{
				System.out.println("Exceptions.NumberFormatException: ERROR: Has introduit algun caracter incorrecte, torna-ho a intentar \n");
			}
			catch (InputMismatchException e) //s'introdueix un caracter o un simbol
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una cadena incorrecta, torna-ho a intentar \n");
			}
			catch (valorImpossible e) //El valor es 0 
			{
				System.out.println(e);
			}
			catch (Cadenabuida e) //La cadena introduida es buida
			{
				System.out.println(e);
			}
		} 
		int opt=0;
		TADCua tad = null;
		while (tad==null) //mentre que el usuari no indiqui l'estructura
		{
			System.out.println("Quina versio vols utilitzar?");
			System.out.println("1.-Cua amb memoria estatica");
			System.out.println("2.-Cua circular memoria estatica");
			System.out.println("3.-Cua dinamica");
			System.out.println("4.-Estructura de les java.util.collection");
			try
			{
				opt=teclat.nextInt();
				switch(opt) {
				case 1: tad=new Cua(num);break;
				case 2: tad=new CuaCircular(num); break; 
				case 3: tad=new CuaDinamica();break;
				case 4: tad=new JavaUtil();break;
				default: System.out.println("Aquesta opcio no esta� a la llista... \n");break;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una cadena incorrecta, torna-ho a intentar \n");
                teclat.nextLine();
			}
		}
		for (int i=0; i<num; i++)
		{
			try
			{
				tad.encuar(aux[i]); 	  //encua directament la clau al tad corresponent, 
			}
			catch (CuaPlena e) 	//s'han introduit massa caracters
			{
				System.out.println(e);
			}
		}
		return tad; //RETORNA LA INSTANCIA TIPUS CUA
	}
	/**
	 * Metode per a llegir el fitxer
	 * @param file -- fitxer a llegir
	 * @return contingut del fitxer 
	 */
	public static String[] llegirFitxer(String file){
		String content="";
		boolean correcte=false;
		teclat.nextLine(); //flush
		while (!correcte)
		{
			try
			{
				System.out.println("Introdueix el nom del fitxer");
				file = teclat.nextLine();
				if (file.isEmpty()) throw new Cadenabuida(); //salta excepcio si esta� buida
				content = new Scanner(new File(file)).useDelimiter("\\Z").next();
				if (content.isEmpty()) throw new FitxerBuit(file);
				System.out.println("CONTINGUT DEL FITXER:\n\n"+content+"\n"); //debug
				correcte=true;
			}
			catch (Cadenabuida e) //La cadena introduida es buida
			{
				System.out.println(e);
			}
			catch (FitxerBuit e) //El fitxer esta� buit
			{
				System.out.println(e);
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Exceptions.FileNotFoundException: ERROR: No s'ha trobat el fitxer.\n");
			}
			catch (NoSuchElementException e)
			{
				System.out.println("ERROR: El fitxer "+file+" esta� buit.");
			}
			
		}
		
		
		return new String[]{content.toUpperCase(), file}; //passem el string a un char array per a poder encriptar/desencriptar
	}
	
	/**
	 * Metode per a interaccionar amb l'usuari sobre si vol encriptar o desencriptar
	 * @return opcio escollida (1-encriptar, 2-desencriptar)
	 */
	public static int options(){ 
		int opt=0;
		while (opt!=2&&opt!=1)
		{
			System.out.println("Vols encriptar o desencriptar? (introdueix 1 o 2)");
			try
			{
				opt=teclat.nextInt();
				if (opt!=1||opt==2) throw new valorImpossible(opt);
			}
			catch (InputMismatchException e)
			{
				System.out.println("ERROR: Has introduit una cadena incorrecta, torna-ho a intentar");
			}
			catch (valorImpossible e)
			{
				System.out.println("e");
			}
		}
		return opt;
	}
	/**
	 * Metode per a netejar la pantalla (clean screen), imprimeix per pantalla 100 intros.
	 */
	public static void cls(){
		for (int i=0; i<100; i++) System.out.println("\n"); //cls

	}
	/**
	 * Metode per encriptar el contingut del fitxer indicat
	 * @param msg missagte a encriptar
	 * @param tad cua amb la clau
	 * @return missatge encriptat
	 */
	public static char[] encriptar(char[] msg, TADCua tad)
	{
		int aux;
		for (int i=0; i<msg.length; i++)
		{
			if ((int)msg[i]>64 && (int)msg[i]<91)
			{
				try
				{
					aux=tad.desencuar();	//desencuem i guardem al valor auxiliar
					tad.encuar(aux);		//El tornem a posar a la cua
					aux=aux+(int)msg[i];	//Desplacem i guardem a aux
					if (aux>90)		//Si el caracter generat es surt de l'alfabet...
					{
						aux=aux-90+64;		//llavors restem 90 i li sumem 64 per a simular un abecedari circular (consultar taula ascii)
					}
					msg[i]=(char)aux;	//Ho convertim a caracter i ho guardem al vector
				}
				catch (CuaPlena e)
				{
					System.out.println(e);
				}
				catch (CuaBuida e)
				{
					System.out.println(e);
				}
			}
		}
		return msg;
	}
	/**
	 * Metode per a desencriptar el contingut del fitxer indicat
	 * @param msg missatge a desencriptar
	 * @param tad cua amb la clau
	 * @return missatge desencriptat
	 */
	public static char[] desencriptar(char[] msg, TADCua tad)
	{
		int aux;
		for (int i=0; i<msg.length; i++)
		{
			if ((int)msg[i]>64 && (int)msg[i]<91)
			{
				try
				{
					aux=tad.desencuar();	//desencuem i guardem al valor auxiliar
					tad.encuar(aux);		//El tornem a posar a la cua
					aux=(int)msg[i]-aux;	//Desplacem i guardem a aux
					if (aux<65)		//Si el caracter generat es surt de l'alfabet...
					{
						aux=91-(65-aux);		//Considerem abecedari circular, ara ens sortim per la part de baix
					}
					msg[i]=(char)aux;	//Ho convertim a caracter i ho guardem al vector
				}
				catch (CuaPlena e)
				{
					System.out.println(e);
				}
				catch (CuaBuida e)
				{
					System.out.println(e);
				}
			}
		}
		return msg;
	}
	/**
	 * Metode per a escriure la sortida del metode encriptar/desencriptar a un fitxer
	 * @param file fitxer origen (utilitza el mateix nom + sufix)
	 * @param opt opcio 1-encriptar, opcio 2-desecriptar
	 * @param msg missatge a escriure en el fitxer de desti
	 */
	public static void EscriureFitxer(String file, int opt, String msg)
	{
		String[] aux;
		aux=file.split("\\.", 2);
		try
		{
			if (opt==1)
			{ 
				file=aux[0]+"_vX."+aux[1];
			}
			else
			{
				file=aux[0]+"_vD."+aux[1];
			}
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			writer.write(msg);
			writer.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	/**
	 * Metode principal del programa
	 * @param args
	 * @throws FileNotFoundException salta en cas de que no es trobi cap fitxer
	 * @throws CuaPlena salta en cas de que la cua estigui plena
	 */
	public static void main(String[] args) throws FileNotFoundException, CuaPlena {
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		String file="";
		while (true)
		{
			TADCua tad=menu(); //preguntem al usuari quina estructura vol i la inicialitzem, tamb� preguntem la clau i la encuem
			String[] arrays= llegirFitxer(file); //retornem string de missatge i retornem el nom del fitxer, convertim a char array
			char[] msgc=arrays[0].toCharArray();
			file=arrays[1];
			int opt = options();
			ti=System.nanoTime();
			if (opt==1) //li passem el missatge i duem a terme encriptacio desencriptacio segons corresposngui
			{
				msgc=encriptar(msgc, tad);
			}
			else
			{
				msgc=desencriptar(msgc, tad);
			}
			tf=System.nanoTime();
			System.out.println("S'ha tardat en processar "+(tf-ti)+" ns\nEl resultat es el seguent:\n\n"+new String(msgc)); //Fem el cast array char to string
			EscriureFitxer(file, opt, new String(msgc));
			teclat.nextLine(); 			teclat.nextLine();

		}
		
	}
}		
