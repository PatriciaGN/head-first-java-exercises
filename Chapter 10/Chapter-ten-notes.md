# Notes from chapter 10 - Numbers and Statics

## Static methods

We can never make an instance of the class Math as it is marked as private, but we can use its methods (although these don't use any instance variable values). These methods are "**static**", which means we don't need to have an instance of Math, only the Math class.

The "**abstract**" modifier in a class makes it impossible to instantiate that class.
We can also restrict other code from instantiating a non-abstract class by marking the constructor "**private**". When a method is called private, only code from within the class can call it. This is what happens with the class Math.

**Main() methods** are also **static methods**.

A **static method** can be called using the **class name** rather than an object reference variable:
`Math.random()`

They can also be invoked without having any instances of the method's class on the heap, they are not associated to a particular instance.

We can combine static and non-static methods in our class, although even only one non-static method means that there must a way of instantiating that class.

**Static methods can't use non-static (instance) variables.**

```java
public class Cat {
    private int size;

    public static void main(String[] args) {
        System.out.println("Size of the cat is " + size);
        // The line above won't compile, as the static method (main())
        //  doesn't know about the instance variable of the class Cat.
    }

    public void setSize(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }
}
// We obtain the error: non-static variable size cannot be referenced from a static context
```

**Static methods can't use non-static methods either.**
Non-static methods usually use instance variable state to affect the behavior of the method.

So this won't compile either:
```java
public class Cat {
    private int size;

    public static void main(String[] args) {
        System.out.println("Size of the cat is " + getSize());
        // The line above won't compile for the same reason as before,
        // the compiler doesn't know which object we are referring to

    public void setSize(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }
}
// We obtain the error: non-static method getSize() cannot be referenced from a static context
```

## Static variables: value is the same for ALL instancess of the class

A static variable allows us to share its value between all the instances of that class, for example, if we wanted to have a counter to know how many instances of that class have been created.

```java
public class Fox {
    private int size;
    private static int foxCount = 0; // This static variable is 
            // initialized ONLY when the class is first loaded,
            // rather than every time we create a new instance.
            // Even if we hadn't given it a value, this would
            // default to 0
    public Fox() {
        foxCount++; // This will increment foxCount each time a 
             // new instance is created. Because it is static,
             // it won't go back to 0 every time.
    }
}
```

* Instance variables: 1 per instance
* Static variables: 1 per class

All **static variables** in a class are initialized *before* any **object** of that class can be created and *before* any **static method** of the class runs.

A **static method** *CAN'T* access a **non-static variable**, but a **non-static** method *CAN* access a **static variable**.

## Final modifier

### Static final variables are constants

 `public static final double PI = 3.1416;`


This means that, once initalized, it can never change. 

**Constant variable names are usually in all caps and words are separated by underscores.**

A **static initializer** is a block of code that runs when a class is loaded, before any other code can use the class, so it is a good place to initialize a **static final variable**:

```java
class ConstantInit1 {
    final static int X;
    static {
        x = 42;
    }
}
```
If these variables are not initialized directly on declaration (first example) or through a static initializer (second example), the code **won't compile**.

### Other cases with final modifier

The modifier "**final**" can be used on **non-static variables**(instance, local and even method parameters). The value of these will not be changeable.

A **final method** cannot be overriden.

A **final class** means that it cannot be extended. It's methods are therefore final as well, but we don't need to mark them as such.

_________

Some basic Math methods are described in the [general-java-notes](/general-java-notes.md)

_____________

## Wrapping a primitive

Sometimes we may want to **treat a primitive like an object**, for example, collections like ArrayList which only work with Objects.

There is a wrapper class for every primitive type, we can recognise them because they are name after the primitive, but with the first letter capitalized:

Boolean, Character, Byte, Short, Integer, Long, Float, Double.

**Java will Autobox primitives for us** it does all the wrapping and unwrapping automatically for us, but if we were to do it manually, it would look like this:

```java
int i = 288;`
Integer iWrap = new Integer(i);  // Wrapping a value

int unWrapped = iWrap.intValue(); // Unwrapping a value, not all the 
           // wrappers look like this, Boolean -> booleanValue(),
           // Char -> charValue()...
```

But when declaring an ArrayList, **we need to specify the wrapper class, rather than the primitive type**:

`ArrayList<Integer> list = new ArrayList<Integer>();` 

If we were to write "int" instead of "Integer", it wouldn't work.

**Autoboxing** also allows us to use either a primitive or its wrapper type anywhere one or the other is expected:
* **Method arguments**
* **Return values**
* **Boolean expressions**
* **Operations on numbers**: `Integer i = new Integer(4); i++;`
* **Assignments**: `int x = 3;  Integer intVal = x;`

**Wrappers also have static utility methods** like `Integer.parseInt(string)` that will convert a string to an integer.

____________
## Number formatting
### **Making big numbers more readable with underscores**
When we are asigning large numbers to variables, it is good practice to put underscores for readability:

`long easyToRead = 1_000_000_000;`

On the following example, we format a number to a string and put commas:
```java
public class TestFormats {
    public static void main(String[] args) {
        long myBillion = 1_000_000_000;
        String s = String.format("%,d", myBillion); // This line will
           // format the number to 1,000,000,000. d is for decimal
           // integer
    }
}
```

The "%" sign tells the formatter to insert the other method argument there AND format it using the modifier.

For example, the following format specifier(%.2f) would insert the second argument as a float rounded to two decimals:

`String.format(I have %.2f, bugs to fix.", 478789.098);` --> `I have 478789.10 bugs to fix.`

 `String.format(I have %,.2f, bugs to fix.", 478789.098);` --> `I have 478,789.10 bugs to fix.`

Anything between the "%" and the type indicator (the letter) is part of the formatting instructions. 

A **format specifier** can have up to five different parts (not including the %). All of them are optional except for the % and the final letter, but they NEED to be in the right order:

**%**  [argument number]   [flags]   [width]   [.precision] **type**

* **Argument number**: It lets your say WHICH argument if there is more than one.
* **Flags**: For special formatting options like inserting commas, putting negative numbers in parenthesis or making the numbers left justified.
* **Width**: Defines the MINIMUM number of characters that will be used. If the number is longer than the width, it'll be used in full, but if it is less than the width, it will be padded with zeros.
* **.Precision**: It defines the precision (sets the number of decimal places, it needs to have a ".").
* **Type**: Is the only required specifier. It is a letter that defines the type of the variable. **"d" for decimal integer**, **"f" for float**, **"x" for hezadecimal (byte, short, int, long, including primitives and wrappers, or BigInteger)**, **"c" for character (the argument must be a byte,short, char or int including primitive or wrapper)**

If there is **more than one argument**, we can use several format specifiers, in the same order as the arguments.




## Static imports

Static imports remove the information about which class the static comes from and can save a lot of typing, but depending on how they are used, can also create naming conflicts with other classes we may have created.

```java
// Without static imports:

System.out.println(Math.sqrt(2.0)); 

_____________

// With static imports:

import static java.lang.Math.*; // We can use wildcards
import static java.lang.System.out;

out.println(sqrt(2.0)); 

// out.println might be a bad place to use a static import as it can make the code unclear and create naming conflicts

// with "sqrt" it is still quite clear what it is doing, so it may be a good place to use a static import.
```
