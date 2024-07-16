class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0, buy = prices[0];

        for(int price : prices){
            if(price - buy > maxi){
                maxi = price - buy;
            }
            else if(price < buy){
                buy = price;
            }
        }

        return maxi;
    }
}
