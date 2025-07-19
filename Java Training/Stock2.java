public class Stock2 {
    public static void main(String[] args) {
        int[] arr = {7,8,5,9,6,2};
        int left = 0;
        int right = 1;
        int maxP = 0;
        int total = 0;

        while(right<arr.length)
        {
            if(arr[right] > arr[left])
            {
                int profit = arr[right] - arr[left];
                maxP = Math.max(profit,maxP);
                total+=maxP;
            }
            else
            {
                left = right;
            }
            left=right;
            right++;
        }

        System.out.println("Max Profit :"+maxP);
    }
}
