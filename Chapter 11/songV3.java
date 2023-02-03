class SongV3 implements Comparable<SongV3> {  // We write "<SongV3> to specify the type that the implementing class can be compared against. This means that SongV3 objects can be compared to other SongV3 objects for the purpose of sorting.
  private String title;
  private String artist;
  private int bpm;
  
  public int compareTo(SongV3 aSong) {
    return title.compareTo(aSong.getTitle());   // The sort() method sends a song to compareTo() to see how it compares to the song the method was invoked on  
  }
  
  SongV3 (String title, String artist, int bpm) {
    this.title = title;
    this.artist = artist;
    this.bpm = bpm;
  }
  
  public String getTitle() {
    return title;
  }
  public String getArtist() {
    return artist;
  }
  public int getBpm() {
    return bpm;
  }
  public String toString() {
    return title;                // This method overrides toString() in the Object class, so that instead
  }                              // of printing its identifier code, it will print the song title.
}
