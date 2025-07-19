import java.util.*;
import java.util.LinkedList;

public class Day15
{
    static class Queue1
    {
        Queue <String> input;
        Queue <String> output;
        Queue1()
        {
            input = new LinkedList<>();
            output = new LinkedList<>();
        }
        public void addElement(String element)
        {
            input.offer(element);
        }
        public void printRange(int range)
        {
            for(int i = 0;i<range;i++)
            {
                String polled = input.poll();
                int count = 0;
                for(char ch : polled.toCharArray())
                {
                    if (ch == '1') count+=1;
                }
                input.offer(polled+"0");
                input.offer(polled+"1");
                while(polled.length()<4)
                {
                    polled = "0" + polled;
                }
                System.out.println("Number of 1's in "+polled+" are: "+count);
            }
        }
    }
    public static void decToBin(int range)
    {
        Queue<String> input = new LinkedList<>();
    }
    public static void DecimalToBinary(int range)
    {
        for(int j = 1;j<=range;j++)
        {
            int i = 0;
            int n = j;
            int res = 0;
            while(n >0)
            {
                int rem = n%2;
                n=n/2;
                res+=rem * (Math.pow(10,i));
                i+=1;
            }
            System.out.println(res);
        }
    }

    public static int equalSum(int[] arr)
    {
        for(int i = 1;i<arr.length - 1;i++)
        {
            int left = 0;
            int right = arr.length-1;
            int leftSum = 0;
            int rightSum = 0;
            while(left<i)
            {
                leftSum+=arr[left];
                left++;
            }
            while(right>i)
            {
                rightSum +=arr[right];
                right--;
            }
            if(leftSum==rightSum) return i;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int range = 10;
        DecimalToBinary(range);
        Queue1 queue = new Queue1();
        queue.addElement("1");
        queue.printRange(10);

        int[] arr = {3,1,5,2,5,4};
        System.out.println(equalSum(arr));
    }
}
