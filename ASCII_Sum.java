public class ASCII_Sum
{
    public static boolean is_palindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            else
                left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args)
    {
        String name = "naman";
        StringBuilder sb = new StringBuilder(name);
        int sum = 0;
        if(is_palindrome(name))

        {
            for(int i = 0; i < name.length(); i++)
            {
                sum+=name.charAt(i);
            }
        }
        System.out.println("SUM: " + sum);

    }
}
