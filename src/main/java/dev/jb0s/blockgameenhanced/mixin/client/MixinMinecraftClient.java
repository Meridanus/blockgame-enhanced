package dev.jb0s.blockgameenhanced.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    private static final MusicSound MUSIC_SILENCE = new MusicSound(new SoundEvent(new Identifier("blockgame", "silence")), 999999, 999999, false);

    @Inject(method = "getMusicType", at = @At("RETURN"), cancellable = true)
    public void getMusicType(CallbackInfoReturnable<MusicSound> cir) {
        World world = MinecraftClient.getInstance().world;
        if(world != null) {
            cir.setReturnValue(MUSIC_SILENCE);
        }
    }
}
