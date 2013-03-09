package com.katas.hannoi;

public class Disk implements Comparable<Disk>{

    private final int size;

    public Disk(int size) {
        this.size = size;
    }


    @Override
    public int compareTo(Disk o) {
        if(this.size < o.size){
            return -1;
        }
        if(this.size > o.size){
            return 1;
        }
        if(this.size == o.size){
            return 0;
        }
        return 0;
    }
}
