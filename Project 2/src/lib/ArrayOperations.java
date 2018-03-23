package lib;

import java.util.Arrays;

public class ArrayOperations
{

	public static int getTotal (int [ ] array)
	{
		int total = 0;

		for (int i = 0; i < array.length; i++ )
		{
			total += array [i];
		}

		return total;
	}

	public static int getTotal (float [ ] array)
	{
		int total = 0;

		for (int i = 0; i < array.length; i++ )
		{
			total += array [i];
		}

		return total;
	}

	public static int getTotal (double [ ] array)
	{
		int total = 0;

		for (int i = 0; i < array.length; i++ )
		{
			total += array [i];
		}

		return total;
	}

	public static double getAverage (int [ ] array)
	{
		double average = 0;

		average = getTotal (array) / array.length;

		return average;
	}

	public static double getAverage (float [ ] array)
	{
		double average = 0;

		average = getTotal (array) / array.length;

		return average;
	}

	public static double getAverage (double [ ] array)
	{
		double average = 0;

		average = getTotal (array) / array.length;

		return average;
	}

	public static int getHighest (int [ ] array)
	{
		int highest = 0;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] > array [highest])
			{
				highest = i;
			}
		}

		return highest;
	}

	public static int getHighest (float [ ] array)
	{
		int highest = 0;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] > array [highest])
			{
				highest = i;
			}
		}

		return highest;
	}

	public static int getHighest (double [ ] array)
	{
		int highest = 0;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] > array [highest])
			{
				highest = i;
			}
		}

		return highest;
	}

	public static int getLowest (int [ ] array)
	{
		int lowest = 0;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] < array [lowest])
			{
				lowest = i;
			}
		}

		return lowest;
	}

	public static int getLowest (float [ ] array)
	{
		int lowest = 0;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] < array [lowest])
			{
				lowest = i;
			}
		}

		return lowest;
	}

	public static int getLowest (double [ ] array)
	{
		int lowest = 0;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] < array [lowest])
			{
				lowest = i;
			}
		}

		return lowest;
	}

	public static boolean compare (int [ ] array, int [ ] array2)
	{
		boolean tf;

		if (array.length == array2.length)
		{
			tf = true;
		}
		else
		{
			tf = false;
		}

		return tf;
	}

	public static boolean compare (float [ ] array, float [ ] array2)
	{
		boolean tf;

		if (array.length == array2.length)
		{
			tf = true;
		}
		else
		{
			tf = false;
		}

		return tf;
	}

	public static boolean compare (double [ ] array, double [ ] array2)
	{
		boolean tf;

		if (array.length == array2.length)
		{
			tf = true;
		}
		else
		{
			tf = false;
		}

		return tf;
	}

	public static int sequentialSearch (int [ ] array, int searchNum)
	{
		int returnNum = -1;

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i] == searchNum)
			{
				returnNum = array [i];
			}
		}
		return returnNum;
	}

	public static boolean sequentialSearch (String [ ] array, String searchString)
	{
		for (String element : array)
		{
			if (element.trim ( ).equals (searchString))
			{
				return true;
			}
		}
		return false;
	}

	public static boolean searchTerm (String [ ] array, String searchString)
	{

		for (int i = 0; i < array.length; i++ )
		{
			if (array [i].equals (searchString))
			{
				return true;
			}
		}
		return false;

	}

	public static int findMax (int [ ] array, int size)
	{
		int max = 0;
		for (int i = 1; i < size; i++ )
		{
			if (array [i] > array [max])
			{
				max = i;
			}
		}
		return max;
	}

	public static void selectionSort (int [ ] array, int size)
	{
		for (int i = size; i > 1; i-- )
		{
			int m = findMax (array, i);
			if (m != i - 1)
			{
				int temp = array [m];
				array [m] = array [i - 1];
				array [i - 1] = temp;
			}
		}
	}

	public static boolean binarySearch (String [ ] array, String stringPassed)
	{
		int first, last, middle, position;
		boolean found;

		first = 0;
		last = array.length - 1;
		position = -1;
		found = false;

		while ( !found && first <= last)
		{
			middle = (first + last) / 2;
			if (array [middle].equals (stringPassed))
			{
				found = true;
				position = middle;
			}
			else if (array [middle].compareTo (stringPassed) > 0)
			{
				last = middle - 1;
			}
			else
			{
				first = middle - 1;
			}
		}
		return found;
	}
}
