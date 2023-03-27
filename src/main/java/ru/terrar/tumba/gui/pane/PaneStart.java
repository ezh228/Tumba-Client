package ru.terrar.tumba.gui.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ru.terrar.tumba.gui.ClickGui;
import ru.terrar.tumba.gui.PaneGui;

/**
 * @author zTerrarxd_
 * @since 12:06 of 28.02.2023
 */
public class PaneStart extends PaneGui {
    public PaneStart(){
        Text name = new Text(360, 150, "Tumba CLient");
        name.setStroke(new Color(254f/255f, 138f/255f, 44f/255f, 1));
        StackPane.setAlignment(name, Pos.CENTER);
        Button start = new Button("Start");
        start.setLayoutX(400-50);
        start.setLayoutY(270);
        start.setStyle("-fx-background-radius: 1em; -fx-border-radius: 1em; -fx-border-color: #FE8A2C; -fx-border-width: 3px; -fx-background-color: #491D00; -fx-text-fill: #FE8A2C;");
        start.setMinWidth(100);
        start.setMinHeight(50);
        //start.setBackground(new Background(new BackgroundFill(new Color(254f/255f, 138f/255f, 44f/255f, 1), new CornerRadii(5), new Insets(50))));
        getChildren().add(start);
        name.setScaleX(2);
        name.setScaleY(2);
        name.setScaleZ(2);
        name.setTextAlignment(TextAlignment.CENTER);
        getChildren().add(name);
        Image image = new Image("https://i.ibb.co/860D3Zm/logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(400-50);
        imageView.setY(20);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        getChildren().add(imageView);
        start.setOnAction((event) -> {
            ClickGui.displayPane(new PaneModules());
        });
    }
}
