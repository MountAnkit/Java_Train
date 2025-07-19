public class Merge_String
{
    public static void main(String[] args)
    {
        String a = "abc";
        String b = "xyz123";
        StringBuilder result = new StringBuilder();
        int len = Math.max(a.length(),b.length());

        for(int i = 0;i<len;i++)
        {
            if(i<a.length()) result.append(a.charAt(i));
            if(i<b.length()) result.append(b.charAt(i));
        }

        System.out.println("Merged String : "+result);

    }
}
