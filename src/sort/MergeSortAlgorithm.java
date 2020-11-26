package sort;

public class MergeSortAlgorithm implements SortAlgorithm {

	<T> void merge(T[] array, int start, int mid, int end)
	{
		int size1 = mid - start + 1;
		int size2 = end - mid;
	}
	
	
	@Override
	public <T> void sort(T[] arrayToBeSorted, int start, int end) {
		if(start < end)
		{
			int mid = start + (end-start)/2;
			sort(arrayToBeSorted,start,mid);
			sort(arrayToBeSorted,mid+1,end);
			merge(arrayToBeSorted,start,mid,end);
		}
	}

}
