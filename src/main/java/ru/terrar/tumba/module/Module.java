package ru.terrar.tumba.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import ru.terrar.tumba.gui.ClickGui;
import ru.terrar.tumba.gui.pane.PaneModules;
import ru.terrar.tumba.setting.Setting;

import java.util.ArrayList;

/**
 * @author zTerrarxd_
 * @since 16:04 of 28.02.2023
 */
public class Module {
    protected Minecraft mc=  Minecraft.getInstance();
    String name;
    int key;
    boolean enabled = false;

    ArrayList<Setting> settings=  new ArrayList<>();


    public ArrayList<Setting> getSettings() {
        return settings;
    }

    public void addSetting(Setting setting){
        settings.add(setting);
    }

    public Module(String name){
        this.name=  name;
    }

    public String getName() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled){
            onEnable();
        }else {
            onDisable();
        }
        if (ClickGui.pane instanceof PaneModules){
            for (PaneModules.Mod mod : ((PaneModules) ClickGui.pane).mods){
                if (mod.module == this){
                    mod.update();
                }
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void toggle(){
        setEnabled(!isEnabled());
    }
    public void onEnable(){
        MinecraftForge.EVENT_BUS.register(this);
    }
    public void onDisable(){
        MinecraftForge.EVENT_BUS.unregister(this);

    }
}
