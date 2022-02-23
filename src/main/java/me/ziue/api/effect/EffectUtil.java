package me.ziue.api.effect;

import lombok.experimental.UtilityClass;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

@UtilityClass
public class EffectUtil {

    // Play effect using arguments, player & effect.
    public void play(Player player, String effect) {
        // Check if effect isn't empty.
        if (!effect.isEmpty()) {
            // Play effect at the players' location, using effect in arguments[2].
            player.getWorld().spigot().playEffect(player.getLocation(), Effect.valueOf(effect), 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
        }
    }
}
/*
    Effects

    CLICK2(1000, Effect.Type.SOUND),
    CLICK1(1001, Effect.Type.SOUND),
    BOW_FIRE(1002, Effect.Type.SOUND),
    DOOR_TOGGLE(1003, Effect.Type.SOUND),
    EXTINGUISH(1004, Effect.Type.SOUND),
    RECORD_PLAY(1005, Effect.Type.SOUND, Material.class),
    GHAST_SHRIEK(1007, Effect.Type.SOUND),
    GHAST_SHOOT(1008, Effect.Type.SOUND),
    BLAZE_SHOOT(1009, Effect.Type.SOUND),
    ZOMBIE_CHEW_WOODEN_DOOR(1010, Effect.Type.SOUND),
    ZOMBIE_CHEW_IRON_DOOR(1011, Effect.Type.SOUND),
    ZOMBIE_DESTROY_DOOR(1012, Effect.Type.SOUND),
    SMOKE(2000, Effect.Type.VISUAL, BlockFace.class),
    STEP_SOUND(2001, Effect.Type.SOUND, Material.class),
    POTION_BREAK(2002, Effect.Type.VISUAL, Potion.class),
    ENDER_SIGNAL(2003, Effect.Type.VISUAL),
    MOBSPAWNER_FLAMES(2004, Effect.Type.VISUAL),
    FIREWORKS_SPARK("fireworksSpark", Effect.Type.PARTICLE),
    CRIT("crit", Effect.Type.PARTICLE),
    MAGIC_CRIT("magicCrit", Effect.Type.PARTICLE),
    POTION_SWIRL("mobSpell", Effect.Type.PARTICLE),
    POTION_SWIRL_TRANSPARENT("mobSpellAmbient", Effect.Type.PARTICLE),
    SPELL("spell", Effect.Type.PARTICLE),
    INSTANT_SPELL("instantSpell", Effect.Type.PARTICLE),
    WITCH_MAGIC("witchMagic", Effect.Type.PARTICLE),
    NOTE("note", Effect.Type.PARTICLE),
    PORTAL("portal", Effect.Type.PARTICLE),
    FLYING_GLYPH("enchantmenttable", Effect.Type.PARTICLE),
    FLAME("flame", Effect.Type.PARTICLE),
    LAVA_POP("lava", Effect.Type.PARTICLE),
    FOOTSTEP("footstep", Effect.Type.PARTICLE),
    SPLASH("splash", Effect.Type.PARTICLE),
    PARTICLE_SMOKE("smoke", Effect.Type.PARTICLE),
    EXPLOSION_HUGE("hugeexplosion", Effect.Type.PARTICLE),
    EXPLOSION_LARGE("largeexplode", Effect.Type.PARTICLE),
    EXPLOSION("explode", Effect.Type.PARTICLE),
    VOID_FOG("depthsuspend", Effect.Type.PARTICLE),
    SMALL_SMOKE("townaura", Effect.Type.PARTICLE),
    CLOUD("cloud", Effect.Type.PARTICLE),
    COLOURED_DUST("reddust", Effect.Type.PARTICLE),
    SNOWBALL_BREAK("snowballpoof", Effect.Type.PARTICLE),
    WATERDRIP("dripWater", Effect.Type.PARTICLE),
    LAVADRIP("dripLava", Effect.Type.PARTICLE),
    SNOW_SHOVEL("snowshovel", Effect.Type.PARTICLE),
    SLIME("slime", Effect.Type.PARTICLE),
    HEART("heart", Effect.Type.PARTICLE),
    VILLAGER_THUNDERCLOUD("angryVillager", Effect.Type.PARTICLE),
    HAPPY_VILLAGER("happyVillager", Effect.Type.PARTICLE),
    LARGE_SMOKE("largesmoke", Effect.Type.PARTICLE),
    ITEM_BREAK("iconcrack", Effect.Type.PARTICLE, Material.class),
    TILE_BREAK("blockcrack", Effect.Type.PARTICLE, MaterialData.class),
    TILE_DUST("blockdust", Effect.Type.PARTICLE, MaterialData.class);
*/
