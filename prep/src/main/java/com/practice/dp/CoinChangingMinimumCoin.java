package com.practice.dp;

import java.util.Arrays;



public class CoinChangingMinimumCoin {
	 public static void main ( String args[] ) {
	        int total = 11;
	        int coins[] = {1, 5, 6, 8};
	        CoinChangingMinimumCoin cc = new CoinChangingMinimumCoin();
//	        Map<Integer, Integer> map = new HashMap<>();
//	        int topDownValue = cc.minimumCoinTopDown(total, coins, map);
	        int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

	        System.out.print(String.format("Bottom up and top down result %s", bottomUpValue));

	    }

	 public int minimumCoinBottomUp(int total, int coins[]){
	        int T[] = new int[total + 1];
	        int R[] = new int[total + 1];
	        T[0] = 0;
	        for(int i=1; i <= total; i++){
	            T[i] = Integer.MAX_VALUE-1;
	            R[i] = -1;
	        }
	        for(int j=0; j < coins.length; j++){
	            for(int i=1; i <= total; i++){ 
	                if(i >= coins[j]){
	                    if (T[i - coins[j]] + 1 < T[i]) {
	                        T[i] = 1 + T[i - coins[j]];
	                        R[i] = j;
	                    }
	                }
	            }
	        }
	        System.out.println(Arrays.toString(T));
	        System.out.println(Arrays.toString(R));
	        //printCoinCombination(R, coins);
	        return T[total];
	    }
}
