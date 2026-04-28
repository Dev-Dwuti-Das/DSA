class Solution {
    public int maxProfit(int[] prices) {
      int buy = prices[0];
      int max = 0;
      int profit = 0;
      for(int i = 0; i < prices.length; i++){
        int sell = prices[i];
        if(sell - buy < 0){
          buy = sell;
        }
        max = Math.max(max, sell - buy);
      }
    return max; 
    }
}