package ru.terrar.tumba.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

import java.util.Random;

/**
 * @author zTerrarxd_
 * @since 20:19 of 07.03.2023
 */
public class Utils {
    public static float randFloat(float min, float max) {

        Random rand = new Random();

        return rand.nextFloat() * (max - min) + min;

    }
    public static boolean fov(Entity entity, float fov) {
        fov = (float)((double)fov * 0.5D);
        double v = ((double)(Minecraft.getInstance().player.yRot - fovToEntity(entity)) % 360.0D + 540.0D) % 360.0D - 180.0D;
        return v > 0.0D && v < (double)fov || (double)(-fov) < v && v < 0.0D;
    }
    public static double fovFromEntity(Entity en) {
        return ((double)(Minecraft.getInstance().player.yRot - fovToEntity(en)) % 360.0D + 540.0D) % 360.0D - 180.0D;
    }

    public static float fovToEntity(Entity ent) {
        double x = ent.getX() - Minecraft.getInstance().player.getX();
        double z = ent.getZ() - Minecraft.getInstance().player.getZ();
        double yaw = Math.atan2(x, z) * 57.2957795D;
        return (float)(yaw * -1.0D);
    }
}
