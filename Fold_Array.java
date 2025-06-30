import java.util.ArrayList;
import java.util.List;

public class Fold_Array
{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        List<Integer> res = new ArrayList<>();
        //out = 6,6,3
        int left = 0;
        int right = arr.length -1;
        while(left<=right){
            if(left==right){
                res.add(arr[left]);
            }
            else {
                res.add(arr[left] +arr[right]);
            }
            left ++;
            right--;
        }
        System.out.println("Folded array :"+res);
    }
}
