import java.util.Scanner;
import java.util.*;
import java.io.*;

public class CheckDigit {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long test = 0;
		
		System.out.print("Enter a credit card number as a long integer: ");
		
		test = in.nextLong();
		in.close();
		
		if (isValid(test))
			System.out.println(test + " is valid");
		else
			System.out.println(test + " is not valid");
	}
	
	public static boolean isValid(long card)
	{
		long cardN = card;
		ArrayList<Long> numbers = new ArrayList<>();
		
		while (cardN > 0) {
		    numbers.add(cardN % 10);
		    cardN = cardN / 10;
		}
		
		int i = 0;
		long element = 0, subElement1, subElement2;
		long sum = 0;
		while (i <= numbers.size() - 1)
		{
			element = numbers.get(i);
			if (i != 0 && (i + 1) % 2 == 0) //Even numbers from right (only odd in calc due to first val in list at ref 0)
			{
				if (element * 2 >= 10)
				{
					subElement1 = (element * 2) % 10;
					subElement2 = (element * 2) / 10;
					sum += subElement1 + subElement2;
				} else
				{
					sum += element * 2;
				}
					
			} else
			{
				sum += element;
			}
			i++;
		}
		
		if (sum % 10 == 0)
			return true;
		else
			return false;
	}
	
	
}
