public class MergedSortedArray {
	/**
	 * Merged sorted arrays and stores the combined result in the first array.
	 * First array has enough space to store the combined size.
	 * @param nums1 Sorted array with m values and the rest are 0, should be used to store the result
	 * @param m Size of num1, first sorted array.
	 * @param nums2 Sorted array with n values
	 * @param n Size of num2
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        // todo:
		int i=m-1, j=n-1, k=m+n-1;
		
		// 2 options exist
		// 1) start placing entries from the end i.e. place stuff in desc order
		// 2) or make one pass to move stuff in nums1 to the tail end of the array and then do the
		// merge in asc order itself
		while(i >= 0 && j >= 0) 
		{
			if(nums1[i] > nums2[j]) 
			{
				nums1[k--] = nums1[i--];
			}
			else 
			{
				nums1[k--] = nums2[j--];
			}
		}
		
		while(i >= 0) 
		{
			nums1[k--] = nums1[i--];
		}
		
		while(j >= 0) 
		{
			nums1[k--] = nums2[j--];
		}
    }
}
