package com.fluidsim;

import com.fluidsim.backend.Coords;
import com.fluidsim.backend.Grid;

import static com.fluidsim.Main.APP_HEIGHT;
import static com.fluidsim.Main.APP_WIDTH;

public class Utility {
    public static Coords coordsToPixel(int x, int y) {
        if (x < 0 || x >= Grid.GRID_WIDTH || y < 0 || y >= Grid.GRID_HEIGHT) {
            throw new IllegalArgumentException("Grid Coords out of bounds! X = " + x + ", Y = " + y);
        }

        return new Coords(x * Grid.GRID_FACTOR_WIDTH, y * Grid.GRID_FACTOR_HEIGHT);
    }

    public static Coords pixelToCoords(int px_x, int px_y) {
        if (px_x < 0 || px_x >= APP_WIDTH || px_y < 0 || px_y >= APP_HEIGHT) {
            throw new IllegalArgumentException("Pixel Coords out of bounds! X = " + px_x + ", Y = " + px_y);
        }
        return new Coords(px_x / Grid.GRID_FACTOR_WIDTH, px_y / Grid.GRID_FACTOR_HEIGHT);
    }
}
