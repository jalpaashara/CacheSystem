# Cache System

The project Cache System covers the following features:   
- LRU cache

## LRU
The way LRU cache works is as follow:
- If a resource exists in the cache, return immediately.
- If not and the cache has extra storage slots, we fetch resource and return to the client. In addition, insert it into the cache.
- If the cache is full, remove the resource that is least recently used and replace it with the new resource.
The strategy here is to maximum the chance that the requesting resource exists in the cache.

## LRU design
An LRU cache should support the operations: lookup, insert and delete. In order to achieve fast lookup, I have used **hashtable** with resource identifier as key and the corresponding queue node as value. By the same token, to make insert/delete fast, I have used linked list. Since we need to locate the least recently used item efficiently, I have used **queue implementation of doubly linked list** to store all the resources. 

**Below is the algorithm:**
- When resource A is requested, check the hashtable to see if A exists in the cache. 
- If exists, immediately locate the corresponding queue node (i.e. the value in the hash table) and return the resource.  and simultaneously move the queue node to the head of the list.
- If not, if there is enough space, add the queue Node to the end of the queue and update the hashtable. 
- Otherwise, delete the least recently used entry. To do that, remove the node at the tail of the list and add the new resource to the head of the list and correspondingly remove the old resource from the hashMap and add the new resource.

Files introduced:
- QNode.java
- LRUCache.java
- LRUCacheTester.java

----------------------------------------------------------------------------------------------------------------------------------------
   
## SETUP:   
Importing Project into eclipse:    
	1. Create a new Java Project in your workspace   
	2. Import the files:   
	  File -> Import -> Select "File System" -> Next -> Browse and set root directory to folder contents of zip were extracted to -> Finish   
  
* Feel free to use another IDE or manually compile and run your programs.   
