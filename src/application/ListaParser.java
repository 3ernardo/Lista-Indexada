package application;

import java.util.Scanner;

import application.ListaDuplamenteEncadeada.Node;

public class ListaParser implements Parser<Node> {

	public String parse(String dados) {

		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");

		String dado = arquivo.next();
		
		//listagem.Node pessoa = new listagem.Node(dado);
				
		arquivo.close();
		return dado;
	}

}