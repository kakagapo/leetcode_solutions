
public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
    	int count = 0;
    	for(int i = 0; i < grid.length; i++){
    		for(int j=0; j < grid[0].length ; j++){
    			if(grid[i][j] == '1'){
    				count++;
    				mark_island(grid, i, j);
    			}
    		}
    	}
    	return count;
    }
    
    private void mark_island(char[][] grid, int i, int j){
    	if(i <0 || j < 0 ||  i >= grid.length || j >= grid[0].length){
    		return;
    	}
    	if(grid[i][j] == '1'){
    		grid[i][j] = '2';
    		mark_island(grid, i+1, j);
    		mark_island(grid, i, j+1);
    		mark_island(grid, i-1, j);
    		mark_island(grid, i, j-1);
    	}
    }
    
    public static void main(String[] args){
    	NumberOfIslands sol = new NumberOfIslands();
    	System.out.println(sol.numIslands(new char[][]
    			{
    				{1, 1, 1, 1, 0},
    				{1, 1, 0, 1, 0},
    				{1, 1, 0, 0, 0},
    				{0, 0, 0, 0, 0}
				}));
    }
	
}
