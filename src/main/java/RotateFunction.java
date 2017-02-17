import java.util.Arrays;


/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array 
 * A k positions clock-wise, we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1)
 */
public class RotateFunction {
	
	//Naive O(n^2) solution
	public int maxRotateFunctionNaive(int[] A) {
		if(A == null || A.length < 2){
			return 0;
		}
		int fMax = Integer.MIN_VALUE;
        for(int shift = 0 ; shift < A.length; shift++){
        	int f = 0;
        	for(int i = 1; i < A.length; i++){
        		f += i * A[(i+shift) % A.length];
        	}
        	if(f > fMax){
        		fMax = f;
        	}
        }
        return fMax;
    }
	
	//O(n) solution
	public int maxRotateFunction(int[] A) {
		if(A == null || A.length < 2){
			return 0;
		}
		
		int sum = 0;
		for(int i=0;i < A.length; i++){
			sum += A[i];
		}
		
		int fPrev = 0;
		
		for(int i = 1; i < A.length; i++){
    		fPrev += i * A[i];
    	}
		System.out.println("F(0) : " + fPrev);
		int f = 0;
		int fMax = fPrev;
		
		for(int shift = 1; shift < A.length; shift++ ){
			int tmp = ((A.length - 1) - (shift - 1));
			System.out.println("offset to remove : "+tmp);
			f = fPrev + sum - (A.length * A[tmp]);
			System.out.println("F("+shift+") : " + f);
			if(f > fMax){
				fMax = f;
			}
			fPrev = f;
		}
		
		
        return fMax;
    }
	
	
	
	public static void main(String[] args){
		RotateFunction sol = new RotateFunction();
		System.out.println(sol.maxRotateFunction(new int[]{4, 3, 2, 6}));
	}
}
