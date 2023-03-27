package ru.terrar.tumba.module.modules;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.module.Module;
import ru.terrar.tumba.setting.BoolSetting;

/**
 * @author zTerrarxd_
 * @since 19:29 of 28.02.2023
 */
public class ESP extends Module {
    public ESP() {
        super("ESP");
    }
    @SubscribeEvent
    public void onTick(PlayerEvent event){
        for(PlayerEntity players : mc.level.players()){
            if (!players.isGlowing()){
                players.setGlowing(true);
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        for(PlayerEntity players : mc.level.players()){
            if (players.isGlowing()){
                players.setGlowing(false);
            }
        }
    }
}
