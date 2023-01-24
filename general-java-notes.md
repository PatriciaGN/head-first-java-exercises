# General Java notes

## Scope

In Java, to be able to use a variable inside a loop, this variable needs to be declared **outside the loop (given a value)**.

```java
String name = ''

while(loop) {
    name = ...
}
```

## Static methods and variables

A **static method** and **static variable** are methods and variables that belong to a class rather than an instance of a class. This means you can call a static method or variable without creating an object of the class. Static methods are sometimes called class methods.

Example:
```java
public class A { 
  static int result = 1;
  static int counter = 1;
  
 public static int getNumber() {   
   if (counter > 1) {
     result = result * 2;
   }
   counter += 1;
   return result;
 }
}
```

## Switch statement

Instead of writing many if..else statements, you can use the switch statement.

The switch statement selects one of many code blocks to be executed:
```java
private static char getComplement(char c) {
    switch(c) {
      case 'A': return 'T';
      case 'T': return 'A';
      case 'C': return 'G';
      case 'G': return 'C';
    }
    return c;
  }
```
When Java reaches a **break keyword**, it breaks out of the switch block.

The **default keyword** specifies some code to run if there is no case match:


```java
int day = 4;
switch (day) {
  case 1: System.out.println("Monday");
    break;
  case 2: System.out.println("Tuesday");
    break;
  case 3: System.out.println("Wednesday");
    break;
  case 4: System.out.println("Thursday");
    break;
  case 5: System.out.println("Friday");
    break;
  case 6: System.out.println("Saturday");
    break;
  case 7: System.out.println("Sunday");
    break;
}
// Outputs "Thursday" (day 4)
```

## String

| Method | Description | Returns | Exception |
|-----|------|-----|-----|
|`str.replaceAll("a", "e");` | Replaces all ocurrences of "a" to "e". Uses Regex. |  Replaced string | PatternSyntaxException |
| `str.replace("a", "e");` | Replaces all ocurrencences of "a" to "e". Does not use Regex, just chars. | Replaced string| |
| `str.replaceFirst("a", "e");` | Replaces the first match "a" with "e". Uses Regex. | Replaced string | |
|`str.toCharArray();` | Converts a string to a new char array | New char array| | 




## Array 

To declare an Array

For primitive types:
```java
int[] intArray = new int[3]; // each element of the array is initialised to 0
int[] intArray = {1, 2, 3};
int[] intArray = new int[]{1, 2, 3};

// Since Java 8. Doc of IntStream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

int [] intArray = IntStream.range(0, 100).toArray(); // From 0 to 99
int [] intArray = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
int [] intArray = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved.
int [] mintArray = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort 
```
For classes, for example String, it's the same:
```java
String[] myStringArray = new String[3]; // each element is initialised to null
String[] myStringArray = {"a", "b", "c"};
String[] myStringArray = new String[]{"a", "b", "c"};
```

The third way of initializing is useful when you declare an array first and then initialize it, pass an array as a function argument, or return an array. The explicit type is required.
```java
String[] myStringArray;
myStringArray = new String[]{"a", "b", "c"};
```

| Method | Description | Returns | Imports |
|-----|------|-----|-----|
| `Arrays.sort(arr);`| Sorts an array in ascending order. | Modifies original array | `import java.util.Arrays;` OR `import java.util.*;`|
|`Arrays.sort(arr, Collections.reverseOrder());` | Sorts an array in descending order.| Modified original array | `import java.util.Arrays;`, `import java.util.Collections;` OR `import java.util.*;`
| `Arrays.toString(arr);` | Returns a string representation of the contents of the specified array. Needed to **print** arrays. | String with a list of the array's elements enclosed in squared brackets. | `import java.util.Arrays;` |
|`Arrays.copyOf(int[] original, int newLength);`| It creates a copy of an array with a new length.| Returns a copy of the original array| `import java.util.Arrays`|
|`String myString = String.format("name is %s, name);` 
 `String myString = String.format("name is %f, 32.2);` |`%d` for int, byte, short, long, bigint, `%e/a/f/g` for floating points, `%b/h` for any type, `%x` for int| Interpolates a value or string into a string| Formatted string| |
|`charArray.stream().map(String::valueOf).collect(Collectors.joining());`| It converts a char array into a string| Returns the new string | `import java.util.Stream;`, `import java.util.stream.Collectors;`, `import java.util.List;`, `import java.util.Arrays;`  |

To get the length, we can use the length variable: `arr.length`

## ArrayList 

```java
ArrayList<Cat> catList = new ArrayList<Cat>; // We create a new ArrayList object
Cat cat1 = new Cat();
```

| Method | Description | Returns | Imports |
|-----|------|-----|-----|
|`arrList.add(a);`| It adds an element to the ArrayList | Modifies the original array | `java.util.ArrayList;`|
|`arrList.size();`| It tells us the size of the ArrayList | Int | `java.util.ArrayList;`|
|`arrList.contains(a);` | It tells us whether the ArrayList contains a particular element | Boolean| `java.util.ArrayList;`|
|`arrList.isEmpty();` | It tells us if the ArrayList is empty | Boolean| `java.util.ArrayList;`|
|`arrList.indexOf(a);` | It tells us the index of a particular element | Int | `java.util.ArrayList;`|
|`arrList.get(int);` | Gets the element with a particular index | Element | `java.util.ArrayList;`|
|`arrList.remove(a);` | Removes a particular element of the ArrayList | - | `java.util.ArrayList;`|
|`str.stream().collect(Collectors.joining(", "));` | Converts a list of strings into a joined string | New joined string | `import java.util.Arrays;`, `import java.util.List;`, `import java.util.stream.Collectors;`, `import java.util.stream.Stream;` | 


## Char 

In Java, char type is trated as an int, and trying to add two chars together adds their unicode values and returns an int.
To concatenate chars together as a String, do:
`return char1 + "" + char2`

| Method | Description | Returns | Imports |
|-----|------|-----|-----|
|

## Integer

| Method | Description | Returns | Imports |
|-----|------|-----|-----|
|`Integer.toString(2)` | | Returns the integer as a string | |

## Object
All objects we create in Java are subclasses of class Object and inherit all its methods.

| Method | Description | Returns | Imports |
|-----|------|-----|-----|
|`Object.equals(anotherOrSameObject);` | Tells us if two objects are considered equal | Returns a boolean | |
|`Object.getClass();` | Gives us the class that an object was instantiated from | Returns the name of the class | |
|`Object.hashCode();` | Tells us the hashcode for the object (like its unique ID) | Returns the object number | |
|`Object.toString();` | Gives us a String message with the name of the class and another number | Returns a String | |


## Math

`return (int) Math.ceil(month / 3.)`  -> To round up