class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // for(int[] a: dp){
        //     Arrays.fill(a, -1);
        // }
        // int profit = solve(prices, 1, 0, dp);
        // return profit;

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
                int profit = 0;
                if(buy == 1){//buy
                    profit = Math.max(-prices[idx] + dp[idx+1][0], 
                                0 + dp[idx+1][1]);
                }
                else{//sell
                    profit = Math.max(prices[idx] + dp[idx+1][1],
                                0 + dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int solve(int[] prices, int buy, int idx, int[][] dp){
        if(idx == prices.length){
            return 0;
        }

        if(dp[idx][buy] != -1)return dp[idx][buy];
        int profit = 0;

        if(buy == 1){//buy
            profit = Math.max(-prices[idx] + solve(prices, 0, idx+1, dp), 
                        0 + solve(prices, 1, idx+1, dp));
        }
        else{//sell
            profit = Math.max(prices[idx] + solve(prices, 1, idx+1, dp),
                        0 + solve(prices, 0, idx+1, dp));
        }

        return dp[idx][buy] = profit;
    }
}
