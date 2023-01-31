# Notes from chapter 9 - Constructors and garbage collection

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

## Object creation and constructors
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

### Inheritance and constructors

When an object is created, it will have its own instance variables and **those from the superclasses it inherits from**, even if they are encapsulated.

**All the constructors in an object's inheritance tree must run when we make a new object**.

Even when a class is abstract and we can't create a new instance of it, an abtract class is still a superclass, so its constructor runs when someone makes an instance of a concrete subclass.

Even if a superclass has instance variables that the subclass doesn't inherit (because they are private) the subclass still depends on the superclass methods to *use* those variables.

Example:

```java
public class Feline {
    public Feline () {
        System.out.prinln("Making a Feline");
    }
}
__________________

public class Cat extends Feline {
    public Cat() {
        System.out.println("Making a Cat");
    }
}
_________________

public class TestCat {
    public static void main(String[] args) {
        System.out.println("Starting...");
        Cat cat = new Cat();
    }
}
// Output:
// % java TestCat
// Starting...
// Making a Feline
// Making a Cat
```
*What is happening?*

1. When a new subclass is created, the Cat's constructor goes into a stack frame at the top of the stack. 
2. Cat() invokes the superclass constructor, which pushes the Feline() constructor onto the top of the stack.
3. Feline() invokes the superclass constructor, which pushes the Object() constructor onto the top of the stack.

The correct way of calling the superclass constructor would be:
```java
public class Cat extends Feline {
    int size;

    public Cat(int newSize) {
        super(); // This would be the right way of calling the  
                 // superclass constructor, but if we don't, the 
                 // compiler does it automatically
    }
}
```

Same as a child cannot exist before the parents, **the superclass parts of an object has to be completely built before the subclass parts can be constructed**.

The **call to super()** **MUST be the FIRST** statement in each constructor (with an exception that will be explained later on), or be left for the compiler to put.

We can also pass arguments on the super() call if the superclass needs them to instantiate:

```java
public abstract class Animal {
    private String name; // ALL animals, including subclasses, have a name

    public String getName(){
        return name;   // A getter method that Seal inherits
    }

    public Animal(String theName) {
        name = theName;
    }
}
__________________

public class Seal extends Animal {
    public Seal(String name) { // Seal constructor takes a name
        super(name);  // It sends the name up the Stack to the
    }                 // Animal constructor
}
__________________

public class MakeSeal {
    public static void main(String[] args) {
        Seal s = new Seal("Sally");
        System.out.println(s.getName()); // Prints Sally
    }
}
```

### Invoking one overloaded constructor from another

* We can use "__this()__" to call a constructor from another overloaded constructor in the same class.
* The call to "**this()** can be used only in a constructor, and MUST be the FIRST statement in a constructor.
* Constructor can have a call to **super()** OR **this()**, but never both!.

```java
import java.awt.Color;

class Daffodil extends Flower {
    private Color color;

    public Daffodil() {  // The no-arg constructor supplies a default
        this(Color.YELLOW); // Color and calls the overloaded REAL 
    }                     // Constructor (the one that calls super())
    
    public Daffodil(Color c) {  // This is The REAL Constructor that 
        super("Daffodil");  // does the REAL work of initializing the
        color = c;          // object (including the call to super())
        // ...
    }

    public Daffodil(int petals) {
        this(Color.YELLOW);  // THIS WON'T WORK!! Can't have both
        super(petals);  // super() and this() in the same constructor
    }                   // because both of them need to be first
}
```

## Object's life

An object lives as long as it's references are still "alive". The life of these references depends on whether the variable is a *local* variable or an *instance* variable:
* A **local variable** lives only within the method that declared it, and the variable scope is only within that method.
* An **instance variable** lives as long as the object does.

When a method with local variables calls another, the latter is put on top of the stack
* The **local variables** of the method **on top** of the stack are **alive** and **in scope**. 
* The variables of methods that are on other positions of the stack, are **alive** but **not in scope**.
* Once the method completes and is removed from the stack, its variables **not alive or in scope**

Local variables are only **in scope** within their own method. We can only use that variable when its method is on top of the Stack.



