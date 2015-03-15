package com.lc.highfrequency;

public class BestTimeToBuySellStockII {

	public int maxProfitII(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
		    int diff = prices[i+1] - prices[i];
		    if (diff > 0) {
		        profit += diff;
		    }
		}
		return profit;
	}
}
