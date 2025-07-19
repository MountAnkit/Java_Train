import java.util.HashMap;
import java.util.Map;

public class Day11
{
    public static class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next=null;
        }
    }
    Node headNode;
    public void buildList(int[] input)
    {
        if(input.length == 0)
        {
            headNode = null;
            return;
        }
        headNode = new Node(input[0]);
        Node tailNode = headNode;

        for(int i = 1;i< input.length;i++)
        {
            tailNode.next = new Node(input[i]);
            tailNode = tailNode.next;
        }
    }
    public void print() {
        Node temp = headNode;

        System.out.print("head -> ");
        if(headNode == null)
        {
            System.out.println("LL is Empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public int middle()
    {
        if (headNode == null)
        {
            throw new RuntimeException("No middle element");
        }
        Node slowNode = headNode;
        Node fastNode = headNode;

        while(fastNode!=null && fastNode.next!=null)
        {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode.data;
    }
    public static Node NodeDetection(Node headNode) {
        if (headNode == null) {
            throw new RuntimeException("No Loop");
        }

        Node slowNode = headNode;
        Node fastNode = headNode;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode) {
                slowNode.next = null;
                return slowNode; // Meeting point inside the loop
            }
        }

        return null; // No loop
    }
    public Node RemoveDuplicate() {
        HashMap<Node, Integer> map = new HashMap<>();
        Node current = headNode;

        while (current != null) {
            map.put(current, current.data);  // ✅ Store node with its data
            current = current.next;
        }

        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            System.out.println("Node object: " + entry.getKey() + ", Data: " + entry.getValue());
        }

        return headNode;
    }


    public static void main(String[] args) {
        int[] input = {10,20,30,40,50};
        Day11 list = new Day11();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        list.headNode = n1;
        list.RemoveDuplicate();
//        list.print();
//        int middle = list.middle();
//        System.out.println("Midlle "+middle);
//        Node loopStart = NodeDetection(n1);
//        if (loopStart != null) {
//            System.out.println("Cycle detected, node inside loop: " + loopStart.data);
//        } else {
//            System.out.println("No cycle detected.");
//        }
    }
}
