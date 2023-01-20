// Pool puzzle
// Take the code snippets and put them into the blank lines in Boat, Sailboat, Rowboat and TestBoats to obtain
// the following ouput: drift drift hoist sail

public class Boat {
  private int length;
  public void setLength (int len) {
     length = len;
    }
  public int getLength() {
    return length;
  }
  public void move() {
    System.out.print("drift ");
  }
}
