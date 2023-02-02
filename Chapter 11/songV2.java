class SongV2 {
  private String title;
  private String artist;
  private int bpm;
  
  SongV2(String title, String artlist, int bpm) {
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
  }                              of printing its identifier code, it will print the song title.
}
