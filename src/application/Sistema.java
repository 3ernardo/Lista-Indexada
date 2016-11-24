package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

//import application.ListaDuplamenteEncadeada.Node;

public class Sistema {

	static int numTeste;
	static Scanner input = new Scanner(System.in);
	
	public static void run() throws FileNotFoundException{
		
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		lista.inserirNoFim("Alva");
		lista.inserirNoFim("Beto");
		lista.inserirNoFim("Cris");
		lista.inserirNoFim("Dani");
		lista.inserirNoFim("Erik");
		lista.inserirNoFim("Fabi");
		lista.inserirNoFim("Gabi");
		lista.inserirNoFim("Hugo");
		lista.inserirNoFim("Ivan");
		lista.inserirNoFim("Jean");
		lista.inserirNoFim("Kely");
		lista.inserirNoFim("Lara");
		lista.inserirNoFim("Zulu");
		
		Iterador iter = lista.iterator();
		
		//===============================================================
		//	Parser
		//===============================================================
		
		/*Parser<Node> parser = new ListaParser(); 
		CSVReader<Node> reader = new CSVReader<>("nomes.csv", parser);
		while (reader.hasNext()) {
			String teste = reader.readObject();
			iter.sortedInsert(teste);
		}
		reader.close();*/
		
		//===============================================================
		//	Iterador;
		//===============================================================
		//---------------------------------------------
				
		/*iter.goToTail();
		System.out.println(iter.now());
		while (iter.hasPrev()){
			System.out.println(iter.prev());
		}
		System.out.println("|||||||||||||||||||||||||||||");
		//gravaNomes();
		lista.imprime();
		System.out.println("|||||||||||||||||||||||||||||");*/
		
		System.out.println("//////////////////////////");
		System.out.println("Lista Duplamente Encadeada");
		System.out.println("--------------------------");
		System.out.println("Digite 'sair' para findar ");
		System.out.println("as insersões e apresentar ");
		System.out.println("a lista em ordem inversa. ");
		System.out.println("//////////////////////////");
		
		lista.imprime();
		
		String nome = "";
		while (!nome.equals("sair")) {
			iter.goToHead();
			boolean whil = false;
			System.out.println("//////////////////////////");
			System.out.println("Insira um nome:");
			nome = input.next();
			if (nome.equalsIgnoreCase("sair")){
				whil = true;
			}
			while (!whil) {
				whil = iter.sortedInsert(nome);
				System.out.println("//////////////////////////");
				lista.imprime();
			}

		}
		
		System.out.println("//////////////////////////");
		System.out.println("Lista em ordem inversa    ");
		System.out.println("//////////////////////////");
		
		iter.goToTail();
		System.out.println(iter.now());
		while (iter.hasPrev()){
			System.out.println(iter.prev());
		}
		
		System.out.println("//////////////////////////");
		
		//ListaParser listagem = new ListaParser();
		/*
		while (true) {
			System.out.println("Insira a primaira palavra:");
			String um = input.next();
			System.out.println("Insira a segunda palavra:");
			String dois = input.next();
			System.out.println(teste(um, dois));
		}*/
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
	

	
	/*public static void gravaNomes() throws FileNotFoundException {
		Parser<Node> parser = new ListaParser(); 
		CSVReader<Node> reader = new CSVReader<>("nomes.csv", parser);
		while (reader.hasNext()) {
			String teste = reader.readObject();
			System.out.println(teste);
			iter.sortedInsert(teste);
		}
		reader.close();
	}*/
	
}
