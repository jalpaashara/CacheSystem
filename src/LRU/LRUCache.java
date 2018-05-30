package LRU;

import java.util.Hashtable;
import java.util.Map;

/**
 * This class implements the LRU Cache System.
 * When the client requests resource A, it happens as follow:
 * <dd>If A exists in the cache, we just return immediately.<br>
 * If not and the cache has extra storage slots, we fetch resource A and return to the client. In addition, insert A into the cache.<br>
 * If the cache is full, we kick out the resource that is least recently used and replace it with resource A.<br>
 *  </dd><br>
 * @author Jalpa
 *
 */

public class LRUCache {
		private int capacity = 0;
	    Map<Integer, Node> map;
	    QNode LRUQueue;
	    
	/**
	 * Create a HashMap of the given capacity
	 * @param capacity
	 */
	public LRUCache(int capacity) {
		assert capacity > 0;
        this.capacity = capacity;
        this.map = new Hashtable<Integer, Node>(capacity);
        this.LRUQueue = new QNode();
    }
	
	/**
	 * Return the resource if found and move it to the head of the list
	 * @param key
	 * @return node value
	 */
	public int get(int key) {
		Node node=map.get(key);
		if (node==null) return -1;
		else  {
			LRUQueue.moveToHead(node);
			return node.value;
		}
		
	}
	
	/**
	 * Checks if resource is available in the cache, if not then checks if cache is full, 
	 * if cache is full then removes the least recently used resource and adds the new resource 
	 * at front of the list, and 
	 * if cache has storage it simply adds the resource at the head of the list
	 * @param key
	 * @param value
	 */
	public void set(int key, int value) {
		Node node=map.get(key);
		if (node!=null)  {
			if (node.value==value) get(key);
			else{
				Node new_node=node;
				new_node.value=value;
				LRUQueue.replaceNode(node, new_node);
				map.replace(key, node, new_node);
			}
		}
		else {
			Node insertNode = new Node(key,value);
			if (map.size()<capacity) {
				add(insertNode);
			}
			else {
				removeLRU();
				add(insertNode);
			}
		}
	}
	
	/**
	 * Removes the resource from list and hash Map
	 */
	private void removeLRU() {
		Node del = LRUQueue.removeLastNode();
		map.remove(del.key);
	}
	
	/**
	 * Add the resource to the list and hash map
	 * @param insertNode
	 */
	private void add(Node insertNode) {
		map.put(insertNode.key, insertNode);
		LRUQueue.addToHead(insertNode);
		
	}
	
	/**
	 * To print all current items in LRUCache
	 */
	public void printLRUCache() {
		LRUQueue.print();
	}
	
	
}
