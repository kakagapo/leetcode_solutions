public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null) return null;
        
        for(String str : strs){
           if(str == null) return null;
        }
        
        for(String str : strs){
           if(str.isEmpty()) return "";
        }
        
        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        
        
        
        for(int pos = 0; ; pos++){
            System.out.println("pos : " + pos);
            boolean match = true;
            if(pos == strs[0].length()){
                return strs[0];
            }
            char prevChar = strs[0].charAt(pos);
            for(int strNum = 1; strNum < strs.length; strNum++){
                
                //on frist mismatch return the everything before this pos
                //on reaching end return the whole string
                if(pos == strs[strNum].length() || prevChar != strs[strNum].charAt(pos)){
                    return strs[strNum].substring(0, pos);
                }
            }
        }
        
        //unreachable
        //return "";
    }
}