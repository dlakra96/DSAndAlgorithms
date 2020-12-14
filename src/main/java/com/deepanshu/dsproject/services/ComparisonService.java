package com.deepanshu.dsproject.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.deepanshu.dsproject.search.BinarySearch;
import com.deepanshu.dsproject.search.TernarySearch;
import com.deepanshu.dsproject.sort.HeapSortAlgorithm;
import com.deepanshu.dsproject.sort.MergeSortAlgorithm;

@Service
public class ComparisonService {

	public Map<String, Float> getSortingAlgorithmComparison(int n) {
		Map<String, Float> comparisonData = new HashMap<>();
		
		ExecutorService executorService  = Executors.newFixedThreadPool(2);
		Random random = new Random();
		int size = 1000;
		int maxElement = 10000;
		Integer[] integers = Stream.generate(() -> random.nextInt(maxElement)).limit(size).toArray(Integer[]::new);
	/* cloning above array so as to pass that copy to second sort algorithm otherwise we will be having synchronizing
      problem when a single array will be accessed by two different algorithms simultaneously  */
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
		
		Future<Float> heapFuture = executorService.submit(heapSortCallable);
		Future<Float> mergeFuture = executorService.submit(mergeSortCallable);
		
		while(!heapFuture.isDone() || !mergeFuture.isDone());
	
		try {
			
			comparisonData.put("HEAP", heapFuture.get());
			comparisonData.put("MERGE", heapFuture.get());
		
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comparisonData;
	}
	
	public Map<String, Float> getSearchingAlgorithmComparison(int n) {
		
		Map<String, Float> comparisonData = new HashMap<>();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Random r = new Random();
		int size = 1000;
		int maxElement = 100000;
		Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);
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
		
		Future<Float> ternaryFuture = executorService.submit(ternaryCallable);
		Future<Float> binaryFuture = executorService.submit(binaryCallable);
		
		while(!ternaryFuture.isDone() || !binaryFuture.isDone());
		
		try {
			
			comparisonData.put("BINARY", binaryFuture.get());
			comparisonData.put("TERNARY", ternaryFuture.get());
		
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comparisonData;
		
	}
}
