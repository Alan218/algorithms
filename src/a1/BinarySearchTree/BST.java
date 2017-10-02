package a1.BinarySearchTree;

public class BST {
	Node root=null;
	
	public void add(int index){
		if(root==null){
			root=Node.getNode();
			root.key=index;
			return;
		}
		Node cur = root;
		Node next=null;
		if (index > cur.key) {
			next = cur.rightChild;
		} else {
			next = cur.leftChild;
		}
		while(next!=null){
			cur=next;
			if (index > cur.key) {
				next = cur.rightChild;
			} else {
				next = cur.leftChild;
			}
		}
		next=Node.getNode();
		next.key=index;
		next.parent=cur;
		if(index>cur.key){
			cur.rightChild=next;
		}else{
			cur.leftChild=next;
		}
	}
}

class Node {
	int key;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	static Node nil = new Node();
	
	private	Node() {
		key = 0;
		parent = leftChild = rightChild = this;
	}
	
	static public Node getNode() {
		Node node = new Node();
		node.parent = node.leftChild = node.rightChild = nil;
		return node;
	}
}
