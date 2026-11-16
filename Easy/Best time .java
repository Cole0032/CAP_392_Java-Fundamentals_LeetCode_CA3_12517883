//Finding the best time to buy and sell Stock 
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices){
            if (price < minPrice){
                minPrice = price;
            }else if(price - minPrice > maxProfit){

                maxProfit = price - minPrice;


            }
          
        }
          return maxProfit;
    }
}
