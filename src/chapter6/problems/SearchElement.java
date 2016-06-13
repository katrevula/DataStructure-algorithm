package chapter6.problems;

import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 5/24/2016.
 */
public class SearchElement {

	public boolean searchInBinaryTree(Node<Integer> root, int data) {
		boolean temp;
		if (root == null) {
			return false;
		} else {
			if (root.item == data) {
				return true;
			} else {
				temp = searchInBinaryTree(root.left, data);
				if (temp) {
					return temp;
				} else {
					return searchInBinaryTree(root.right, data);
				}
			}
		}
	}

	public boolean searchNonRecursive(Node<Integer> root, int data) {

		Node<Integer> p = root;
		Node<Integer> temp;
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		if (p == null) {
			return false;
		}
		queue.enQueue(p);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.item == data) {
				return true;
			}
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
		return false;
	}

	public static void main(String[] args) {

		SearchElement se = new SearchElement();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();

		System.out.println("The number 11 is present in tree: " + se.searchInBinaryTree(tree.getRoot(), 11));
		System.out.println("The number 6 is present in tree: " + se.searchInBinaryTree(tree.getRoot(), 6));
		System.out.println("The number 5 is present in tree: " + se.searchInBinaryTree(tree.getRoot(), 5));

		System.out.println(
				"The number 11 is present in tree- Non recursive: " + se.searchNonRecursive(tree.getRoot(), 11));
		System.out
				.println("The number 6 is present in tree- Non recursive: " + se.searchNonRecursive(tree.getRoot(),
						6));
		System.out
				.println("The number 5 is present in tree- Non recursive: " + se.searchNonRecursive(tree.getRoot(),
						5));
	}
}
