import java.util.*;

public class Subsets {
	
	/**
	 * uses recursion to determine every possible combination of values in the input
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		if(nums == null || nums.length == 0){
			return new ArrayList<>();
		}
		
		List<List<Integer>> output = new ArrayList<>((int)Math.pow(2, nums.length));		
		subsets(nums, output, new ArrayList<>(),  0);
        return output;
    }
	
	private void subsets(int[] nums, List<List<Integer>> output, List<Integer> buffer, int pos){
		if(pos >= nums.length){
			output.add(buffer);
			return;
		}else{
			subsets(nums, output, buffer, pos+1);
			List<Integer> bufferClone =  new ArrayList<>(buffer);
			bufferClone.add(nums[pos]);
			subsets(nums, output, bufferClone, pos+1);
		}
		
		
	}

}
