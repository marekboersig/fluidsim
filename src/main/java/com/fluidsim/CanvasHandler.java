package com.fluidsim;

import com.fluidsim.backend.Coords;
import com.fluidsim.backend.Grid;
import com.fluidsim.backend.Particle;
import com.fluidsim.backend.ParticleType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Iterator;

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
        updateCanvas();

        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            grid.spawnParticle(Utility.pixelToCoords((int) x, (int) y), ParticleType.EARTH);
            updateCanvas();
        });
    }

    public void updateCanvas() {
        Iterator<Particle> it = grid.getParticles().iterator();

        while (it.hasNext()) {
            Particle p = it.next();
            Coords pixel_c = Utility.coordsToPixel(p.getX(), p.getY());

            gc.setFill(p.getType().getColor());
            gc.fillRect(pixel_c.x(), pixel_c.y(), GRID_FACTOR_WIDTH, GRID_FACTOR_HEIGHT);

            it.remove();
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
