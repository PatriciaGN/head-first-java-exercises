class SimpleStartupGame {
  public static void main (String [] args) {
    int numOfGuesses;      
    // MAKE a new SimpleStartup instance                
   java.util.Random randomGenerator = new java.util.Random(); 
   int startingPosition = randomGenerator.nextint(5); 
   // MAKE an int array with 3 ints using the randomly generated number, that number incremented by 1, and that number incremented by 2 (example 3, 4, 5)
   // INVOKE the setLocationCells() method on the SimpleStartup instance
   // DECLARE a boolean variable representing the state of the game, named isAlive. SET it to true
   
   while (numOfHits < 3) {      // WHILE the Startup is alive (isAlive == true) 
     Scanner userInput = new Scanner(System.in) // Create scanner object
     System.out.println("enter a number");
     String guess = userInput.nextLiner();   // GET user input from the command line
     // INCREMENT numOfGuesses variable
     // // CHECK for Startup dead
     // IF result is "kill"
     //    SET isAlive to false
     //    PRINT number of guesses
     System.out.println(result);
   }
  } // End of method
} // End of class
