public class Total_MaxP {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int min = 0;
        int sum = 0;
        for(int i = 0;i<arr.length -1;i++){
            if(arr[i+1]>arr[i]){
                int profit = arr[i+1] - arr[i];
                sum+=profit;
            }
        }
        System.out.println("Total :"+sum);
    }
}
