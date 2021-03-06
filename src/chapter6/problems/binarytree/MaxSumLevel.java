package chapter6.problems.binarytree;

import chapter5.LinkedListQueue;

/**
 * Created by mishrk3 on 6/16/2016.
 */
public class MaxSumLevel {

	public int findMaxSumLevelOfTree(SampleBinaryTree.Node<Integer> root) {

		LinkedListQueue<SampleBinaryTree.Node<Integer>> queue = new LinkedListQueue<>();
		SampleBinaryTree.Node<Integer> temp = null;
		int maxSum = 0;
		int levelSum = 0;
		int level = 0;
		int maxLevel = 0;

		queue.enQueue(root);
		queue.enQueue(null);
		level++;
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp == null) {
				if (!queue.isEmpty()) {
					queue.enQueue(null);
				}
				if (levelSum > maxSum) {
					maxSum = levelSum;
					maxLevel = level;
				}
				level++;
				levelSum = 0;
			} else {
				levelSum += temp.item;
				if (temp.left != null) {
					queue.enQueue(temp.left);
				}
				if (temp.right != null) {
					queue.enQueue(temp.right);
				}
			}
		}
		return maxLevel;
	}

	public static void main(String[] args) {
		MaxSumLevel msl = new MaxSumLevel();
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		SampleBinaryTree tree1 = SampleBinaryTree.getDefaultTree();
		System.out.println("The level having max sum is: " + msl.findMaxSumLevelOfTree(tree.getRoot()));
		System.out.println("The level having max sum is: " + msl.findMaxSumLevelOfTree(tree1.getRoot()));
	}
}
