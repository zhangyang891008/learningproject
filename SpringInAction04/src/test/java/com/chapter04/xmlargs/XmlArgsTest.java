package com.chapter04.xmlargs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-xmlargs.xml")
public class XmlArgsTest {

    @Autowired
    private CompactDisc disc;

    @Autowired
    private TrackCounter counter;

    @Test
    public void test(){
        disc.playTrack(1);
        disc.playTrack(2);
        disc.playTrack(3);
        disc.playTrack(4);
        disc.playTrack(3);
        disc.playTrack(3);
        disc.playTrack(0);
        disc.playTrack(2);

        System.out.println("0--"+counter.getPlayCount(0));
        System.out.println("1--"+counter.getPlayCount(1));
        System.out.println("2--"+counter.getPlayCount(2));
        System.out.println("3--"+counter.getPlayCount(3));
        System.out.println("4--"+counter.getPlayCount(4));
        System.out.println("5--"+counter.getPlayCount(5));
    }
}
