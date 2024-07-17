package java8.Collections.linkedList;

public class SinglyLinkedList_Test {

	Node head;
	
	public void add(String data)
	{
		Node newNode = new Node(data);

		if(head == null)
		{
			head  = newNode;
		}
		else 
		{
			Node current = head;
			while(current.next!=null)
			{
				current = current.next;
			}
			current.setNext(newNode);
		}
	}
	
	public static void main(String[] args) {

		SinglyLinkedList_Test linkedList_Test = new SinglyLinkedList_Test();
		linkedList_Test.add("AA");
		linkedList_Test.add("BB");
		linkedList_Test.add("CC");
		linkedList_Test.add("DD");
		Node ptr=linkedList_Test.head;
		while(ptr!=null)
		{
			System.out.println(ptr.getData());
			ptr = ptr.next;
		}
		
	}

}
