package com.example.firsttwoweek;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Collections in java
 * Array vs arraylist : array len is fix whereas arraylist is variable len
 *
 * RandomAccess : this interface supports random access and retrieve any random element in the array list at the same speed
 * if you have 1 m data in array list,  -> get -> 10th element -> speed =  9999999 element
 * whenever you new an arraylist -> the size of your arraylist = 10? 0? any number?  Answer 0, before you adding any elements into your arraylist
 * ArrayList<Integer> mylist = new ArrayList<>();
 * myList.add(1) ->
 * as long as you add one element into your array list, then the size is 10
 *
 * add() function in arraylist
 *      modCount++
 *      add(e, elemenData, size) -> add operation here
 *
 *
 * add(e, elemenData, size) -> check size ==  elementData.lenth() , if yes, then increase size = grow() else add element to your index ->
 *              elementData[s] =e;
 *           size = s +1;
 *
 *  new cap = 1.5 * old
 *
 *   modCount++
 *   fail fast ->  has exception. modCount++
 *   and fail safe -> no exception.
 *
 *   add(index, element) the best case O(1), worst case O(n)
 *   get() O(1)
 *   remove() O(n)
 *   contains() O(n)
 *   ...
 *
 *   stack + vector
 *   stack extends vector
 *   push() Pop(), szie() O(1)
 *   new = old + cap increment
 *
 *   Linkedlist + deque
 *
 *   the underlaying linkedlist uses a double linked list data structure
 *   not tread safe. does not support random access, you are not allowed to use index to access data.
 *
 *   linkedlist
 *   add() = O(1)
 *   add(index, e) = O(N)
 *   get() = N
 *   remove(index) = N
 *
 *   deque: double ended queue, which means that we can use deque as stack(FILO) and queue(FIFO)
 *   Deque<String> de</String>
 *
 *  PriorityQueue
 *  in java .. the default priority queue is min heap. the lowest value is the first one
 *  what is underlaying data structure pq using now? hashmap? array? arraylist? somethign else? it using array
 *
 *  [1,2,3,4,5,6,7,8,9..]
 *  leftNo = parentNo * 2 + 1
 *  right number = parent No * 2 + 2
 *
 *  parent Number = (node number - 1) /2
 *
 *                  1
 *          2               3
 *       4      5.    6            7
 *       ..
 * siftUp: min number or max number
 *
 * add() O(log(n)) = delete
 * peek O(1)
 * seize O(1)
 *
 * hashmap: key value data structure.
 * key.hashcode()
 * 1111 1111 1111 1111 1111 0000 1110 1010
 * 0000 0000 0000 0000 1111 1111 1111 1111  h >>> 16
 *
 * 1111 1111 1111 1111 0000 1111 0001 0101 exclusice OR
 *
 * (n - 1) & hash
 * 0000 0000 0000 0000 0000 0000 0000 1111
 * 0000 0000 0000 0000 0000 0000 0000 0101 -> 5 = 2^2 + 2^0 = 4 + 1 = 5
 *
 * resizing: since java 8 -> hashmap use linkedlist + red-black tree
 * resizing :
 * linkedlist -> red and black tree: this happens when a bucket contains more than 8 nodes. it resize from linkedlist to red - back tree
 *
 * red - black tree -> linked list: this happens when the number of nodes in a tree drops to 6 or fewer.
 *
 * the process of put function:
 *      1: calculating hash value and find the index where we should put
 *      2: if there is null(no hash collision), then hashmap stores it
 *      3: if there exits hash collision. hashmap do the this
 *          3/1: if  hashmap is using tree, then call tree insertion method to put
 *          3/2: if not tree, then put the value into linked list
 *              hashmap will check the len of linkedlist, if len > 8, change to tree
 *       4: if there exits duplicate key, then replace the value
 *       5: check the size.
 *
 *
 *    insertion = O(1)
 *    deletion = O(1)
 *
 *    search = O(1)
 *    ...worst case for all = O(n)
 *
 *    Tree map = hashmap, but the elements are stored in some order
 *    cmp = k.compareTo(t.key)
 *
 *    concurrent hashmap
 *    thread safe
 *    concurrent hashmap has locker. does not allow null key
 *
 *    hash set
 *    it is a wrapper around a hashmap
 *
 *    hash set does not allow duplicate elements
 *    allows one null element
 *
 *      O(1)
 *    tree set
 *     does allow null,
 *        O(log(n))
 *
 */
public class DayTwo {
    public static void main(String[] args) {
        Deque<String> deque =  new LinkedList<>();
        Deque<String> deque1 = new ArrayDeque<>();

        // leetcode: build stack using deque

    }
}
