public class BestTimeToBuyAndSellStock2 {
    /*NOTE: First the person will but the shares, only then he will sell the shares*/
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1)
            return 0;
        int profitSum=0;
        for(int i=1;i<prices.length;i++)
        {
            if((prices[i]-prices[i-1])>0)  // if the selling price is greater than buying price, only then add it to profit
            {
                profitSum=profitSum+(prices[i]-prices[i-1]);
            }
        }
        return profitSum;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bttobass=new BestTimeToBuyAndSellStock2();

        //int[] arr=new int[]{7,1,5,3,6,4};
        int[] arr=new int[]{7,6,4,3,1};
        int result=bttobass.maxProfit(arr);
        System.out.println(result);

    }
}
