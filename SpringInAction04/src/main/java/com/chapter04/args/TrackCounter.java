package com.chapter04.args;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {
    private Map<Integer,Integer> trackCounts = new HashMap<Integer,Integer>();

    @Pointcut("execution(* com.chapter04.args.CompactDisc.playTrack(int))"+ "&& args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        trackCounts.put(trackNumber,trackCounts.getOrDefault(trackNumber, 0) +1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounts.getOrDefault(trackNumber,0);
    }

}
