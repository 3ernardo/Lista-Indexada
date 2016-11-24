package application;

import java.util.Iterator;

public interface Iterador extends Iterator<String> {
	void insertPrev(String dado);
	void insertNext(String dado);
	boolean hasPrev();
	String prev();
	String now();
	//int compare(String comparable);
	void goToTail();
	void goToHead();
	void starter();
	boolean sortedInsert(String string);
}
