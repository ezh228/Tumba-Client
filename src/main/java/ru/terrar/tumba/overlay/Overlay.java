package ru.terrar.tumba.overlay;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.terrar.tumba.Client;
import ru.terrar.tumba.gui.pane.PaneStart;
import ru.terrar.tumba.module.Module;


/**
 * @author zTerrarxd_
 * @since 19:58 of 27.02.2023
 */
public class Overlay extends Application {
    public static Stage stage;
    static double xOffset;
    static double yOffset;

    @Override
    public void start(Stage staged) throws Exception {
        stage = staged;
        Pane pane = new Pane();
        Text text= new Text("Tumba");
        text.setLayoutX(50);
        text.setLayoutY(50);
        text.setScaleX(2);
        text.setScaleY(2);
        text.setScaleZ(2);
        text.setStroke(new Color(254f/255f, 138f/255f, 44f/255f, 1));

        pane.getChildren().add(text);
        Scene scene = new Scene(pane, java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);

        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.setTitle("Overlay");

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);

        stage.setResizable(false);
        stage.show();

    }


}
