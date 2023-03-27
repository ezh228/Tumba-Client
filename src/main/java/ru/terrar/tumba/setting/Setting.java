package ru.terrar.tumba.setting;

import java.util.Set;
import java.util.function.Supplier;

/**
 * @author zTerrarxd_
 * @since 17:00 of 01.02.2023
 */
public class Setting {
    String name;
    Supplier<Boolean> visable;
    public Setting(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean isVisable(){
        return visable.get();
    }

    public Setting setVisable(Supplier<Boolean> visable) {
        this.visable = visable;
        return this;
    }
}
