package com.example.danielmacario.amp_ecse_428;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PostalCalculatorTest {

    private static final double DELTA = 0.00001;

    @Test
    public void standard_envelope_requirements() throws Exception {
        Envelope stdEnvelope = new Envelope(150.2, 110.1, 45.0);

        assertTrue(stdEnvelope.isStandard());
    }

    @Test
    public void nonstandard_envelope_requirements() throws Exception {
        Envelope nonstdEnvelope = new Envelope(300.0, 200.0, 200.0);

        assertFalse(nonstdEnvelope.isStandard());
    }

    @Test
    public void light_standard_envelope_rate() throws Exception {
        Envelope lightStdEnvelope = new Envelope(150.2, 110.1, 25.0);
        assertTrue(lightStdEnvelope.isStandard());
        assertEquals(0.85, PostalCalculator.calculateRate(lightStdEnvelope), DELTA);
    }

    @Test
    public void heavy_standard_envelope_rate() throws Exception {
        Envelope lightStdEnvelope = new Envelope(150.2, 110.1, 40.0);
        assertTrue(lightStdEnvelope.isStandard());
        assertEquals(1.20, PostalCalculator.calculateRate(lightStdEnvelope), DELTA);
    }

    @Test
    public void light_nonstandard_envelope_rate() throws Exception {
        Envelope envelope = new Envelope(300.0, 200.0, 50.0);
        assertFalse(envelope.isStandard());
        assertEquals(1.80, PostalCalculator.calculateRate(envelope), DELTA);
    }

    @Test
    public void light_medium_nonstandard_envelope_rate() throws Exception {
        Envelope envelope = new Envelope(300.0, 200.0, 150.0);
        assertFalse(envelope.isStandard());
        assertEquals(2.95, PostalCalculator.calculateRate(envelope), DELTA);
    }

    @Test
    public void medium_nonstandard_envelope_rate() throws Exception {
        Envelope lightStdEnvelope = new Envelope(300.0, 200.0, 250.0);
        assertFalse(lightStdEnvelope.isStandard());
        assertEquals(4.10, PostalCalculator.calculateRate(lightStdEnvelope), DELTA);
    }

    @Test
    public void medium_heavy_nonstandard_envelope_rate() throws Exception {
        Envelope envelope = new Envelope(300.0, 200.0, 350.0);
        assertFalse(envelope.isStandard());
        assertEquals(4.70, PostalCalculator.calculateRate(envelope), DELTA);
    }

    @Test
    public void heavy_nonstandard_envelope_rate() throws Exception {
        Envelope envelope = new Envelope(300.0, 200.0, 450.0);
        assertFalse(envelope.isStandard());
        assertEquals(5.05, PostalCalculator.calculateRate(envelope), DELTA);
    }

    @Test(expected = MyInputException.class)
    public void length_larger_than_max_exception() throws Exception {
        Envelope envelope = new Envelope(400.0, 200.0, 50.0);
    }

    @Test(expected = MyInputException.class)
    public void length_smaller_than_min_exception() throws Exception {
        Envelope envelope = new Envelope(100, 200.0, 50.0);
    }

    @Test(expected = MyInputException.class)
    public void width_larger_than_max_exception() throws Exception {
        Envelope envelope = new Envelope(150.0, 300.0, 50.0);
    }

    @Test(expected = MyInputException.class)
    public void width_smaller_than_min_exception() throws Exception {
        Envelope envelope = new Envelope(150.0, 50.0, 50.0);
    }

    @Test(expected = MyInputException.class)
    public void weight_larger_than_max_exception() throws Exception {
        Envelope envelope = new Envelope(150.0, 150, 1.0);
    }

    @Test(expected = MyInputException.class)
    public void weight_smaller_than_min_exception() throws Exception {
        Envelope envelope = new Envelope(150.0, 150, 700.0);
    }



}