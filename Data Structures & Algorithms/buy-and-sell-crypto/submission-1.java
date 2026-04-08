class Solution {
    public int maxProfit(int[] prices) {
        int minBuy=prices[0], max=0;

        for(int price:prices){
            max = Math.max(max, price-minBuy);
            minBuy = Math.min(minBuy,price);
        }
        return max;
    }
}
