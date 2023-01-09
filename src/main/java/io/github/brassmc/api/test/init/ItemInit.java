package io.github.brassmc.api.test.init;

import io.github.brassmc.api.BrassAPI;
import io.github.brassmc.api.RegistryUtils;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static final RegistryUtils UTILS = new RegistryUtils(BrassAPI.MOD_ID);

    public static void init() {
        UTILS.registerItem(new Item(new Item.Properties()), "test_item");
    }
}
