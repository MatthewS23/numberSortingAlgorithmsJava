package utils;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

//public static void main(String[]args)

public class IntegerUtils_Sloan {

	public static void main(String[]args)
	{
		//		System.out.println(getGreatestConstrainedMultiple(7,50));
		//		System.out.println(getGreatestConstrainedMultiple(7,1));

		
		//Making a test set for GetMaximum of a set
		int count[] = {34, 22,10,60,30,22};
//		Set<Integer> set = new HashSet<Integer>();
//
//		for(int i = 0; i < 5; i++) 
//		{
//			set.add(count[i]);
//		}
//		System.out.println(getMaximum(set));

		
		//Making a test for getMinimum of an array of integers
		
//		int[] intArrayTest = {2, 4, -6, 8, 10};
//		System.out.println(getMinimum(intArrayTest));
		
		//Creating array^^
		
		//Test case below for reverse:
//		System.out.println(reverse(21));
		
		//Test case below for "sumthing"
		System.out.println(sumthing(71));
		//Test case below for "getIntegerH"
//		System.out.println(getIntegerH(7,3));
//		System.out.println(getGreatestConstrainedMultiple(700, -3));
		
		int[] intArrayTest3 = {2, 4, 2, 8, 10};
		System.out.println(getSmallestIndexOfMatch(intArrayTest3, 2));
		
	}
	
	//middle of road: IntegerUtils_Sloan.isEven(2) == true: "error: isEven did not work"; 
	//degenerate:IntegerUtils_Sloan.isEven(0) == true: "error: isEven did not work at zero";  
	//cornercase:IntegerUtils_Sloan.isEven(-2) == true: "error: isEven did not work at negative two";
	//If the number is divided by 2 and has no remainder then it is even.  
	
	public static boolean isEven(int k)
	{
		boolean oddEvenDecider = false;
		if(k % 2 == 0)
		{
			oddEvenDecider = true;
		}
		return oddEvenDecider;
	}

	//middle of roadIntegerUtils_Sloan.isOdd(2) == false: "error: isODD did not work on two"; 
	//middle of roadIntegerUtils_Sloan.isOdd(3) == true: "error: isODD did not work on three"; 
	//cornercase IntegerUtils_Sloan.isOdd(-3) == true: "error: isODD did not work on negative three"; 
	//degenerateIntegerUtils_Sloan.isOdd(0) == false: "error: isODD did not work on two"; 
	//If the number is divided by 2 and has a remainder then it is odd. 
	public static boolean isOdd(int k)
	{
		boolean oddEvenDecider = false;
		if(k % 2 == 1)
		{
			oddEvenDecider = true;
		}
		return oddEvenDecider;
	}

	//middle of road IntegerUtils_Sloan.isPrime(3) == true:"error: cornercase: isPrime did not work on 3"; 
	//cornercase IntegerUtils_Sloan.isPrime(2) == true: "error: cornercase: isPrime did not work on 2"; 
	//degenerate IntegerUtils_Sloan.isPrime(1) == false:"error: degenerate: isPrime did not work on 0"; 
	//degenerate IntegerUtils_Sloan.isPrime(0) == false:"error: degenerate: isPrime did not work on 0"; 
	//degenerate IntegerUtils_Sloan.isPrime(-1) == false:"error: degenerate: isPrime did not work on 0"; 
	//There are no prime numbers from 1 or below. Iterate all numbers leading up to k. If one of the numbers divides into k without a remainder then it has a factor and is not prime. 
	//--otherwise it is prime. 
	public static boolean isPrime(int k)
	{
		boolean primeDecider = true;
		//Degenerate and cornercases would consist of a value of k of 1 or less
		if(k<=1)
		{
			primeDecider = false;
		}

		for(int i = 2; i < k; i++)
		{
			if(k % i == 0)
			{
				primeDecider = false;
			}
		}
		return primeDecider;
	}

	//middle of roadInteger: Utils_Sloan.greatestCommonFactor(12, 16) == 4:"error: middle of road: GCF did not work on 12 & 16"; 
	//cornercase: IntegerUtils_Sloan.greatestCommonFactor(1, 1) == 1:"error: cornercase: GCF did not work on 1 & 1"; 
	//degenerate: IntegerUtils_Sloan.greatestCommonFactor(-1, 1) == -1:"error:degenerate:GCF did not work on -1 & 1";
	//degenerate: IntegerUtils_Sloan.greatestCommonFactor(-10, 5) == 5; 
	//If (1, -1) is passed in we recieve -1. And vice versa. 
	//Iterate up to smallest m or n value, and if that iteration divides into m and n without a remainder then we return that value. 
	public static int greatestCommonFactor(int m, int n)
	{
		if(m==1 & n==-1)
		{
			return -1;
		}
		if(m==-1 & n==1)
		{
			return -1;
		}
		int theAnswer = 1;

		for(int i =2; i < m && i < n; i++)
		{
			if(n%i==0 && m % i == 0)
			{
				theAnswer = i;
			}
		}

		return theAnswer;
	}

	//middle of road: IntegerUtils_Sloan.getGreatestConstrainedMultiple(7, 50) == 49;
	//cornercase: IntegerUtils_Sloan.getGreatestConstrainedMultiple(1, 1) == 1;
	//degenerate: IntegerUtils_Sloan.getGreatestConstrainedMultiple(-5, 25) == 25;
	//Iterate down from the maximum value received and the first number to divide into K with no remainder is returned.  
	
	public static int getGreatestConstrainedMultiple(int k, int maximum)
	{
		int largestMultipleK = maximum;
		if (maximum < k)
		{
			return 0;
		}

		for(int i = maximum; i > k-1; i--)
		{
			if(i% k == 0)
			{
				largestMultipleK = i;
				break;
			}
		}
		return largestMultipleK;

	}
	
	//	Creating Set: HashSet<Integer> setToTest = new HashSet<Integer>() {{
	//	Populating Set:	add(-10);
	//	Populating Set:	add(-5);
	//	}};
	//	cornercase: assert IntegerUtils_Sloan.getMaximum(setToTest) == -5: "error: isODD did not work on negative five";
	//Iterate through set while there is still values and on each iteration compare store the largest value. Return largest value once set no longer has values. 
	
	public static int getMaximum(Set<Integer> integerSet)
	{
		Iterator<Integer> iterateSet = integerSet.iterator();
		int max = iterateSet.next();
		while(iterateSet.hasNext())
		{
			int nextValueHolder = iterateSet.next();
			if(max < nextValueHolder)
			{
				max = nextValueHolder;
			}
			
		}
		return max;
//		
//		int biggestValue = Collections.max(integerSet);
//		return biggestValue;
		
	}

	//Creating Arrays:	int[] intArrayTest1 = {2, 4, -6, 8, 10};
	//Creating Arrays:	int[] intArrayTest2 = {2, 4, -6, 8, -10};
	//CornerCase:	 IntegerUtils_Sloan.getMinimum(intArrayTest1) == -6;
	//Degenerate:	 IntegerUtils_Sloan.getMinimum(intArrayTest2) == -10;
	////Iterate through array  and on each iteration compare store the smaller value. Return smallest value once array no longer has values.
	public static int getMinimum(int[] intArray)
	{
		int minValue = intArray[0];
		for(int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] < minValue)
			{
				minValue = intArray[i];
			}
		}
		return minValue;
		
	}
		
	//	int[] intArrayTest1 = {2, 4, 3, 8, 10};
	//	int[] intArrayTest2 = {2, 4, 6, 8, 10};//
	// 	int[] intArrayTest3 = {2, 4, -6, 8, 10};//
	//middle road:	IntegerUtils_Sloan.isSorted(intArrayTest1) == false;
	//middle road:	 IntegerUtils_Sloan.isSorted(intArrayTest2) == true;
	//cornercase:	 IntegerUtils_Sloan.isSorted(intArrayTest3) == false;
	//List is assumed to be sorted. Iterate through the list, and if the last iteration's value is bigger than the current iteration then list is considered unsorted. 
	public static boolean isSorted(int[] intArray)
	{
//		boolean foundOutOfOrderPair = true;
//		int i = 0;
//		while(i < intArray.length)
//		{
//			foundOutOfOrderPair = intArray[i-1] > intArray[i];
//			i++;
//		}
//		
//		boolean sortedDecider = (!foundOutOfOrderPair);
//		return sortedDecider;
	boolean sortedDecider = true;
		for(int i=1; i<intArray.length;i++) 
        {
            if(intArray[i-1] > intArray[i])
            {
            	sortedDecider = false;
            }
        }
        return sortedDecider;
		
	}
	
	
	//Creating Arrays:int[] intArrayTest1 = {2, 4, 3, 8, 10};
	//Creating Arrays:int[] intArrayTest2 = {-2, 4, -2, 8, 10};
	//Creating Arrays:int[] intArrayTest3 = {2, 4, 2, 8, 10};
	
	//middle road: IntegerUtils_Sloan.getSmallestIndexOfMatch(intArrayTest1, 3) == 2;
	//cornercase: IntegerUtils_Sloan.getSmallestIndexOfMatch(intArrayTest3, 2) == 0;
	//cornercase: IntegerUtils_Sloan.getSmallestIndexOfMatch(intArrayTest2, -2) == 0;
	//Iterate from the beginning of the array until the target value matches the value of the particular iteration. Return the iteration number. 
	
	public static int getSmallestIndexOfMatch(int[] intArray, int target)
	{
		int retValue = 0;
		for(int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] == target)
			{
			 retValue = i;
			 break;
			}
		}
		return retValue;
	}

	
	//middle road: IntegerUtils_Sloan.reverse(89)==98;
	//middle road: IntegerUtils_Sloan.reverse(91)==19;
	//cornercase:IntegerUtils_Sloan.reverse(10)==01;
	//Degenerate:IntegerUtils_Sloan.reverse(0)==0;
	//Convert K to a string to be able to iterate through it. Iterate through string. Push the numeric value of the string's characters to populate a linked list. --
	//--iterate through linked list. Pop the topvalue of the list. Add that value to a string on each iteration. Fffectively reversing the numbers. Return String with reversed number. 
	
	public static int reverse(int k)
	{
		LinkedList <Character> reverseList = new LinkedList<Character>();
		String reversedNum = "";
		
		String kToString = String.valueOf(k);
		//Converting to String to be able to iterate^^
		for(int i = 0; i < kToString.length(); i++)
		{
			char figure = kToString.charAt(i);
			reverseList.push((char) Character.getNumericValue(figure));
		}
		while(!reverseList.isEmpty())
		{
			int topValue = reverseList.pop();
			reversedNum += topValue;
		}
		return Integer.valueOf(reversedNum);
	}
	
	//Middle of road:  IntegerUtils_Sloan.sumthing(14) == 5:"error: sumthing did not work";
	//Doesnt work.
	
	public static int sumthing(long k)
	{
//		int charsAddedTogether = "";
		//		char [] arrayDigits = kConvertToString.toCharArray();									//		int [] arrayOfIntegers = new int[kConvertToString.length()];
int currentSum = 0;

String kConvertToString = String.valueOf(k);
//while(kConvertToString.length() >= 2)
//{
for(int i = 0;i < kConvertToString.length(); i++)
{
		//			arrayOfIntegers[i] = Character.getNumericValue(arrayDigits[i]); 
char numToAdd = kConvertToString.charAt(i);
currentSum += numToAdd;
String charToString = Character.toString(kConvertToString.charAt(i));
		//			currentSum = Integer.parseInt(charToString);
}

		//		kConvertToString = String.valueOf(currentSum);
//}
return currentSum;

	}
	
	
	//cornercase: IntegerUtils_Sloan.getIntegerH(7, 3) == 23;
	//middle of road:  IntegerUtils_Sloan.getIntegerH(15, 0) == 45;
	//Mathematically not possible for the remainder of h_r_5 divided by 5 to be greater than 5.
	//Mathematically not possible for  one  of h_q_3 & h_r_5 to be positive and the other to be negative. 
	//Reverse the division of 3 on  h_q_3 by multiplying it by 3, (answer). Create loops for possibilities of both values being negative or positive. 
	//Both positive case:If our value "answer" is divided by five and does not have a remainder equal to h_r_5 we are going to increase the value of answer until this condition is satisfied.  
	//Both negative case:If our value "answer" is divided by five and does not have a remainder equal to h_r_5 we are going to decrease the value of answer until this condition is satisfied.
	//Positive and negative cases: In order to meet the rules of integer division. 
	public static int getIntegerH(int h_q_3, int h_r_5)
	{
		int answer = 0;
		
		if(Math.abs(h_r_5) >= 5)
		{
			return 0;
		}
		if( h_q_3 > 0 && h_r_5 < 0)
		{
			return 0;
		}
		if (h_q_3 < 0 && h_r_5 > 0)
		{
			return 0;
		}
		
		answer = h_q_3 * 3;
		if(h_q_3 < 0 && h_r_5 < 0)
		{
			while(answer % 5 != h_r_5)
			{
				answer --;
			}
		}
		if(h_q_3 > 0 && h_r_5 > 0)
		{
			
			while(answer % 5 != h_r_5)
			{
				answer ++;
			}
			
		}
		return answer;
	}
	//It's a beauty^^
}










