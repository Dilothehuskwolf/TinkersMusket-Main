//TinkersMusket.java

package com.dilothehuskwolf.tinkersmusket;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.dilothehuskwolf.tinkersmusket.registry.TestItems;


@Mod(TinkersMusket.MOD_ID)
public class TinkersMusket {
    public static final String MOD_ID = "tinkersmusket";

    public TinkersMusket() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

            // 注册物品
            TestItems.register(modEventBus);
        }
        // 這裡以後可以註冊方塊、物品、事件等
    }
