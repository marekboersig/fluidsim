package com.fluidsim;

import com.fluidsim.backend.Coords;
import com.fluidsim.backend.Grid;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.fluidsim.Main.APP_WIDTH;
import static com.fluidsim.Main.APP_HEIGHT;
import static com.fluidsim.backend.Grid.GRID_FACTOR_HEIGHT;
import static com.fluidsim.backend.Grid.GRID_FACTOR_WIDTH;

public class CanvasHandler {
    private final Canvas canvas;
    private final GraphicsContext gc;
    private final Grid grid;

    public CanvasHandler(Grid grid) {
        this.grid = grid;
        canvas = new Canvas(APP_WIDTH, APP_HEIGHT);

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, APP_WIDTH, APP_HEIGHT);

        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            grid.spawnParticle(Utility.pixelToCoords((int) x, (int) y));
            updateCanvas();
        });
    }

    public void updateCanvas() {
        grid.getParticles().stream().filter(p -> p.updated).forEach(p -> {
            Coords pixel_c = Utility.coordsToPixel(p.getX(), p.getY());
            gc.setFill(Color.WHITE);
            gc.fillRect(pixel_c.x(), pixel_c.y(), GRID_FACTOR_WIDTH, GRID_FACTOR_HEIGHT);
            p.updated = false;
        });
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
