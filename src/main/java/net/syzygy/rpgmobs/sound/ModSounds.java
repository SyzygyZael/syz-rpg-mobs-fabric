package net.syzygy.rpgmobs.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.syzygy.rpgmobs.RPGMobs;

public class ModSounds {
    public static final SoundEvent TWISTED_TREANT_ROAR = registerSoundEvent("twisted_treant_roar");
    public static final SoundEvent TWISTED_TREANT_AMBIENT = registerSoundEvent("twisted_treant_ambient");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(RPGMobs.MOD_ID, name);
        SoundEvent soundEvent = new SoundEvent(new Identifier(RPGMobs.MOD_ID, name));

        return Registry.register(Registry.SOUND_EVENT, identifier, soundEvent);
    }

    public static void registerSounds() {
        RPGMobs.LOGGER.info("Registering ModSounds for " + RPGMobs.MOD_ID);
    }
}
