package java8.Collections.linkedList;

public class Node {
	String data;
	Node next;

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(String data) {
		super();
		this.data = data;
		this.next = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "SinglylinkedList [data=" + data + ", next=" + next + "]";
	}
}
