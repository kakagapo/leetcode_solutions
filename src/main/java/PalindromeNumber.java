public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0)
        {
            return false;
        }
        else if(x < 9)
        {
            return true;
        }
        else
        {
            int reversedNum = 0;
            int length = decimaLength(x);
            for(int i=0; i < length/2; i++)
            {
                reversedNum = reversedNum * 10 + x % 10;
                x = x / 10;
            }
            
            if(isOdd(length))
            {
                // one extra divide by 10 to get rid of the middle number
                x = x / 10;
            }
            
            return x == reversedNum;
            
        }
    }
	
	public static int decimaLength(int num) 
	{
		// this method will return length as 1 when 0 is the input
		int length = 1;
		while(num >= 10)
		{
			length++;
			num /= 10;
		}
		return length;
	}
	
	public static boolean isOdd(int num)
	{
		return num % 2 != 0;
	}
}
