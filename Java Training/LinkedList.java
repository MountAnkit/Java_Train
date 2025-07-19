class Node{
    int data;
    Node next;
}
public class LinkedList {
    Node head;

    public void addFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;

        head = newNode;
    }

    public int search(int key) {
        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == key) {
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return -1;
    }

    public void print() {
        Node temp = head;
        System.out.println("Linked List:");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int Length(){
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len+=1;
            temp = temp.next;
        }
        return len;
    }

    public void addLast(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    public boolean delete(int key) {
        if (head == null) {
            System.out.println();
        }
        if (head.data == key) {
            head = head.next;
            System.out.println("Deleted " + key + " from the list");
            return true;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
                System.out.println("Deleted " + key + " from the list");
                return true;
            }
            temp = temp.next;
        }
        System.out.println(key + " not found in the list");
        return true;
    }

    public static void main(String[] args) {
        // First linked list
        LinkedList list1 = new LinkedList();

        Node n1 = new Node();
        n1.data = 10;
        Node n2 = new Node();
        n2.data = 20;
        Node n3 = new Node();
        n3.data = 30;
        Node t1 = new Node();
        t1.data = 40;
        Node t2 = new Node();
        t2.data = 50;

        n1.next = n2;
        n2.next = n3;
        n3.next = t1;
        t1.next = t2;
        t2.next = null;


        list1.head = n1;

        // Second linked list
        LinkedList list2 = new LinkedList();

        Node m1 = new Node();
        m1.data = 5;
        Node m2 = new Node();
        m2.data = 15;

        m1.next = m2;
        m2.next = t1;

        list2.head = m1;

        // Print both lists
        System.out.println("List 1:");
        list1.print();

        System.out.println("List 2:");
        list2.print();

        System.out.println("Length of List 1 is "+list1.Length());
        System.out.println("Length of List 2 is "+list2.Length());
        int lenA = list1.Length();
        int lenB = list2.Length();

        while(lenA>lenB){
            lenA--;
            list1.head = list1.head.next;
        }
        while(lenB>lenA){
            lenB--;
            list2.head = list2.head.next;
        }

        for(int i = 0;i<lenA;i++)
        {
            if(list1.head == list2.head){
                System.out.println(list1.head.data);
                break;
            }
            else
            {

            }
        }

    }
}
