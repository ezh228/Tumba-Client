package ru.terrar.tumba.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


/**
 * @author zTerrarxd_
 * @since 11:59 of 28.02.2023
 */
public class PaneGui extends Pane {
    public PaneGui(){

        for (int x = 0; x < 800; x+=25) {
            if (!(x==0 || x==800)){
                Line line=  new Line();
                line.setStartX(x);
                line.setStartY(6);
                line.setEndX(x);
                line.setEndY(450-6);
                line.setStroke(new Color(37f/255f, 17f/255f, 3f/255f, 1));
                getChildren().add(line);
            }

        }

        for (int y = 0; y < 450; y+=25) {
            if (!(y==0 || y==450)){
                Line line=  new Line();
                line.setStartX(6);
                line.setStartY(y);
                line.setEndX(800-6);
                line.setEndY(y);
                line.setStroke(new Color(37f/255f, 17f/255f, 3f/255f, 1));
                getChildren().add(line);
            }

        }
        setStyle("-fx-background-color: #0E0600; -fx-background-size: 800 450; -fx-background-radius: 30; -fx-border-radius: 30; -fx-border-width:5; -fx-border-color: #FE8A2C;");
        Button closeButton = new Button("X");
        closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #ff0000;");
        closeButton.setMinHeight(10);
        closeButton.setMinWidth(10);
        closeButton.setOnAction((event) -> {
            ClickGui.close();
        });
        closeButton.setLayoutX(763);
        closeButton.setLayoutY(10);
        getChildren().add(closeButton);
    }
}
