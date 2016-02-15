package com.example.danielmacario.amp_ecse_428;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PostalCalculatorTest {

    @Test
    public void standard_envelope_requirements() throws Exception {
        Envelope stdEnvelope = new Envelope(150.2, 110.1, 45.0, Envelope.Destination.CANADA);

        assertTrue(stdEnvelope.isStandard());
    }

    @Test
    public void nonstandard_envelope_requirements() throws Exception {
        Envelope nonstdEnvelope = new Envelope(300.0, 200.0, 200.0, Envelope.Destination.CANADA);

        assertFalse(nonstdEnvelope.isStandard());
    }

    @Test
    public void light_standard_envelope_rate() throws Exception {
        Envelope lightStdEnvelope = new Envelope(150.2, 110.1, 25.0, Envelope.Destination.CANADA);
        assertEquals(PostalCalculator.calculateRate(lightStdEnvelope), 0.49);
    }


}