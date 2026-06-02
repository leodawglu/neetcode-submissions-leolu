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
    /*
    To solve for this, we can make use of the Node addresses and an hashmap to keep track
    of the relationship between the original and new node copies, so as to associate the 
    correct next and random copy nodes with each other.
    */
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr!=null){
            Node copy = map.get(curr);
            copy.random = map.get(curr.random);
            copy.next = map.get(curr.next);
            curr = curr.next;
        }

        return map.get(head);
    }
}
