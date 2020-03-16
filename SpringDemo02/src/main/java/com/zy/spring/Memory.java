package com.zy.spring;

public class Memory {

    private Integer storage;
    public Memory(Integer storage){
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "storage=" + storage +
                '}';
    }
}
