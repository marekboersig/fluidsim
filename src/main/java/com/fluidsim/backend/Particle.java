package com.fluidsim.backend;

public class Particle {
    int x_ind;
    int y_ind;

    public boolean updated;

    public Particle(int x_ind, int y_ind) {
        this.x_ind = x_ind;
        this.y_ind = y_ind;

        updated = true;
    }

    public int getX() {
        return x_ind;
    }

    public int getY() {
        return y_ind;
    }
}
