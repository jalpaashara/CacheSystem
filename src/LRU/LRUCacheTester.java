package LRU;

public class LRUCacheTester {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		
		cache.set(2, 1);
		cache.set(1, 1);
		cache.printLRUCache();
		cache.set(2, 3);    // replaces resource 1 with 3 and puts the current resource on top or in front
		cache.printLRUCache(); 
		cache.set(4, 1);    // evicts key 1
		cache.printLRUCache();
		System.out.println("Get value: "+cache.get(1));       // returns -1 (not found)
		System.out.println("Get value: "+cache.get(2));       // returns 3
		cache.printLRUCache();
		System.out.println("-------------------------------------------------------------------------------");
		

		cache.set(1, 1);
		cache.set(2, 2);
		cache.printLRUCache();
		System.out.println("Get value: "+cache.get(1));       // returns 1
		cache.printLRUCache();
		cache.set(3, 3);    // evicts key 2
		cache.printLRUCache();
		System.out.println("Get value: "+cache.get(2));       // returns -1 (not found)
		cache.set(4, 4);    // evicts key 1
		cache.printLRUCache();
		System.out.println("Get value: "+cache.get(1));       // returns -1 (not found)
		System.out.println("Get value: "+cache.get(3));       // returns 3
		cache.printLRUCache();
		System.out.println("Get value: "+cache.get(4));       // returns 4
		cache.printLRUCache();
		System.out.println("-------------------------------------------------------------------------------");
		
		
       LRUCache lru = new LRUCache(5);
        for (int i = 5; i < 11; i++) {
            lru.set(i, i * 2);
        }
        System.out.println("LRU Cache after creation");
        lru.printLRUCache();
        lru.get(7);
        System.out.println("LRU Cache after retrieving 7");
        lru.printLRUCache();
        lru.set(11, 11 * 2);
        System.out.println("LRU cache on adding one more item. It will replace last one");
        lru.printLRUCache();
        System.out.println("Trying to insert existing key with new Value");
        lru.set(9, 27);
       	lru.printLRUCache();
        System.out.println("-------------------------------------------------------------------------------");
    }

}
