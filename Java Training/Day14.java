import java.util.*;

public class Day14
{
    static class Queue
    {
        Deque<Integer> input;
        Deque<Integer> output;

        Queue()
        {
            input = new ArrayDeque<>();
            output = new ArrayDeque<>();
        }
        public void addElement(int item)
        {
            input.addLast(item);
            System.out.println(item+" added to stack");
            while(!output.isEmpty())
            {
                input.addLast(output.pollFirst());
            }
            Deque<Integer> temp = new ArrayDeque<>();
            temp = input;
            input = output;
            output=temp;
        }
        public void removeElement()
        {
            System.out.println(output.pollFirst()+" removed from stack");
        }
        public void printStack()
        {
            System.out.println("Stack is :"+output);
        }
    }

    static class Cars
    {
        int position;
        int speed;
        Cars(int position,int speed)
        {
            this.position = position;
            this.speed = speed;
        }
    }

//    public static void int closestNumber(int target,int[] arr)
//    {
//        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(arr));
//
//    }
    public static void smallRightElements(int[] arr)
    {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = n-1;i>=0;i--)
        {
            set.add(arr[i]);
            result.add(0,set.headSet(arr[i]).size());
        }
        System.out.println("Array is : "+result);
    }
    public static int nonCollidingCars(Cars[] car,int target)
    {
        Stack<Integer> fleet = new Stack<>();
        Arrays.sort(car,(Cars a,Cars b)->a.position-b.position);

        for(int i = 0;i<car.length;i++)
        {
            int time = (target-car[i].position)/car[i].speed;
            if(fleet.isEmpty()||fleet.peek()<time)
            {
                fleet.push(time);
            }
        }
        return fleet.size();
    }
    public static void main(String[] args)
    {
        Cars[] cars = {
                new Cars(2,3),
                new Cars(6,2),
                new Cars(4,1)
        };
        System.out.println("fleet size :"+nonCollidingCars(cars,20));

        int[] arr = {7,8,5,3,9,6};
        smallRightElements(arr);
        Queue stack = new Queue();
        stack.addElement(5);
        stack.addElement(8);
        stack.addElement(11);
        stack.printStack();
        stack.removeElement();
        stack.printStack();
    }
}
