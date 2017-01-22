import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		OUTER_LOOP:
		for(int i=0; i< nums.length - 2; i++){
			if(nums[i] > 0){
				break;
			}
			INNER_LOOP:
			for(int j = i+1, k = nums.length - 1; j < k;){
				int three_sum = nums[i] + nums[j] + nums[k];
				
				if(three_sum == 0){
					List<Integer> toAdd = Arrays.asList(nums[i], nums[j], nums[k]);
					result.add(toAdd);
					j++;
					k--;

					//advance j and k to prevent duplicates in result
					while(j < k && nums[j] == nums[j-1]){
						j++;
					}
					while(j < k && nums[k] == nums[k+1]){
						k--;
					}
					
				}else if(three_sum < 0){
					j++;
				}else{
					k--;
				}
				
				
				
			}//end INNER_LOOP 
			
			//advance i to prevent duplicates in result
			while(i< nums.length - 2 && nums[i] == nums[i+1]){
				i++;
			}
			
		}//end OUTER_LOOP
        
		return result;
    }
	
	public static void main(String[] args) {
		
		int[] S = {-1, 0, 1, 2, -1, -4};
		ThreeSum solution = new ThreeSum();
		
		printSolution(solution.threeSum(S));

	}
	
	private static void printSolution(List<List<Integer>> solution){
		for(List<Integer> entry : solution){
			System.out.println("");
			for(Integer numberInEntry: entry){
				System.out.print("->" + numberInEntry);
			}
			System.out.println("");
		}
	}

}
