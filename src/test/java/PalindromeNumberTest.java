import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumberTest {

	@Test
	public void isPalindromeTest() {
		PalindromeNumber testTarget = new PalindromeNumber();
		assertEquals(true, testTarget.isPalindrome(0));
		assertEquals(true, testTarget.isPalindrome(1));
		assertEquals(true, testTarget.isPalindrome(121));
		assertEquals(false, testTarget.isPalindrome(12));
		assertEquals(true, testTarget.isPalindrome(1001));
	}
	
	@Test
	public void decimalLengthTest() 
	{
		assertEquals(1, PalindromeNumber.decimaLength(0));
		assertEquals(1, PalindromeNumber.decimaLength(1));
		assertEquals(2, PalindromeNumber.decimaLength(10));
		assertEquals(3, PalindromeNumber.decimaLength(100));
		assertEquals(3, PalindromeNumber.decimaLength(120));
		assertEquals(4, PalindromeNumber.decimaLength(1001));
	}

	@Test
	public void isOddTest() 
	{
		assertEquals(false, PalindromeNumber.isOdd(0));
		assertEquals(true, PalindromeNumber.isOdd(1));
		assertEquals(false, PalindromeNumber.isOdd(10));
		assertEquals(false, PalindromeNumber.isOdd(100));
	}
}
