package com.cp3;

public class Permutation {

	static int solution(int a[], int n) {

		int maxNum = Integer.MIN_VALUE;
		int prev = Integer.MIN_VALUE;
		
		// O(N)
		for (int i = 0; i < n; i++) {
			if (a[i] > maxNum) {
				maxNum = a[i];
			}
			if (a[i] == prev) {
				return 0;
			}
			else {
				prev = a[i];
			}
		}
		
		if (n != maxNum) {
			return 0;
		}
		
		return 1;
	}
	
	public static void main(String[] args) {
		int[] a = {4, 1, 3 ,2};
		
		System.out.println(solution(a, 4));
	}
}
