import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person
{
    String name;
    int age;

    Person(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return name+" ("+age+")";
    }
}
class Activity
{
    int start,finish;
    Activity(int start,int finish)
    {
        this.start = start;
        this.finish = finish;
    }
}

public class Day5
{
    public static void Selection(int start[],int end[])
    {
        int n = start.length;
        //Integer[] start = {3,3,1,5};
        //Integer[] finish = {7,4,2,9};
        Activity[] activities = new Activity[n];
        for(int i = 0;i<n;i++)
        {
            activities[i] = new Activity(start[i],end[i]);
        }

        Arrays.sort(activities,(a,b)->a.finish-b.finish);

        List<Activity> selected = new ArrayList<>();
        selected.add(activities[0]);
        int lastFinish = activities[0].finish;
        for(int i = 1;i<n;i++)
        {
            if(activities[i].start>=lastFinish)
            {
                selected.add(activities[i]);
                lastFinish = activities[i].finish;
            }
        }

        int total_activities = selected.size();
        System.out.println("Total Activities : "+total_activities);

        for (Activity activity : selected)
        {
            System.out.println("Start: "+activity.start+"Finish: "+activity.finish);
        }
    }
    public static void Greedy(int cash)
    {
        int[] cash_arr = {1,2,5,10,20,50,100,200,500,2000};
        List<Integer> result = new ArrayList<>();
        int n = cash_arr.length-1;
        while(cash>=0 && n>=0)
        {
            if(cash>=cash_arr[n]){
                cash-=cash_arr[n];
                result.add(cash_arr[n]);
            }
            else
            {
                n--;
            }
        }
        System.out.println("Change :"+result);
    }
    public static void Character_compare(Character arr[])
    {
        Arrays.sort(arr, (a,b)->b-a);
        System.out.println("Sorted Characters :"+Arrays.toString(arr));
    }
    public static void Ascending_Descending(String words[],String words1[])
    {
        Arrays.sort(words,(a,b) -> Integer.compare(b.length(),a.length()));
        Arrays.sort(words1,(a,b) -> Integer.compare(a.length(),b.length()));
        System.out.println("Sorted words ascending :"+Arrays.toString(words1));
        System.out.println("Sorted words descending :"+Arrays.toString(words));
    }
    public static void main(String[] args)
    {
        String[] words = {"yo","rav","anki"};
        String[] words1 = {"ankit","kiw","ravi"};
        Character[] chr = {'a','b','c','d'};

        Character_compare(chr);
        Ascending_Descending(words,words1);

        Integer[] numbers = {5,4,6,3,2};
        Arrays.sort(numbers,(a, b)->b-a);
        System.out.println("Sorted Array :"+Arrays.toString(numbers));

        Person[] people =
                {
                new Person("Alice",10),
                new Person("Bob",25),
                new Person("Ravi",30)
                };

        Arrays.sort(people,(a,b) -> a.age-b.age);
        System.out.println(Arrays.toString(people));

        int cash = 1241;
        Greedy(cash);

        int[] start = {3,3,1,5};
        int[] finish = {7,4,2,9};
        Selection(start,finish);


    }
}
