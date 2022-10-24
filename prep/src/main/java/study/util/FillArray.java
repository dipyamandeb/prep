package study.util;

public class FillArray {

	// initialize the array
	public static int[][] initialize(int n, int w, int value) {
		int t[][] = new int[n][w];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < w; j++) {
				t[i][j] = value;
			}
		}
		return t;
	}
}
