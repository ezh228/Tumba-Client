package ru.terrar.tumba.module.modules;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ru.terrar.tumba.module.Module;
import ru.terrar.tumba.setting.BoolSetting;
import ru.terrar.tumba.setting.FloatSetting;
import ru.terrar.tumba.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author zTerrarxd_
 * @since 20:13 of 07.03.2023
 */
public class AimAssist extends Module {
    BoolSetting toHitbox;
    FloatSetting range;
    FloatSetting fov;
    FloatSetting speed;

    public AimAssist() {
        super("AimAssist");
        addSetting(range = new FloatSetting("Range", 0, 10, 6));
        addSetting(fov = new FloatSetting("Fov", 0, 360, 110));
        addSetting(speed = new FloatSetting("Speed", 0, 100, 45));
        addSetting(toHitbox = new BoolSetting("To HitBox", false));
        /*
        addSetting(yawRandomize = new BoolSetting("YawRandomize", true));
        addSetting(yawRandom = new FloatSetting("YawRandom", 0, 20, 10));
        addSetting(pitchRandomize = new BoolSetting("PitchRandomize", false));
        addSetting(pitchRandom = new FloatSetting("PitchRandom", 0, 20, 3));

         */
    }


    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event){
        if (toHitbox.getVal() && ((EntityRayTraceResult)mc.hitResult).getEntity() != null && ((EntityRayTraceResult)mc.hitResult).getEntity() instanceof PlayerEntity){
            return;
        }
        Entity player = null;
        ArrayList<PlayerEntity> playerEntities = new ArrayList<>();
        for (Entity entity : mc.level.players()){
            PlayerEntity player2 = (PlayerEntity) entity;
            if (player2.getHealth() > 0 && player2.distanceTo(mc.player) <= range.getVal() && player2 != mc.player && Utils.fov(entity, fov.getVal() * 2)){
                playerEntities.add(player2);

            }
        }
        playerEntities.sort(new Comparator<PlayerEntity>() {
            @Override
            public int compare(PlayerEntity o1, PlayerEntity o2) {
                return (int) (mc.player.distanceTo(o1) - mc.player.distanceTo(o2));
            }
        });
        if (playerEntities.size() > 0){
            player = playerEntities.get(0);
        }
        if (player == null){
            return;
        }


        double n = getAimYaw(player);
        if (n > 1.0D || n < -1.0D) {
            float val = (float)(-(n / (101.0D - speed.getVal())));
            mc.player.yRot += val;
        }
        /*
        try{
            if(mc.hitResult != null){
                if (((EntityRayTraceResult)mc.hitResult).getEntity() != null){
                    if ( ((EntityRayTraceResult)mc.hitResult).getEntity() == player){
                        if (yawRandomize.getVal()){
                            mc.player.yRot+=motionYaw / 10;
                            motionYaw-=motionYaw / 10;c
                        }
                        if (pitchRandomize.getVal()){
                            mc.player.xRot+=motionPitch / 10;
                            motionYaw-=motionPitch / 10;
                        }

                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         */



    }


    public  double getAimYaw(Entity en) {
        return ((double)(mc.player.yRot - m(en)) % 360.0D + 540.0D) % 360.0D - 180.0D;
    }


    public float m(Entity ent) {
        double x = ent.getX() - mc.player.getX();
        double z = ent.getZ() - mc.player.getZ();
        double yaw = Math.atan2(x, z) * 57.2957795D;
        return (float)(yaw * -1.0D);
    }
}
