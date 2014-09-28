import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class CCheckUnitTest {
	
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

	@Test
	public void testIsValid() {
		assertEquals("4388576018410707 is true", true, isValid((long)4388576018410707));
	}

}
