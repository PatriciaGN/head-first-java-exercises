# Notes from chapter 8 - Interfaces and abstract classes

## Abstraction

An **interface** is a class that is 100% abstract and can't be instantiated, and therefore its only purpose is to be **extended** (there is the exception of these classes *static members*).

Sometimes, we won't want the superclasses to be instantiated, we only want them for inheritance and polymorphism. We wouldn't want *Animal* objects, but *Cat*, *Tiger* and *Seal* objects. If we mark the class with the word **abstract**, the compiler will stop us from creating new objects of that class.

When designing the class inheritance structure, we need to decide which classes will be **abstract** and which will be **concrete** (these can be instantiated). 

```java
abstract class Feline extends Animal {
    public void eatFood(){}
}
```

**Abstract methods** have **no body**, since it's already decided there isn't any code that would make sense. So it doesn't have curly brackets:
`public abstract void eatFood();`

**If we declare an abstract method, the class MUST be abstract as well, but we can mix abstract and non-abstract methods in an abstract class.**

The point of an abstract method, is that even though we haven't put any actual code into it, we've still defined part of the *protocol* for a group of subclasses.

**ALL abstract methods MUST be implemented**. This means the first *concrete* class in the inheritance tree must implement ALL abstract methods. This means that we need to give those methods *a body*. We must **create a non-abstract method** in the class with the **same method signature** (*name* and *arguments*), and a **return type** that is compatible with the declared return type of the abstract method.


_______________________

**Every class in Java extends class Object**. Class Object is the superclass of everything, and the compiler asumes that any class that doesn't extend another class, extends class Object and inherits all of its methods.

Some of these methods can be overriden, some others are marked as *final*. We are strongly encouraged to override `hashCode()`, `equals()` and `toString()` in our own classses.

The Object class serves two main purposes:
* **To act as a polymorphic type for methods that need to work on any class**. We could use it as a polymorphic argument and return type.
* **To provide real method code that all Java objects need at runtime**.

If were to try and use the Object class in the following way:
```java
Object cat = new Cat();
cat.eatFood(); // Not legal!
```
It wouldn't even make it past the compiler. We would only be able to use methods from the class Object.

```java
ArrayList<Object> myCatArrayList = new ArrayList<Object>();
Cat aCat = new Cat();
myCatArrayList.add(aDog);
Cog d = myCatArrayList.get(0); // Won't compile, because it returns type Object, so the compiler doesn't know this object is a Cat object.
```

If we make an `ArratList<Object>` and put Cat objects inside it, these Cat objects will come out as a reference of type Object, regardless of what the actual object type is.

So the problem with having everything treated polymorphically as an Object is that the objects appear to lose their true essence.

```java
Cat cat = new Cat(); // The compiler knows that we are referencing a class Cat and therefore, we will be able to use the methods of this class, including the methods inherited from class Object.

Object theCat = cat; // The compiler only knows we are referencing an Object class, so we will only be able to use the methods of the class Object.
```

### Casting an object reference back to its real type

If we had stored a reference to a Cat object into an Object type reference, we are still able to retrieve its original type so that we can use its methods.

```java
Object theCat = al.get(index);
Cat cat = (Cat) theCat; // Cast the Object back to a Cat we know is there
cat.eatFood();
```

If we are not sure the Object is a Cat, we can use the `instanceof` operator. If we are wrong when doing the cast, we'll get a ClassCastException at runtime:
```java
if (cat instanceof Cat) {
    Cat cat = (Cat) theCat;
}
```

**IMPORTANT: Remember that the compiler checks the class of the reference variable, not the class of the actual object at the other end of the referrence**

## Multiple inheritance
**Multiple inheritance** is not allowed in Java, due to a problem known as "The Deadly Diamond of Death".

If a subclass inherited from two superclasses that have the same methods that do different things, the compiler wouldn't know which of the methods it has to use. We would need special rules to deal with these ambiguities.

### Interfaces
Java gives us a solution for these problems, called **interfaces**. We are not talking of a GUI, but the Java keyword `interface`.

These interfaces solve the multiple inheritance problem by giving us the polymorphic benefits of multiple inheritance without the potential problems they can bring.

These interfaces **make all the methods abstract**, this way, the subclass **MUST** implement those methods (abstract methods must be implemented by the first concrete subclass), so the JVM know which of the two inherited versions it it supposed to call.

**A java interface is like a 100% pure abstract class**

To **DEFINE** an interface:

```java
public interface Pet {
    public abstract void beFriendly();
    public abstract void play();
}
```

To **IMPLEMENT** an interface:


```java
public class Cat extends Feline implements Pet {
    public abstract void beFriendly() {...};
    public abstract void play() {...};

    public void eatFood() {...};
}
```

We use the keyword "**implements**" followed by the interface name. Note that when we implement an interface, we can still extend a class.


**AS A SUMMARY**: A class can **only have one superclass**, but **implement multiple interfaces**.

### When to make a class, subclass, abstract class or an interface
* When a class doesn't pass the IS-A test for any other type, it **shouldn't extend anything**.
* When we need to make a more specific version of a superclass and override or add new behaviours, we will make a **subclass**.
* When we want to define a template for a group of subclasses and we have some implementation code that all of them could use, we will make an **abstract class**. This will make sure nobody can make objects of that type.
* When we want to define a role that other classes can play, regardless of where they are in the inheritance tree, we will make an **interface**.

## Invoking the superclass verion of a method

Sometimes, we will need to override and extend the behaviour of a particular superclass' method. In cases where we need to use the superclass' method, we can use the keyword "**super**" to invoke it.

```java
abstract class Feline {
  void eatFood() {...}
}

class Cat extends Feline {
  void eatFood() {
    super.eatFood(); // Call superclass version of the method
    ...
  }
}
