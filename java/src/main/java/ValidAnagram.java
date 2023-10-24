/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

	//assumption: string are made of lower case English alphabets
	public boolean isAnagram(String s, String t) {
		if(s == t){
			return true;
		}else if(s.length() != t.length()){
			return false;
		}
		
		
		int[] exisitingElems = new int['z' - 'a' + 1];
		
		for(int i = 0; i < s.length(); i++){
			exisitingElems[s.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < t.length(); i++){
			if(--exisitingElems[t.charAt(i) - 'a'] < 0){
				return false;
			}
		}
		
		
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
