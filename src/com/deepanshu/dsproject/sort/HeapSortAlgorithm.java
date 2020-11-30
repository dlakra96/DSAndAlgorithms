package com.deepanshu.dsproject.sort;

public class HeapSortAlgorithm implements SortAlgorithm {

	void heapify(int[] arrayToBeSorted,int n,int i)
	{
		int min = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		if(left <= n && arrayToBeSorted[left] < arrayToBeSorted[min])
			min = left;
		if(right <= n && arrayToBeSorted[right] < arrayToBeSorted[min])
			min = right;
		if(min != i)
		{
			int temp = arrayToBeSorted[min];
			arrayToBeSorted[min] = arrayToBeSorted[i];
			arrayToBeSorted[i] = temp;
			heapify(arrayToBeSorted,n,min);
		}
	}
	
	void buildMinHeap(int[] arrayToBeSorted)
	{
		int len = arrayToBeSorted.length;
		for(int i = len/2 - 1; i>=0; i--)
			heapify(arrayToBeSorted,len-1,i);
	}
	
	void swap(int arr[], int i, int j)
	{
		
	}
	
	@Override
	public void sort(int[] arrayToBeSorted, int start, int end) {
		
		buildMinHeap(arrayToBeSorted);
		
		for(int i = arrayToBeSorted.length - 1; i>0; i--)
		{
		//	int t
		}
	
	}

}
