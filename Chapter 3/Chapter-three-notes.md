# Notes from Chapter 3 (Variables)

We need to tell Java the type of a variable when we create it, and this variable will only be able to hold values of that type. If a variable is marked as *final*, that variable is inmutable.

Variables must have a **type** and a **name**.

* **Primitive variables**: They hold fundamental values like integers, floating-point numbers and booleans. A primite value is the bits representing the value.
* **Object reference variables**: They hold references to objects, a way to get to them. A reference variable value is the bits representing a way to get to an object on the heap.

## Naming rules
* Must **start** with a **letter**, **underscore** or **dollar sign**.
* After the first character, we can also use **numbers**.
* We must not use any reserved words.

The eight types of **primitive variables** are:
* Boolean
* Char (16 bits)
* Byte (8 bits)
* Short (16 bits)
* Int (32 bits)
* Long (64 bits)
* Float (32 bits)
* Double (64 bits)

## Object reference variables
There is no such thing as an "object variable", there is only a "object reference variables", that hold a **way to access a particular object**, but not the object itself. This is because objects in Java live in the heap. 

If after creating an object and asigning it to a variable (or asigning the way to get to it) we change that variable to point to a different object, that object is not accessible anymore, and becomes eligible for **Garbage Collection(GC)**.

If we asign a value **null** to a variable, it doesn't reference anything.

## Arrays

An array can hold primitive values, but it is never a primitive, always an **object**.

```java
int[] nums; // We declare an int array variable
nums = new int[6]; // We create a new int array with a length of 6 and assign it to the previous int[] variable
nums[0] = 1;
nums[1] = 2; //... We give each element of the array a value.
```

When we have an array of objects, these objects are not referenced by a variable name, but we can still use the dot operator on an object at a particular index in the array: `array[0].doSomething()`

### Array methods
* `array.length` - Gives you the length of the array 