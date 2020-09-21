package correa;

import java.util.ArrayList;
import java.util.Collections;

public class BST {

	public Node root;
	public int count;
	public ArrayList<Integer> list;
	public int startIndex;

	public BST() {
		list = new ArrayList<Integer>();
		root = null;
	}

	public void addNode(int n) {
		assert !found(n) : n + " already exists. Insert another value.";
		Node temp = new Node(n);
		System.out.println(n + " has been added.");
		
		count++;
		if (root == null) {
			root = temp;
		} else {
			Node travel = root;
			while (true) {
				if (temp.value < travel.value) {
					if (travel.left != null) {
						travel = travel.left;
					} else {
						travel.left = temp;
						break;
					}
				} else {
					if (travel.right != null) {
						travel = travel.right;
					} else {
						travel.right = temp;
						break;

					}
				}
			}
		}

	}

	public void deleteNode(int n) {

		assert found(n) && !isEmpty() : "The node with the value of " + n + " doesn't exist"; 
		
		System.out.println(n + " has been deleted.");
		
		list.remove(Integer.valueOf(n));
		
		Collections.sort(list);
		
		Node removed = root;
		Node parent = null;
		boolean found = false;
		count--;

		while (!found && removed != null) {
			if (n == removed.value) {
				found = true;
			} else {
				parent = removed;
				if (n > removed.value) {
					removed = removed.right;
				} else {
					removed = removed.left;
				}
			}
		}

		if (!found) {
			System.out.println("Node is not found");
			count++;
			return;
		}
		if (removed.left == null || removed.right == null) {
			Node child;
			if (removed.left == null) {
				child = removed.right;
			} else {
				child = removed.left;
			}

			if (parent == null) {
				root = child;
			}

			else if (parent.left == removed) {
				parent.left = child;
			}

			else {
				parent.right = child;
			}
			return;

		}

		Node smallestParent = removed;
		Node smallest = removed.right;

		while (smallest.left != null) {
			smallestParent = smallest;
			smallest = smallest.left;
		}

		removed.value = smallest.value;

		if (smallestParent == removed) {
			smallestParent.right = smallest.right;
		}

		else {
			smallestParent.left = smallest.right;
		}
		assert !found(n) && isBST(): "This node value of " + n
		+ " is found and still exists.";
	}
	public void displayInOrder() {
		assert !isEmpty() : "No values in tree";
		inOrderRecursive(root);
	}

	private void inOrderRecursive(Node travel) {
		if (travel != null) {

			inOrderRecursive(travel.left);
			System.out.println(travel.value);
			inOrderRecursive(travel.right);
		}
	}

	public void CountNodes() {
		System.out.println("Number of nodes: " + count);
	}
	//HELPER METHODS

	public boolean found(int num) { 

		Node n = root;
		Node parent = null;
		boolean found = false;
		while (!found && n != null) {
			if (num == n.value) {
				found = true; 
			} else {
				parent = n;
				if (num > n.value) {
					n = n.right;
				} else {
					n = n.left;
				}
			}
		}
		if (!found) {
			
			return found;
		}

		else {
			return found;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean isBST() {
		return isBSTScan(root, Collections.min(list), Collections.max(list));
	}

	public boolean isBSTScan(Node travel, int min, int max) {

		if (travel == null) {
			return true;
		}

		if (travel.value < min || travel.value > max) {
			return false;
		}
		return (isBSTScan(travel.left, min, travel.value - 1)
				&& isBSTScan(travel.right, travel.value + 1, max));
	}
	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) { 
		this.list = list;
	}

}
