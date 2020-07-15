package com.bogusmachine.softwaretechnik.ant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;


public class CowTest {

    private Cow cow;

    @Before
    public void setUp() {
        cow = new Cow();
    }

    @Test
    public void testGreeting() {
        assertEquals(cow.getGreeting(), "MOO!");
    }
}