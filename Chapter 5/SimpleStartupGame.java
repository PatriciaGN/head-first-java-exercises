class SimpleStartupGame {
  public static void main (String [] args) {
    int numOfGuesses;      
    GameHelper helper = new GameHelper // This is a special classs we wrote that has the method for getting user input. For now, pretend it's part of Java
    
   SimpleStartup theStartup = new SimpleStartup(); // MAKE a new SimpleStartup instance                
   int randomNum = (int) (Math.random() * 5);
    
   int[] locations = (randomNum, randomNum + 1, randomNum + 2); // MAKE an int array with 3 ints using the randomly generated number, that number incremented by 1, and that number incremented by 2 (example 3, 4, 5)
   theStartup.setLocationCells(locations); // INVOKE the setLocationCells() method on the SimpleStartup instance (Give the startup its locations)
   boolean isAlive = true;  // DECLARE a boolean variable representing the state of the game, named isAlive. SET it to true
   
   while (isAlive) {      // WHILE the Startup is alive (isAlive == true) 
     int guess = helper.getUserInput("enter a number");        // GET user input from the command line
     String result = theStartup.checkYourself(guess);
     numOfGuesses++;     // INCREMENT numOfGuesses variable
     if (result.equals("kill")) {
       isAlive = false;
       System.out.pringln("You took " + numOfGuesses + " guesses"); // // CHECK for Startup dead
     // IF result is "kill"
     //    SET isAlive to false
     //    PRINT number of guesses
   }
  } // End of method
} // End of class
