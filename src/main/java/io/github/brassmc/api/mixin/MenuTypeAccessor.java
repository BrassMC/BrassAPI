package io.github.brassmc.api.mixin;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MenuType.class)
public interface MenuTypeAccessor {
    @FunctionalInterface
    interface MenuSupplier<T extends AbstractContainerMenu> {
        MenuType<T> create(int syncId, Inventory inventory);
    }

    @Accessor("<init>")
    static <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuSupplier<T> supplier) {
        throw new AssertionError();
    }
}
