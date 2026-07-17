/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create duplicate nodes and insert them next to original nodes
        Node iter = head;
        while (iter != null) {
            Node front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        // Step 2: Assign random pointers for the copied nodes
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Step 3: Restore the original list and extract the copied list
        iter = head;
        Node pseudoHead = new Node(0);
        Node copyIter = pseudoHead;

        while (iter != null) {
            Node front = iter.next.next; // Save the next original node
            
            // extract the copy
            copyIter.next = iter.next;
            copyIter = copyIter.next;
            
            // restore the original list
            iter.next = front;
            
            iter = front;
        }

        return pseudoHead.next;
    }
}