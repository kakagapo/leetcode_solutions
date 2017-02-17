
public class ImageRotate {
	static class Point{
		final int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	/**
	 * does a 90 degree rotation of given matrix without using
	 * extra space
	 * @param matrix - square matrix
	 */
	public void rotate(int[][] matrix) {
		
		int N = matrix.length;
		
		int L = N/2; 
		
		for(int i=0; i < L ; i++){
			for(int j= i; j < N-i - 1; j++){
				//4 way swap
				doFourWaySwap(matrix, i, j);
				
			}
		}
    }
	
	private void doFourWaySwap(int[][] matrix, int x, int y){
		int N = matrix.length;
		int prevVal = matrix[x][y];
		Point p = new Point(x,y);
		for(int i = 0; i < 4; i++){
			p = rotatePoint(p, N);
			int val = matrix[p.x][p.y];
			matrix[p.x][p.y] = prevVal;
			prevVal = val;
		}
	}
	
	
	private Point rotatePoint(Point p, int N){
		return new Point(p.y, N-1 - p.x);
	}
}
