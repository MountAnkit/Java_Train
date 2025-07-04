public class Maximise_Loot
{
    public static int maximizeLoot(int[] bankLineup)
    {
        int n = bankLineup.length;
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return bankLineup[0];
        }
        int[] dp = new int[n];
        int yo = Math.max(bankLineup[0],bankLineup[n-1]);
        dp[0] = bankLineup[0];
        dp[1] = Math.max(yo,bankLineup[2]);

        for(int i =1;i<n;i++)
        {
            yo = Math.max(bankLineup[0],bankLineup[i]);
            dp[i] = Math.max(bankLineup[i] + dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public static void main(String[] args)
    {
        int[] bankLineup = {3,1,2,5,4,1};
        int maxLoot = maximizeLoot(bankLineup);
        System.out.println("Maximum Loot "+maxLoot);

    }
}
