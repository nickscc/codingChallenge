import java.util.LinkedList;

public class detectIntersection {

    static Node head1;
    static Node head2;

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    //*OBJECT TO STORE AND RETURN 2 VALUES
    public static class Result{
        Node tail;
        int size;

        public Result(Node tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }

    public static void addNode(Node head, Node n) {
		Node tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = n;
        // tmp = tmp.next;
        // tmp.next = null;
        n.next = null;
	}

    public static Result getTailAndSize(Node head){

        Node current = head;
        int size = 1;
        while(current != null){
            current = current.next;
            size ++;
        }    
        return new Result(current, size);
    }

    public static Node setPosition(Node head, int difference){
        //! SIEMPRE RECUERDA QUE PARA RECORRER UNA LISTA ENLAZADA NECESITAS DE CURRENT
        Node current = head;
        for( int x = 0; x < difference; x++){
            current = current.next;
        }
        return current;
    }
    
    public static Node findIntersection(Node head1, Node head2){

        //* IF ONE OF THE LISTS IS EMPTY THERE IS NO INTERSECTION */
        if(head1 == null || head2 == null)
            return null;

        Result r1 = getTailAndSize(head1);
        Result r2 = getTailAndSize(head2);

        //* IF THE LIST DON'T SHARE THE LAST NODE THERE IS NO INTERSECTION */
        if(r1.tail != r2.tail)
            return null;
        
        //* SET 2 POINTERS TO THE START OF EACH LIST */
        // ~ solo es para que los nombres esten a la par con el tamano de las listas y no me pierda
        Node longPointerCurrent = r1.size > r2.size ? head1 : head2;
        Node shortPointerCurrent = r1.size > r2.size ? head2 : head1;

        //* SET THE LONGPOINTER TO ADVANCE AND BE AT THE SAME LEVEL AS THE SHORT POINTER */
        longPointerCurrent = setPosition(longPointerCurrent, Math.abs(r1.size - r2.size)); //~ABS TO AVOID MATH NEGATIVE NUMBERS

        //* MOVE BOTH POINTERS UNTIL THEY POINT TO THE SAME NODE */
        while(longPointerCurrent != shortPointerCurrent){
            longPointerCurrent = longPointerCurrent.next;
            shortPointerCurrent = shortPointerCurrent.next;
        }

        //! TEN CUIDADO CON TUS APUNTADORES LONG Y SHORT SON APUNTADORES EXTRA PARA NO PERDER LA REFERENCIA
        //! O LA ESTRUCTURA ORIGINAL PERO SIGEN SIENDO CURRENTS O TEMPS
        //! POR ESO AL RECORRERLOS EN EL PASO DE ARRIBA NO NECESITAS OTRO TEMP O CURRENT, YA QUE AMBOS SON CURRENTS

        return longPointerCurrent;
    }

    public static void main(String[] args) {

        head1 = new Node(1);
        head2 = new Node(8);

        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        Node n7 = new Node(9);
        
        
        //*CONSTRUCTING LISTS AND INTERSECCION
        //~ l1
        addNode(head1,n1);
        addNode(head1,n2);
        addNode(head1,n3);
        addNode(head1,n4);
        addNode(head1,n5);
        addNode(head1,n6);

        //~ l2
        addNode(head2,n7);
        addNode(head2,n4);
        addNode(head2,n5);
        addNode(head2,n6);
        
        
        System.out.println(findIntersection(head1, head2).val);

        
    }
    
}
