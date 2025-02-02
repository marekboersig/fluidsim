package com.fluidsim.backend;

import javafx.scene.paint.Color;

public enum ParticleType {
    AIR(1.225, Color.LIGHTBLUE), // density in kg / m3
    EARTH(5515.0, Color.BROWN);
    // add further particle types here

    private final Color color;
    private final double density;

    ParticleType(double density, Color color) {
        this.color = color;
        this.density = density;
    }

    public Color getColor() {
        return color;
    }

    public double getDensity() {
        return density;
    }
}
