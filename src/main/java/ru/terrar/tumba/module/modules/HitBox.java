package ru.terrar.tumba.module.modules;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.module.Module;
import ru.terrar.tumba.setting.FloatSetting;

/**
 * @author zTerrarxd_
 * @since 16:11 of 01.03.2023
 */
public class HitBox extends Module {
    FloatSetting side;
    public HitBox() {
        super("HitBox");
        addSetting(side = new FloatSetting("Size", 0, 2, 0.3f));
    }

    @SubscribeEvent
    public void onTick(PlayerEvent event){
        for (PlayerEntity player : mc.level.players()){
            if (player!=mc.player){
                double size = side.getVal();
                player.setBoundingBox(new AxisAlignedBB(player.getX()-0.3d-size, player.getY(), player.getZ()-0.3d-size, player.getX()+0.3d+size, player.getY()+1.8d, player.getZ()+0.3d+size));
            }
        }
    }
}
