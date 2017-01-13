public class KGroupReverse {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null){
			return null;
		}
		if(k==1){
			return head;
		}


		int length = findLength(head);

		if(k>length){
			return head;
		}

		length -= length%k;

		int count = 0;
		ListNode cur = head;
		ListNode next = head.next;
		ListNode nextNext = null;

		ListNode curSegmentHead = head;
		ListNode prevSegmentHead = null;
		ListNode newHead= null;


		//when count = i, we invert nodes i and i + 1 (0 start offset)
		//cur node's next pointer might already be changed so don't trust it
		while (next != null && count < length){
			if(count % (k-1) == 0){
				if(newHead == null){
					newHead = cur;
				}
				//don't do invert, but just append 
				if(prevSegmentHead != null){
					prevSegmentHead.next = cur;    
				}
				prevSegmentHead = curSegmentHead;
				curSegmentHead = next;
			}else{
				nextNext = next.next;
				invert(cur);//inverts the flow from cur to next node  
			}
			count++;
			cur = next;
			next = nextNext;
		}

		return newHead;
	}

	private int findLength(ListNode head){
		if(head == null) return 0;
		ListNode curNode = head;
		int count = 0;
		while(curNode != null){
			count++;
			curNode = curNode.next;
		}
		return count;
	}

	private void invert(ListNode node){
		ListNode nextNode = node.next;
		nextNode.next = node;
	}
}