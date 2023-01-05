# Notes from chapter one

In Java, everything must go inside a class.
The naming convention for the files are: "ClassName.java".

To **compile** an application, we can write `javac MyApp.java` on the command line, and to **run** it, `java MyApp.java` or `java MyApp` if it's already compiled.

When the **Java virtual machine (JVM)** starts running, it will first look for the class that it is given in the command line. On every application, there must be **at least one class** and a **single main method** (this method will only appear once on every application and determine where our program should start running).

Example of syntax for a class with a main method:
```java
public class ExampleApp {
    public static void main (string[] args) {
        System.out.print("This is an example");
        int days = 3;
        String name = "Luna";
    }
} // This is a single-line comment

```
* **Code blocks are defined by a pair of curly brackets**
* The **assignment** operatior is "=", the **equals** operator is "==".
* **Public**: Makes these class and method accessible from everywhere in the program.
* **static**:
* **void**: There is no return value.
* **main**: The name of the method.
* **(String[] args)**: The arguments to the method. In this case, it must be given an array of strings which will be called "args".
* **System.out.print()**: It will print to the standard output, which defaults to the command line. 
* **Variables**: Must be declared with a type and a name.
* **Every statementent should be ended with a semicolon.**
* **Most white spaces don't matter**


## Loops
```java
while (x < 4) {
    x = x + 1;
}

for (int i = 3; i < 15; i = i + 1) {
    System.out.print("i is " + i)
}
```

