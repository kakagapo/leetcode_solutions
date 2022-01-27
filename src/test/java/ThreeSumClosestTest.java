import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;

public class ThreeSumClosestTest {
    @Test
    public void test1() 
    {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        ThreeSumClosest obj = new ThreeSumClosest();
        int output = obj.threeSumClosest(nums, target);
        
        // (-1 + 2 + 1 = 2).
        Assert.assertEquals(2, output);

        output = obj.threeSumClosestBruteForce(nums, target);
        Assert.assertEquals(2, output);
    }

    @Test
    public void test2() 
    {
        int[] nums = {0,0,0};
        int target = 1;

        ThreeSumClosest obj = new ThreeSumClosest();
        int output = obj.threeSumClosest(nums, target);
        
        Assert.assertEquals(0, output);

        output = obj.threeSumClosestBruteForce(nums, target);
        Assert.assertEquals(0, output);
    }
}
