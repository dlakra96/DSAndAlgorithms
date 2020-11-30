package com.deepanshu.dsproject.search;

public interface SearchAlgorithm {
	<T extends Comparable<T>> int find(T array[],T key);
}
