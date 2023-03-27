package ru.terrar.tumba.module;

import ru.terrar.tumba.module.modules.*;

import java.util.ArrayList;

/**
 * @author zTerrarxd_
 * @since 16:30 of 28.02.2023
 */
public class ModuleManager {
    public ArrayList<Module> modules=  new ArrayList<>();
    public ModuleManager(){
        modules.add(new ESP());
        modules.add(new Bright());
        modules.add(new AutoSprint());
        modules.add(new HitBox());
        modules.add(new TriggerBot());
        modules.add(new AimAssist());
    }

}
