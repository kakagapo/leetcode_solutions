public class KGroupReverse {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null){
			return null;
		}
		if(k < 2){
			return head;
		}


		int length = findLength(head);
		System.out.println("length " + length);

		if(k > length){
			return head;
		}

		int adjustedLength = length - length%k;
		System.out.println("adjusted length " + adjustedLength);

		int i = 1;
		ListNode cur = head;
		ListNode next = head.next;
		ListNode nextNext = null;

		ListNode curSegmentHead = head;
		ListNode prevSegmentHead = null;
		ListNode newHead= null;


		//For each i we invert nodes i - 1(cur) and i(next)
		//cur node's next pointer might already be changed so don't trust it
		while (cur != null && next != null && i < adjustedLength){
			System.out.println("chk1 , i" + i);
			nextNext = next.next;
			if(i % k == 0){
				System.out.println("chk 2");
				if(newHead == null){
					newHead = cur;
				}
				//don't do invert, but just append 
				if(prevSegmentHead != null){
					prevSegmentHead.next = cur;    
				}
				prevSegmentHead = curSegmentHead;
				curSegmentHead = next;
				curSegmentHead.next = null;				
			}else{
				System.out.println("chk 3");
				//inverts the flow from cur to next node
				next.next = cur;  
			}
			i++;
			cur = next;
			next = nextNext;
		}
		if(newHead == null){
			System.out.println("chk 4");
		    //only one segment present
		    newHead = cur;
		}else if(prevSegmentHead != null){
			prevSegmentHead.next = cur;    
		}
		
		if(length == adjustedLength){
			System.out.println("chk 5, curSegmentHead"+ curSegmentHead.val);
			curSegmentHead.next = null; // you can also use head = null;
		}else if(next != null && curSegmentHead != null){
			System.out.println("chk 6");
			curSegmentHead.next = next;
		}
		
		
		

		return newHead;
	}
	
	private static int findLength(ListNode head){
		if(head == null) return 0;
		ListNode curNode = head;
		int count = 0;
		while(curNode != null){
			count++;
			curNode = curNode.next;
		}
		return count;
	}
	
	
	public static void main(String[] args){
		
		ListNode reverse;
		reverse = reverseKGroup(createList(new int[]{1,2,3,4,5,6,7,8,9}), 3);
		printList(reverse);
		
		reverse = reverseKGroup(createList(new int[]{1,2}), 2);
		printList(reverse);
		
	}
	
	public static ListNode createList(int[] arr){
		ListNode head = new ListNode(arr[0]);
		ListNode cur = head;
		for(int i = 1; i < arr.length; i++){
			cur.next = new ListNode(arr[i]); 
			cur = cur.next;
		}
		return head;
	}
	
	public static void printList(ListNode head){
		ListNode cur = head;
		System.out.println("");
		while(cur != null){
			System.out.print("->" + cur.val);
			cur = cur.next;
		}
		System.out.println("");
	}
}