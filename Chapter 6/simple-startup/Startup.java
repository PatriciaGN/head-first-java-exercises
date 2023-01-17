import java.util.ArrayList;

public class Startup {

  private ArrayList<String> locationCells;
  private String name;

  public void setLocationCells(ArrayList<String> locs) {
    locationCells = locs;
  };

  public void setName(String n) {
    name = n;
  }
  
  public String checkYourself(String userInput) { 
    String result = "miss";                
    int index = locationCells.indexOf(userInput); // If user input not on the list, indexOf() returns -1
      if (index >= 0) {      // If index is greater than or equal to zero, user guess is on the list, so remove it             
        locationCells.remove(index);    
                     
        if (locationCells.isEmpty()) {
          result = "kill"; 
          System.out.println("Ouch! You sunk " + name + " :( ");    
        } else {
          result = "hit";               
        }
      }
      return result;
  }
}
