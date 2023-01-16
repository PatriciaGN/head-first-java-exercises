import java.util.ArrayList;

class Startup {

  private ArrayList<String> locationCells;

  public void setLocationCells(ArrayList<String> locs) {
    locationCells = locs;
  };

  public String checkYourself(String userInput) { 
    String result = "miss";                
    int index = locationCells.indexOf(userInput); // If user input not on the list, indexOf() returns -1
      if (index >= 0) {      // If index is greater than or equal to zero, user guess is on the list, so remove it             
        locationCells.remove(index);                 
        if (locationCells.isEmpty()) {
          result = "kill";     
        } else {
          result = "hit";               
        }
      }
      return result
  }
}
