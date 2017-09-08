package binarysearchtree;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree {
	
	private Node rootNode;
	
	public BinarySearchTree() {
		rootNode = null;
	}
	
	public void readFromTextFile(String fileName, String delimiter) {
		
		File file = new File(fileName);
		
		try(Scanner scanner = new Scanner(file).useDelimiter(delimiter)) {
			
			while(scanner.hasNext()){
				
				if(rootNode == null) {
					rootNode = add(rootNode, scanner.nextInt());
				}
				else {
					add(rootNode, scanner.nextInt());
				}
			}
			
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("The specified file was not found.");
			fileNotFoundException.printStackTrace();
		}
	}
	
	public void add(int value) {
		rootNode = add(rootNode, value);
	}
	
	private Node add(Node node, int value) {
		if(node == null) {
			
			return new Node(value, null, null);
		}
		else {
			
			if(value <= node.getValue()) {
				
				node.setLeftChild(add(node.getLeftChild(), value));
			}
			else {
				
				node.setRightChild(add(node.getRightChild(), value));;
			}
		}
		return node;
	}
	
	public void printInOrderTraverseTree() {
		traverseInOrder(rootNode);
	}
	
	private void traverseInOrder(Node node) {
		if(node != null) {
			
			traverseInOrder(node.getLeftChild());
			
			System.out.println(" " + node.getValue());
			
			traverseInOrder(node.getRightChild());
		}
	}
	
	public void printPreOrderTraverseTree() {
		traversePreOrder(rootNode);
	}
	
	private void traversePreOrder(Node node) {
		if(node != null) {
			
			System.out.println(" " + node.getValue());
			
			traversePreOrder(node.getLeftChild());
			
			traversePreOrder(node.getRightChild());
		}
	}
	
	public void printPostOrderTraverseTree() {
		traversePostOrder(rootNode);
	}
	
	private void traversePostOrder(Node node) {
		if(node != null) {
						
			traversePostOrder(node.getLeftChild());
			
			traversePostOrder(node.getRightChild());
			
			System.out.println(" " + node.getValue());
		}
	}
	
	public boolean isContained(int valor) {
		return isContained(rootNode, valor);
	}
	
	private boolean isContained(Node node, int value) {
		if (node == null) {
			
			return false;
		}
		
		if(node.getValue() == value) {
			
			return true;
		}
		
		if(value < node.getValue()) {
			
			return isContained(node.getLeftChild(), value);	
		}
		else {
			
			return isContained(node.getRightChild(), value);
		}
	}
}
