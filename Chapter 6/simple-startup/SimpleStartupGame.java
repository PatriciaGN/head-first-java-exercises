import java.uti.ArrayList;

class StartupBust {
  private GameHelper helper = new GameHelper();
  private ArrayList<Startup> startups = new ArrayList<Startup>();  // Declare and initialize the variables we need
  private int numOfGuesses = 0;
  
  private void setUpGame(); {
  // first make some Startups and give them locations
    Startup one = new Startup();
    one.setName("poniez");
    Startup two = new Startup();        // Make three Startup objects, give them names, and stick them in the ArrayList
    two.setName("hacqi");
    Startup three = new Startup();
    three.setName("cabista");
    startups.add(one);
    startups.add(two);
    startups.add(three);
    
    System.out.println("Your goal is to sink three Startups.");
    System.out.println("poniez, hacqi, cabista");        // Print brief instructions for user
    System.out.println("Try to sink them all in the fewest number of guesses");
    
    for (Startup startup : startups) {   // Repeat with each Startup in the list
      ArrayList<String> newLocation = helper.placeStartup(3);    // Ask the helper for a Startup location
      startup.setLocationCells(newLocation);  // Call the setter method on this Startup to give it the location the helper gave
    }
  }
    
  private void startPlaying() {
    while (!startups.isEmpty()) {  // As long as the Startup is NOT empty
      String userGuess = helper.getUserInput("Enter a guess");  // Get user input
      checkUserGuess(userGuess); // Call our own checkUserGuess method
    }
    finishGame(); // Call our own finishGame method
  }
  
  private void checkUserGuess(String userGuess) {
    numOfGuesses++;  // Increment the number of guesses the user has made
    String result = "miss"; // Asume it is a miss unless told otherwise
    
    for (Startup starupToTest : startups) {  // Repeat with all Startups on the list
      result = startupToTest.checkYourself(userGuess); // Ask the Startup to check the user guess, looking for a hit (or kill)
      
      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        startups.remove(startupToTest); // This one's dead, so take it out of the Startup list then get out of the loop
        break;
      }
    }
    System.out.println(result); // Print a the result for the user
  }
    
    
  private void finishGame() {  // Print a message telling the user how they did in the game
    System.out.println("All Startups are dead! Your stock is now worthless");
    if (numOfGuesses < = 18) {
      System.out.prinln("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.";
      System.out.prinln("Fish are dancing with your options");   
    }
  }
    
  public static void main(String[] args) {
    StartupBust game = new StartupBust(); // Create the game object
    game.setUpGame(); // Tell the game object to set up the game
    game.startPlaying(); // Tell the game object to start the main game play loop (keeps asking for user input and checking the guess)
  }
}
