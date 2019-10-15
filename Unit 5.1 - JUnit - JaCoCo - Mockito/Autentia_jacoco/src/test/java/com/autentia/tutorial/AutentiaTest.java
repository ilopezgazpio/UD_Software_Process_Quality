package com.autentia.tutorial;

import org.junit.Test;

public class AutentiaTest {

    @Test
    public void testApp() {
	final Autentia autentia = new Autentia();
	autentia.tellMeSometing(3);
	autentia.tellMeSometing(6);

	// Uncomment the following line to get 100% coverage
	autentia.tellMeSometing(7);

    }
}
