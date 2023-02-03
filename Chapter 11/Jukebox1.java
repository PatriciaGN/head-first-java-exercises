// On this exercise, we want to be able to print a list of songs in alphabetical order

import java.util.*;

public class Jukebox1 {
  public static void main(String[] args) {
    new Jukebox1().go();
  }
  
  public void go() {
    List<SongV3> songList = MockSongs.getSongsV3();
    System.out.println(songList);
    // Collections.sort(songList);  Now that we are sorting the songs by title AND by artist, it is not very good practice to have two different mechanisms to sort by each of them.
    
    TitleCompare titleCompare = new TitleCompare();
    songList.sort(titleCompare);
    
    System.out.println(songList);
        
    ArtistCompare artistCompare = new ArtistCompare(); // Makes an instance of the Comparator class
    songList.sort(artistCompare); // Invoke sort() on our list, passing it a reference to the new custom Comparator object.
    
    System.out.println(songList);
  }
}

class TitleCompare implements Comparator<SongV3> {
  public int compare(SongV3 one, SongV3 two) {  // returns an int (-1, 0, 1 depending on whether one song should go before the other)
    return one.getTitle().compareTo(two.getTitle());
  }
}

class ArtistCompare implements Comparator<SongV3> { // We are lettin the String variables (for artist) do the actual
  public int compare(SongV3 one, SongV3 two) {      // comparison, since Strings already know how to alphabetize themselves.
    return one.getArtist().compareTo(two.getArtist());
  }
}

class MockSongs {
  public static List<String> getSongStrings() {
    List<String> songs = new ArrayList<>();
    songs.add("somersault");
    songs.add("cassidy");
    songs.add("$10");
    songs.add("havana");
    songs.add("Cassidy");
    songs.add("50 ways");
    return songs;
  }
  
  public static List<SongV3> getSongsV3() {
    List<SongV3> songs = new ArrayList<>();
    songs.add(new SongV3("somersault", "zero 7", 147));
    songs.add(new SongV3("cassidy", "grateful dead", 158));
    songs.add(new SongV3("$10", "hitchiker", 140));
    songs.add(new SongV3("havana", "cabello", 105));
    songs.add(new SongV3("Cassidy", "grateful dead", 158));
    songs.add(new SongV3("50 ways", "simon", 102));
    return songs;
  }
}
