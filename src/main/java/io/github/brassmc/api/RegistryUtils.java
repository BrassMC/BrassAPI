package io.github.brassmc.api;

import io.github.brassmc.api.mixin.MenuTypeAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class RegistryUtils {
    private final String modid;

    public RegistryUtils(String modid) {
        this.modid = modid;
    }

    public <T extends Item> T registerItem(T item, String name) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(this.modid, name), item);
    }

    public <T extends Block> T registerBlock(T block, String name) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(this.modid, name), block);
    }

    public <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name,
                                                                          BlockEntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(this.modid, name),
                builder.build(null));
    }

    public <T extends AbstractContainerMenu> MenuType<T> registerMenu(String name,
                                                                      MenuTypeAccessor.MenuSupplier<T> supplier) {
        return Registry.register(BuiltInRegistries.MENU, new ResourceLocation(this.modid, name),
                MenuTypeAccessor.createMenuType(supplier));
    }

    public String getModid() {
        return this.modid;
    }
}