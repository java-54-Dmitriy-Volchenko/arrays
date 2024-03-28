package telran.util;

import java.util.Comparator;

public class Arrays {
	public static <T> int indexOf(T[] array, T element) {
		int index = 0;
		while(index<array.length && !equals(array[index], element) ) {
			index++;
		}
		return index == array.length? -1:index;
	}

	private static <T> boolean equals(T elem1, T elem2) {
		
		return elem1==null?elem1==elem2 : elem1.equals(elem2);
	}
	
	public static <T> T min(T[] array, Comparator <T> comp) {
		T res = null;
		
		if (array !=null &&array.length>0) {
			res = array[0];
			for (int i = 1; i<array.length; i++) {
				if (comp.compare(res, array[i])>0) {
					res = array[i];
				}
			}
		}
		
		return res;
		
	}
	
	
	public static <T> void bubbleSort(T[] array, Comparator <T> comp ) {
		 boolean flag = true;
		 int len = array.length-1;
	        while (flag) {	        	
	            flag = false;
	            for (int j = 0; j < len; j++) {
	                if (comp.compare(array[j], array[j + 1]) > 0) {
	                    swap (array, j, j+1);
	                    flag = true;
	                   
	                }         
	              }
	            len--;
	        }
	    }
	private static <T> void swap (T[] array, int i, int j ) {
		T depo = array[i];
        array[i] = array[j];
        array[j] = depo;
	}
	
	
	public static <T> int binarySearch(T[] array,T key,  Comparator <T> comp ) {
		
		return -1;
	}
	
	}


