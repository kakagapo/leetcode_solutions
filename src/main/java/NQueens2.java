import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
	public int totalNQueens(int n) {
		//each entry represent a row and the value at each offset 
		//refers to column that is set in the row identified by offset
		
		int result = 0;
		
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
						result++;
						
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

}
