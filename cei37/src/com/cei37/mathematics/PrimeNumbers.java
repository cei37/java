package com.cei37.mathematics;

public class PrimeNumbers {

	/**
	 * given a number print out all the prime numbers less than the given number
	 * 
	 * for the solution I will use the Sieve of Eratosthenes  = criba de Eratostenes
	 */
	public static void main(String[] args) {
		PrimeNumbers pri = new PrimeNumbers();
		pri.getPrimeNumbers(30);
	}
	
	public void getPrimeNumbers(int number) {
		if (number <= 2) {
			System.out.println("2");
		} else {
			int list[] = new int[number + 1];
			list[0] = -1;
			list[1] = -1;
			for (int i=2; i<=number; i++) {
				int j=i;
				while(j<=number) {
					j += i;
					if ((j)<list.length && list[j]!=-1) {
						list[j] = -1;
					}
				}
			}
			for (int i=2; i<list.length; i++) {
				if (list[i]!=-1) {
					System.out.println(i);
				}
			}
		}
	}
}