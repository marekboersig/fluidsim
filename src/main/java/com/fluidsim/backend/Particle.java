package com.fluidsim.backend;

public class Particle {
    private int x_ind;
    private int y_ind;

    private ParticleType type;

    public Particle(int x_ind, int y_ind, ParticleType type) {
        this.x_ind = x_ind;
        this.y_ind = y_ind;
        this.type = type;
    }

    public ParticleType getType() {
        return type;
    }

    public void setX(int x) {
        this.x_ind = x;
    }

    public void setY(int y) {
        this.y_ind = y;
    }

    public int getX() {
        return x_ind;
    }

    public int getY() {
        return y_ind;
    }
}
