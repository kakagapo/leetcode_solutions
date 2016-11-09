import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
	public List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		if(n == 0){
			return output;
		}
		
		
		char[] charArr = new char[n*2];
		charArr[0] = '(';
		helper(output, charArr, n*2, 1, 0);
		
		return output;
		
    }
	
	
	/**
	 * Recursively constructs a tree
	 * @param node
	 * @param n
	 * @param openParantheses - number of ( added so far
	 * @param closingParantheses - number of ) added so far
	 */
	private void helper(List<String> output, char[] charArr, int n, 
			int openParantheses, 
			int closingParantheses){
		
		if(openParantheses + closingParantheses >= n){
			//reached end
			output.add(new String(charArr));
			return;
		}
		
		if(openParantheses < n/2){
			charArr[openParantheses+closingParantheses] = '(';
			helper(output, charArr, n, openParantheses + 1, closingParantheses);			
		}
		
		if(closingParantheses < openParantheses){			
			charArr[openParantheses+closingParantheses] = ')';
			helper(output, charArr, n, openParantheses, closingParantheses + 1);
		}
	}

	public static void main(String[] args) {
		GenerateParantheses obj = new GenerateParantheses();
		System.out.println(obj.generateParenthesis(6).toString());
		

	}

}
