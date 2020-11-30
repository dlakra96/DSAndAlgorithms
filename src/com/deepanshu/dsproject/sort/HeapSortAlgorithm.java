package com.deepanshu.dsproject.sort;

public class HeapSortAlgorithm implements SortAlgorithm {

	void heapify(Integer[] arrayToBeSorted,int n,int i)
	{
		int max = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		if(left < n && arrayToBeSorted[left] > arrayToBeSorted[max])
			max = left;
		if(right < n && arrayToBeSorted[right] > arrayToBeSorted[max])
			max = right;
		if(max != i)
		{
			swap(arrayToBeSorted,max,i);
			heapify(arrayToBeSorted,n,max);
		}
	}
	
	void buildMaxHeap(Integer[] arrayToBeSorted)
	{
		int len = arrayToBeSorted.length;
		for(int i = len/2 - 1; i>=0; i--)
			heapify(arrayToBeSorted,len,i);
	}
	
	void swap(Integer arr[], int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	@Override
	public void sort(Integer[] arrayToBeSorted, int start, int end) {
		
		buildMaxHeap(arrayToBeSorted);
		
		for(int i = end; i>0; i--)
		{
			swap(arrayToBeSorted,i,0);
			heapify(arrayToBeSorted,i,0);
		}
	
	}

}
