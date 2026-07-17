/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        // STEP 1: Mid nikala
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // STEP 2: Mid se reversal (BUG 1 FIXED: 'head' ki jagah 'slow')
        ListNode prev = null;
        ListNode curr = slow;     
        ListNode nextnode = null;
        while(curr != null){
            nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        
        // STEP 3: Compare
        ListNode right = head;    // Aage ka engine
        ListNode left = prev;     // Ulti ki hui list ka engine
        
        // BUG 2 FIXED: 'right != null' ki jagah 'left != null'
        while(left != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}