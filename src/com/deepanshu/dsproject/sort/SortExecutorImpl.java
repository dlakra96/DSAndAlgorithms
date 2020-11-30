package com.deepanshu.dsproject.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class SortExecutorImpl {

	public static void main(String[] args) {
		
		ExecutorService executorService  = Executors.newFixedThreadPool(2);
		Random random = new Random();
		int size = 1000;
		int maxElement = 10000;
		Integer[] integers = Stream.generate(() -> random.nextInt(maxElement)).limit(size).toArray(Integer[]::new);
		Integer[] integers2 = integers.clone();
		Callable<Float> heapSortCallable = () -> {
			long heapSortStartTime = System.nanoTime();
			(new HeapSortAlgorithm()).sort(integers,0 ,size-1);
			long heapSortEndTime = System.nanoTime();
			return (float)(heapSortEndTime - heapSortStartTime)/1000000000;
		};
		Callable<Float> mergeSortCallable = () -> {
			long mergeSortStartTime = System.nanoTime();
			(new MergeSortAlgorithm()).sort(integers2, 0, size-1);
			long mergeSortEndTime = System.nanoTime();
			return (float)(mergeSortEndTime - mergeSortStartTime)/1000000000;
		};
		
		System.out.println("Size of random array that will be created to perform sorting comparison task :- " + size);
		System.out.println("\nThe random array elements are as follows :-\n");
		Arrays.asList(integers).forEach(d -> {System.out.print(d + "->");});
		System.out.println("\n\n\nNow starting HeapSort and MergeSort processing in parallel fashion on this random array for runtime comparison to be done later on.............");
		
		Future<Float> heapFuture = executorService.submit(heapSortCallable);
		Future<Float> mergeFuture = executorService.submit(mergeSortCallable);
		
		while(!heapFuture.isDone() || !mergeFuture.isDone())
		{
			System.out.println(".");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	/*	
	 * System.out.println();
		Arrays.asList(integers).forEach(d -> {System.out.print(d + "->");});
		System.out.println();
		Arrays.asList(integers2).forEach(d -> {System.out.print(d + "->");});
	*/
		
		System.out.println("\nWe are done with parallel sorting by the two algorithms on the same random array.");
		try {
			System.out.println("\nHeap Sort took(secs) :- " + heapFuture.get());
			System.out.println("Merge Sort took(secs) :- " + mergeFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nThis program code is written by Deepanshu Lakra. Have a nice day !!!");
		

	}

}
