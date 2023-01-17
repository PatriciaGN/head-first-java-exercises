# General Java notes

## Scope

In Java, to be able to use a variable inside a loop, this variable needs to be declared **outside the loop (given a value)**.

```java
String name = ''

while(loop) {
    name = ...
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

# Java methods

## String methods

| Method | Description | Returns | Exception |
|-----|------|-----|-----|
|`str.replaceAll("a", "e");` | Replaces all ocurrences of "a" to "e". Uses Regex. |  Replaced string | PatternSyntaxException |
| `str.replace("a", "e");` | Replaces all ocurrencences of "a" to "e". Does not use Regex, just chars. | Replaced string| |
| `str.replaceFirst("a", "e");` | Replaces the first match "a" with "e". Uses Regex. | Replaced string | |


## Array methods

| Method | Description | Returns | Imports |
|-----|------|-----|-----|
| `Arrays.sort(arr);`| Sorts an array in ascending order. | Modifies original array | `import java.util.Arrays;` OR `import java.util.*;`|
|`Arrays.sort(arr, Collections.reverseOrder());` | Sorts an array in descending order.| Modified original array | `import java.util.Arrays;`, `import java.util.Collections;` OR `import java.util.*;`
| `Arrays.toString(arr);` | Returns a string representation of the contents of the specified array. Needed to **print** arrays. | String with a list of the array's elements enclosed in squared brackets. | `import java.util.Arrays;` |
|`Arrays.copyOf(int[] original, int newLength);`| It creates a copy of an array with a new length.| Returns a copy of the original array| `import java.util.Arrays`|

To get the length, we can use the length variable: `arr.length`

## ArrayList methods

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
