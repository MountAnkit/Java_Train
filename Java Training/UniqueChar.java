import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniqueChar
{
    public static String UniqueStr(String s1,String s2)
    {
        HashMap<Character,Integer> map1 = new HashMap<>();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s1.toCharArray())
        {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(char c : s2.toCharArray())
        {
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for(char c:map1.keySet())
        {
            if(map1.get(c)==1)
            {
                sb.append(c);
            }
        }
        int n = sb.length();
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n-i-1;j++)
            {
                int n1 = sb.charAt(j);
                int n2 = sb.charAt(j+1);
                if(n1>n2){
                    char temp = sb.charAt(j);
                    sb.setCharAt(j,sb.charAt(j+1));
                    sb.setCharAt(j+1,temp);
                }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args)
    {
        HashMap<Character,Integer> map1 = new HashMap<>();
        String ans = "";
        String s1= "hello";
        String s2 ="world";

        System.out.println(UniqueStr(s1,s2));
    }
}
