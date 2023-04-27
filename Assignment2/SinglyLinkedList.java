import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.head.next = new Node(1, null);
        // sl.head.next.next = new Node(2, null);
        // sl.head.next.next.next = new Node(3, null);
        sl.size = 1;
        
        sl.head = sl.deleteNode(sl.head, new Node(1, null) );
        
        System.out.println(sl.size);

        Node p = sl.head.next;
        System.out.println(p);
        
        // for (int i = 0; i < 1; i++) {
        //     System.out.println(p.num);
        //     p = p.next;
        // }
        
    }

    Node head;
    int size;

    public SinglyLinkedList() {
        head = new Node(99, null);
        size = 0;
    }

    public static class Node {
        int num;
        Node next;

        public Node(int num, Node next) {
            this.num = num;
            this.next = next;
        }
    }

    // creates new Node with data val at front; returns new head
    // time complexity: theta 1 (constant)
    // space complexity: constant
    public Node insertAtFront(Node head, int val) {
        Node temp = head.next;
        head.next = new Node(val, temp);
        size += 1;
        return head;
    }

    // creates new Node with data val at end
    // time complexity: theta size (linear)
    // space complexity: constant
    public void insertAtBack(Node head, int val) {
        Node p = head.next;
        for (int i = 0; i < size; i++) {
            if (p.next == null) {
                break;
            } else {
                p = p.next;
            }
        }

        p.next = new Node(val, null);
        size += 1;
    }

    // creates new Node with data val after Node loc
    // time complexity: theta size (linear)
    // space complexity: constant
    public void insertAfter(Node head, int val, Node loc) {
        Node p = head.next;
        for (int i = 0; i < size; i++) {
            if (p.equals(loc)) {
                Node temp = p.next;
                p.next = new Node(val, temp);
                break;
            }
        }
        size += 1;
    }

    // removes first Node; returns new head
    // time complexity: theta 1 (constant)
    // space complexity: constant
    public Node deleteFront(Node head) {
        head.next = head.next.next;
        size -= 1;
        return head;
    }

    // removes last Node
    // time complexity: theta size (linear)
    // space complexity: constant
    public void deleteBack(Node head) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            if (p.next.next == null) {
                p.next = null;
                break;
            }
        }
        size -= 1;
    }

    // deletes Node loc; returns head
    // time complexity: theta size (linear)
    // space complexity: constant
    public Node deleteNode(Node head, Node loc) {
        Node p = head;
        
        for (int i = 0; i < size; i++) {
            
            if (p.next.num == loc.num) {
                
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        size -= 1;
        return head;
    }

    // returns length of the list
    // time complexity: theta 1 (constant)
    // space complexity: constant
    public int length(Node head) {
        return size;
    }

    // reverses the linked list iteratively
    // time complexity: theta size (linear)
    // space complexity: constant
    public Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head.next;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // reverses the linked list recursively (Hint: you will need a helper function)
    // time complexity: theta size (linear)
    // space complexity: constant
    public Node reverseRecursive(Node head) {
        return reverseRecursiveHelper(head.next, null);
    }

    private Node reverseRecursiveHelper(Node curr, Node prev) {
        if (curr == null) {
            return prev;
        } else {
            Node temp = prev;
            return reverseRecursiveHelper(curr.next, new Node(curr.num, temp));
        }
    }

    








}