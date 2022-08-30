package io.github.brassmc.api.mixin;

import io.github.brassmc.api.BrassAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("TAIL"), method = "<init>")
    private void test(GameConfig config, CallbackInfo ci) {
        BrassAPI.LOGGER.warn("Mixin applied!");
        System.exit(0);
    }
}
