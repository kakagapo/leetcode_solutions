import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class LRUCacheTest extends TestCase {
	
	@Test
	public void test1() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
    	cache.put(2, 2);
    	Assert.assertEquals(1, cache.get(1));	
    	cache.put(3, 3);
    	Assert.assertEquals(-1, cache.get(2));
    	cache.put(4, 4);
    	Assert.assertEquals(-1, cache.get(1));
    	Assert.assertEquals(3, cache.get(3));
    	Assert.assertEquals(4, cache.get(4));
	}
	
	@Test
	public void test2() 
	{
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
    	cache.put(1, 1);
    	cache.put(2, 3);
    	cache.put(4, 1);
    	Assert.assertEquals(-1, cache.get(1));
    	Assert.assertEquals(3, cache.get(2));
	}
}
