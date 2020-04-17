package com.chapter04.xmlargs;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {
    private Map<Integer,Integer> trackCounts = new HashMap<Integer,Integer>();

    public void trackPlayed(int trackNumber){}

    public void countTrack(int trackNumber){
        trackCounts.put(trackNumber,trackCounts.getOrDefault(trackNumber, 0) +1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.getOrDefault(trackNumber,0);
    }

}
