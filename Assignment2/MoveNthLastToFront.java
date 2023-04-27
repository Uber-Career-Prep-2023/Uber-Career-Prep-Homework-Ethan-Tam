// Single Pointer
// Time Complexity: N
// Space Complexity: N

public class MoveNthLastToFront extends SinglyLinkedList{
    
    public MoveNthLastToFront() {
        super();
    }

    public void move(int k) {
        Node target = this.head.next;
        int count = this.size - k;
        while (target != null && count != 0) {
            target = target.next;
            count -= 1;
        }
        if (count != 0) {
            return;
        }
        Node newHead = target.next;
        target.next = target.next.next;
        this.insertAtFront(this.head, newHead.num);
    }

}
