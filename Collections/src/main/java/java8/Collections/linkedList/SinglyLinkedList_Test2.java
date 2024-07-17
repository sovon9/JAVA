package java8.Collections.linkedList;


public class SinglyLinkedList_Test2 {

	Node head;
	Node currentNode;
	
	public void add(String data)
	{
		Node newNode = new Node(data);

		if(head == null)
		{
			head  = newNode;
			currentNode = head;
		}
		else 
		{
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
	}
	
	public void addAtBeginning(String data)
	{
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;
		
	}
	
	public void add(int index, String data)
	{
		Node newNode = new Node(data);
		Node ptr = head;
		int c=1;
		while(c!=index)
		{
			if(c == (index-1))
			{
				newNode.setNext(ptr.getNext());
				ptr.setNext(newNode);
			}
			ptr = ptr.getNext();
			c++;
		}

	}
	
	public static void main(String[] args) {

		SinglyLinkedList_Test2 linkedList_Test = new SinglyLinkedList_Test2();
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
		System.out.println("Adda element at the beginning.....");
		linkedList_Test.addAtBeginning("EE");
		linkedList_Test.addAtBeginning("FF");
		ptr = linkedList_Test.head;
		while(ptr!=null)
		{
			System.out.println(ptr.getData());
			ptr = ptr.next;
		}
		System.out.println("Adda element at specific index.....");
		linkedList_Test.add(2,"OO");
		ptr = linkedList_Test.head;
		while(ptr!=null)
		{
			System.out.println(ptr.getData());
			ptr = ptr.next;
		}
		
	}

}
