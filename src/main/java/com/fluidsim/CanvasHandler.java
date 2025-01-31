package com.fluidsim;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.fluidsim.Main.APP_WIDTH;
import static com.fluidsim.Main.APP_HEIGHT;

public class CanvasHandler {
    private final Canvas canvas;
    private final GraphicsContext gc;

    public CanvasHandler() {
        canvas = new Canvas(APP_WIDTH, APP_HEIGHT);

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, APP_WIDTH, APP_HEIGHT);

        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            // spawn particle
            System.out.println("Canvas clicked at: " + x + " | " + y);
        });
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
