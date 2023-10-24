import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Comparator<int[]> comparator = new Comparator<int[]>() 
		{
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		};
		
		// in-place sort => O(n.log(n)), n is the size of intervals array
        Arrays.sort(intervals, comparator);
        
        LinkedList<int[]> mergedList = new LinkedList<int[]>();
        mergedList.add(intervals[0]);
        
        // the following loop takes O(n)
        for(int i=1; i < intervals.length; i++)
        {
        	int[] currentInterval = intervals[i]; 
        	int[] lastIntervalInMergedList = mergedList.getLast();
        	if(lastIntervalInMergedList[1] >= currentInterval[0]) 
        	{
        		lastIntervalInMergedList[1] = 
        				Math.max(lastIntervalInMergedList[1], intervals[i][1]);
        	}
        	else 
        	{
        		mergedList.add(currentInterval);
        	}
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
