package LRU;

/**This class creates Node
 * 
 * @author Jalpa
 *
 */

class Node {
	Node prev;
	Node next;
	int key;
	int value;

	public Node(int key, int value) {
		this.key=key;
		this.value=value;
		prev=next=null;
	}
}

/**This class provides queue implementation of doubly linked list
 * 
 * @author Jalpa
 *
 */

public class QNode{
	private Node head;
    private Node tail;
    
    QNode(){
    	head=tail=null;
    }
    
    /**
     * Adds the node at the front of the doubly linked list
     * @param node
     */
    public void addToHead(Node node) {
    	if (head==null && tail==null) {
    		head=tail=node;
    		return;
    	}
    	node.next=head;
    	head.prev=node;
    	head=node;
    }
    
    /**
     * Removes node from the rear end of the doubly linked list
     * @return Node
     */
    public Node removeLastNode() {
    	if (head==null && tail==null) return null;
    	Node removed = tail;
        if(tail.prev == null){
        	assert head==removed;
            head = tail = null; 
            return removed;
        }
        unlink(removed);
        return removed;
    }
    
    /**
     * Move a node in the front of the list
     * @param node
     */
    public void moveToHead(Node node) {
    	if (head==node) return;
    	unlink(node);
    	addToHead(node);
    }
    
    /**
     * If Node value exists in the list then replace it with new Node containing the new value 
     * and add it to the head of the list
     * @param node
     * @param newNode
     */
    public void replaceNode(Node node, Node newNode) {
		if (node==head) {
			node.value=newNode.value;
		}
		else {
			unlink(node);
			addToHead(newNode);
		}
	}
    
    /**
     * To unlink the node from the list
     * @param node
     */
    private void unlink(Node node) {
    	if (node==tail) {
    		tail=node.prev;
    		tail.next=null;
    	}
    	else {
    		node.prev.next = node.next;
            node.next.prev = node.prev;
    	}
        node.prev=node.next=null;
    }
    
    /**
     *  To print all current items in the list 
    */
    public void print() {
        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.print("key " + traverseNode.key + " value "
                    + traverseNode.value + "\n");
            traverseNode = traverseNode.next;
        }
        System.out.println();
    }

}