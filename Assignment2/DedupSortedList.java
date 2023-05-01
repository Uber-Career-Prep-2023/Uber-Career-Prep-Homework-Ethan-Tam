// Reset / Catch-Up Two-Pointer
// Time Complexity: N
// Space Complexity: N

public class DedupSortedList extends SinglyLinkedList {
    public static void main(String[] args) {
        //System.out.println(Arrays.asList(1,2,3));

        DedupSortedList d = new DedupSortedList();
        d.head.next = new Node(1, null);
        d.head.next.next = new Node(2, null);
        d.head.next.next.next = new Node(2, null);
        d.head.next.next.next.next = new Node(4, null);
        d.head.next.next.next.next.next = new Node(5, null);
        d.head.next.next.next.next.next.next = new Node(5, null);
        d.head.next.next.next.next.next.next.next = new Node(10, null);
        d.head.next.next.next.next.next.next.next.next = new Node(10, null);
        d.size = 8;

        d.removeRepeats();

        Node p = d.head.next;
        System.out.println(d.size);
        
        for (int i = 0; i < d.size; i++) {
            System.out.println(p.num);
            p = p.next;
        }
    }

    public DedupSortedList() {
        super();
    }

    public void removeRepeats() {
        Node p1 = this.head;
        Node p2 = this.head.next;
        int i = 0;

        while (i != this.size) {
            if (p1 != null && p2 != null && p1.num == p2.num) {
                System.out.println(p2.num);
                while (p1 != null && p2 != null  && p1.num == p2.num) {
                    // delete all occurences of p1 after it
                    this.deleteNode(p1, new Node(p1.num, null));
                    this.size -= 1;
                    p2 = p2.next;
                }
            } 
            if (p1 != null) {
                //System.out.println(p1.num);
            }
            
            
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            i+= 1;
        }
    }

    
}

// I spent 40 minutes on this problem.