package ru.terrar.tumba.gui.pane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ru.terrar.tumba.gui.ClickGui;
import ru.terrar.tumba.gui.PaneGui;
import ru.terrar.tumba.module.Module;
import ru.terrar.tumba.setting.BoolSetting;
import ru.terrar.tumba.setting.FloatSetting;
import ru.terrar.tumba.setting.Setting;

import java.awt.*;

/**
 * @author zTerrarxd_
 * @since 18:22 of 01.03.2023
 */
public class PaneSettings extends PaneGui {
    public PaneSettings(Module module){
        int y = 35;

        Button closeButton = new Button("<");
        closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #FE8A2C;");
        closeButton.setMinHeight(10);
        closeButton.setMinWidth(10);
        closeButton.setOnAction((event) -> {
            ClickGui.displayPane(new PaneModules());
        });
        closeButton.setLayoutX(10);
        closeButton.setLayoutY(10);
        getChildren().add(closeButton);
        for (Setting setting : module.getSettings()){
            if (setting instanceof BoolSetting){
                RadioButton button = new RadioButton(setting.getName());
                button.setSelected(((BoolSetting) setting).getVal());
                button.setLayoutX(20);
                button.setLayoutY(y);
                button.setMinWidth(760);
                button.setMinHeight(40);
                
                button.setStyle("-fx-background-radius: 1em; -fx-border-radius: 1em; -fx-border-color: #FE8A2C; -fx-border-width: 3px; -fx-background-color: #491D00; -fx-text-fill: #ffffff; -fx-box-background-color: red;");

                getChildren().add(button);
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        ((BoolSetting) setting).setVal(button.isSelected());


                    }
                });
                y+=50;
            }
            if (setting instanceof FloatSetting){
                //Rect
                Region rect = new Region();
                rect.setLayoutX(20);
                rect.setLayoutY(y);
                rect.setMinWidth(760);
                rect.setMinHeight(80);
                rect.setStyle("-fx-background-radius: 1em; -fx-border-radius: 1em; -fx-border-color: #FE8A2C; -fx-border-width: 3px; -fx-background-color: #491D00; -fx-text-fill: #000000; -fx-box-background-color: red;");
                getChildren().add(rect);

                //Text
                Text name = new Text(setting.getName());
                name.setLayoutY(y+25);
                name.setLayoutX(35);
                name.setStroke(Color.WHITE);
                name.setFill(Color.WHITE);
                getChildren().add(name);

                //Slider
                Slider slider = new Slider(((FloatSetting) setting).getMin(), ((FloatSetting) setting).getMax(), ((FloatSetting) setting).getVal());
                slider.setLayoutX(30);
                slider.setLayoutY(y+30);
                slider.setMinWidth(740);
                slider.setMinHeight(20);
                slider.setShowTickLabels(true);
                slider.setShowTickMarks(true);
                getChildren().add(slider);
                slider.setOnMouseReleased(event -> {
                    ((FloatSetting) setting).setVal((float) slider.getValue());
                });
                //Value
                Text value = new Text();
                value.textProperty().bind(slider.valueProperty().asString("%.1f"));
                value.setLayoutY(y+25);
                value.setLayoutX(745);
                value.setTextAlignment(TextAlignment.RIGHT);

                value.setStroke(Color.WHITE);
                value.setFill(Color.WHITE);
                getChildren().add(value);
                y+=90;

            }


        }
    }

}
