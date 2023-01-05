public class PhraseOMatic {
  public static void main (String[] args) {
  
  String[] wordListOne = {"agnostic", "opinionated", "voice activated",
  "haptically driven", "extensible"};
  
  String[] wordListTwo = {"loosely coupled", "six sigma", "asynchronus", "event driven",
  "pub-sub", "IoT"};
  
  String[] wordListThree = {"framework", "library", "DSL", "REST API", "repository"};
  
  int oneLength = wordListOne.length;
  int twoLength = wordListTwo.length;
  int threeLength = wordListThree.length;
  
  java.util.Random randomGenerator = new java.util.Random();
  int rand1 = randomGenerator.nextInt(oneLength);
  int rand2 = randomGenerator.nextInt(twoLength);
  int rand3 = randomGenerator.nextInt(threeLength);
  
  String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
  
  System.out.println("What we need is a " + phrase);
  }
  }
