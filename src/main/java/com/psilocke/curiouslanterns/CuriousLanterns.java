package com.psilocke.curiouslanterns;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.SlotTypeMessage;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("curiouslanterns")
public class CuriousLanterns {
	public static final String MOD_ID = "curiouslanterns";
	
	public final static String[] lanterns = {
			"minecraft:lantern",
			"minecraft:soul_lantern",
			"supplementaries:copper_lantern",
			"supplementaries:crimson_lantern",
			"supplementaries:silver_lantern",
			"supplementaries:brass_lantern",
			"supplementaries:lead_lantern",
			"cyclic:gold_lantern",
			"cyclic:gold_soul_lantern",
			"cyclic:copper_lantern",
			"cyclic:copper_soul_lantern",
			"cyclic:netherite_lantern"
	};
	
	public final static String[] lan_materials = {
			"normal",
			"obsidian",
			"basalt",
			"andesite",
			"diorite",
			"granite",
			"normal_sandstone",
			"red_sandstone",
			"smooth_stone",
			"end_stone",
			"quartz",
			"prismarine",
			"dark_prismarine",
			"blackstone",
			"normal_nether_bricks",
			"red_nether_bricks",
			"crimson",
			"warped",
			"purpur",
			"bricks"
	};
	
	public final static String[] lan_colors = {
			"",
			"white",
			"orange",
			"magenta",
			"light_blue",
			"yellow",
			"lime",
			"pink",
			"gray",
			"light_gray",
			"cyan",
			"purple",
			"blue",
			"brown",
			"green",
			"red",
			"black"
	};

    public CuriousLanterns()
    {
    	
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    	
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("hip")
        		.icon(new ResourceLocation("curios:slot/empty_hip_slot"))
        		.build()
        		);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}
