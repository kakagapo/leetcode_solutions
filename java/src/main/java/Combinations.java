import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * 		[2,4],
 * 		[3,4],
 * 		[2,3],
 * 		[1,2],
 * 		[1,3],
 * 		[1,4]
 * ]
 * 
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Integer[] tmpArr = new Integer[k];
		helper(output, n, k , tmpArr, 0, 1);
		return output;
        
    }
	/**
	 * 
	 * @param output
	 * @param n
	 * @param k
	 * @param tmpArr - temp array used to populate the each entry in the outer list of output 
	 * @param idxTmpArr - the position in the tmpArr to populate
	 * @param idxInputRange - defines the number from which you start filling the position idxTmpArr in array tmpArr 
	 */
	private void helper(List<List<Integer>> output, int n, int k, Integer[] tmpArr, int idxTmpArr, int idxInputRange){
		if(idxTmpArr >= k){
			//recursion end
			output.add(Arrays.asList(tmpArr.clone()));
			return;
		}
		for(;idxInputRange <= n; idxInputRange++){
			tmpArr[idxTmpArr] = idxInputRange; 
			helper(output, n,k, tmpArr, 1+idxTmpArr, idxInputRange + 1);
		}
	}
	
	public static void main(String[] args){
		Combinations obj = new Combinations();
		System.out.println(obj.combine(4, 2).toString());
		
	}
}
