
public class GCD {
	public static int getGCD(int a, int b){
		// Based on Euclidean Algorithm
		System.out.println("a = " + a + ", b="+b);
		if(a==0) return b;
		return getGCD(b%a, a);
	}
	
	
	// From "Elements of Programming Interviews in Java" with minor
	// modifications.
	public static int getGCDNew(int a, int b) 
	{
		boolean aIsEven = even(a);
		boolean bIsEven = even(b);
		
		if(aIsEven && bIsEven) {
			return (getGCDNew(a >>> 1, b >>> 1)) << 1;
		}
		else if(aIsEven && !bIsEven) 
		{
			return getGCDNew(a >>> 1, b);
		}
		else if(!aIsEven && bIsEven) 
		{
			return getGCDNew(a, b >>> 1);
		}
		else if(a > b) 
		{
			return getGCDNew(a - b, b);			
		}
		else 
		{
			return getGCDNew(a, b - a);
		}
	}
	
	static boolean odd(int num) 
	{
		return !even(num);
	}
	
	static boolean even(int num) 
	{
		return 0 == (num & 1);
	}
}
