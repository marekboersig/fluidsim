package com.fluidsim;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int APP_WIDTH = 1000;
    public static final int APP_HEIGHT = 800;

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT, Color.WHITE);

        CanvasHandler canvasHandler = new CanvasHandler();
        root.getChildren().add(canvasHandler.getCanvas());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}