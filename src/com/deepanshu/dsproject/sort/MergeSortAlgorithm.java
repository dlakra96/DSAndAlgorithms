package com.deepanshu.dsproject.sort;

public class MergeSortAlgorithm implements SortAlgorithm {

	void merge(int[] array, int start, int mid, int end)
	{
		int size1 = mid - start + 1;
		int size2 = end - mid;
 		int arr1[] = new int[size1];
 		int arr2[] = new int[size2];
 		for(int i = 0; i<size1; i++)
 			arr1[i] = array[i+start];
 		for(int j = 0; j<size2; j++)
 			arr2[j] = array[j+mid+1];
 		int i=0,j=0,k=start;
 		while(i<size1 && j<size2)
 		{
 			if(arr1[i] <= arr2[j])
 			{
 				array[k] = arr1[i];
 				i++;
 			}
 			else
 			{
 				array[k] = arr2[j];
 				j++;
 			}
 			k++;
 		}
 		
 		while(i<size1)
 		{
 			array[k] = arr1[i];
 			i++;
 			k++;
 		}
 		
 		while(j<size2)
 		{
 			array[k] = arr2[j];
 			j++;
 			k++;
 		}
	}
	
	
	@Override
	public void sort(int[] arrayToBeSorted, int start, int end) {
		if(start < end)
		{
			int mid = start + (end-start)/2;
			sort(arrayToBeSorted,start,mid);
			sort(arrayToBeSorted,mid+1,end);
			merge(arrayToBeSorted,start,mid,end);
		}
	}

}
