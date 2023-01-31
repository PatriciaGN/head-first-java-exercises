# Notes from Chapter Five - Writing a program

When drawing flow diagrams:
* **Circle**: Means start or finish.
* **Rectangle**: Represents an action.
* **Diamond**: Represents a decision point.

## Developing a class
1. Figure out what the class is meant to do
2. List its instance variables and methods
3. Whrite test code for the methods
4. Implement the class
5. Test the methods
6. Debug and reimplement as needed

A CLASS CAN HAVE ONE SUPERCLASS ONLY

Choose **for** loops over **while** loops when we know how many times we want to repeat the loop code. You can use the **break** word to leave a loop early.

## For loops

There are two ways of writing a for loop:
`for (int i = 0; i < 10; i++) { // do something 10 times }`

Initialize the loop with a variable i which equals 0; continue the loop while i is less than 10 (*boolean test*, can be a true/false expresion, a test or an expression that returns a boolean); on each iteration, add one to i.

OR

`for (int cat : catCollection) { // pet cat }`

For each cat in the array catCollection, do something.



## Post-increment operator

`counter++`  and `counter--`

is the same as


`counter = counter + 1`   and `counter = counter - 1`

If they are placed on the other side, it will first increment the value and then use this new value:

`int i = 0;  int x = ++i`

In this expression, both i and x would equal 1.

If we do it the other way, i would be 1 but x would be 0, as first, x gets the value of i and then, i is incremented:

`int i = 0;  int x = i++;`

## Casting primitives

In Java, we can *cast* a value type into a different kind of type, but the program will cut off the remaining bits until the value fits the size of the new container.
Examples:

```java
long y = 36;
int x = y;   // This won't compile as a long is bigger than an int

// But with casting:

long y = 36;
int x = (int) y;  // This will compile fine, x is now 42

long y = 40002; // The number exceeds the 16-bit limit of a short
short x = (short) y; // x now equals -25534!

float f = 3.14f;
int x = (int) f;  // x will equal 3
```


## Random generator
A more convenient way, but requires importing the Random class:
```java
java.util.Random randomGenerator = new java.util.Random(); 
int startingPosition = randomGenerator.nextint(5);
```
We can also use: 

```java
int randomNum = (int) (Math.random() * 5)
```
* `(int)` --> This is a "cast", and it forces the thing immediately after it to become the tyoe if the cast. Math random returns a double, so we have to cast it to an int. The cast removes the fractional part of the double so that we have a whole number.
* `* 5` --> The Math random method returns a number from zero to just under one. With this formula and the cast, we make it return a number from 0 to 4)


## Get user input

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Enter username");
String userName = scanner.nextLine(); // For strings

int myNumber = scanner.nextInt(); // Integers
scanner.nextBoolean() // Booleans
scanner.nextByte() // Byte
scanner.nextDouble() // Double
scanner.nextFloat() // Float
scanner.nextLong() // Long
scanner.nextShort() // Short
```