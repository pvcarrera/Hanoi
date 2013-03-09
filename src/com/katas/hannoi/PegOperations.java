package com.katas.hannoi;

public class PegOperations {
    public void move(final Peg origin, final Peg destiny) throws InvalidMovementException {
        if (origin.isEmpty()){
            return;
        }
        Disk originDisk = origin.pop();
        if(destiny.isEmpty() || originDisk.compareTo(destiny.peek()) < 0) {
            destiny.push(originDisk);
        }else{
            throw new InvalidMovementException();
        }
    }

}
