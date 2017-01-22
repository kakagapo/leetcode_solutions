
public class MinimumInRotatedSortedArrayWithDuplicates {
	public int findMin(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		return findMin(nums, 0, nums.length -1);		
    }
	
	private int findMin(int[] nums, int start, int end){
		if(start == end){
			return nums[start];
		}else if(nums[start] < nums[end]){
			return nums[start];
		}else{
			int mid = (start + end) / 2;
			if(nums[mid] > nums[mid+1]){
				return nums[mid+1];
			}else{
				return Math.min(findMin(nums, start, mid), findMin(nums, mid+1, end));
			}			
		}
	}
	
	public static void main(String[] args){
		MinimumInRotatedSortedArrayWithDuplicates obj = new  MinimumInRotatedSortedArrayWithDuplicates();
		System.out.println("exp 1, got " + obj.findMin(new int[]{3,3,3,1}));
		System.out.println("exp 1, got " + obj.findMin(new int[]{10,1,10,10,10}));		
		System.out.println("exp 1, got " + obj.findMin(new int[]{4,5,6,7,1,2}));
		System.out.println("exp 1, got " + obj.findMin(new int[]{4,5,6,7,1,1,2}));
		System.out.println("exp 4, got " + obj.findMin(new int[]{4}));
		System.out.println("exp 4, got " + obj.findMin(new int[]{4,4}));
		System.out.println("exp 0, got " + obj.findMin(new int[]{}));
		
		
	}
	
	
}
