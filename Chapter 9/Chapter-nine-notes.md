# Notes from chapter 9

Java has two important areas of memory: The **Stack** is where all **method invocations and local variables** live, the **Heap** is where all **objects** live.

## Instance variables
They are **declared inside a class but not within a method**. They live inside the object they belong to.
```java
public class Cat {
    int numOfLegs; // Every cat will have a "numOfLegs" instance var
}
```
They live in the Heap, inside the object they belong to. If the variables are all primitives, Java makes space for them based on their primitive type. 

When making space for an instance variable that refers to an object but its still not initialized, the Heap doesn't need to make space for that object, just for its reference:
```java
public class Cat {
    private Food food;
}
```
Once we initialize that variable with a real object, the space will have to be created for it.


## Local variables
They are **declared inside a method**, including method parameters. They are temporary, and exist onlu while the method is being used (is on the stack).
```java
public void foo(int x) {
    int y = x + 7;
    boolean bol = false; // parameter x and variables y and bol are all local variables
}
```

## The Stack
When methods are called, these are put on top of a call stack. The new thing that is actually pushed onto the stack is the *stack frame*, which holds the state of the method including the line of code that is executing and the values of all local variables.

The method that is at the *top* of the stack is the one that is running at the moment. These methods will stay on the stack until they hit the closing bracket. If a method `eatFood()` calls the method `chew()`, the method `chew()` will be stacked on top of `eatFood()`.

If a local variable is a reference to an objec, only the variable (not the bject) goes on the stack.

## Object creation
The three steps for creating an object are:
* **Declaring a reference variable**
* **Creating an object**
* **Linking the object and the reference**

```java
Cat myCat = new Cat();
```
When we use the word *new*, we are calling the **constructor**, which has the code that runs when we instantiate an object. Every class has a constructor, even if we don't write it.

```java
public class Cat {
    public Cat() {
        System.out.println("Meow"); // Constructor code
    }
}

public class useACat {
    public static void main (String[] args) {
        Cat cat = new Cat(); // THis calls the Cat constructor
    }
}
```

To be able to tell if what we have in our class is a method or a constructor (as both are allowed to have the same name as a class), we need to look at the return type. Methods NEED to have a return type, constructors DO NOT have one.

```java
public Cat(){} // Constructor
public void Cat() {} // Method (but it should start with lowercase)
```

**CONSTRUCTORS ARE NOT INHERITED** by subclasses.

We can use the constructor to initialize state:

```java
public class Cat {
    int size;

    public Cat(int catSize) {
        System.out.println("Meow");

        size = catSize;
        
        System.out.println("size is " + size);
    }
}

____

public class UseACat {
    public static void main(String[] args) {
        Cat c = new Cat(25); // Pass a value to the constructor
    }
}
```

### No-arg constructors and overloaded constructors

Sometimes we will want a default value for our instance variables if the user doens't enter any values, in those cases, we will need two constructors:

```java
public class Cat {
    int size;

    public Cat(int catSize) {
      size = catSize; // Use catSize parameter
    }

    public Cat(int catSize) {
       size = 25; // Supply default size
    }
}
```
If we have **more than one constructor in a class**, it means that we have **overloaded constructors**.

If we **don't write any constructors**, the compiler will create a default no-arg constructor for us, but if we already have a constructor with an argument, the compiler will not create another no-arg constructor for us.

If we have **more than one constructor** in a class, the constructors **MUST have different argument lists** (different arguments or different order).

When we don't set a **default value on a variable**, it's given a default value of **0/0.0/false for primitives** and **null for references**.

Example of a class with multiple constructors, which means multiple ways of making an object of that class:

```java
public class Mushroom {
    public Mushroom(int size) {}; // We only know the size

    public Mushroom() {}

    public Mushroom(boolean isMagic) {} // We know if its magic but not the size
 
    public Mushroom(boolean isMagic, int size) {}

    public Mushroom(int size, boolean isMagic) {}
    // On the last two, they have the same arguments but a different order, so it is valid and will compile
}
```

Constructors can be *public*, *protected*, *private* or *default* (this means no access modifiers at all).

Four key things about constructors
* **A constructor is the code that runs when someone creates a new instance of a class**
* **It MUST have the same name as the class and NO return value**
* **If the class doesn't have a constructor, the compiler will place a no-arg default one**
* We can have **more than one constructor** in a class, as long as the **argument lists are different**. Having more than one constructor in a class means we have **overloaded constructors**.