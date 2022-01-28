/*

Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

Note: 1 ≤ k ≤ n ≤ 109.

Example:

Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

 */
public class KthSmallestInLexicographicalOrder {
	public int findKthNumber(int n, int k) {
		// todo
		return 0;
	}
	
	private int returnCountOfNumbersWithPrefix(int prefix, int numberOfDigitsInPrefix,  int n, int k){
		//todo: just adding a return statement to make it compile
		int count = 0;
		for(int i = prefix; i < n; i++){
			Math.pow(10, numberOfDigitsInPrefix -1);
		}
		return 0;
	} 

}
