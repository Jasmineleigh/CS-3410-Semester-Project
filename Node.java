package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	String name;
	int index;
	
	public Node(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ": " + index;
	}

}
