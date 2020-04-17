package com.chapter04.xmlargs;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks = new ArrayList<>();

    public void playTrack(int trackNumber){
        String song = tracks.get(trackNumber);
        System.out.println("playing --"+trackNumber+"=="+song);
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", tracks=" + tracks +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
