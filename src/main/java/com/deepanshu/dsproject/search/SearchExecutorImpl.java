package com.deepanshu.dsproject.search;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class SearchExecutorImpl {

	public static void main(String args[])
	{
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Random r = new Random();
		int size = 1000;
		int maxElement = 100000;
		Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);
		
		/* selecting random element from array only to perform binary and ternary search on array,so it will  
		   ensure that we will successfully end up with element at the end of both binary and ternary search 
		 		*/
		Integer searchValue = integers[r.nextInt(size-1)];
		
		Callable<Float> ternaryCallable = () -> {
			long ternarySearchStartTime = System.nanoTime();
			(new TernarySearch()).find(integers, searchValue);
			long ternarySearchEndTime = System.nanoTime();
			return (float)(ternarySearchEndTime - ternarySearchStartTime)/1000000000;
		};
		
		Callable<Float> binaryCallable = () -> {
			long binarySearchStartTime = System.nanoTime();
			(new BinarySearch()).find(integers, searchValue);
			long binarySearchEndTime = System.nanoTime();
			return (float)(binarySearchEndTime - binarySearchStartTime)/1000000000;
		};
		
		System.out.println("Array Size :- " + size);
		System.out.println("Printing array with random elements :-");
		Arrays.asList(integers).forEach(s -> System.out.print(s + "->"));
		System.out.println("\nElement to search for :- " + searchValue);
		
		System.out.println(" :: Starting with execution of ternary search and binary search on array of random integers of size 1000 in concurrent fashion:: ");
		
		Future<Float> ternaryFuture = executorService.submit(ternaryCallable);
		Future<Float> binaryFuture = executorService.submit(binaryCallable);
		
		while(!ternaryFuture.isDone() || !binaryFuture.isDone());
		
		System.out.println("Done with the execution of both ternary and binary search. Following are the runitme of both algorithms :- ");
		
		try {
			
			System.out.println("Ternary Search took(secs) :- " + ternaryFuture.get());
			System.out.println("Binary Search took(secs) :- " + binaryFuture.get());
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("The program code has been written by Deepanshu Lakra. Have a nice day !!!");
		
		
	}
	
}
