#include "com_example_fibonaccinative_FibLib.h"

static long fib(long n){
	return n <= 0 ? 0 : n == 1? 1 : fib(n - 1) + fib(n - 2);
}


JNIEXPORT jlong JNICALL Java_com_example_fibonaccinative_FibLib_fibNR
  (JNIEnv *env, jclass clazz, jlong n){
	return fib(n);
}
