import java.util.*;

public class SpiralMatrix {
	
	int[][] increments = {{0,1}, {1, 0}, {0, -1}, {-1,0}};
	int x, y;
	int[] x_limit= {0,0}, y_limit= {0,0};
	int curIncrementIdx = 0;
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix == null || matrix.length == 0){
			return result;
		}
		
		//init limits
		x_limit[1] = matrix.length-1;
		y_limit[1] = matrix[0].length-1;
		
		while(canProceedFurther()){
			
			//add current pos to list
			result.add(matrix[x][y]);
			
			if(atLimit()){
				System.out.println("change direction");
				//change direction
				curIncrementIdx = curIncrementIdx + 1;
				if(curIncrementIdx == increments.length){
					System.out.println("step in");
					fixLimits();
					curIncrementIdx = 0;
				}
			}
			
			updatePos();
		}//end while
		
        return result;
    }
	
	private void updatePos(){
		x += increments[curIncrementIdx][0];
		y += increments[curIncrementIdx][1];
	}
	
	private boolean atLimit(){
		switch (curIncrementIdx) {
			case 0: return y == y_limit[1]; 
			case 1: return x == x_limit[1];
			case 2: return y == y_limit[0];
			default: return x == x_limit[0]+1;
		}
	}
	
	private void fixLimits(){
		//increasing lower limits by 1 and decreasing upper limits by 1
		x_limit[0]++;
		x_limit[1]--;
		
		y_limit[0]++;
		y_limit[1]--;
	}
	
	private boolean canProceedFurther(){
		if(curIncrementIdx == 3){
			return isWithinLimit(x, x_limit[0]+1, x_limit[1]) && isWithinLimit(y, y_limit[0], y_limit[1]);
		}
		
		return isWithinLimit(x, x_limit[0], x_limit[1]) && isWithinLimit(y, y_limit[0], y_limit[1]);
	}
	
	private boolean isWithinLimit(int val, int LowerLimit, int upperLimit){
		return val >= LowerLimit && val <= upperLimit;
	}
	
	public static void main(String[] args){
		SpiralMatrix sol = new SpiralMatrix();
		int[][] matrix = {};
		sol.spiralOrder(matrix);
	}

}
