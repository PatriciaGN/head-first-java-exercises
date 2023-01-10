class SimpleStartupGame {
  public static void main (String [] args) {
    int numOfGuesses;                      // DECLARE an int variable to hold the number of user guesses, named numOfGuesses
   java.util.Random randomGenerator = new java.util.Random(); 
   int startingPosition = randomGenerator.nextint(5); // COMPUTE a   random number between 0 and 4 that will be the starting location cell position
   while (numOfHits < 3) {      // WHILE the Startup is still alive:
     Scanner userInput = new Scanner(System.in) // Create scanner object
     System.out.println("enter a number");
     String guess = userInput.nextLiner();   // GET user input from the command line
     System.out.println(result);
   }
  } // End of method
} // End of class
