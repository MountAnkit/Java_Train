import java.util.HashMap;
import java.util.Map;

public class Hashmap
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> map = new HashMap();
        map.put("apple",4);
        map.put("banana",3);
        map.put("mango",5);
        System.out.println(map.get("apple"));

        for(Map.Entry<String, Integer>entry : map.entrySet())
        {
            System.out.println(entry.getKey()+ " =>"+entry.getValue());
        }
    }


}
