public class Day4
{
    public static String reverse(String s)
    {
        StringBuilder rev = new StringBuilder(s);
        return rev.reverse().toString();
    }
    public static int Max_Diff(int number)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while(number > 0)
        {
            int digit = number %10;
            max= Math.max(digit,max);
            min = Math.min(digit,min);
            number/=10;
        }
        int diff = max-min;
        return diff;
    }
    public static String Merge_String(String s1,String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        String merged_string = "";
        if (len1 > len2) {
            for (int i = 0; i < len2; i++) {
                merged_string += s1.charAt(i);
                merged_string += s2.charAt(i);
            }
            for (int i = len2; i < len1; i++) {
                merged_string += s1.charAt(i);
            }
        } else {
            for (int i = 0; i < len1; i++) {
                merged_string += s1.charAt(i);
                merged_string += s2.charAt(i);
            }
            for (int i = len1; i < len2; i++) {
                merged_string += s2.charAt(i);
            }
        }
        return merged_string;
    }

    public static boolean Vowel(char s)
    {
        return "aeiouAEIOU".indexOf(s) != -1;
    }
    public static boolean Cons_Vowel(String s)
    {
        for(int i =1;i<s.length()-1;i++)
        {
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);
            char c3 = s.charAt(i+1);
            if(c1==c3 && !Vowel(c1) && !Vowel(c3))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean Number_of_AB(String s)
    {
        int a = 0;
        int b = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'A')
            {
                a+=1;
            }
            if(s.charAt(i) == 'b' || s.charAt(i) == 'B')
            {
                b+=1;
            }
        }
        return a==b;
    }

    public static boolean Pythagorean_Triplet(int a,int b, int c)
    {
        a = a*a;
        b = b*b;
        c = c*c;
        int max = Math.max(a,b);
        max = Math.max(max,c);

        if(c == max){
            return a+b==c;
        }
        else if(b==max){
            return a+c==b;
        }
        else
        {
            return b+c==a;
        }
    }

    public static String Flip_Case(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch))
                {
                    sb.append(Character.toUpperCase(ch));
                }
            else sb.append(Character.toLowerCase(ch));
        }
        return sb.toString();
    }

    public static String Mirror_Image(String s)
    {
        StringBuilder rev = new StringBuilder();

        String[] arr = s.split(" ");

        for(int i = 0;i<arr.length;i++)
        {
            String reverse = reverse(arr[i]);
            if(i!=0) rev.append(" ");
            rev.append(reverse);
        }
        return rev.toString();
    }

    public static void main(String[] args)
    {
        String s1 = "abc";
        String s2 = "xyz123";
        String merged_string = Merge_String(s1,s2);
        System.out.println("Merged String: "+merged_string);


        int number = 9264;
        int diff = Max_Diff(number);
        System.out.println("Max Diff: "+(diff));

        String s = "bebab";
        System.out.println(Cons_Vowel(s));

        String AB = "AaBB";
        System.out.println(Number_of_AB(AB));

        int a = 8,b=15,c=17;
        System.out.println("Pythagorean Triplet :"+Pythagorean_Triplet(a,b,c));

        String str = "ankit";
        System.out.println("Toggled Case :"+Flip_Case(str));

        String mirror = "Hello World";
        System.out.println("Mirror Image of "+mirror+" is "+Mirror_Image(mirror));

    }
}
