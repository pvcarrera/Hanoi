package com.katas.hannoi;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertTrue;

public class HannoiGameTest {

    public static final int DISKS = 3;

    private HannoiGame hannoiGame;

    @Before
    public void setUp(){
        hannoiGame = new HannoiGame(DISKS);
    }

    @Test
    public void should_solve_hannoi() throws InvalidMovementException {
        // Given
        Peg initialPeg = (Peg) hannoiGame.firstPeg().clone();

        // When
        hannoiGame.solve();

        // Then
        assertThat(hannoiGame.lastPeg(), equalTo(initialPeg));
        assertTrue(hannoiGame.firstPeg().isEmpty());
        assertTrue(hannoiGame.middlePeg().isEmpty());

    }

    @Test
    public void should_initialize_pegs() {
        // Given
        HannoiGame hanoi = new HannoiGame(DISKS);

        // When
        Peg initialPeg = hanoi.firstPeg();
        Peg middlePeg = hanoi.middlePeg();
        Peg lastPeg = hanoi.lastPeg();


        // Then
        assertThat(initialPeg.size(), equalTo(DISKS));
        assertTrue(middlePeg.isEmpty());
        assertTrue(lastPeg.isEmpty());

    }


}
