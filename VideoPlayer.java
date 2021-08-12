package com.google;

import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private Map<String, VideoPlaylist> videoPlaylists;

  private String nowPlaying = null;
  private String nowPaused = null;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    this.videoPlaylists = new HashMap<>();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {

    System.out.println("Here's a list of all available videos:");

    List<Video> vids = this.videoLibrary.getVideos();
    TreeMap<String, String> sorted = new TreeMap<>();
    String output;

    for (Video v : vids){
      output = v.getTitle() + " (" + v.getVideoId() + ") " + v.getTags().toString().replace(",", "") ;
      sorted.put(v.getTitle(), output);
    }

    Collection<String> values = sorted.values();

    for (String vals : values){
      System.out.println(vals);
    }
  }

  public void playVideo(String videoId) {

    Video vid = videoLibrary.getVideo(videoId);

    if(vid == null){
      System.out.println("Cannot play video: Video does not exist");
    }
    else{
      if(nowPlaying != null){
        System.out.println("Stopping video: " + nowPlaying);
        System.out.println("Playing video: " + vid.getTitle());
        nowPlaying = vid.getTitle();
      }
      else{
        if(nowPaused != null){
          System.out.println("Stopping video: " + nowPaused);
        }
        System.out.println("Playing video: " + vid.getTitle());
        nowPlaying = vid.getTitle();
        nowPaused = null;
      }

    }
  }

  public void stopVideo() {

    if(nowPlaying != null){
      System.out.println("Stopping video: " + nowPlaying);
      nowPlaying = null;
      nowPaused = null;
    }
    else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {

    Random randomGenerator = new Random();
    int index = randomGenerator.nextInt(videoLibrary.getVideos().size());
    Video vid = videoLibrary.getVideos().get(index);

    if(nowPlaying != null){
      System.out.println("Stopping video: " + nowPlaying);
      System.out.println("Playing video: " + vid.getTitle());
      nowPlaying = vid.getTitle();
    }
    else{
      System.out.println("Playing video: " + vid.getTitle());
      nowPlaying = vid.getTitle();
    }
  }

  public void pauseVideo() {

    if(nowPaused != null){
      System.out.println("Video already paused: " + nowPaused);
    }
    else{
      if(nowPlaying != null){
        System.out.println("Pausing video: " + nowPlaying);
        nowPaused = nowPlaying;
        nowPlaying = null;
      }
      else{
        System.out.println("Cannot pause video: No video is currently playing");
      }
    }
  }

  public void continueVideo() {

    if(nowPlaying != null){
      System.out.println("Cannot continue video: Video is not paused");
    }
    else{
      if(nowPaused != null){
        System.out.println("Continuing video: " + nowPaused);
        nowPlaying = nowPaused;
        nowPaused = null;
      }
      else{
        System.out.println("Cannot continue video: No video is currently playing");
      }
    }
  }

  public void showPlaying() {

    Video vid;

    if(nowPaused != null){
      vid = videoLibrary.getVideoByName(nowPaused);
      System.out.println("Currently playing: " + vid.getTitle() +
              " (" + vid.getVideoId() + ") " +
              vid.getTags().toString().replace(",", "") + " - PAUSED");
    }
    else{
      if(nowPlaying != null){
        vid = videoLibrary.getVideoByName(nowPlaying);
        System.out.println("Currently playing: " + vid.getTitle() +
                " (" + vid.getVideoId() + ") " +
                vid.getTags().toString().replace(",", ""));
      }
      else{
        System.out.println("No video is currently playing");
      }
    }
  }

  public void createPlaylist(String playlistName) {

    if(videoPlaylists.containsKey(playlistName.toLowerCase(Locale.ROOT))){
      System.out.println("Cannot create playlist: A playlist with the same name already exists");
    }
    else{
      videoPlaylists.put(playlistName.toLowerCase(Locale.ROOT), new VideoPlaylist(playlistName));
      System.out.println("Successfully created new playlist: " + playlistName);
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {

    List<Video> vids = this.videoLibrary.getVideos();

    if (!videoPlaylists.containsKey(playlistName.toLowerCase(Locale.ROOT))){
      System.out.println("Cannot add video to " + playlistName + ": Playlist does not exist");
    }
    else{
      if(!vids.contains(videoId)){
        System.out.println("Cannot add video to " + playlistName + ": Video does not exist");
      }
      else{
        if(videoPlaylists.get(playlistName.toLowerCase(Locale.ROOT)).getplayListVideos(playlistName).contains(videoId)){
          System.out.println("Cannot add video to " + playlistName + ": Video already added");
        }
        else{
          videoPlaylists.get(playlistName.toLowerCase(Locale.ROOT)).putplayListVideos(playlistName, videoId);
          System.out.println("Added video to " + playlistName + ": " + videoLibrary.getVideo(videoId).getTitle());
        }
      }
    }
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}