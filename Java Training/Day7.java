import java.util.HashMap;
import java.util.Map;

public class Day7
{
    public static void count(String s)
    {
        HashMap<String, Integer> map = new HashMap();

        String arr[] = s.split(" ");
        for(String s1 : arr)
        {
            map.put(s1,map.getOrDefault(s1,0)+1);
        }
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
    }
    public static char non_repeating_char(String s)
    {
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(char key:map.keySet())
        {
            if(map.get(key)==1)
            {
                return key;
            }
        }
        return ' ';
    }

    public static boolean Isogram(String s)
    {
        int y = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(char key:map.keySet())
        {
            if(map.get(key)>1)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram(String s1,String s2)
    {
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();
        for(int i = 0;i<s1.length();i++)
        {
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        for(char key:map1.keySet())
        {
            if(map1.get(key)!=map2.get(key))
            {
                return false;
            }
        }
        return true;
    }

    public static void Sub_Anagram(String s1,String s2)
    {
        for(int i = 0;i<s1.length()-2;i++)
        {
            String sub_str = s1.substring(i,i+s2.length());
            if(isAnagram(sub_str,s2))
            {
                System.out.print(" "+i);
            }
        }
    }
    public static int Climb_Stairs(int n)
    {
        if(n<=1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++)
        {
            dp[i] = dp[i-1] + dp[i+2];
        }
        return dp[n];
    }
    public static int NumberOfWaysToClimbStairs(int n)
    {
        if(n==0 || n==1)
        {
            return 1;
        }
        else
        {
            return NumberOfWaysToClimbStairs(n-1) + NumberOfWaysToClimbStairs(n-1);
        }
    }

    public static void main(String[] args)
    {
        String words = "hello hello java";
        count(words);

        String word = "aaaabbbcccdefg";
        System.out.println("First non repeating char is :"+non_repeating_char(word));

        String iso = "abcdef";
        System.out.println("Is the String Isogram? "+Isogram(iso));

        String word1 = "heart";
        String word2 = "earth";

        String ana = "bacabaaccbdabc";
        String ana1 = "abc";

        System.out.println("The words "+word1+" and "+word2+" are Anagram? "+isAnagram(word1,word2));
        Sub_Anagram(ana,ana1);
        System.out.println();

        int stairs = 5;
        System.out.println("Number of Ways are :"+NumberOfWaysToClimbStairs(stairs));
    }
}
