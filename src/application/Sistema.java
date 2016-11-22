package application;

import java.util.Scanner;

public class Sistema {

	static int numTeste;
	static Scanner input = new Scanner(System.in);
	
	public static void run(){
		
		while (numTeste != 0) {
			System.out.println("Quantas posições tem a lista?");
			setNum(input.nextInt());
			calculaPotencia();
		}
		
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		lista.inserirNoFim("Um");
		lista.inserirNoFim("Dois");
		lista.inserirNoFim("Três");
		lista.inserirNoFim("Quatro");
		lista.inserirNoFim("Cinco");
		lista.inserirNoFim("Seis");
		
		Iterador iter = lista.iterator();
		//iter.next();
		//iter.prev();
		//iter.insertPrev("inserido 1");
		/*System.out.println(iter.hasPrev());
		System.out.println(iter.hasNext());
		iter.starter();
		System.out.println(iter.prev());
		System.out.println(iter.hasPrev());
		iter.next();
		iter.prev();
		System.out.println(iter.hasPrev());		
		iter.next();
		iter.next();
		iter.next();
		iter.next();
		iter.next();
		iter.next();
		System.out.println(iter.hasNext());
		iter.next();
		System.out.println(iter.hasPrev());
		System.out.println(iter.hasNext());
		iter.next();
		iter.next();
		iter.next();
		System.out.println(iter.hasNext());
		iter.goToTail();
		iter.prev();
		iter.prev();
		iter.prev();
		iter.prev();
		iter.prev();
		iter.prev();
		iter.insertPrev("inserido 2");
		iter.goToHead();
		iter.insertPrev("inserido 1");
		iter.next();
		iter.next();
		iter.next();
		iter.insertPrev("inserido 2");*/
		
		System.out.println("/////////////////////");
		
		lista.imprime();
		
		System.out.println("/////////////////////");
		
		for (String s : lista) {
			System.out.println(s);
		}		
		
	}
	
	public static void setNum(int num){
		numTeste = num;
	}
	
	public static void calculaPotencia(){
		int pot = 2;
		int exp = 1;
		
		while (numTeste > pot) {
			exp++;
			pot = pot * 2;
		}
		
		System.out.println(pot);
		System.out.println(exp);
	}

}
