import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Birthday
{
    int start,finish;
    Birthday(int start,int finish)
    {
        this.start = start;
        this.finish = finish;
    }
}

public class Day6
{
    public static void Selection(int n,int[] events)
    {
        //int n = start.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int j = 0;
        for(int i = 0;i<n;i+=2)
        {
            start[i] = events[j];
            j+=1;
            end[i] = events[j];
            j+=1;
        }


        Birthday[] activities = new Birthday[n];
        for(int i = 0;i<n;i++)
        {
            activities[i] = new Birthday(start[i],end[i]);
        }

        //System.out.println("Activities array : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(" Activities array : "+activities[i]);
        }

        Arrays.sort(activities,(a,b)->a.finish-b.finish);

        List<Birthday> selected = new ArrayList<>();
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

        for (Birthday activity : selected)
        {
            System.out.println("Start: "+activity.start+"Finish: "+activity.finish);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        //int acts = 5;

        int[] events = new int[n*2];
        for(int i=0;i<n*2;i++)
        {
            events[i] = sc.nextInt();
        }
        for(int i=0;i<n*2;i++)
        {
            System.out.print(" Events :"+events[i]);
        }

        Selection(n,events);
    }
}
