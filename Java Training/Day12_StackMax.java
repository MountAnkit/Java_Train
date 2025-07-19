import java.util.Scanner;
import java.util.Stack;

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> max_stack;

    public MaxStack()
    {
        stack = new Stack<>();
        max_stack = new Stack<>();
    }
    public void addItem(int value)
    {
        stack.push(value);
        if(max_stack.isEmpty() || value >= max_stack.peek())
        {
            max_stack.push(value);
        }
    }
    public void removeItem()
    {
        int popped = stack.pop();
        if (popped == max_stack.peek()) {
            max_stack.pop();
        }
    }
    public void getMax()
    {
            System.out.println("Max Element is: " + max_stack.peek());
    }
}
public class Day12_StackMax
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MaxStack stack = new MaxStack();
        while (true)
        {
            System.out.println("Choose an option:\n1. Add item\n2. Remove item\n3. Find maximum item\n4. Exit");
            int choice = sc.nextInt();

            if(choice == 4) break;

            else if (choice == 1)
            {
                System.out.println("Enter item ");
                int item = sc.nextInt();
                stack.addItem(item);
            }
            else if(choice==2) stack.removeItem();
            else if(choice ==3) stack.getMax();
        }
        sc.close();
    }
}
