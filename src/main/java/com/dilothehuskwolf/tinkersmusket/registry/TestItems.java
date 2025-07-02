//TestItems.java

package com.dilothehuskwolf.tinkersmusket.registry;

import com.dilothehuskwolf.tinkersmusket.TinkersMusket;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestItems {
    /** 1) 建立 DeferredRegister */
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TinkersMusket.MOD_ID);

    /** 2) 先註冊物品（不再呼叫 .tab(...)） */
    public static final RegistryObject<Item> MUSKET = ITEMS.register(
            "musket",
            () -> new Item(new Properties().stacksTo(1))
    );

    /** 3) 再宣告自訂 Creative Mode 分頁，實際顯示時把 MUSKET 加進去 */
    public static final CreativeModeTab CREATIVE_TAB = CreativeModeTab.builder()
            .title(Component.literal("Tinkers Musket"))
            .icon(() -> new ItemStack(MUSKET.get()))
            .displayItems((params, output) -> output.accept(MUSKET.get()))
            .build();

    /** 4) 主 Mod 類的建構子裡呼叫：TestItems.register(modEventBus); */
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}

