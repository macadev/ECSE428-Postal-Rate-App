package com.example.danielmacario.amp_ecse_428;

public class PostalCalculator {

    public static double calculateRate(Envelope envelope) {
        // The envelope constructor verifies that all the constraints
        // are met, meaning that this method will always receive a valid
        // envelope. Invalid envelopes throw an exception in the constructor
        if (envelope.isStandard()) {
            if (envelope.getWeight() <= 30) {
                return 0.85;
            } else if (envelope.getWeight() <= 50) {
                return 1.20;
            }
        } else {
            if (envelope.getWeight() <= 100) {
                return 1.80;
            } else if (envelope.getWeight() <= 200) {
                return 2.95;
            } else if (envelope.getWeight() <= 300) {
                return 4.10;
            } else if (envelope.getWeight() <= 400) {
                return 4.70;
            } else if (envelope.getWeight() <= 500) {
                return 5.05;
            }
        }

        return -1.2;
    }

}
