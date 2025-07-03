//TestItems.java
package com.dilothehuskwolf.tinkersmusket.registry;

import com.dilothehuskwolf.tinkersmusket.TinkersMusket;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestItems {
    // 1) 物品的 DeferredRegister
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TinkersMusket.MOD_ID);

    // 2) 创意标签页的 DeferredRegister
    private static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinkersMusket.MOD_ID);

    // 3) 在标签页里显示的物品
    public static final RegistryObject<Item> MUSKET = ITEMS.register("musket",
            () -> new Item(new Item.Properties().stacksTo(1))
    );

    // 4) 注册一个 Creative Mode Tab，ID 用 "tinkers_musket"
    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = TABS.register("tinkers_musket",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + TinkersMusket.MOD_ID + ".tinkers_musket"))
                    .icon(() -> new ItemStack(MUSKET.get()))
                    .displayItems((params, output) -> {
                        // 只把 MUSKET 这个物品放进来
                        output.accept(MUSKET.get());
                    })
                    .build()
    );

    /** 在主 Mod 类构造器里调用：TestItems.register(modEventBus); */
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        TABS.register(bus);
    }
}