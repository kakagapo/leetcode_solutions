
public class GCD {
	public static int getGCD(int a, int b){
		System.out.println("a = " + a + ", b="+b);
		if(a==0) return b;
		return getGCD(b%a, a);
	}
}
