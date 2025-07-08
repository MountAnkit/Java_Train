public class Day8
{
    public static int min_jumps(int arr[],int k)
    {
        int hops = k;
        int n = arr.length;
        int i = 0;
        int jumps = 0;
        while(i<=n)
        {
            if(i == n)
            {
                return jumps;
            }
            if(i>n)
            {
                k-=1;
            }
            i+=k;
            jumps++;
        }
        return 0;
    }
    public static int Max_SubArray(int arr[])
    {
        int current_sum = 0;
        int max_sum = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++)
        {
            current_sum = Math.max(arr[i],current_sum+arr[i]);
            max_sum = Math.max(max_sum,current_sum);
        }
        return max_sum;
    }

    public static int Optimized_Array(int arr[])
    {
        int n = arr.length;
        int[] dp = new int[n];
        int maxsum = arr[0];
        dp[0] = arr[0];
        //dp[1] = Math.max(arr[1],dp[0]+arr[1]);

        for(int i = 1;i<n;i++)
        {
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
            maxsum = Math.max(maxsum,dp[i]);
        }
        return maxsum;
    }

    public static void main(String[] args)
    {
        System.out.println("Sum of Max Subarray :"+Max_SubArray(new int[] {-2,-3,4,-1,-2,1,5,-3}));
        System.out.println("Min Jumps :"+min_jumps(new int[] {1,2,3,4,5,6,7,8},3));
    }
}
