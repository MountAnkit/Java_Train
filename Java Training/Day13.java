import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Day13
{
    static class SimpleQueue
    {
        Deque<Integer> mainQueue;
        int maxCapacity;

        public SimpleQueue(int Capacity)
        {
            mainQueue =new ArrayDeque<>();
            maxCapacity = Capacity;
        }

        public void addElement(int element)
        {
            if(mainQueue.size()<maxCapacity)
            {
                mainQueue.addLast(element);
                System.out.println(element+" added to queue");
            }
            else
            {
                System.out.println("Queue is Full");
            }
        }
        public void removeElement()
        {
            int removed = mainQueue.pollFirst();
            System.out.println(removed+" removed from the queue");
        }
        public void printQueue()
        {
            System.out.println("Queue : "+mainQueue);
        }
    }
    static class QueueStack
    {
        Deque<Integer> input;
        Deque<Integer> output;

        QueueStack()
        {
            input = new ArrayDeque<>();
            output = new ArrayDeque<>();
        }
        public void addElement(int element)
        {
            input.addLast(element);
            System.out.println(element+" added to stack");
        }
        public void removeElement()
        {
            while(!input.isEmpty())
            {
                output.addLast(input.pollFirst());
            }
            while(!output.isEmpty())
            {
                if(!(output.size() == 1))
                {
                    input.addLast(output.pollFirst());
                }
                else
                {
                    int removed = output.pollFirst();
                    System.out.println(removed+" removed to stack");
                }
            }
        }
        public void printStack()
        {
            System.out.println("Stack : "+input);
        }
    }
    static class StackQueue
    {
        Stack<Integer> input;
        Stack<Integer> output;

        StackQueue()
        {
            input = new Stack<>();
            output = new Stack<>();
        }
        public void addElement(int item)
        {
            input.push(item);
            System.out.println(item+" added to queue");
        }
        public void removeElement()
        {
            while(!input.isEmpty())
            {
                output.push(input.pop());
            }
            int popped = output.pop();
            System.out.println(popped+" removed from queue");
            while(!output.isEmpty())
            {
                input.push(output.pop());
            }
        }
        public void printQueue()
        {
            System.out.println("Queue is -> "+input);
        }
    }

    public static void main(String[] args)
    {
        QueueStack stack = new QueueStack();
        stack.addElement(1);
        stack.addElement(2);
        stack.addElement(3);
        stack.addElement(4);
        stack.printStack();
        stack.removeElement();
        stack.printStack();
    }
}
