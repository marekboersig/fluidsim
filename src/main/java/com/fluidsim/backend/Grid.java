package com.fluidsim.backend;

import java.util.ArrayList;
import java.util.List;

import static com.fluidsim.Main.APP_HEIGHT;
import static com.fluidsim.Main.APP_WIDTH;

public class Grid {
    public static final int GRID_WIDTH = 200;
    public static final int GRID_HEIGHT = 160;

    public static int GRID_FACTOR_WIDTH = APP_WIDTH / GRID_WIDTH;
    public static int GRID_FACTOR_HEIGHT = APP_HEIGHT / GRID_HEIGHT;

    private final Particle[][] cells;
    private List<Particle> particleList = new ArrayList<>();

    public Grid() {
        this.cells = new Particle[GRID_WIDTH][GRID_HEIGHT];
    }

    public List<Particle> getParticles() {
        return particleList;
    }

    public void spawnParticle(Coords c) {
        if (cells[c.x()][c.y()] == null) {
            Particle tmp = new Particle(c.x(), c.y());
            cells[c.x()][c.y()] = tmp;
            particleList.add(tmp);
        }
    }

    public Particle getCell(int x, int y) {
        return cells[x][y];
    }
}
