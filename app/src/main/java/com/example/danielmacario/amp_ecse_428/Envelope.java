package com.example.danielmacario.amp_ecse_428;

public class Envelope {

    private double width;
    private double length;
    private double weight;
    private boolean standard;

    public Envelope(double length, double width, double weight) throws MyInputException {
        if (length < 140.0 || length > 380.0) {
            throw new MyInputException("Invalid length value");
        }
        if (width < 90 || width > 270) {
            throw new MyInputException("Invalid width value");
        }
        if (weight < 2 || weight > 500) {
            throw new MyInputException("Invalid weight value");
        }

        this.width = width;
        this.length = length;
        this.weight = weight;
        this.checkIsStandard();
    }

    public void checkIsStandard() {
        if (length >= 140 && length <= 245 && width >= 90 && width <= 156 && weight >= 2 &&
                weight <= 50) {
            this.setStandard(true);
        }
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public boolean isStandard() {
        return standard;
    }
}
