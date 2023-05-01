// basic iteration
// Time Complexity: N
// Space Complexity: 1

public class DisconnectCycle extends SinglyLinkedList {
    
    public DisconnectCycle() {
        super();
    }

    public void disconnectCyc() {
        // get to last Node, since that's where cycles can only exist in singly linked lists
        Node p = this.head.next;
        for (int i = 0; i < this.size - 1; i++) {
            p = p.next;
        }

        // the 'next' of the last Node of the linked list should always be null
        // thus eliminates any possible cycles
        p.next = null;
    }
}

// I spent 20 minutes on this problem.