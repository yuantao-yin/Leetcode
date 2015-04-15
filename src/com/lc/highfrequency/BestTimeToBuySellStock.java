package com.lc.highfrequency;

public class BestTimeToBuySellStock {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int min = Integer.MAX_VALUE;
		for (int i : prices) {
			min = i < min ? i : min;
			profit = (i - min) > profit ? i - min : profit;
		}
		return profit;
	}
}
