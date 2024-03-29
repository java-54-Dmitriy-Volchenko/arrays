package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.Arrays;

class ArraysTests {
Integer[] numbers = {100, -3, 23, 4, 8, 41, 56, -7};
String[] strings = {"abc", "lmn", "123", null, "a"};
String[] stringsMin = {"abc", "lmn", "123",  "y"};
	@Test
	void indexOfTest() {
		assertEquals(1, Arrays.indexOf(strings, "lmn"));
		assertEquals(3, Arrays.indexOf(strings, null));
		assertEquals(-1, Arrays.indexOf(numbers, 150));
		assertEquals(4, Arrays.indexOf(numbers, 8));
	}
	@Test
	void minValueTest() {
		Comparator<String> compLength = (s1, s2) -> s1.length() - s2.length();
		assertEquals("y", Arrays.min(stringsMin,
				compLength));
		Comparator<String> compNative = (s1, s2) -> s1.compareTo(s2);
		assertEquals("123", Arrays.min(stringsMin, compNative));
	}
	@Test
	void bubbleSortTest() {
		Integer [] expected = {4, 8, 56, 100, 41, 23, -3, -7};
		Integer [] numbersCopy = java.util.Arrays.copyOf(numbers, numbers.length);
         /* lambda expression example */
	//	Comparator<Integer> evenOddComp = (num1, num2) ->
   //	evenOddComparator(num1, num2);
		/*************************************/
		/* method reference */
		Comparator<Integer> evenOddComp = ArraysTests::evenOddComparator;
		/*********************************************/
		Arrays.bubbleSort(numbersCopy, evenOddComp);
		assertArrayEquals(expected, numbersCopy);
		
	}
	static int evenOddComparator(Integer num1, Integer num2) {
		//first even numbers sorted in the ascending order
		//last odd numbers sorted in the descending order
		boolean isNum1Even = num1 % 2 == 0;
		boolean isNum2Even = num2 % 2 == 0;
		int res = 1;
		if (isNum1Even && isNum2Even) {
			res = Integer.compare(num1, num2);
		} else if (!isNum1Even && !isNum2Even) {
			res = Integer.compare(num2, num1);
		} else if (isNum1Even) {
			res = -1;
		}
		return res;
	}
	@Test
	void searchTest() {
		Integer[] expectedEven = {100, 4, 8,  56};
		assertArrayEquals(expectedEven, Arrays.search(numbers,
				a -> a % 2 == 0));
		Integer[] expectedNegative = {-3,-7};
		assertArrayEquals(expectedNegative, Arrays.search(numbers,
				a -> a < 0));
		
	}
	@Test
	void binarySearchTest() {
		Integer[] sortedInt = {-22, -14, 0, 4, 15, 88, 88, 339, 1000254};			
		assertEquals (3, Arrays.binarySearch(sortedInt,4,(a, b) -> a.compareTo(b)));
		assertEquals (-10, Arrays.binarySearch(sortedInt,1000255,(a, b) -> a.compareTo(b)));
		assertEquals (-1, Arrays.binarySearch(sortedInt,-33,(a, b) -> a.compareTo(b)));
		assertEquals (-3, Arrays.binarySearch(sortedInt,-5,(a, b) -> a.compareTo(b)));
		assertTrue(Arrays.binarySearch(sortedInt,88,(a, b) -> a.compareTo(b))>-1);
	}
	 @Test
	 void removeIfTest() {
		 Integer[] numbers = {100, -3, 23, 4, 8, 41, 56, -7};
		 Integer[] result1  = {100, 23, 4, 8, 41, 56};
		 assertArrayEquals (result1, Arrays.removeIf(numbers, a -> a>0));
		 Integer[] result2  = {-3, -7};
		 assertArrayEquals (result2, Arrays.removeIf(numbers, a -> a<0));	
		 Integer[] result3  = {};
		 assertArrayEquals (result3, Arrays.removeIf(numbers, a -> a==0));
	 }

}