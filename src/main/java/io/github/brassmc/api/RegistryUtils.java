package io.github.brassmc.api;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RegistryUtils {
    private final String modid;

    public RegistryUtils(String modid) {
        this.modid = modid;
    }

    public <T extends Item> T registerItem(T item, String name) {
        return Registry.register(Registry.ITEM, new ResourceLocation(this.modid, name), item);
    }

    public <T extends Block> T registerBlock(T block, String name) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(this.modid, name), block);
    }

    @SuppressWarnings("unchecked")
    public <T extends BlockEntityType<?>> T registerBlockEntity(String name, BlockEntityType.Builder<?> builder) {
        return (T) Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(this.modid, name),
                builder.build(null));
    }

    public <T extends MenuType<?>> T registerMenu(String name, Supplier<T> supplier) {
        return Registry.register(Registry.MENU, new ResourceLocation(this.modid, name), MenuType.);
    }

    public String getModid() {
        return this.modid;
    }
}