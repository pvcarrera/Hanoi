package com.katas.hannoi;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PegOperationsTest {

    private PegOperations pegOperations;

    @Before
    public void setUp(){
        pegOperations = new PegOperations();
    }

    @Test
    public void should_move_disk_from_origin_to_destiny() throws InvalidMovementException {
        // Given
        Peg origin = createPegWhit3Disks();
        Peg destiny = new Peg();
        Object disk = origin.peek();

        // When
        pegOperations.move(origin, destiny);

        // Then
        assertThat(destiny.pop(), equalTo(disk));
    }

    @Test(expected = InvalidMovementException.class)
    public void should_throw_an_invalid_movement_exception() throws InvalidMovementException {
        // Given
        Peg origin = createPegWhit3Disks();
        Peg destiny = new Peg();


        // When
        pegOperations.move(origin, destiny);
        pegOperations.move(origin, destiny);

    }

    private Peg createPegWhit3Disks() {
        Peg origin = new Peg();
        origin.push(new Disk(3));
        origin.push(new Disk(2));
        origin.push(new Disk(1));

        return origin;
    }
}
