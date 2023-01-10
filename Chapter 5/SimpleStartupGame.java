class SimpleStartupGame {
  public static void main (String [] args) {
    int numOfGuesses;      
    GameHelper helper = new GameHelper 
    
   SimpleStartup theStartup = new SimpleStartup();              
   int randomNum = (int) (Math.random() * 5);
    
   int[] locations = (randomNum, randomNum + 1, randomNum + 2); // MAKE an int array with 3 ints using the randomly generated number, that number incremented by 1, and that number incremented by 2 (example 3, 4, 5)
   theStartup.setLocationCells(locations);
   
   while (isAlive) {     
     int guess = helper.getUserInput("enter a number");        // GET user input from the command line
     String result = theStartup.checkYourself(guess);
     numOfGuesses++;     
     if (result.equals("kill")) {
       isAlive = false;
       System.out.pringln("You took " + numOfGuesses + " guesses"); 
      } // End of if
   }
  } // End of method
} // End of class
