// Pool puzzle
// Take the code snippets and put them into the blank lines in Boat, Sailboat, Rowboat and TestBoats to obtain
// the following ouput: drift drift hoist sail

public class TestBoats {
  public static void main(String[] args) {
    Boat b1 = new Boat();
    Sailboat b2 = new Sailboat();
    Rowboat b3 = new Rowboat();
    b2.setLength(32);
    b1.move();
    b3.move();
    b2.move();
  }
}
