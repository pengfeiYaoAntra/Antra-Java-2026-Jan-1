package com.example.firsttwoweek;

/**
 * Day 1
 * OOP
 *  1: polymorphsim:
 *      it means: one name, many behaviors (many types)
 *      in java it means, the same method name  behave differently depending on the situation.
 *      Overloading vs overriding  in java
 *      1: Overloading (compile time poly...): the same method name, but different variables: such as the number of variables, types...
 *              this happens within the same class
 *              class Calculator{
 *
 *                  int add(int a, int b){ return a + b}
 *                  int add(int a, int b, int c) {return a + b + c}
 *              }
 *       2: Overriding(runtime poly...) it happens in a child class, child class would like to inheritancce some parent's feature or function.
 *
 *       can data members be overriden? no,
 *
 *    2: Encapsulation :
 *       it means an object protects it own data and controls how that data is accessed or modified
 *
 *    3: abstraction
 *      interface vs abstraction class ; see below
 *      when to use an abstract class
 *      1: classes are closely related to each other
 *      2: you want to share code (fields, methods)
 *      3: you need constructor or protected members
 *      4: you expect subclass to extend behavior
 *
 *      when to use an interface
 *      1: you want to define a capability
 *      2: classes may be unrelated to each other
 *      3: you want to support multiple inheritance.
 *
 *    4:Inheritance
 *      classes can be created from parent class. : code reusability
 *
 *      the diamond problem
 *
 *
 *      primitive type vs wrapper type -> wrapper types offer more functions that you can use it
 *
 *      primitive: int, long, float, double
 *      wrapper : Integer, Float, Double
 *
 *      Integer wrapper : range[-128, 127]; any numbers under this range  are cached
 *
 *      autoboxing vs unboxing
 *      autoboxing: it is the aotumatic conversion of a primitive type
 *          int -> Integer
 *          int a = 1;
 *         Integer boxedA = Integer.valueOf(a)
 *      unboximng : change wrapper type to primitive type
 *          Integer -> int
 *          int unboxedB = i1.intValue();
 *
 *          Integer value = null
 *          int n = value <- this does not work
 *
 *
 *
 *     String vs StringBuilder vs String Buffer
 *      String: immutable class, whereas stringbuilder and string buffer are mutable
 *      Stringbuilder is not thread safe, whereas string buffer is thread safe
 *
 *
 *      modifier        same class      same package            subclass            world
 *      public              Y               Y                       Y                   Y
 *      Protected            Y              Y                       Y                   N
 *      default             Y               Y                      N                    N
 *      private             Y               N                       N                   N
 *
 *
 *      "this" vs "super" keywords
 *
 *      this:
 *          1: refers to current class instance variables
 *          class Person{
 *              String name;
 *              Person(String name){
 *                  this.name = name
 *              }
 *          }
 *          2: call current class methods
 *             class Person{
 *  *              String name;
 *  *              Person(String name){
 *  *                  this.name = name
 *  *              }
 *                 void showName(){
 *                     this.display();
 *                 }
 *
 *                  void display(){System.out.print("hi this is my name" + name)}
 *  *          }
 *          3: call another constructor in the same class
 *          class Person{
 *  *              String name;
 *  *              Person(String name){
 *  *                  this(name, 18)
 *  *              }
 *                 Person(String name, int age){
 *                     this.name = name;
 *                     this.age = age;
 *                 }
 *  *          }
 *
 *          4: can be used to pass current object as a parameter
 *          class Person{
 *  *              String name;
 *  *              Person(String name){
 *  *                  this.name = name
 *  *              }
 *              void call(){
 *                  show(this)
 *
 *              }
 *              void show(Person person){
 *                  print("this is my person class" + person.name)
 *              }
 *  *          }
 *      5: you can return "this"
 *              chianing function with return this keyword
 *              person.setName("Matthew").setAge(28).setCompany("Antra")
 *              setName(String name){
 *                  this.name = name;
 *                  retur this;
 *              }
 *
 *          class Person{
 *  *              String name;
 *                  Person Person(){
 *                      return this;
 *                  }
 *  *              Person(String name){
 *  *                  this.name = name
 *  *              }
 *  *          }
 *
 *
 *      super:
 *      1: points to parent object
 *      2: call parent's functions
 *      3: call parent's constructors
 *
 *
 *      Does Java use pass by value or pass by reference? 0x123456
 *      Java uses pass by value;
 *      for a primitive type, like int, char, double... the actual value is passed like 1.1, 1, 'a'
 *      for an object, the value of the parameter contains a reference to an object. the value of reference like 0x123456
 *      is passed to the method.
 *
 *      original object -----> passed to a method ----> new object
 *      original object and new object are pointing the same address : Ox123456
 *
 *      shallow copy vs deep copy
 *          shallow copy: original object and copied object are pointing to the same address
 *          deep copy: original object and copied object  are pointing to the different address.
 *
 *
 *       static and non static
 *       static: can be used with variable, classes, blocks and method
 *       it means that this variable, block, method belong to class itself.
 *       facts about static
 *          non static variable cannot be accessed within the static class
 *          all static are nested classes
 *          a static class or method is shared. it may has concurrence problem
 *
 *      error vs exception
 *
 *          checked vs unchecked exception
 *              checked: happens in compile time. ClassNotFoundException
 *              unchecked: happens in runtime: IndexOutOfBounds
 *              try catch finally
 *              can we do try and finnaly blocks without catch block? yes
 *
 *
 *       Generic
 *       it allows you to write type safe, reusable code by parameterizing types
 *       T - Type: represents any type
 *       E - Element: can used in any collections...
 *       K - key : maps - key
 *       V - value: maps - value
 *       N - number: used when you want to have number like long, double, integer...
 *
 *
 *       different level:
 *       class level:public class HashMap<K,V> extends AbstractMap<K,V>
 *       method level: private T random();
 *
 *
 *       bounded type
 *       class Calculator<T extends Number>
 *
 *       upper bounded wildcard
 *       <? extends T>
 *           used when a method reads/ produces data. you cannot add elements safely
 *           for(Number n : list){
 *               print(n)
 *               //n.add(1) this not allowed
 *           }
 *
 *         lower bound wildcard
 *         <? super T> used when a method writes/consumes data
 *         list.add(1)
 *
 *         generic can be used with interface.
 *
 *
 *
 *
 */
public class DayOne {
    public static void main(String[] args) {

        Integer i1 = 12;
        Integer i2 = 12;
        System.out.println(i1 == i2);

        Integer i3 = 333; // 0X123456
        Integer i4 = 333; // 0X123459
        System.out.println(i3 == i4);// comparing address

        System.out.println(i3.equals(i4));// comparing values

    }
}

abstract  class absClass{
    String myName = "Matthew";
    // can we have constructor?
    public absClass(String myName){
        this.myName = myName;
    }
    // can we have method with a body
    void thisIsMethod(){
        System.out.println("Hey, I am a method body");
    }
    // can we have method without a body
    abstract void thisIsAnotherMethod();
}

interface  interfaceClass{
    // the vairbale(s) you define in the an interface class,  they are public static and final by default
    public static  final String  myName = "";
    // can we have method without a body
    void thisIsMethod(); // default is abstract and public, not body
    default void thisIsDefault(){
        System.out.println("hi this is defautl method"); // yes, but only your version is after java 8
    }
    static int add(int a, int b){
        return a + b; // yes, but only your version is after java 8
    }
    private int mul(int a, int b) {
        return b * a; // yes after java 9
    }
}

