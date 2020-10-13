package LiKou;

public class maxProfit {
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};

        System.out.println(maxProfit(arr));

    }
    public static int maxProfit(int[] prices) {
        int sum = 0;
        int lowprice = prices[0];
        int maxprice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (maxprice>prices[i]){
                sum =sum + maxprice-lowprice;
                lowprice = prices[i];
                maxprice = prices[i];
            }else {
                maxprice =prices[i];
            }
        }

            sum =sum+maxprice-lowprice;


        return sum;
    }
}
