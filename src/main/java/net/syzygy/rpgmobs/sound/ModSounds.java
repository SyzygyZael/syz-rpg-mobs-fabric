package net.syzygy.rpgmobs.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ModSounds {
    public static final SoundEvent TWISTED_TREANT_ROAR = registerSoundEvent("twisted_treant_roar");
    public static final SoundEvent TWISTED_TREANT_AMBIENT = registerSoundEvent("twisted_treant_ambient");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(RPGMobs.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        RPGMobs.LOGGER.info("Registering ModSounds for " + RPGMobs.MOD_ID);
    }
}
