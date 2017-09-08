import binarysearchtree.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
	
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		binarySearchTree.readFromTextFile("binarysearchtree.txt", ", ");
		
		binarySearchTree.printInOrderTraverseTree();
		binarySearchTree.printPreOrderTraverseTree();
		binarySearchTree.printPostOrderTraverseTree();
		
		System.out.println(binarySearchTree.isContained(13));
	}

}
