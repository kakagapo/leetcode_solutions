
public class LongestSubstringWithoutRepeatingChars {
	
    public static int lengthOfLongestSubstring(String s) {
        int arr[] = new int[Character.MAX_VALUE - Character.MIN_VALUE];
        int start = 0;
        if(s == null || s.isEmpty()){
        	return 0;
        }
        
        int maxLenSubstrStart = 0, maxLenSubstrEnd = 0;
        
        for(int i=1; i < s.length(); i++){
        	System.out.println("i:" + i);
        	int end = i;
        	if(arr[s.charAt(i)] >= start){
        		end = i-1;
        	}
    		//end of substr without repeating chars
    		if(end - start >  maxLenSubstrEnd - maxLenSubstrStart){
        			System.out.println("Updating max len, arr val : "+ arr[s.charAt(i)] + ", start : " + start);
        			maxLenSubstrEnd = end;
        			maxLenSubstrStart = start;
    		}
        	if(arr[s.charAt(i)] >= start){
        		start = arr[s.charAt(i)]+1;
        	}
        	arr[s.charAt(i)] = i;
        }
        System.out.println("max len substr :" + maxLenSubstrStart + "," + maxLenSubstrEnd);
        return maxLenSubstrEnd - maxLenSubstrStart + 1;
    }
    
    public static void main(String[] args){
    	System.out.println(Character.MAX_VALUE - Character.MIN_VALUE);
    	lengthOfLongestSubstring("abcabcbb");
    	lengthOfLongestSubstring("au");
    	
    	/*
    	"abcadefgh" => 1 to end
		""
		*/
    }


}
