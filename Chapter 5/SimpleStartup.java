class SimpleStartup {
  private int[] locationCells;
  private int numOfHits = 0;

  public void setLocationCells(int[] locs) {
    locationCells = locs;
  };

  public String checkYourself(int guess) { // METHOD String checkYourself(int userGuess)
    String result = "miss";                //   GET the user guess as an int parameter
    for (int cell : locationCells) {       //   REPEAT with each of the location cells in the int array
      if (guess == cell) {                 //     // COMPARE the user guess to the location cell
        result = "hit";                    //     IF the user guess matches
        numOfHits++;                       //       INCREMENT the number of hits
        break;                             //       // FIND OUT if it was the last location cell:
      }
    }
    if (numOfHits == locationCells.length) { //       IF number of hits is 3, RETURN "Kill" as the result
      result = "kill";
    }                                        //       ELSE it was not a kill, so RETURN "Hit"
    System.out.println(result);
    return result;
  }
}
