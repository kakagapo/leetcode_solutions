import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

The n-queens puzzle is the problem of placing n queens on an n×n chess board such that no two 
queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */
public class NQueens {
	
	 
	public List<List<String>> solveNQueens(int n) {
		//each entry represent a row and the value at each offset 
		//refers to column that is set in the row identified by offset
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		int[] board = new int[n];
		
		int row = 0, col = 0;
		int rowDelta = 1;
		
		boolean foundAns = false;
		
		for(; row >= 0 && row < n; row += rowDelta){
			
			if(rowDelta < 0){
				board[row] += 1;
			}
			
			foundAns = false;
			
			for(col = board[row]; col >= 0 && col < n; col++){
				
				board[row] = col;
				
				if(collisionPresent(board, row)){
					//System.out.println("Collision detected. row = " + row + ", col = " + col);
					//System.out.println(Arrays.toString(board));					
				}else{
					//System.out.println("No collision so far. row = " + row + ", col = " + col);
					//System.out.println(Arrays.toString(board));

					//continue processing the rest of the rows
					if(row >= n-1){
						//found a solution, save it
						System.out.println("yay !!!! found answer " + Arrays.toString(board));
						foundAns = true;
						result.add(constructResultMatrix(board));
					}
					break;
				}
			}
			
			if(col >= n || foundAns){
				//no more to try in this row so back track
				board[row] = 0;
				rowDelta = -1;
			}else{
				rowDelta = 1;
			}
		
		}
        
		return result;
    } 
	
	private List<String> constructResultMatrix(int[] board){
		List<String> matrix = new ArrayList<>();
		int n = board.length;
		for(int i=0; i < n ; i++){
			matrix.add(constructRow(board[i], n));
		}
		return matrix;
	}
	
	private String constructRow(int posWithQueen, int n){
		assert(posWithQueen < n);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< posWithQueen; i++){
			sb.append(".");
		}
		sb.append("Q");
		for(int i=posWithQueen+1 ; i< n; i++){
			sb.append(".");
		}
		return sb.toString();
	}
	
	/**
	 * only check collision of last row value with every
	 * other row as everything before that has already been found
	 * to be valid by this point 
	 * @param board
	 * @param rowLimit
	 * @return
	 */
	private boolean collisionPresent(int[] board, int rowLimit){
		
		if(rowLimit == 0) return false;
		int j = rowLimit;
		
		for(int i = 0;  i < rowLimit; i++){
			
			//for(int j = i+1;  j <= rowLimit; j++){
				if(board[i] == board[j]){
					//System.out.println("vertical collision between rows " + i + " and " + j);
					 return true;
				}
				if(Math.abs(board[i] - board[j]) == Math.abs(i-j)){
					//System.out.println("Diagonal collision between rows " + i + " and " + j);
					return true;
				}
			//}
			
		}
		return false;
	}
	
	public static void main(String[] args){
		
		NQueens sol = new NQueens();
		sol.solveNQueens(4);
	}
}
