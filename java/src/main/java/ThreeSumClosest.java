import java.util.*;
public class ThreeSumClosest {
    /**
    * Finds three integers in nums such that the sum is closest to target.
    * You may assume that each input would have exactly one solution.
    * Constraints:
    * 3 <= nums.length <= 1000
    * -1000 <= nums[i] <= 1000
    * -104 <= target <= 104
    * @return the sum of the three integers.
    */
    public int threeSumClosestBruteForce(int[] nums, int target) {
        int closestSum = 0;
        int closestSumDiff = Integer.MAX_VALUE;
        
        // Brute-force O(n^3) solution, where n is the length of nums array
        // Find all possible 3 sums and finds the closest to target.
        for(int i=0; i < nums.length - 2; i++){
            for(int j=i+1; j < nums.length - 1; j++){
                for(int k=j+1; k < nums.length; k++ ){
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(target - sum); 
                    if(diff < closestSumDiff){
                        closestSumDiff = diff;
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int closestSumDiff = Integer.MAX_VALUE;
        
        Arrays.sort(nums);

        for(int i=0; i < nums.length - 2; i++){
            
            // j and k are updated inside the body of the loop
            for(int j= i+1, k=nums.length-1;j < k;)
            {
                // note that nums[i] <= nums[j] <= nums[k]
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);
                if(sum == target) return sum; // this early termination exists because we are not trying find all sums that results in target
                else if(sum < target) j++; // 
                else k--; // find a smaller number to add 
                
                if(diff < closestSumDiff)
                {
                    closestSumDiff = diff;
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}