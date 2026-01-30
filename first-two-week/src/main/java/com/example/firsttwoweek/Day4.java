package com.example.firsttwoweek;

/**
 *JVM stands for java virtual machine.
 * it has three components:
 *  class loader: loading .class file
 *  runtime data areas: store values  it is a memory
 *  execution engine: executing your code from .class file
 *
 *
 *
 *  Memory area(shared):  this is used to store class and method data, such as class and method definition, constant,...
 *
 *  heap: new Day4() -> you are creating an object -. where to store  and manage it?
 *   new created objects will be located in this memory and managed by GC(garbage collection)
 *
 *   stack: used to store data for method invocation  like method arguments, and return value
 *
 *
 *   heap: it has young generation old generation and metaspace
 *
 *   young generation: stores all new created objects
 *      eden space: main area to store all new created objects.
 *      survivor space 1
 *      survivor space 2
 *
 *     old generation: this place to store old objects(after GC execute a lot times)
 *     matespace: store class metadata, like class definitions, method definitions....
 *
 *     the gc root method is optional to know,
 *
 *     gc roots can be used to determine you objects alive or dead( remove from gc)
 *
 *     1 core algo: mark and sweep
 *     how it works
 *      mark: the gc identifies which objects are in use
 *      sweep: it removes unused objects to free up space.
 *      fragmentation: [[.     ] .[..] .. [.]]
 *
 *     mark and seep and compact
 *     how it works
 *  *      mark: the gc identifies which objects are in use
 *  *      sweep: it removes unused objects to free up space.
 *         compact: sort your memory -> [[.     ][..] [.]...]
 *
 *      stop-the-world: your entire system will be stop during gc running
 *
 *      cms
 *      initial mark(stw): pauses your app to mark root objects, this is very fast
 *      concurrent mark: do another mark while you app is running
 *      remark(stw) a third mark and short pause your app
 *      concurrent sweep: it removes the dead objects.
 *
 *      G1
 *
 *
 *
 *      threading:
 *      3 ways to create a thread
 *      1: extends thread class
 *              class MyThread extends Thread{
 * @Override run()
 *              }
 *
 *       2: implements runnable class
 *
 *       3: implements callable class
 *
 *
 *      thread states
 *       new: thread is created and now start yet
 *       runnable a thread in this state is running in the JVM
 *       blocked: thread is blocked for resources (monitor lock).
 *       waited: waiting, timed wating
 *       terminated
 *
 *       wait() function in thread: is a method that can be called by a thread to give up its hold on a shared resources
 *       and wait untile another thread notifies(call notify()) it to wakte up.
 *
 *       sleep():  is a method that can be called by a thread to temporarily suspend its execution(do not give up shared resources)
 *       it does not release the cpu
 *
 *      run  vs start() function in thread
 *      run(): it does not create a new thread, will use current thread(usually the main thread that created by main function)
 *      start():this method will trigger the multithreading machinery.  it creates a brand new thread .
 *
 *      volatile!!!!!!!!!!!!!!!
 *      make sure there is way to communicate between different treads
 *      thread A                                    thread B
 *
 *      local memory                                local memory
 *      shared resource A replica                      shared resource A replica
 *
 *
 *
 *      main memory
 *      shared resource A , B ,C ......
 *
 *
 *      prevent to reordering
 *
 *      without volatile case
 *      int a =0. < -  int c = 2.
 *      int b = 1;
 *      int c = 2.   <- int a =0
 *      int d = a +b
 *      int e =b +c
 *      what you will get after compiling
 *      int c
 *      int b
 *      int a
 *      int d
 *      int e
 *
 *      with volatile case
 *
 *      volatile int a
 *      volatile int b
 *      volatile int c
 *      what you will get after compiling
 *
 *       volatile int a
 *  *      volatile int b
 *  *      volatile int c
 *
 *
 *
 *  synchronized: you can control access to shared resources in a multithreading env
 *  it prevents race condition - situations where multiple threads try to modify the same data at the same time
 *  leading to corrupted data or unexpected errors
 *
 *  without sync
 *  thread A read your bank account balance -> 100
 *  thread B read your bank account balance -> 100
 *  thread A adds 10 to your bank -> 110 and saves it
 *  thread B subtracts 10 (new balance is 90) and saves it -> finnaly your bank account balance is 90
 *
 *  with sync
 *
 *   thread A read your bank account balance -> 100
 *   thread B read your bank account balance -> 100
 *   thread A adds 10 to your bank -> 110 and saves it
 *   thread B subtracts 10 (new balance is 90) and check the new balance value before save it (110) do subtract by 10
 *    -> 100
 *
 *
 *    synchronized:
 *    pessimistic locker
 *          whenever I try to access data, someone else definitely try to modify it at the same time.
 *          therefore, I must lock it, no one else cannot touch it utile I finish
 *
 *     optimistic locker
 *     no one will fight me for this data, I won't lock anything, I will just do my work
 *     and rifht at the end. I will check if anyone else modified the date while I was working.
 *
 *     deadlock for synchronized
 *     thread 1 holds lock A and wants lock B
 *     thread 2 holds lock B and wants lock A
 *
 *
 *     better ways(alternatives)
 *     reentrant locker
 *     readwrite locker
 *     atomic variable
 *
 *
 *     question: can you create a class that your integer increase by one when you can increase function?
 *     class UnsafeCounter{
 *
 *         private int count =0;
 *         public void increse(){
 *             count++;
 *         }
 *         public int getCount(){
 *             return count
 *         }
 *     }
 *     class SafeCounter{
 *         private final AtomicInteger count = new AtomicInteger(0);
 *         pulic void increase(){
 *             count++;
 *         }
 *         public int getCount(){
 *  *             return count
 *  *         }
 *
 *     }
 *
 *
 *
 *
 *
 *
 */
public class Day4 {
    public static void main(String[] args) {
        System.out.println("hello there");

    }
}
