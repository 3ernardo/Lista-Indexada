package application;

import java.util.Iterator;

public interface Iterador extends Iterator<String> {
	void insertPrev(String dado);
	void append(String dado);
	boolean hasPrev();
	String prev();
	void goToTail();
	void goToHead();
	void starter();
}
