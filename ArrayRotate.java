//Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

// Link to this question - https://www.geeksforgeeks.org/array-rotation/

package main.java.Arrays;

import java.util.Scanner;

public class ArrayRotate {
	public static void main(String[] args) {

		// Asking user for size of array
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of array whose values will be defaulted with its size range :: ");

		int n = sc.nextInt();

		int[] ar = new int[n];

		for (int i=0;i<ar.length;i++) {
			ar[i] = i;
		}

		for (int i=0;i<ar.length;i++) {
			System.out.print(ar[i] + " ");
		}

		System.out.println("Enter the number by which the array to be rotated :: ");

		int d = sc.nextInt();
		
		sc.close();

		if(d>=ar.length) {
			throw new RuntimeException("The number by which the array to be rotated exceeds/equals array size");
		}

		// Method 1
		// ---------------
		// Rotating Array using temp array

		int[] rotatedArray = rotateArrayUsingTempArray(ar, d, n);
		System.out.println("rotatedArray using Temp Array");
		for (int i=0;i<n;i++) {
			System.out.print(rotatedArray[i] + " ");
		}
		System.out.println("");

		// Method 2
		// ---------------
		// Rotating Array elements to left one by one

		int[] rotatedArraybyLeft = rotateArrayleft(ar, d, n);
		System.out.println("rotatedArray to left one by one");
		for (int i=0;i<n;i++) {
			System.out.print(rotatedArraybyLeft[i] + " ");
		}
		
	}

	public static int[] rotateArrayleft(int[] ar, int d, int n) {
		for(int i=0; i<d;i++) {
			rotateArrayLeftbyOne(ar, n);
		}
		return ar;
	}

	private static void rotateArrayLeftbyOne(int[] ar, int n) {
		int a = ar[0];
		int i=0;
		for(; i<n-1;i++) {
			ar[i]=ar[i+1];
		}
		ar[i]=a;
	}

	private static int[] rotateArrayUsingTempArray(int[] ar, int d, int n) {
		int[] temp = new int[n];
		int j=0;
		for(int i=d;i<n;i++,j++) {
			temp[j]=ar[i];
		}
		for(int i=0;i<d;i++,j++) {
			temp[j]=ar[i];
		}
		return temp;
	}
}
