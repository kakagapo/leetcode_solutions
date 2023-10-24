public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] arr;
        
        int N = board[0].length;
        
        for(int row = 0; row < N ; row++){
            arr = new boolean[10]; 
            for(int col = 0; col < N ; col++){
                if(!helper(arr, row, col, board[row][col])){
                    return false;
                }   
            }
        }
        
        for(int col = 0; col < N ; col++){
            arr = new boolean[10];
            for(int row = 0; row < N ; row++){
                if(!helper(arr, row, col, board[row][col])){
                    return false;
                }
            }
        }
        
        for(int row = 0; row < N ; row += 3){
            for(int col = 0; col < N ; col += 3){
                arr = new boolean[10]; 
                for(int i = row; i < row + 3 ; i++){
                    for(int j = col; j < col + 3 ; j++){
                        if(!helper(arr, i, j, board[i][j])){
                            return false;
                        }   
                    }//end j loop
                }//end i loop
            }//end col loop
        }//end row loop
        
        return true;
        
    }
    
    private boolean helper(boolean[] arr, int row, int col, char ch){
        if(ch != '.'){
            int arrOffset = ch - '0';
            if(arr[arrOffset] == false){
               arr[arrOffset] = true; 
            }else{
                return false;
            }
        }
        return true;
    }
    
}