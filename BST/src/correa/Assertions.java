package correa;

public class Assertions {
	public static BST b;

	public static void main(String[] args) {
		b = new BST();
		//b.displayInOrder(); Used to show assertion if tree is empty.

		int[] a = new int[] { 1, 2, 5, 9, 12, 14, 17, 20, 21 };
		for (int i = 0; i < a.length; i++) {
			b.addNode(a[i]);
		}
		b.displayInOrder();
		System.out.println("Now only odds");
		oddsOnly(a); //deletes all even nodes
		b.displayInOrder();
		//b.addNode(1); assert for duplicate node.
		//b.deleteNode(54); assert for non-existing node.
		System.out.println("Binary search tree build success");
		

	}

	public static void oddsOnly(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				b.deleteNode(arr[i]);
			}

		}
	}

}
