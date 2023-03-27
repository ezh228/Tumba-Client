package ru.terrar.tumba.gui.pane;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import net.java.games.input.Controller;
import net.java.games.input.Keyboard;
import ru.terrar.tumba.Client;
import ru.terrar.tumba.gui.ClickGui;
import ru.terrar.tumba.gui.PaneGui;
import ru.terrar.tumba.module.Module;

import javax.net.ssl.KeyManager;
import java.util.ArrayList;

/**
 * @author zTerrarxd_
 * @since 14:42 of 28.02.2023
 */
public class PaneModules extends PaneGui {
    public ArrayList<Mod> mods = new ArrayList<>();

    public class Mod{
        public Button button;
        public Module module;

        public void update(){
            if (module.isEnabled()){
                button.setStyle("-fx-background-radius: 1em; -fx-border-radius: 1em; -fx-border-color: #FE8A2C; -fx-border-width: 3px; -fx-background-color: #491D00; -fx-text-fill: #FE8A2C;");
            }else {
                button.setStyle("-fx-background-radius: 1em; -fx-border-radius: 1em; -fx-border-color: #FE8A2C; -fx-border-width: 3px; -fx-background-color: #491D00; -fx-text-fill: #ffffff;");
            }
        }
        public Mod(Module module, int y){
            this.module= module;
            button = new Button(module.getName());

            button.setLayoutX(20);
            button.setLayoutY(y);
            button.setMinWidth(760);
            button.setMinHeight(40);
            update();
            getChildren().add(button);

            button.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    MouseButton click = event.getButton();
                    if(click==MouseButton.PRIMARY){

                        module.toggle();

                    }else if(click==MouseButton.SECONDARY){
                        ClickGui.displayPane(new PaneSettings(module));
                    }else if(click==MouseButton.MIDDLE){
                        Client.instance.bindModule(module);
                    }
                }
            });
        }
    }
    public PaneModules(){
        int y = 35;
        for (Module module : Client.instance.moduleManager.modules){
            mods.add(new Mod(module, y));
            y+=50;
        }

    }



}
