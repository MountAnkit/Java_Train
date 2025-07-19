import java.util.Stack;

class MiddleStack {
    Stack<Integer> stack;
    Stack<Integer> temp_stack;

    public MiddleStack()
    {
        stack = new Stack<>();
        temp_stack = new Stack<>();
    }
    public void remove_middle()
    {
        int size = stack.size();
        for(int i = 0;i<size;i++)
        {
            int a = stack.pop();
            if(i != size/2)
            {
                temp_stack.push(a);
            }
        }
        //System.out.println("Temp_Stack :"+temp_stack);
        //System.out.println("Stack :"+stack);
        int temp_size = temp_stack.size();
        for(int i = 0;i<temp_size;i++)
        {
            int b = temp_stack.pop();
            stack.push(b);
        }
        System.out.println("After removing middle :"+stack);
    }
    public void add(int value)
    {
        stack.push(value);
    }
    public void remove()
    {
        stack.pop();
    }
}
public class Day12_MiddleStack
{
    public static void main(String[] args)
    {
        MiddleStack middle = new MiddleStack();
        middle.add(6);
        middle.add(5);
        middle.add(4);
        middle.add(3);
        middle.add(2);
        //middle.add(1);
        middle.remove_middle();

    }
}
