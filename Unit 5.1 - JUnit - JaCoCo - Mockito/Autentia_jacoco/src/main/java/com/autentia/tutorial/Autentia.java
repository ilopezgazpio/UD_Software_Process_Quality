package com.autentia.tutorial;

public class Autentia {

    public void tellMeSometing(int i) {

	if (i < 5) {
	    System.out.println("Lower than 5");
	    return;
	}

	if (i % 2 == 0) {
	    System.out.println("Even number.");
	    return;
	}
    }
}
