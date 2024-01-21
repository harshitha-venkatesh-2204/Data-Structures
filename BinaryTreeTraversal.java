//A simple binary tree class.  
//Does not do anything fancy other than imitate the abstract binary tree data type.

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {
    public Object value;                    //The value of an element.
    private BinaryTreeTraversal leftChild;     //The element's left child.
    private BinaryTreeTraversal rightChild;    //The element's right child.
    
    //Create an element and assign it a value and two children.
    public BinaryTreeTraversal(Object value, BinaryTreeTraversal leftChild, BinaryTreeTraversal rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    //Leaf constructor.
    //Create an element and assign it no children.
    public BinaryTreeTraversal(Object value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public Object getValue() {
        return value;
    }
    
    public BinaryTreeTraversal getLeftChild() {
        return leftChild;
    }
    
    public BinaryTreeTraversal getRightChild() {
        return rightChild;
    }
    
    public void setLeftChild(BinaryTreeTraversal subtree){
        this.leftChild=subtree;
    }
    
    public void setRightChild(BinaryTreeTraversal subtree){
        this.rightChild=subtree;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    //If an element's children are null, it is a leaf.
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
    
    public static void inOrder(BinaryTreeTraversal t){
		//IMPLEMENT ME
        if (t != null) {
            inOrder(t.getLeftChild());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRightChild());
        }
    }
    public static void postOrder(BinaryTreeTraversal t){
    	//IMPLEMENT ME
        if (t != null) {
            postOrder(t.getLeftChild());
            postOrder(t.getRightChild());
            System.out.print(t.getValue() + " ");
        }
    }
    public static void preOrder(BinaryTreeTraversal t){
    	//IMPLEMENT ME
        if (t != null) {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeftChild());
            preOrder(t.getRightChild());
        }
    }
    public static void breadthFirst(BinaryTreeTraversal t){
    	//IMPLEMENT ME
         if (t == null) {
        return;
    }

    Queue<BinaryTreeTraversal> queue = new LinkedList<>();
    queue.add(t);

    while (!queue.isEmpty()) {
        BinaryTreeTraversal currentNode = queue.poll();
        System.out.print(currentNode.getValue() + " ");

        if (currentNode.getLeftChild() != null) {
            queue.add(currentNode.getLeftChild());
        }
        if (currentNode.getRightChild() != null) {
            queue.add(currentNode.getRightChild());
        }
    }
    }
    
    public static void main(String[] args){
        //Create several leaf elements.  
        //At first, they are actually 8 different binary trees of one element each.
        BinaryTreeTraversal t = new BinaryTreeTraversal("A");
        BinaryTreeTraversal t1 = new BinaryTreeTraversal("B");
        BinaryTreeTraversal t2 = new BinaryTreeTraversal("C");
        BinaryTreeTraversal t3 = new BinaryTreeTraversal("D");
        BinaryTreeTraversal t4 = new BinaryTreeTraversal("E");
        BinaryTreeTraversal t5 = new BinaryTreeTraversal("F");
        BinaryTreeTraversal t6 = new BinaryTreeTraversal("G");
        BinaryTreeTraversal t7 = new BinaryTreeTraversal("H");
        
        //Link the elements together to form one large binary tree.
        t3.setLeftChild(t7);
        t1.setLeftChild(t3);
        t1.setRightChild(t4);
        t2.setLeftChild(t5);
        t2.setRightChild(t6);
        t.setLeftChild(t1);
        t.setRightChild(t2);
        
        //Print out the traversals of the tree.
        System.out.println("inOrder: ");
        inOrder(t);
        System.out.println("\npostOrder: ");
        postOrder(t);
        System.out.println("\npreOrder: ");
        preOrder(t);
        System.out.println("\nbreadthFirst: ");
        breadthFirst(t);
        System.out.println();
    }
}
