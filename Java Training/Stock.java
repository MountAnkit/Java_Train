import java.util.*;
public class Stock
{
    public static void main(String[] args)
    {
        int[] arr = {7,8,5,9,2,5};
        int min = arr[0],min_idx = 0;

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i]<min)
            {
                min = arr[i];
                min_idx = i;
            }

        }

        int max = 0;
        for(int i = min_idx;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        System.out.println("Min Stock Value: " + min);
        System.out.println("Max Stock Value to buy: " + max);
        System.out.println("Profit: " + (max-min));

    }
}


