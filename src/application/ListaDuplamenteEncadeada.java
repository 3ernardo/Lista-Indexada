package application;

import java.util.Iterator;

public class ListaDuplamenteEncadeada implements Iterable<String> {

	//===============================================================
	//	Lista
	//===============================================================
	
	private Node head = null;
	private Node tail = null;

	public void inserirNoFim(String dado) {
		Node node = new Node(dado);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrev(tail);
		}
		tail = node;
	}
	
	public void inserirNoInicio(String dado) {
		Node node = new Node(dado);
		if (head == null) {
			tail = node;
		} else {
			head.setPrev(node);
			node.setNext(head);
		}
		head = node;
	}
	
	public void imprime() {
		Node percorre = head;
		while (percorre != null) {
			System.out.println(percorre.dado);
			percorre = percorre.getNext();
		}
	}
	
	@Override
	public Iterador iterator() {
		return new ListaIterator() ;
	}
	
	//===============================================================
	//	Elo: são os objetos que compõe a lista duplamente encadeada;
	//===============================================================
	
	private class Node {
		
		public final String dado;
		private Node prevNode;
		private Node nextNode;

		public Node(String dado) {
			this.dado = dado;
			this.prevNode = null;
			this.nextNode = null;
		}

		public void setNext(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNext() {
			return nextNode;
		}
		
		public void setPrev(Node prevNode) {
			this.prevNode = prevNode;
		}
		
		public Node getPrev() {
			return prevNode;
		}
		
	}
	
	//===============================================================
	//	Iterador: ;
	//===============================================================
	
	private class ListaIterator implements Iterador {

		private Node current = null;
		private Node previous = null;

		public void starter() {
			if (current == null) {
				current = head;
			}
		}
		
		@Override
		public boolean hasNext() {
			starter();
			return current.getNext() != null;
		}
		
		@Override
		public boolean hasPrev() {
			starter();
			return current.getPrev() != null;
		}
		
		@Override
		public String next() {
			starter();
			if (hasNext()) {
				current = current.getNext();
				return current.dado;
			} else {
				return "Não há elemento posterior.";
			}
		}
		
		@Override
		public String prev() {
			starter();
			if (hasPrev()) {
				current = current.getPrev();
				return current.dado;
			} else {
				return "Não há elemento anterior.";
			}
		}
		
		@Override
		public void goToTail() {
			current = tail;
		}
		
		@Override
		public void goToHead() {
			current = head;
		}
		
		/*@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}
		
		@Override
		public boolean hasPrev() {
			if (current == null)
				return head != null;
			return current.getPrev() != null;
		}
		
		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				current = current.getNext();
			}
			return current.dado;
		}
		
		@Override
		public String prev() {
			if (!hasPrev()) {
				return "Não há elemento anterior.";
			} else {
				current = current.getPrev();
				return current.dado;
			}
		}	
		*/

		


		@Override
		public void insertPrev(String dado) {
			Node node = new Node(dado);
			starter();
			node.setNext(current);
			if (hasPrev()) {
				node.setPrev(current.getPrev());
				current.getPrev().setNext(node);
			}
			current.setPrev(node);
		}

		//@Override
		public void inserirNoFim(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			Node node = new Node(dado);
			Node anterior = current.getPrev();
			Node proximo = current.getNext();
			node.setNext(proximo);
			current.setNext(node);
			if (proximo == null) {
				tail = node;
			}
		}

		@Override
		public void remove() {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			previous.setNext(current.getNext());
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}

		@Override
		public void append(String dado) {
			// TODO Auto-generated method stub
			
		}

	}	
}