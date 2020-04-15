package com.chapter03.elexpression;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlankDisc {
    private String title;

    private String artist;

    public String getTitle() {
        return title;
    }

    public BlankDisc(@Value("#{systemEnvironment['disc.title']}") String title,
                     @Value("#{systemEnvironment['disc.artist']}") String artist){
        this.title = title;
        this.artist = artist;
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

    @Override
    public String toString() {
        return "BlankDisc{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
