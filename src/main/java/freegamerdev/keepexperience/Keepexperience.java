package freegamerdev.keepexperience;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class Keepexperience implements ModInitializer {

    @Override
    public void onInitialize() {
        ServerPlayerEvents.AFTER_RESPAWN.register(this::onPlayerRespawn);
    }

    private void onPlayerRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if (!alive) {
            newPlayer.experienceLevel = oldPlayer.experienceLevel;
            newPlayer.experienceProgress = oldPlayer.experienceProgress;
        }
    }
}
