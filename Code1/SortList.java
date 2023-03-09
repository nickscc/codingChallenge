import java.util.*;

public class SortList {

    // * ---------------------------------------------------------------------------------------------------

    // solution 1
    // simple code (O(n log n) / O(n))

    //The PriorityQueue is based on the priority heap. 
    //The elements of the priority queue are ordered according to the natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.  
    //PriorityQueue doesn’t permit null.
    //ties are broken arbitrarily.
    //The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
    //It provides O(log(n)) time for add and poll methods.

    public ListNode sortList(ListNode head) {
        
        ListNode curr = head;
        Queue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val); 
        //  Queue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n2.val - n1.val);  esto lo hace de mayor a menor
        // pones todo en orden en la lista de prioridad y luego lo vas colocando en una nueva lista ya en orden
        while (curr != null) {
            queue.add(curr);
            curr = curr.next;
        }
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            curr.next = null;
            prev.next = curr;
            prev = curr;
        }
        //[0,1,2,3,4] por el primer prev al inicializar el nodo dummy se inicia con valor 0 
        // al pasarle dummy.next nos deshacemos del primer valor y listo!
        return dummy.next;
    }

    // * ---------------------------------------------------------------------------------------------------
    // solution2 esta madre esta complicada asf usa merge y recursion
    // version pro
    // O(n log n) time using constant space complexity
    ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }
    
}
