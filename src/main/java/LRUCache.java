import java.util.HashMap;

//both get and put takes O(n) time
public class LRUCache {
	
	int capacity=0;
	
	private static class Q {
		Node qHead;
	    Node qTail;
	    
		private static class Node {
			int key;
	        int value;
	        Node next;
	        Node prev;

	        Node(Node prev, int key, int element, Node next) {
	        	this.key = key;
	            this.value = element;
	            this.next = next;
	            this.prev = prev;
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
	    		prevNode.next = nextNode;
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
	
	private Q q = new Q();
	private HashMap<Integer, Q.Node> map = new HashMap<Integer, Q.Node>();
	
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * 
     * @param key
     * @return the value associated with the key, -1 if not found
     */
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
    
    /**
     * 
     * @param key
     * @param value can not be -1
     */
    public void put(int key, int value) {
    	Q.Node node =  map.get(key);
    	if(map.size() >= capacity){
    		Q.Node prevHead = q.dequeue();
    		if(prevHead != null){
    			map.remove(key);
    		}
    	}
    	if(node != null){
    		q.moveToEndOfQueue(node);
    		node.value = value;
    	}else{
    		node = new Q.Node(null, key, value, null);
    		q.enqueue(node); 
    	}
    }
    
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println("Expected : 1");
    	cache.get(1);
    	cache.put(3, 3);
    	System.out.println("Expected : -1");
    	cache.get(2);
    	cache.put(4, 4);
    	System.out.println("Expected : -1");
    	cache.get(1);
    	System.out.println("Expected : 3");
    	cache.get(3);
    	System.out.println("Expected : 4");
    	cache.get(4);    	
    }
    
    
}