import java.util.HashMap;

//both get and put takes O(n) time
public class LRUCache {
	
	int capacity=0;
	
	/**
	 * Implementing a Queue based on a doubly-linked list that 
	 * removes an item in O(1) time. The remove method in
	 * LinkedList operates in O(n) time as it first searches 
	 * for the element and then removes it.
	 */
	private static class Q {
		Node qHead;
	    Node qTail;
	    
		private static class Node {
			int key;
	        int value;
	        Node next;
	        Node prev;

	        Node(int key, int element) {
	        	this.key = key;
	            this.value = element;
	        }
	    }
		
		Node dequeue(){
			if(qHead ==  null){
				return null;
			}
			Node out = qHead; 
			qHead = qHead.next;
			fixHead();
			return out;
		}
		
		private void moveToEndOfQueue(Node node){
	    	if(node != null){
	    		remove(node);
	    		enqueue(node);
	    	}
	    }
	    
	    private void remove(Node node){
	    	if(node == qHead || node == qTail){
	    		if(node == qHead){
		    		qHead = node.next;
		    		fixHead();	    		
		    	}
		    	
		    	if(node == qTail){
		    		qTail = node.prev;
		    		fixTail();
		    	}
	    	}else{
	    		Node prevNode = node.prev;
	    		Node nextNode = node.next;
	    		if(prevNode != null)
	    			prevNode.next = nextNode;
	    		if(nextNode != null)
	    			nextNode.prev = prevNode;
	    	}
	    }
	    
	    private void enqueue(Node node){
	    	if(qTail == null){
	    		//empty queue
	    		qHead = node;
	    		qTail = node;
	    		fixHead();
	    		fixTail();
	    	}else{
	    		node.prev = qTail;
	    		qTail.next = node;
	    		qTail = node;	    		
	    		fixTail();
	    	}
	    }
	    
	    private void fixHead(){
	    	if(qHead != null){
	    		qHead.prev = null;
	    	}
	    }
	    
	    private void fixTail(){
	    	if(qTail != null){
	    		qTail.next = null;
	    	}
	    }
	}
	
	// Queue used to hold the elements in the cache 
	// in the order in which they will be evicted.
	private Q q;
	
	// Used to do O(1)[amortized] cache lookup.
	private HashMap<Integer, Q.Node> map;	
	
    public LRUCache(int capacity) {
    	assert capacity > 0;
    	q = new Q();
    	map = new HashMap<Integer, Q.Node>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	Q.Node node =  map.get(key);
    	if(node == null){
    		System.out.println("Get result : -1");
    		return -1;
    	} 
    	q.moveToEndOfQueue(node);
    	System.out.println("Get result :" + node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
    	Q.Node node =  map.get(key);
    	if(map.size() >= capacity && node == null)
    	{
    		// cache is full and incoming item is not present in cache, so to make space
    		// removing the head of the queue. 
    		Q.Node prevHead = q.dequeue();
			map.remove(prevHead.key);
			// Incoming item will be added in the else part of the following if condition
    	}
    	
    	if(node != null)
    	{
    		// Existing item but value has changed.
    		q.moveToEndOfQueue(node);
    		node.value = value;
    	} 
    	else 
    	{
    		// Incoming item not present in the cache.
    		node = new Q.Node(key, value);
    		q.enqueue(node);
    		map.put(key, node);
    	}
    }    
}