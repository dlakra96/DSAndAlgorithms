package com.deepanshu.dsproject.search;

public class BinarySearch implements SearchAlgorithm {

	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
		
		return binarySearch(array,key,0,array.length-1);
	
	}

   <T extends Comparable<T>> int binarySearch(T[] arr,T key,int start,int end)
	{
		if(start > end)
		{
			return -1;
		}
		
		int mid = start + (end - start)/2;
		
		if(key.compareTo(arr[mid]) == 0)
			return mid;
		else if(key.compareTo(arr[mid]) < 0)
			return binarySearch(arr,key,start,--mid);
		else 
			return binarySearch(arr,key,++mid,end);
		
	}
}
