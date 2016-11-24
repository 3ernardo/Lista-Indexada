package application;

public class ListaDuplamenteEncadeada implements Iterable<String> {

	//===============================================================
	//	Lista;
	//===============================================================
	
	private Node head = null;
	private Node tail = null;
	private int elementos = 0;

	public void inserirNoFim(String dado) {
		Node node = new Node(dado);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrev(tail);
		}
		tail = node;
		elementos++;
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
		elementos++;
	}
	
	public void imprime() {
		Node percorre = head;
		while (percorre != null) {
			System.out.println(percorre.dado);
			percorre = percorre.getNext();
		}
	}
	
	public int getElementos() {
		return elementos;
	}
	
	@Override
	public Iterador iterator() {
		return new ListaIterator() ;
	}
	
	//===============================================================
	//	Elo;
	//===============================================================
	
	protected class Node {
		
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
	//	Iterador;
	//===============================================================
	
	private class ListaIterator implements Iterador {

		private Node current = null;

		public void starter() {
			if (current == null)
				current = head;
		}
		
		public String now() {
			return current.dado;
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
		
		@Override
		public void insertPrev(String dado) {
			Node node = new Node(dado);
			starter();
			node.setNext(current);
			if (hasPrev()) {
				node.setPrev(current.getPrev());
				current.getPrev().setNext(node);
			} else {
				head = node;
			}
			current.setPrev(node);
			elementos++;
		}

		@Override
		public void insertNext(String dado) {
			Node node = new Node(dado);
			starter();
			node.setPrev(current);
			if (hasNext()) {
				node.setNext(current.getNext());
				current.getNext().setPrev(node);
			} else {
				tail = node;
			}
			current.setNext(node);
			elementos++;
		}

		@Override
		public void remove() {
			starter();
			if (hasPrev()) {
				current.getPrev().setNext(current.getNext());
			} else {
				head = current.getNext();
				head.setPrev(null);
			}
			if (hasNext()) {
				current.getNext().setPrev(current.getPrev());
			} else {
				tail = current.getPrev();
				tail.setNext(null);
			}
			current = current.getNext();
			elementos--;
		}
		
		
		
		/*
		@Override
		public int compare(String comparable) {
			return current.dado.compareToIgnoreCase(comparable);
		}
		
		public void insertInOrder(String dado) {
			int comp = current.dado.compareToIgnoreCase(dado);
			
			if (comp == 0) { // posição igual
				
			} else if (comp > 0) { // vai antes
				int compP = current.getPrev().dado.compareToIgnoreCase(dado);
				
				
			} else if (comp < 0) { // vai depois
				
			}
		}*/
		
		////////////
		public boolean sortedInsert(String dado) {
			int compC = current.dado.compareToIgnoreCase(dado);
			int compN = current.getNext().dado.compareToIgnoreCase(dado);
			//System.out.println(compC + "," + compN);
			if (compC <= 0 && compN >= 0) {
				insertNext(dado);
				//System.out.println(current.dado + "," + current.getNext().dado);
				return true;
			} else {
				next();
				return false;
			}
		}
		////////////
		
		/*public boolean sortedInsert(String dado) {
			int compC = now().dado.compareToIgnoreCase(dado);
			if (!hasNext()) {
				if (compC <= 0) {
					insertNext(dado);
					return true;
				}
			}			

			int compN = current.getNext().dado.compareToIgnoreCase(dado);
			if (compC <= 0 && compN >= 0) {
				insertNext(dado);
				return true;
			} else {
				next();
				return false;
			}
		}*/
	}	
}