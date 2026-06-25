class Solution {
    public int maxProfit(int[] prices) {
      int maxi = Integer.MIN_VALUE;
      int costprice = prices[0];
      for( int i = 0; i < prices.length; i++){
        int sell = prices[i];
        if(sell - costprice < 0){
          costprice = sell;
        }
        maxi = Math.max(maxi ,sell - costprice);
      }
    return maxi;
    }
}