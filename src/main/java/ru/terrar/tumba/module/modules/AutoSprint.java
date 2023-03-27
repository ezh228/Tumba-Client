package ru.terrar.tumba.module.modules;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.module.Module;

/**
 * @author zTerrarxd_
 * @since 21:39 of 28.02.2023
 */
public class AutoSprint extends Module {
    public AutoSprint() {
        super("AutoSprint");
    }

    @SubscribeEvent
    public void onTick(PlayerEvent event){
        mc.options.keySprint.setDown(true);
    }
}
