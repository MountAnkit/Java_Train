import java.util.PriorityQueue;
import java.util.Scanner;

public class Day17
{
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next=null;
        }
    }
    static Node headNode;
    static class Patient
    {
        String name;
        int priority;
        Patient(String name,int priority)
        {
            this.name = name;
            this.priority = priority;
        }
    }
    public static void topKElements(int[] arr,int k)
    {
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0;i<arr.length;i++)
        {
            min.add(arr[i]);
        }
        for(int i = 0;i<k;i++)
        {
            System.out.println(min.poll());
        }
    }

    public static void kSmallestElement(int[] arr,int k)
    {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++)
        {
            min.add(arr[i]);
        }
        int i = 0;
        int smallest=0;
        while(i<k)
        {
            smallest = min.poll();
            i++;
        }
        System.out.println(smallest);
    }

    public static void patientPriority()
    {
        PriorityQueue<Patient> min = new PriorityQueue<>((Patient a,Patient b)->b.priority-a.priority);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Enter Patient Name and Priority 2. Exit");
            int i = sc.nextInt();
            if(i==1)
            {
                System.out.print("Enter Name ");
                String name = sc.next();
                System.out.print("Enter Priority ");
                int priority = sc.nextInt();
                min.add(new Patient(name,priority));
            }
            if(i==2) break;
        }

        System.out.println("---------Priority order of Patients-----------");
        while(!min.isEmpty())
        {
            System.out.println(min.poll().name);
        }
    }

    public static void printList(Node head)
    {
        if (head == null) return;

        Node current = head;
        do
        {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }

    public static void divideLList()
    {
        Node slow = headNode,fast = headNode;
        while(fast.next!=headNode&&fast.next.next!=headNode)
        {
            slow =slow.next;
            fast = fast.next.next;
        }
        Node head1 = headNode;
        Node head2 = slow.next;

        slow.next = head1;
        Node temp = head2;
        while(temp.next!=headNode)
        {
            temp = temp.next;
        }
        temp.next = head2;

        printList(head1);
        System.out.println();
        printList(head2);
    }

    public static void main(String[] args)
    {
        //patientPriority();
        //topKElements(new int[]{5,20,3,100,11,70},3);
        //kSmallestElement(new int[]{5,20,3,100,11,70},3);
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = n1;

        headNode = n1;
        divideLList();
    }
}
