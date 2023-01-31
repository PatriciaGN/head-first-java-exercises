# Notes from chapter two - OOP

The dot operator (.) gives us access to an object's state and behaviour:
```java Cat luna = new Cat()
luna.meow();
luna.age = 3;
```

To really use OOP, we need to create other clases outside main().
The main two purposes of main() are:
* Test your real class
* Launch/start a Java application


Every time an object is created in Java, it is stored into an area of memory called "The Heap" (Garbage-Collectible Heap). When an object is no longer used, it becomes eligible for garbage collection and the space gets freed up.

When we need to deliver an application with many files, we can put all of them into a **Java Archive** (a.jar file). In it, we can include a simple text file formatted as a **"manifest"**, that states which class holds the main() method that should be run.

OOP principles
* An object **knows** things (**instance variables**) and **does** things (**methods**).
* A **child class** can **inherit** instance variables and methods from a **parent class**. These variables and methods can be overwritten by the child class.

In Java, to create an object we need **two classes**:
* A clase for the type of object we want to use.
* A class to test the previous class, that will hold the main method, in this method we will create and access objects of the new class type.

```java
class Book {
    String title;
    int pages;

    void readIt() {
        System.out.println("Reading the book");
    }
}

public class BookTestDrive {
    public static void main(String[] args) {
        Book one = new Book();
        one.title = "The Hobbit";
        one.readIt();
    }
}
```