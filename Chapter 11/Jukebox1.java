// On this exercise, we want to be able to print a list of songs in alphabetical order

import java.util.*;

public class Jukebox1 {
  public static void main(String[] args) {
    new Jukebox1().go();
  }
  
  public void go() {
    List<SongV2> songList = MockSongs.getSongsV2();
    System.out.println(songList);
    Collections.sort(songList); // Now that we have a list of SongsV2, the sort method doesn't know what to sort it on (title, bpm...), so it doesn't compile
    System.out.println(songList);
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
  
  public static List<SongV2> getSongsV2() {
    List<SongV2> songs = new ArrayList<>();
    songs.add(new SongV2("somersault", "zero 7", 147));
    songs.add(new SongV2("cassidy", "grateful dead", 158));
    songs.add(new SongV2("$10", "hitchiker", 140));
    songs.add(new SongV2("havana", "cabello", 105));
    songs.add(new SongV2("Cassidy", "grateful dead", 158));
    songs.add(new SongV2("50 ways", "simon", 102));
    return songs;
  }
}
