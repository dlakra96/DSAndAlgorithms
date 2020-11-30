package search;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class SearchExecutorImpl {

	public static void main(String args[])
	{
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Random r = new Random();
		int size = 1000;
		int maxElement = 100000;
		Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);
		Integer searchValue = integers[r.nextInt(size-1)];
		Callable<Integer> ternaryCallable = () -> {
			return TernarySearch.ternarySearch(integers, searchValue, 0, size-1);
		};
		Callable<Integer> binaryCallable = () -> {
			return BinarySearch.binarySearch(integers, searchValue, 0, size-1);
		};
		
		System.out.println("Array Size :- " + size);
		System.out.println("Printing array with random elements :-");
		Arrays.asList(integers).forEach(s -> System.out.print(s + "->"));
		System.out.println("\nElement to search for :- " + searchValue);
		
		System.out.println(" :: Starting with execution of ternary search on array of random integers of size 1000 :: ");
		
		long ternaryStartTime = System.nanoTime();
		Future<Integer> ternaryFuture = executorService.submit(ternaryCallable);
		while(!ternaryFuture.isDone());
		long ternaryEndTime = System.nanoTime();
		
		System.out.println("Took(secs) :- " + (float)(ternaryEndTime - ternaryStartTime)/1000000000);
		
		System.out.println(" :: Starting with execution of binary search on array of random integers of size 1000 :: ");
		
		long binaryStartTime = System.nanoTime();
		Future<Integer> binaryFuture = executorService.submit(binaryCallable);
		while(!binaryFuture.isDone());
		long binaryEndTime = System.nanoTime();
		
		System.out.println("Took(secs) :- " + (float)(binaryEndTime - binaryStartTime)/1000000000);
		
		System.out.println("The program code has been written by Deepanshu Lakra. Have a nice day !!!");
		
		
	}
	
}
