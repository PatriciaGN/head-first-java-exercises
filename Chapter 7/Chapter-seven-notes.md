# Notes from chapter 7 - Inheritance and polymorphism

## Inheritance
```java
public void doSomething() {
    super.doSomething();
}
```

The parent class will not know of the methods in the child classes.

A subclass inherits members (including instance variables and methods) of a superclass. A superclass can decide which members it wants subclasses to inherit.

There are four main access levels, going from more to least restrictive:

Private -> default -> protected -> public

**Public** members **are** inherited, **private** members **are not**.
Therefore, a subclass will inherit all the public instance variables and methods, but none of the private ones, from a subclass.

**Inherited methods** can be **overriden**, **instance variables** cannot be overriden but they **can be redefined** in the subclass.

When a subclass inherits a member, it is as if the subclass defined this memeber itself.

If we **change the methods and instance variables** of a superclass and recompile it, **these will change them in all the subclasses** that extend that superclass (the subclasses don't need to be recompiled to be able to use the newest version).

Inheritance lets you guarantee that all classes grouped under a certain superclass have all the methods that this superclass has. We are therefore defining a common protocol for a group of classes related through inheritance.

### Inheritance rules

* USE inheritance when one class is a more specific type of a superclass. For example, Siamese is a more specific type of Cat.

* CONSIDER inheritance when there is a behaviour that should be shared among multiple classes of the same general type. Bear in mind that inheritance is not always the best way to achieve behavior reuse.

* DO NOT use inheritance so that you can reuse code if the relationship between classes violates one of the previous two rules. For example a Potato class shouldn't inherit from a Feline class, because a potato *is not* a feline.

* DO NOT use inheritance if the superclass and subclass don't pass the IS-A test. Always ask if the subclass IS-A class (if a Cat IS-A Feline).


## Polymorphism

When creating an object, we could do: `Cat Luna = new Cat();`, it is important that the reference type AND the object type are the same.
With *polymorphism*, these two types can be different, as long as the reference type is a superclass of the actual object type: `Animal Luna = new Cat();`

This allows to do things like **polymorphic arrays**:

```java
Animal[] animals = new Animal[3];
animals[0] = new Cat();
animals[1] = new Seal();
animals[2] = new Hedgehog();

for (Animal animal : animals {
    animal.makeNoise();
    animal.eatFood();
})
```
We have declared an array of the type Animal, but then put different subclasses of Animal as elements. 
We can then **loop** through this array and call the Animal-class methods on each of the elements.

We can also have **polymorphic arguments and return types**:

```java
class Vet {
    public void giveVaccine(Animal a) {
        // Give a vaccine to the animal referrenced by "a"
        a.makeNoise();
    }
}
```
The "a" parameter can take ANY animal as an argument, and its methods can be called.

```java
class ZooCarer {
    Vet vet = new Vet()
    Tiger tiger = new Tiger();
    Elephant elephant = new Elephant();
    
    vet.giveVaccine(Tiger); // Tiger makeNoise();
    vet.giveVaccine(Elephant); // Elephant makeNoise();
}
```

There are no private classes, but a class can be marked as **non-public** (if it's not declared as public). A non-public class can only be subclassed or used by classes in the same package.

Another thing that will prevent a class from being subclassed is the keyword **final**. This means that it's the end of the inheritance class and **can't be extended**. A particular method can also be marked as **final** and therefore **cannot be overriden**.

If a class has only **private constructors** it can't be subclassed either.

### Overriding a method

If we use the superclass as a reference to the subclass, and we call one of the subclasses methods, in order for it to work if it has been overriden, is that it has the **same arguments and return types**, otherwise, it **will not be an override**.

```java
class Animal
eat(String food);

class Cat
eat(int amount); // This is NOT an override
                 // It is a legal overLOAD, but NOT an overRIDE.
```

* **Arguments must be the same, and return types must be compatible (same type or a subclass type).**

* **The method can't be less accessible (but can be more)**. You can't override a public method and make it private.


### Overloading a method

It means having two methods with the **same name but different argument lists**. It doesn't involve any polymorphism.

This way, callers can have several methods to use with several data types as arguments, and don't need to convert this data types themselves.

* **The return types can be different**.

* **We can't ONLY change the return type**: If only the return type is different, it's not a valid *overload*, and the compiler assumes that you are trying to override the method but it won't be legal because the return type will be different. **WE MUST CHANGE THE ARGUMENT LIST**.

