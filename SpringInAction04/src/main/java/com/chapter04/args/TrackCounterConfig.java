package com.chapter04.args;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc disc(){
        CompactDisc compactDisc = new CompactDisc();
        compactDisc.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        compactDisc.setArtist("The Beatles");
        List<String> tracks = new ArrayList<>();
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        tracks.add("Lucy in the sky with Diamonds");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        compactDisc.setTracks(tracks);
        return compactDisc;
    }

    @Bean
    public TrackCounter counter(){
        return new TrackCounter();
    }
}
