import org.junit.Assert;
import org.junit.Test;

public class GCDTest {
	@Test
	public void test() {
		Assert.assertEquals(2, GCD.getGCD(2, 4));
		Assert.assertEquals(2, GCD.getGCDNew(2, 4));
		
		Assert.assertEquals(1, GCD.getGCD(3, 5));
		Assert.assertEquals(1, GCD.getGCDNew(3, 5));
		
		Assert.assertEquals(6, GCD.getGCD(18, 24));
		Assert.assertEquals(6, GCD.getGCDNew(18, 24));
	}
	
}
