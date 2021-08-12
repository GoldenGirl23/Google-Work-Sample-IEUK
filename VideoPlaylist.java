package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A class used to represent a Playlist */
class VideoPlaylist {

    private final HashMap<String,ArrayList<String>> playlist;

    VideoPlaylist(String playlistName){

        this.playlist = new HashMap<>();
        playlist.put(playlistName, new ArrayList<>());
    }

    void putplayListVideos(String playlistName, String vidId){

        playlist.get(playlistName).add(vidId);
    }

    List<String> getplayListVideos(String playlistName) {

        return new ArrayList<String>(this.playlist.get(playlistName));
    }



}
