package ru.terrar.tumba;


import javafx.application.Application;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.gui.ClickGui;
import ru.terrar.tumba.module.Module;
import ru.terrar.tumba.module.ModuleManager;
import ru.terrar.tumba.overlay.Overlay;

import javax.swing.*;
import java.awt.*;

/**
 * @author zTerrarxd_
 * @since 18:02 of 27.02.2023
 */
public class Client {
    public static Client instance;
    public ModuleManager moduleManager;
    boolean bind = false;
    public Module binding;
    public Client(){
        MinecraftForge.EVENT_BUS.register(this);
        moduleManager = new ModuleManager();
            Thread one = new Thread() {
                public void run() {
                    Application.launch(ClickGui.class);
                }
            };
            one.start();





    }

    public static void main(String[] args) {
        Client.instance = new Client();

    }

    public void bindModule(Module module){
        bind = true;
        binding  =module;
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event){
        if (event.getAction() == 1){
            if (bind){
                binding.setKey(event.getKey());
                bind = false;
            }else {
                for (Module module : moduleManager.modules){
                    if (module.getKey() == event.getKey()){
                        module.toggle();
                    }
                }
            }
        }

    }




}
