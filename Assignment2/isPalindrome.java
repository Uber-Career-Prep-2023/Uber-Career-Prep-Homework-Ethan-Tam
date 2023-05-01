// Doubly Linked List Forward- Backward Two-Pointer
// Time Complexity: N
// Space Complexity: 1

public class isPalindrome extends DoublyLinkedList{
    public isPalindrome() {
        super();
    }

    public boolean palindrome() {
        Node front = this.head.next;
        Node back = this.head.prev;
        for (int i = 0; i < this.size / 2; i++) {
            if (front.num != back.num) {
                return false;
            } else {
                front = front.next;
                back = back.prev;
            }
        }
        return true;
    }


}

// I spent 30 minutes on this problem.
