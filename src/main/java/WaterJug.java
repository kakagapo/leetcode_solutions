

public class WaterJug {
	public boolean canMeasureWater(int x, int y, int z) {
        assert(x>=0 && y >= 0 && z >=0);
        int tmp = y;
        if(x > y) {
            y = x;
            x = tmp;
        }
        if(x == 0 && y != z){
            return false;
        }
        
        if(z==0 || z == x+y || z == x || z == y){
            return true;
        }
        
        int diff = y - x;
        
        if(helper(diff, x, y, z)){
        	return true;
        }
        if(diff < x){
        	if(helper(y - (x-diff), x, y, z)){
            	return true;
            }
        }
        
        
        return false;
    }
	
    private boolean helper(int a, int smaller, int larger, int required_quantity){
        if(a <= 0){
    		return false;
    	}
    	if(a == required_quantity){
    		return true;
    	}
    	assert(required_quantity <= smaller+larger);
    	assert(a < larger && a <= required_quantity);
    	
    	if((required_quantity - a) % smaller == 0){
    	//if(a + smaller == required_quantity){
    		return true;
    	}
    	
    	if(a <= smaller && larger + a == required_quantity){
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	WaterJug solution = new WaterJug();
    	System.out.println("answer : " + solution.canMeasureWater(6, 9, 1));
    	System.out.println("answer : " + solution.canMeasureWater(34, 5, 6));
    }
    
}
