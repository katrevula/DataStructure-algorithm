package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 5/21/2016.
 */
public class FindMax {

	public int findMax(SampleBinaryTree.Node<Integer> root) {
		SampleBinaryTree.Node<Integer> p = root;
		int rootVal, left, right, max = Integer.MIN_VALUE;
		if (null != p) {
			rootVal = p.item;
			left = findMax(p.left);
			right = findMax(p.right);

			if (left > right) {
				max = left;
			} else {
				max = right;
			}
			if (rootVal > max) {
				max = rootVal;
			}
		}
		return max;
	}



	public static void main(String[] args) {
		FindMax fm = new FindMax();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();
		System.out.println("The max element is: " + fm.findMax(tree.getRoot()));

		/*System.out.println("The number 13 is present in tree- Non recursive: " + tree.searchNonRecursive(13));
		System.out.println("insertIntoMaxHeap 13 in Binary tree");
		tree.insertElement(13);
		System.out.println("The number 13 is present in tree- Non recursive: " + tree.searchNonRecursive(13));*/
	}

}
