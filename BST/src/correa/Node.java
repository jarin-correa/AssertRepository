package correa;

public class Node {
	public Integer value;
	public Node left;
	public Node right;

	// EXPLICIT CONSTRUCTOR
	public Node(int n) {
		value = n;
		left = null;
		right = null;
	}

	public String toString() { // when you print the objects
		return "(Node value: " + value + ")";

	}
}
