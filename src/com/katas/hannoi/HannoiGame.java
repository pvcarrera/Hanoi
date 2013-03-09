package com.katas.hannoi;

public class HannoiGame {

    private final Peg firstPeg = new Peg();
    private final Peg lastPeg = new Peg();
    private final Peg middlePeg = new Peg();
    private PegOperations pegOperations;

    public HannoiGame(int disks) {
        initializeFirstPeg(disks);
    }

    private void initializeFirstPeg(final int disks) {
        int disksSize = disks;
        for (int i = 0; i < disks; i++) {
            firstPeg.push(new Disk(disksSize));
            disksSize -= 1;
        }
    }

    public void solve() throws InvalidMovementException {
        applyRecursiveHanoi(firstPeg.size(), firstPeg, middlePeg, lastPeg);
    }

    private void applyRecursiveHanoi(int disks, final Peg firstPeg, final Peg middlePeg, final Peg lastPeg) throws InvalidMovementException {
        if (disks > 0){
            applyRecursiveHanoi(disks - 1, firstPeg, lastPeg, middlePeg);
            getPegOperations().move(firstPeg, lastPeg);
            applyRecursiveHanoi(disks - 1, middlePeg, firstPeg, lastPeg);
        }
    }

    public Peg firstPeg() {
        return firstPeg;
    }

    public Peg lastPeg() {
        return lastPeg;
    }

    public Peg middlePeg() {
        return middlePeg;
    }

    private PegOperations getPegOperations() {
        if (pegOperations == null) {
            pegOperations = new PegOperations();
        }
        return pegOperations;
    }

}
