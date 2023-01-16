# Notes from chapter 6

## Java library (Java API)
Java has lots of **prebuilt classes** in the Java library, known as the **Java API**.

## ArrayList
Thanks to the Java API, we have prebuilt classes like ArrayLists that we can use in our code.

We need to import ArrayList at the beginning of our code:

`import java.util.ArrayList;`

Arrays in Java are fixed sized, but ArrayLists can change their length.

ArrayLists contain plenty of methods that allow us to modify the elements they contain:

```java
ArrayList<Cat> catList = new ArrayList<Cat>; // We create a new ArrayList object

Cat cat1 = new Cat();
catList.add(cat1);  // We add one element (an object) into the ArrayList

int catListSize = catList.size(); // To know the size of the ArrayList

boolean isIn = catList.contains(cat1); // Tells us whether the ArrayList contains a particular element.

int index = catList.indexOf(cat1); // Gives us the index of an element (starting from 0)

boolean empty = catList.isEmpty(); // Tells us if an ArrayList is empty

catList.get(0); // Gets the element with index 0 (cat1)

catList.remove(cat1); // Removes an element from the ArrayList
```

## Differences between an Array and an ArrayList

* We need to give Arrays a **size** at the time they are created, but it is not necessary for ArrayLists (although we can if we want)
```java
new int[2]; //-> Needs a size
new ArrayList<int>(); // -> Doesn't need a size, although it can be given.
```

* To put an object in an Array, we must assign it to a specific location, but this is not needed with an ArrayList
```java
myArray[1] = a; // -> Needs an index
myArrayList.add(a); // -> Doesn't need an index
```

* Arrays use array syntax that is not used anywhere else, but ArrayLists are plain Java objects, so they do not use this syntax. For example, in  `myArray[1]`, the squared brackets are special array syntax.

* ArrayLists are parameterized, they do not have special array syntax, but they use something called **parameterized types**:
```ArrayList<int>```  -> The "`<int>`" is a type parameter, meaning a list of integers.




