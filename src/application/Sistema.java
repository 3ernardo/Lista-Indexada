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
		lista.inserirNoFim("Ana");
		lista.inserirNoFim("Beto");
		lista.inserirNoFim("Cris");
		lista.inserirNoFim("Dani");
		lista.inserirNoFim("Erik");
		lista.inserirNoFim("Fabi");
		lista.inserirNoFim("Gabi");
		lista.inserirNoFim("Hugo");
		lista.inserirNoFim("Ivo");
		lista.inserirNoFim("Jean");
		lista.inserirNoFim("Kely");
		lista.inserirNoFim("Lara");
		
		Iterador iter = lista.iterator();
		iter.goToTail();
		System.out.println(iter.now());
		while (iter.hasPrev()){
			System.out.println(iter.prev());
		}
		
		String nome = "";
		while (!nome.equals("0")) {
			iter.goToHead();
			boolean whil = false;
			System.out.println("/////////////////////");
			System.out.println("Insira um nome:");
			nome = input.next();
			while (!whil) {
				whil = iter.sortedInsert(nome);
			}
			System.out.println("/////////////////////");
			lista.imprime();
		}
		
		System.out.println("/////////////////////");
		
		lista.imprime();
		
		System.out.println("/////////////////////");
		
		
		
		while (true) {
			System.out.println("Um:");
			String um = input.next();
			System.out.println("Dois:");
			String dois = input.next();
			System.out.println(teste(um, dois));
		}
	}
	
	/*
	public static boolean insertInOrder(String current, String dado) {
		boolean posicionado = false;
		if (current.compareToIgnoreCase(dado) == 0) {
			posicionado = true;
		} else if (current.compareToIgnoreCase(dado) > 0) { // vai antes
			
		} else if (current.compareToIgnoreCase(dado) < 0) { // vai depois
			
		}
	}*/
	
	public static int teste(String um, String dois) {
		return um.compareToIgnoreCase(dois);
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
