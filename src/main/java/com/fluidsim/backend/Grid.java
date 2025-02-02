package com.fluidsim.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fluidsim.Main.APP_HEIGHT;
import static com.fluidsim.Main.APP_WIDTH;

public class Grid {
    public static final int GRID_WIDTH = 200;
    public static final int GRID_HEIGHT = 160;

    public static int GRID_FACTOR_WIDTH = APP_WIDTH / GRID_WIDTH;
    public static int GRID_FACTOR_HEIGHT = APP_HEIGHT / GRID_HEIGHT;

    private final Particle[][] cells;
    private List<Particle> updatedParticles = new ArrayList<>();

    public Grid() {
        this.cells = new Particle[GRID_WIDTH][GRID_HEIGHT];

        // fill grid with air particles
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                cells[i][j] = new Particle(i, j, ParticleType.AIR);
                updatedParticles.add(cells[i][j]);
            }
        }
    }

    public List<Particle> getParticles() {
        return updatedParticles;
    }

    public void spawnParticle(Coords c, ParticleType type) {
        Particle tmp = new Particle(c.x(), c.y(), type);
        cells[c.x()][c.y()] = tmp;
        updatedParticles.add(tmp);
    }

    public Particle getCell(int x, int y) {
        return cells[x][y];
    }
}
