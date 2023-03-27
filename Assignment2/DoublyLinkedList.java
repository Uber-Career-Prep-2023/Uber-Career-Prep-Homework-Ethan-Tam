public class DoublyLinkedList {

    public static void main(String[] args) {
        
    }

    Node head;
    int size;

    public DoublyLinkedList() {
        head = new Node(99, null, null);
        size = 0;
    }

    private class Node {
        int num;
        Node next;
        Node prev;

        public Node(int num, Node next, Node prev) {
            this.num = num;
            this.next = next;
            this.prev = prev;
        }
    }

    // creates new Node with data val at front; returns new head
    // time complexity: theta 1 (constant)
    // space complexity: constant
    public Node insertAtFront(Node head, int val) {
        Node temp = head.next;
        head.next = new Node(val, temp, head);
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

        p.next = new Node(val, null, p);
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
                p.next = new Node(val, temp, p);
                p.next.next.prev = p.next;
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
        head.next.prev = head;
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
            if (p.next.equals(loc)) {
                p.next = p.next.next;
                p.next.next.prev = p.next;
                break;
            }
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
            if (curr.next != null) {
                curr.next.prev = curr;
            }
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
        } else if (prev == null) {
            return reverseRecursiveHelper(curr.next, new Node(curr.num, null, null));
        } else {
            Node temp = prev;
            temp.prev = new Node(curr.num, temp, null);
            return reverseRecursiveHelper(curr.next, temp);
        }
    }

}
