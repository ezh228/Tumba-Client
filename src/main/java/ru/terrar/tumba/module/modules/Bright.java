package ru.terrar.tumba.module.modules;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.module.Module;

/**
 * @author zTerrarxd_
 * @since 21:40 of 28.02.2023
 */
public class Bright extends Module {
    double gamma=0;
    public Bright() {
        super("Bright+");
    }
    @SubscribeEvent
    public void onTick(PlayerEvent event){
        gamma = mc.options.gamma;
        mc.options.gamma=10;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.options.gamma = gamma;
    }
}
