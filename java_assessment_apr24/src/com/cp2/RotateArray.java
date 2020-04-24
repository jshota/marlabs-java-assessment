package com.cp2;

public class RotateArray {

	void rightRotate(int a[], int n, int k) {
		for (int i = 0; i < k; i++) {
			rightRotatebyOne(a, n);
		}
	}
	
	void rightRotatebyOne(int a[], int n) {
		int i, tmp;
		tmp = a[n-1];
		for (i = n-1; i > 0; i--) {
			a[i] = a[i-1];
		}
		a[i] = tmp;
	}
	
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		
		int a[] = {3, 8, 9, 7, 6};
		ra.rightRotate(a, 5, 3);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}