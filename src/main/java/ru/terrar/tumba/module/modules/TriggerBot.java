package ru.terrar.tumba.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.module.Module;
import ru.terrar.tumba.setting.BoolSetting;
import ru.terrar.tumba.setting.FloatSetting;
import ru.terrar.tumba.utils.Utils;

/**
 * @author zTerrarxd_
 * @since 21:51 of 04.03.2023
 */
public class TriggerBot extends Module {
    FloatSetting yawRandom;
    FloatSetting pitchRandom;
    public TriggerBot() {
        super("TriggerBot");
        addSetting(yawRandom = new FloatSetting("YawRandom", 0, 20, 10));
        addSetting(pitchRandom = new FloatSetting("PitchRandom", 0, 20, 3));
    }


    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event){

        if (mc.hitResult != null)
            if (mc.hitResult.getType()== RayTraceResult.Type.ENTITY){
                if (((EntityRayTraceResult) mc.hitResult).getEntity() instanceof PlayerEntity && mc.player.canAttack((LivingEntity) ((EntityRayTraceResult) mc.hitResult).getEntity()) && mc.player.getAttackStrengthScale(0.85f) >= 1){
                    mc.gameMode.attack(mc.player, ((EntityRayTraceResult) mc.hitResult).getEntity());
                    mc.player.swing(Hand.MAIN_HAND);
                    mc.player.yRot+= Utils.randFloat(-(yawRandom.getVal()/yawRandom.getMax()), yawRandom.getVal()/yawRandom.getMax());
                    mc.player.xRot+= Utils.randFloat(-(pitchRandom.getVal()/pitchRandom.getMax()), pitchRandom.getVal()/pitchRandom.getMax());

                }
            }


    }
}
