package com.example.fibonaccinative;

public class FibLib {

	public static long fibJR(long n){
		return n <= 0 ? 0 : n == 1? 1 : fibJR(n - 1) + fibJR(n - 2);
	}

	public native static long fibNR(long n);

	
	static{
		System.loadLibrary("com_example_fibonaccinative_FibLib");
	}
	
}

