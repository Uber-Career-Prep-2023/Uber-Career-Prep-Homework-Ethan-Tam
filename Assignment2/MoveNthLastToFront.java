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
        Node hold = this.head.next;
        this.head.next = newHead;
        newHead.next = hold;
    }

}
