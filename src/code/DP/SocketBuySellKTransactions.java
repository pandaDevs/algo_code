package code.DP;

public class SocketBuySellKTransactions {

    /**
     * Formula is
     * T[i][j] = max(T[i][j - 1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i - 1][j] - prices[j])
     *
     * This method is faster. Time complexity here is O(k * number of days)
     * @param prices stock price every day
     * @param k number of transactions
     * @return max profit
     */
    public int maxProfit(int[] prices, int k) {
        // i：number of transactions, k
        // j: number of days
        int T[][] = new int[k + 1][prices.length];
        for(int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for(int j = 1; j < T[0].length; ++j) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
            }
        }
        return T[k][prices.length - 1];
    }

    /**
     * Slow method
     * O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j - 1], max(prices[j] - prices[m] + T[i - 1][m])), where m is 0...j-1
     * @param prices
     * @param k
     * @return
     */
    public int maxProfitSlowSolution(int prices[], int k) {
        int T[][] = new int[k + 1][prices.length];
        for(int i = 1; i < T.length; ++i) {
            for(int j = 1; j < T[0].length; ++j) {
                int maxVal = 0;
                for(int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i - 1][m]);
                }

                T[i][j] = Math.max(T[i][j - 1], maxVal);
            }
        }

        return T[k][prices.length - 1];
    }

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }
}
