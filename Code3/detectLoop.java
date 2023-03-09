import java.util.HashSet;

public class detectLoop {

    //& -------------------------------------------- FORMA 3 ----------------------------------------------------------
    static class Node {
		int key;
		Node next;
	};

	static Node newNode(int key)
	{
		Node temp = new Node();
		temp.key = key;
		temp.next = null;
		return temp;
	}

	//* A utility function to print a linked list
	static void printList(Node head)
	{
		while (head != null) {
			System.out.print(head.key + " ");
			head = head.next;
		}
		System.out.println();
	}

	//* Function to detect first node of loop in a linked list that may contain loop
	static boolean detectLoop(Node head)
	{

		//* Create a temporary node
		Node temp = new Node();
		while (head != null) {

			//* This condition is for the case when there is no loop
			if (head.next == null) {
				return false;
			}

			//*Check if next is already pointing to temp
			if (head.next == temp) {
				return true;
			}

			//* Store the pointer to the next node in order to get to it in the next step
			Node next = head.next;

			//* Make next point to temp
			head.next = temp;

			//* Get to the next node in the list
			head = next;
		}

		return false;
	}

    //& ---------------------------------------------------------------------------------------------------------------
    //? -------------------------------------------- FORMA 1 ----------------------------------------------------------

    static Node1 head1; //* head of list
 
    //* Linked list Node
    static class Node1 {
        int data;
        Node1 next;
        Node1 (int d)
        {
            data = d;
            next = null;
        }
    }
 
    //* Inserts a new Node at front of the list.
    static public void push1(int new_data)
    {
        //* Allocate the Node & Put in the data
        Node1 new_node = new Node1(new_data);
 
        //* Make next of new Node as head
        new_node.next = head1;
 
        //* Move the head to point to new Node
        head1 = new_node;
    }
 
    //* Returns true if there is a loop in linked list else returns false.
    static boolean detectLoop1(Node1 h)
    {
        HashSet<Node1> s = new HashSet<Node1>();
        while (h != null) {
            //*If we have already has this node in hashmap it means their is a cycle (Because you we encountering the node second time).
            if (s.contains(h))
                return true;
 
            //*  If we are seeing the node for the first time, insert it in hash
            s.add(h);
 
            h = h.next;
        }
 
        return false;
    }

    //? --------------------------------------------------------------------------------------------------------------

    //~ -------------------------------------------- FORMA 4 ----------------------------------------------------------

    static Node4 head4; //* head of list
 
    //* Linked list Node
    static class Node4 {
        int data;
        Node4 next;
        Node4(int d)
        {
            data = d;
            next = null;
        }
    }
 
    //* Inserts a new Node at front of the list. 
    public static void push4(int new_data)
    {
        
        Node4 new_node = new Node4(new_data);
 
        new_node.next = head4;
 
        head4 = new_node;
    }
 
    public static void detectLoop4()
    {
        Node4 slow_p = head4, fast_p = head4;
        int flag = 0;
        while (slow_p != null && fast_p != null
               && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }
 
    //~ --------------------------------------------------------------------------------------------------------------
    
	//* Driver code
    public static void main(String[] args) {

    //& -------------------------------------------- FORMA 3 ----------------------------------------------------------

        Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);

		//* Create a loop for testing(5 is pointing to 3)
		head.next.next.next.next.next = head.next.next;

		boolean found = detectLoop(head);
		if (found)
			System.out.println("Loop Found");
		else
			System.out.println("No Loop");

    //& --------------------------------------------------------------------------------------------------------------

    //? -------------------------------------------- FORMA 1 ----------------------------------------------------------

        push1(20);
        push1(4);
        push1(15);
        push1(10);
 
        //*Create loop for testing 
        head1.next.next.next.next = head1;
        
 
        if (detectLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");

    //? --------------------------------------------------------------------------------------------------------------
    
    //~ -------------------------------------------- FORMA 4 ----------------------------------------------------------

    //! NOTE: HERE I HAVE EVERYTHING IN A STATIC WAY...IS NOT GOOD BETTER FOLLOW FORM 3

        push4(20);
        push4(4);
        push4(15);
        push4(10);
 
        /*Create loop for testing */
        head4.next.next.next.next = head4;
 
        detectLoop4();
    }
}
    
