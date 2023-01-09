# Chapter 4 notes (How objects behave: Methods use instance variables)

A class is a blueprint for an object.
Objects have **state** (instance variables) and **behavior** (methods). Each object (or instance of a class) can have its own unique values for its instance variables.

**Methods** use the values stored in the instance variables.

Every instance of a particular class will have the same methods, but these methods will **behave differently** depending on the instance variables of that object.

## You can send things to a method
A **method** takes **arguments or parameters** or can be passed **arguments or parameters** by the caller. 

A **parameter** is a local variable with a **type** and **name** that can be used inside the body of the method.

If a method takes a parameter, this parameter **must** be passed when the method is called, and its value **must** be of the **appropriate type**.

```java
void sayHello(int numOfTimes) {
  while (numOfTimes > 0) {
    System.out.println("Hello!");
    numOfTimes = numOfTimes - 1;
  }
}
```

## You can get things back from a method

Methods can **return** values.
If the method has a **void return type**, it means they don't give anything back.
`void run() {}`

We can declare a method to return a specific type of value back to the caller:
`int numberOfEyes() { return 2; }`

If a method is declared to return a value of a particular type, they **must** return such value or a compatible one.

You can pass a byte where an int is expected, because the byte fits into the int the caller will use for assigning the result. Values passed in and out of methods can be **implicitly promoted** to a larger type or **explicitly cast** to a smaller type.

## Getters and setters
Getters and setters are methods that allow us to get and set instance variables.

```java
class Cats {
    String name;
    int age;

    String getName() { // Getter
        return name;
    }

    void setAge(int catsAge) { // Setter
        age = catsAge; 
    }
}
```

## Encapsulation

When an instance variable is exposed, we mean that it is reachable with the dot operator: `myCat.name = "Luna";`

This allows other methods to change the instance variables directly, which is not good practice. That is why we need to build setter methods, which will allow us to **set limitations for our instance variables** through those methods:

```java
public void setAge(int catsAge) {
    if (catsAge < 30) {
        age = catsAge;
    }
}
```

We can hide our data using the **public and private access modifiers**.
As a general rule, a good practice is to mark all **instance variables** as **private** and provide **public getters and setters** for access control.

### Declaring and initializing instance variables
Instance variables always get a default value if we don't assign it one:

|var type | default value|
|----|----|
|integers| 0|
|floating points| 0.0 |
|booleans| false |
|strings| null|
|references| null|

### Difference between instance and local variables

* **Instance variables** are **declared inside a class**, but not inside a method.
* **Local variables** are **declared within a method**, and **MUST be initialized** before use.
* **Instance variables** are assigned values by default, **local variables** are not, we always need to initialize them.