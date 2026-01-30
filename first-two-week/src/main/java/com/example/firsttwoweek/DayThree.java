package com.example.firsttwoweek;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * functional interface:
 *  it has single abstract method in an interface and with functionalinterface annotation
 *
 *  common example:
 *  runnable, callable, consumer, Function class, supplier
 *
 * lambda  it is a concise way to implement an interface that has exactly one abstract method(functional interface)
 * scenario                      syntax                               note
 * no parameter         () -> System.out.print("hello")             no parameters need
 * one param            (a) -> a *a
 * multiple param         (a, b) -> a + b
 * multiple lines        (n) -> {int res = n * 2; return res;}
 *
 *
 * stream api
 *  it allows you to perform aggregate operations on collections(list....) of elements
 *
 *  intermediate functions
 *      allowing you to perform a series of chained operations on your data, like data in your collection
 *
 *      filter():only selects the elements that match given predicate
 *      map():transforms the elements of the stream into new type
 *      distinct(): removes duplicates
 *      limit(): truncates the stream to a specified size
 *      skip(): skips the first n element(s)
 *      ...
 *
 *
 *  terminal functions
 *          it is some operations that produce a result.
 *
 *          foreach(): loop over each elements
 *          reduce(): always return a single result
 *          collect(): collects the elements of the stream into a collection (hashmap -> list)
 *          min()
 *          max()
 *          count()
 *          anyMatch()
 *          Allmatch*(
 *          NonMatch()
 *
 *
 *
 * Collections vs stream api
 * collections are data structure that stores data in the memory
 * whereas stream api process  data and does not store data in the memory
 *
 * collections can be modified by adding, removing.... whereas stream api does modify the original data
 *
 * collections provides methods of accessing and iterating element whereas stream api
 * provides a set of operations that can be applied to a stream
 *
 *
 * optional: can avoid null pointer exception
 * class BankAccount{
 *     private Optional<Double> balance
 *
 * }
 *
 * isPresent() returns a boolean value.  some value != null  -> is there a value inside
 * if (balance.isPresent()){
 *     print(balance.get())
 *
 * }else{
 *     print...
 * }
 *
 * ifPresent(): it says" if a value exists, do this with it."
 * it takes a lambda expression as an argument. it a value exists, then do lambda, if no, nothing happens.
 *
 * Completable Future
 * Asynchronous computations
 *
 * task1 ------------------------------500 milis---------
 *      task2 ----------------------------500-------------
 *       task3------------------------500-------------------
 *      total 504
 *
 *
 *
 *      executors                                        executor                            executorservice
 *      utility class                                        interface                               interface
 *      use for creating thread pool                        the simplest way to execute a task      more functions that executor you can submit and stop task
 *
 * @FunctionalInterface
 * public interface Supplier<T> {
 *
 *     T get();}
 *
 *     public interface Consumer<T> {void accept(T t);}
 *
 *
 *
 *     method reference
 *     it is a short version of lambda expression
 *
 *     ClassName :: methodName <- method reference
 *     (args) -> ClassName.methodName(args) <- lambda
 *
 *     1: static method reference
 *     Integer::max
 *     Integer::parseInt
 *
 *     2: Instance method of a particular object
 *     object::instanceMethodName
 *     System.out::println()
 *
 *     3: instance method of an arbitrary object of a particular type
 *      className :: instanceMethodName
 *      String::toUpperCase
 *      String::toLowerCase
 *
 *      4: Constructor reference
 *      ClassName :: new
 *      ArrayList:: new
 *
 *      Java 17 new features
 *      Sealed class: allow you to say "only these specific classes are allowed to inherit from me "
 *
 *      public sealed interface Shape permits Circle, Square, Triangle{
 *          ....
 *      }
 *
 *      Record : you dont have to code for getters, setters, hashcode()...
 *      public record User(Long id, String firstName, String lastName, int age){}
 *
 *      switch statements
 *      you can now with switch statement based on the type of the object
 *      switch (car){
 *          case Integer
 *          case String
 *          case null
 *          default
 *
 *      }
 *
 *
 *      Java 21
 *      virtual thread (the game changer) it is managed by JVM, not the OS
 *
 *
 *
 *
 *
 */
public class DayThree {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Calculator calculator = (a,b) -> a + b;
//        int res = calculator.calculate(1,1);
//
//        List<String> list = Arrays.asList("a1", "a2", "b1", "b2", "c4", "c3", "c1","c99");
//
//        list.stream().filter(s->s.startsWith("c"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);
//
//        List<String> list1 = Arrays.asList("THis", "is", "a", "My", "firST", "time", "To", "use", "stream API");
//
//        List<Integer> numbers = Arrays.asList(3,4,65,7,8,33,5,7,8);
//        Integer max = numbers.stream().reduce(Integer::max).get();
//        System.out.println(max);
//
//        numbers.parallelStream().map(number -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Number is " + number + " thread name is " + threadName);
//            return number * number;
//        }).forEach(result -> System.out.println(result));



//        long startTime = System.currentTimeMillis();
//        // task 1
//        try{
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        //task 2
//        try{
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        //task 3
//        try{
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("Total time is " + (endTime - startTime));

//        ExecutorService threadpool = Executors.newFixedThreadPool(3);
//
//        long startTime = System.currentTimeMillis();
//
//        FutureTask<String> task1 = new FutureTask<>(()->{
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task1";
//        });
//        threadpool.submit(task1);
//        FutureTask<String> task2 = new FutureTask<>(()->{
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task2";
//        });
//        threadpool.submit(task2);
//        FutureTask<String> task3 = new FutureTask<>(()->{
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task3";
//        });
//        threadpool.submit(task3);
//        try{
//            task1.get();
//            task2.get();
//            task3.get();
//        }catch (InterruptedException | ExecutionException e){
//            e.printStackTrace();
//        }
//
//        long endTime =System.currentTimeMillis();
//        threadpool.shutdown();
//        System.out.println("Total time is " + (endTime - startTime));



        CompletableFuture<Void> completableFuture  = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        System.out.println(completableFuture.get());
        ExecutorService threadpool = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> completableFuture1  = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },threadpool);
        System.out.println(completableFuture1.get());

        Executors.newVirtualThreadPerTaskExecutor();




        // three example about thenApply, thenAccept, thenRun()...





    }
}


@FunctionalInterface
  interface  Calculator{
    int calculate(int a , int b);
}
