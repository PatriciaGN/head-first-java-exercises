# Notes from chapter 11 - Data Structures: Collections and Generics

So far, to declare ArrayLists we have used the following syntax:

`ArrayList<String> songs = new ArrayList<String>();`

But most of the time, we do not need to put the data type twice, so we can write this instead:

`ArrayList<String> songs = new ArrayList<>();`

This syntax is called the "diamond operator".

On the Jukebox exercise from this chapter we declare an ArrayList like this:

`List<String> songs = new ArrayList<>();`

We have assigned the ArrayList to a List reference (ArrayList IS-A List) and we create an ArrayList but returned a List from the method. This is one of the advantages of polymorphism, our method doesn't need to know which type of List to be able to use List methods on it. It is usually safer to pass the **interface type** (List) around instead of the implementation.

## **Exploring the java.util API, List and Collections**

Some exerpts from the API:
* **java.util.List**  `sort(Comparator)`: Sorts this list according to the order induced by the specified **Comparator**.
* **java.util.Collections**  `sort(List)`: Sorts the specified list into ascending order, according to the natural ordering of its elements. `sort(List, Comparator)`: Sorts the specified list according to the order defined by the comparator.

### **"Natural ordering"**
Java uses Unicode to sort things alphabetically:
1. Some special characters
2. Numbers
3. Uppercase letters
4. Lowercase letters
5. Some special characters

The sort() method declaration:

`static <T extends Comparable <? superT>> void sort(List<T> List)` (Sorts the specified list into ascending order, according to the natural ordering of its elements)

The angle brackets in Java source code or documentation, it means **generics**.

## **Generics**
We will often be using generics to write type-safe collections (code that makes the compiler stop us from putting Cats into a list of Ducks). Without generics, the compiler wouldn't care what we put in the collection, as all hold type Object (it would be as if we wrote `ArrayList<Object>`).

Things we should know about **generics**:
1. **Creating instances of generic classes (like ArrayList)**: When making an ArrayList, we need to tell it the type of the objects we'll allow in the list. `new ArrayList<Song>()`

2. **Declaring and assigning variables of generic types**: `List<song> songList = new ArrayList<song>()`

3. **Declaring (and invoking) methods that take generic types**: `void foo(List<Song> list)   x.foo(songList)`

### **Using generic classes**
The two key areas to look at in a generic class are:
1. The class declaration
2. The method declaration that let you add elements

```java
public class ArrayList<E> extends AbstractList<E> implements List<E> ... { 
    public boolean add(E o)  
    // more code...   
 }

```
* The first "`<E>`" is a **placeholder** for the REAL type we use when we declare and create an ArrayList
* The second "`<E>`": **ArrayList** is a subclass of **AbstractList**, so whatever type we specify for the ArrayList is automatically used for the type of the AbstractList
* The third "`<E>`": The type (the value of `<E>`) becomes the type of the List interface as well
* The fourth "`E`": Whatever "E" is determines what kind of things we are allowed to add to our ArrayList

The **"E"** (for **element**) represents the **type** to create an instance of ArrayList. Sometimes a **"T"** (for **type**) or an **"R"**(for **return type**) may be used in the documentation.

### **Using generic methods**

A **generic class** means that the **class declaration** includes a type parameter.

A **generic method** means that the **method declaration** uses a type parameter in its signature.

We can use **type parameters** in a **method** in several ways:
1. **Using a type parameter defined in the class declaration**: In the folowing declaration, we can use "E" on the method because it has already been defined as part of the class: `public class ArrayList<E> extends AbstractList<E>... { public boolean add(E o) ...}` 

2. **Using a type parameter that was NOT defined in the class declaration**: In the following example we can use `<T>` because we declared it at the start of the method declaration `public <T extends Animal> void takeThing(ArrayList<T> list)`

```java
// This:
public <T extends Animal> void takeThing(ArrayList<T> list)

// IS NOT the same as this:
public void takeThing(ArrayList<Animal> list)

// Both are LEGAL but they are DIFFERENT!
```
On the above examples, the **first one** where `<T extends Animal>` is part of the method declaration, means that any ArrayList declared of a type that is Animal, or one of Animal's subtypes (like Dogs or Cats) is legal.

On the **second one**, where the method argument is `(ArrayList<ANimal> list)` means that **ONLY** an `ArrayList<Animal>` is legal.

________________

On the example exercise (Jukebox1) the file fails to compile when we try to use the method "sort()" on a list of "SongV1" objects. If we look into the docs again for the sort() method:

`static <T extends Comparable <? superT>> void sort(List<T> List)` 

"SongV1" would substitute "T", but the sort() method can only take a list of "Comparable objects" (`<T extends Comparable>`).

**In generics, "extends" means "extends OR implements"**. 
The word "extends" in this case means "IS-A" and works or both classes and interfaces.

## Using a Comparator
A **Comparable** element in a list can compare itself to another of its own type in only one way, using its compareTo() method. But a **Comparator** is external to the element type we are comparing. Because it is a separate **class**, we can make as many as we want.
Then, we will need to call a sort() method that takes a Comparator (Collections.sort or List.sort) which will use this Comparator to put things in order. 

If our **sort() method gets a Comparator**, it will not be calling compareTo() anymore, but instead use the compare() method on the Comparator.

To summarize:
* Invoking the **Collections.sort(List list)** method means the list element's **compareTo()** method determines the order. The elements in the list MUST **implement the Comparable interface**.

* Invoking **List.sort(List list, Comparator c)** or **Collections.sort**(List list, Comparator c) means the **Comparator's compare()** method will me used. That means the elements in the list do NOT need to implement the Comparable interface, but if they do, the list element's compareTo() method will NOT be called.



