package ru.terrar.tumba.gui;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.terrar.tumba.Client;
import ru.terrar.tumba.gui.pane.PaneStart;
import ru.terrar.tumba.module.Module;


/**
 * @author zTerrarxd_
 * @since 19:58 of 27.02.2023
 */
public class ClickGui extends Application {
    public static Stage stage;
    static double xOffset;
    static double yOffset;
    public static PaneGui pane;

    @Override
    public void start(Stage staged) throws Exception {
        stage = staged;

        Scene scene = new Scene(new PaneStart(), 800, 450);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.setTitle("Tumba Client");

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setResizable(false);
        stage.show();

    }

    public static void displayPane(PaneGui paneGui){
        pane = paneGui;
        Scene scene = new Scene(paneGui, 800, 450);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                event.getCode().getName();
            }
        });
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.setTitle("Tumba Client");

        //stage.initStyle(StageStyle.TRANSPARENT);

        stage.setResizable(false);
        stage.show();
    }

    public static void close(){
        stage.close();
        for (Module module : Client.instance.moduleManager.modules){
            module.setEnabled(false);
        }
    }
}
