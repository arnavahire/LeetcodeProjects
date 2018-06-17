import java.util.Collections;
import java.util.LinkedList;

public class BestTimeToBuyAndSellStock {

    // Brute Force

    public int maxProfit(int[] prices) {
        LinkedList<Integer> profits=new LinkedList<Integer>();
        if(prices.length==0||prices.length==1)
            return 0;
        for(int i=0;i<prices.length-1;i++)
        {
            for(int j=i+1;j<prices.length;j++)
            {
                profits.add(prices[j]-prices[i]);
            }
        }
        Collections.sort(profits);
        int max=profits.getLast();
        if(max<0)
            return 0;
        else
            return max;
    }

    // Better solution - Kadane's Algorithm

    public int improvedMaxProfit(int[] prices)
    {
        if(prices.length==0||prices.length==1)
        {
            return 0;
        }

        int[] profits=new int[prices.length];
        int minSoFar=prices[0];        // the first element is considered min initially
        profits[0]=0;  // written this just to clarify that the first number will be 0 since there will be no profit for the first item
        for(int i=1;i<prices.length;i++)
        {
            profits[i]=prices[i]-minSoFar;  // this gives us the profit at an instant
            if(prices[i]<minSoFar)
            {
                minSoFar=prices[i];   // we need the minimum value to calculate distances at every instance
            }
        }
        int max=0;
        for(int i=0;i<profits.length;i++)
        {
            if(profits[i]>max)
            {
                max=profits[i];   // calculate max value of the profits and return
            }
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bttobass=new BestTimeToBuyAndSellStock();

        //int[] arr=new int[]{7,1,5,3,6,4};
        int[] arr=new int[]{7,6,4,3,1};
        int result=bttobass.maxProfit(arr);
        System.out.println(result);
        int result2=bttobass.improvedMaxProfit(arr);
        System.out.println(result2);
    }
}
