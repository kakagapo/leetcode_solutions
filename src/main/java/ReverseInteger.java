

public class ReverseInteger {
	
	/**
	 * 
	 * @param x
	 * @return
	 */
    public static int reverse(int input) {
    	int x = input;
    	int output = 0;
    	int remainder;
    	while(x!=0){
    		remainder = x%10;
    		if(output > Integer.MAX_VALUE/10 || output < Integer.MIN_VALUE/10){
    			return 0;
    		}/*else if(output == Integer.MAX_VALUE/10 || output == Integer.MIN_VALUE/10){//looks like this case is 
    			if(remainder > (input%10) ){
    				return 0;
    			}
    		}*/
    		output = output * 10 + remainder;
    		x = x / 10;
    	}
    	
    	return output;
    }
    
    
    public static void main(String[] args){
    	int input, output;
    	input = -123;
    	output = reverse(input);
    	System.out.println(input +" <--> "+ output);
    	
    	input = Integer.MAX_VALUE;
    	output = reverse(input);
    	System.out.println(input +" <--> "+ output);
    	
    	input = Integer.MIN_VALUE;
    	output = reverse(input);
    	System.out.println(input +" <--> "+ output);
    }
	
}
