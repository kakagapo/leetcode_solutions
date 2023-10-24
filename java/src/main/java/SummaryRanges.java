import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {
	
	static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      @Override
    	public String toString() {    		
    		return String.format("start %d , end %d", start, end);
    	}
	}
	
	TreeMap<Integer, Interval> map = new TreeMap<>();
	
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        Map.Entry<Integer, Interval> floor = map.floorEntry(val);
        Map.Entry<Integer, Interval> ceil = map.ceilingEntry(val);
        
        int newEnd = val;
    	if(ceil != null  && ceil.getKey() == val+1){
    		newEnd = ceil.getValue().end;
    		map.remove(ceil.getKey());
    	}
    	
        if(floor == null || floor.getValue().end < val - 1){
        	map.put(val, new Interval(val, newEnd));
    	}else if(floor.getValue().end == val - 1){
    		floor.getValue().end = newEnd;
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args){
    	SummaryRanges obj = new SummaryRanges();
    	obj.addNum(1);
    	obj.addNum(3);
    	obj.addNum(7);
    	obj.addNum(2);
    	obj.addNum(6);
    	
    	
    	List<Interval> param_2 = obj.getIntervals();
    	System.out.println();
    }
}
