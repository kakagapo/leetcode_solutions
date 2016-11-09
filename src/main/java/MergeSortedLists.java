import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class MergeSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){

			public int compare(ListNode o1, ListNode o2) {
				if(o1 == o2){
					return 0;
				}else{
					return Integer.compare(o1.val, o2.val);
				}
			}
        	
        });
        
        for(int i=0; i< lists.length; i++){
        	if(lists[i] != null){
        		pq.add(lists[i]);
        	}
        }
        
        ListNode  resultHead, resultTail;
        
        
        ListNode head = pq.remove();
        if(head.next != null){
    		pq.add(head.next);
    	}
        
        resultHead = resultTail = head;
        
        while(!pq.isEmpty()){
        	head = pq.remove();
        	if(head.next != null){
        		pq.add(head.next);
        	}
        	
        	resultTail.next = head;
        	
        }
        
        return resultHead;
        
    }
}
