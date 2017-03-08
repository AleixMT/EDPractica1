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
	
	public static TADCua menu(){ //mostra el menú i inicialitza el TAD
		int opt=0;
		TADCua tad = null;
		while (tad==null) //mentre que el usuari no indiqui l'estructura
		{
			System.out.println("Quina versió vols utilitzar?");
			System.out.println("1.-Cua amb memoria estàtica");
			System.out.println("2.-Cua circular memoria estàtica");
			System.out.println("3.-Cua dinámica");
			System.out.println("4.-Estructura de les java.util.collection");
			try
			{
				opt=teclat.nextInt();
				switch(opt) {
				case 1: tad=new Cua(99999);break;
				case 2: tad=new CuaCircular(99999); break; 
				case 3: tad=new CuaDinamica();break;
				case 4: tad=new JavaUtil();break;
				default: System.out.println("Aquesta opció no està a la llista... \n");break;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una cadena incorrecta, torna-ho a intentar \n");
                teclat.nextLine();
			}
			
		}
		return tad; //RETORNA LA INSTANCIA TIPUS CUA
	}
	
	public static void clau(TADCua tad){
		boolean correct=false;
		String clau="";
		clau=teclat.nextLine();
		int aux;
		while (!correct)
		{
			System.out.println("Introdueix els digits de la clau");
			clau=teclat.nextLine();
			String[] nombres = clau.split(""); //dividim la clau en strings de un sol número
			try
			{
				if (clau.isEmpty()) throw new Cadenabuida(); //llença excepció si està buida
				for (int i=
						0; i<nombres.length; i++)
				{
					aux=Integer.parseInt(nombres[i]); //convertim string d'un sol nombre a enter
					if (aux<1) throw new valorImpossible(aux);
					tad.encuar(aux); 	  //encua directament la clau al tad corresponent, 
				}
				correct=true;
			}
			catch (NumberFormatException e) //s'introdueix un caracter o simbol
			{
				System.out.println("Exceptions.NumberFormatException: ERROR: Has introduit algun carácter incorrecte, torna-ho a intentar \n");
			}
			catch (InputMismatchException e) //s'introdueix un carácter o un simbol
			{
				System.out.println("Exceptions.InputMismatchException: ERROR:Has introduit una cadena incorrecta, torna-ho a intentar \n");
			}
			catch (CuaPlena e) 	//s'han introduit massa carácters
			{
				System.out.println(e);
			}
			catch (Cadenabuida e) //La cadena introduida es buida
			{
				System.out.println(e);
			}
			catch (valorImpossible e) //El valor es 0 o negatiu
			{
				System.out.println(e);
			}
		} 
	}
	
	public static String[] llegirFitxer(String file){
		String content="";
		boolean correcte=false;
		while (!correcte)
		{
			try
			{
				System.out.println("Introdueix el nom del fitxer");
				file = teclat.nextLine();
				if (file.isEmpty()) throw new Cadenabuida(); //llença excepció si està buida
				content = new Scanner(new File(file)).useDelimiter("\\Z").next();
				if (content.isEmpty()) throw new FitxerBuit(file);
				System.out.println("CONTINGUT DEL FITXER:\n\n"+content+"\n"); //debug
				correcte=true;
			}
			catch (Cadenabuida e) //La cadena introduida es buida
			{
				System.out.println(e);
			}
			catch (FitxerBuit e) //El fitxer està buit
			{
				System.out.println(e);
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Exceptions.FileNotFoundException: ERROR: No s'ha trobat el fitxer.\n");
			}
		}
		
		return new String[]{content.toUpperCase(), file}; //passem el string a un char array per a poder encriptar/desencriptar
	}
	
	
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
	
	public static void cls(){
		for (int i=0; i<100; i++) System.out.println("\n"); //cls

	}
	
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
					aux=aux+(int)msg[i];	//Fem desplaçament i guardem a aux
					if (aux>90)		//Si el caracter generat es surt de l'alfabet...
					{
						aux=aux-90+64;		//llavors restem 90 i li sumem 64 per a simular un abecedari circular (consultar taula ascii)
					}
					msg[i]=(char)aux;	//Ho convertim a caràcter i ho guardem al vector
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
					aux=(int)msg[i]-aux;	//Fem desplaçament i guardem a aux
					if (aux<65)		//Si el caracter generat es surt de l'alfabet...
					{
						aux=91-(65-aux);		//Considerem abecedari circular, ara ens sortim per la part de baix
					}
					msg[i]=(char)aux;	//Ho convertim a caràcter i ho guardem al vector
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
	public static void main(String[] args) throws FileNotFoundException, CuaPlena {
		long ti, tf; // temps per a mesurar l'eficiencia de l'algorisme
		String file="";
		while (true)
		{
			TADCua tad=menu(); //preguntem al usuari quina estructura vol i la inicialitzem
			clau(tad); //Preguntem la clau a l'usuari i la posem la clau a dins del nostre tad
			String[] arrays= llegirFitxer(file); //retornem string de missatge i retornem el nom del fitxer, convertim a char array
			char[] msgc=arrays[0].toCharArray();
			file=arrays[1];
			int opt = options();
			ti=System.nanoTime();
			if (opt==1) //li passem el missatge i duem a terme encriptació desencriptació segons corresposngui
			{
				msgc=encriptar(msgc, tad);
			}
			else
			{
				msgc=desencriptar(msgc, tad);
			}
			tf=System.nanoTime();
			System.out.println("S'ha tardat en processar"+(tf-ti)+" ns\nEl resultat és el següent:\n\n"+new String(msgc)); //Fem el cast array char to string
			EscriureFitxer(file, opt, new String(msgc));
			teclat.nextLine(); 			teclat.nextLine();

		}
		
	}
}		
