package com.example.firsttwoweek;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS
 * what is CAS?
 * it stands for compare and swap, witch is type of atomic operation in java concurrency programming language.
 *
 * what is atomic operation?
 * it is an unit of operation always execute together or none of them executes.
 *
 * CAS has three components:
 * 1: V: memory location: the address of the variable to be updated
 * 2: A: expected value: what the thread thinks the current value is
 * 3: B: new value: the value the thread wants to write.
 *
 * why use CAS instead of synchronized?
 *
 * bc synchronized keyword has performance bottlenecks, it is pessimistic locker
 *
 * CAS is optimistic.
 *  wait- free: threads do not get block/ suspended by the OS
 *  high performance.
 *
 *  operation of CAS: I think V should have the value A, if it does, change it to B, otherwise, do not change it.
 *
 *
 * ABA problem:
 * Thread 1 reads value A
 * thread 2 changes value A to B, then back to A
 * thread 1 performs CAS, sees A, and think nothing has changed, even though the state was modified in between.
 *
 * AtomicStampedReference class can solve ABA problem..
 *
 *
 * Blockingqueue
 * it is thread -safe queue that does more than just store values.
 * Producer - consumer pattern.
 * blocking:
 *  wait to add: when your queue is full and you want to add more elements into your queue, you have to wait util there is one slot
 *  wait to remove: when your queue is empty and you still want to remove more elements from the queue, you have to wait util there is one element
 *
 *  two points: put, remove
 *  put and remove points are pointing index 0 at the first time before inserting.
 *  [] [] [] [] [] []
 *
 *  when you put one value
 *  put point ++ -> pointing index 1
 *  [remove] [put] [] [] [] []
 *  you are inserting 6 values
 *  [1] [2] [3] [4] [5] [6]  -> put pointer is pointing index 5 and remove still pointing index 0
 *  if you are removing values from your queue
 *  [] [2] [3] [4] [5] [6] -> put pointer isn pointing index 5 and remove is pointing index 1
 *
 *
 * the disadvanages of synchronized keyword
 *  1: decreased performance
 *  2: deadlock
 *  3: difficulty in debugging: you do not the root cause of issues.
 *
 *  what are thread pools you have
 *  Executors  -> creating thread pools
 *
 *  fixed - size thread pool: 10 threads
 *  cached thread pool : no limitation to number of threads.  create new thread as you needed, and reuse idle threads when
 *  they are available, if a thread is not used for a specified time, then it will be terminated.
 *  single - thread pool: only one thread.
 *  fork join pool:
 *   key concept: can be used for dividing large tasks into smaller sun-tasks that can be executed in parallel.
 *
 *
 *
 * what is java reflection?
 * it allows you access class variables, functions, modifier, constructors and more while you code is executing.....
 *
 * it is very useful tool when you developing your framework: springboot, vscode, Intellij, unit testing, orm, AOP...
 *
 */
public class Day5 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        int expectedValue = 0;
//        int newValue = 1;
//        System.out.println("The result is " + atomicInteger.compareAndSet(expectedValue, newValue));

//        ProducerConsumer producerConsumer = new ProducerConsumer();
//
//        Thread producer = new Thread(()->{
//            try{
//                producerConsumer.produce();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//        Thread consumer = new Thread(()->{
//            try{
//                producerConsumer.consume();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//
//        producer.start();
//        consumer.start();

        Class studnet1 = Student.class;
        //Class student2 = Class.forName("path of your class")

//        Constructor constructor = studnet1.getDeclaredConstructor(String.class);
//        constructor.setAccessible(true);
//        Object obj = constructor.newInstance("Yao");


        // public
        Constructor[] constructors1 = studnet1.getConstructors();
        for(Constructor cons : constructors1){
            System.out.println(cons.getName());
        }


        //private
        Constructor[] constructors2 = studnet1.getDeclaredConstructors();
        for(Constructor cons : constructors1){
            System.out.println(cons.getName());
        }

        Field[] fields = studnet1.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field);
        }





    }
}

class Student{
    private String firstname;
    private String lastName;
    private int age;
    private Student(){
        System.out.println("Hello ,I am a private constructor");
    }

    public Student(String firstname, String lastName, int age){
        this.firstname =firstname;
        this.lastName = lastName;
        this.age = age;
    }
    public Student(String firstName){
        this.firstname = firstName;
    }

    public void setAge(int age){
        this.age = age;
    }
    public void setFirstname(){
        this.firstname = firstname;
    }
    public  void  setLastName(){
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

}

class ProducerConsumer{

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() throws  InterruptedException{
        int value = 0;
        while(true){
            System.out.println("Produce " + value);
            queue.put(value++);
        }
    }

    public void consume() throws  InterruptedException{
        while (true){
            if(queue.size() == 10){
                int value = queue.take();
                System.out.println("consume " + value);
                Thread.sleep(1000);
            }
        }
    }


}
