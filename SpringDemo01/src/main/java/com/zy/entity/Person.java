package com.zy.entity;

import java.util.*;

public class Person {
    List<String> hobbies = new ArrayList<String>();
    Map<String,Integer> scores = new HashMap<String, Integer>();
    Set<String> bookes = new HashSet<String>();

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "hobbies=" + hobbies +
                ", scores=" + scores +
                ", bookes=" + bookes +
                '}';
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

    public Set<String> getBookes() {
        return bookes;
    }

    public void setBookes(Set<String> bookes) {
        this.bookes = bookes;
    }
}
