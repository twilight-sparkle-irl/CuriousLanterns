package com.psilocke.curiouslanterns;

import com.psilocke.curiouslanterns.config.CuriousLanternsClientConfig;
import com.psilocke.curiouslanterns.config.CuriousLanternsCommonConfig;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("curiouslanterns")
public class CuriousLanterns {
	public static final String MOD_ID = "curiouslanterns";
	
	public static String[] lanterns = {
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
			"cyclic:netherite_lantern",
			"mcwlights:striped_lantern",
			"mcwlights:covered_lantern",
			"mcwlights:chain_lantern",
			"mcwlights:tavern_lantern",
			"mcwlights:festive_lantern",
			"mcwlights:cross_lantern",
			"mcwlights:bell_lantern"
	};

	public static String[] medium_lanterns = {
			"skinnedlanterns:pufferfish_lantern_block",
			"skinnedlanterns:pufferfish_soul_lantern_block",
			"skinnedlanterns:zombie_lantern_block",
			"skinnedlanterns:zombie_soul_lantern_block",
			"skinnedlanterns:creeper_lantern_block",
			"skinnedlanterns:creeper_soul_lantern_block",
			"skinnedlanterns:skeleton_lantern_block",
			"skinnedlanterns:skeleton_soul_lantern_block",
			"skinnedlanterns:wither_skeleton_lantern_block",
			"skinnedlanterns:wither_skeleton_soul_lantern_block",
			"skinnedlanterns:bee_lantern_block",
			"skinnedlanterns:bee_soul_lantern_block",
			"skinnedlanterns:jack_o_lantern_lantern_block",
			"skinnedlanterns:jack_o_lantern_soul_lantern_block",
			"skinnedlanterns:paper_white_lantern_block",
			"skinnedlanterns:paper_white_soul_lantern_block",
			"skinnedlanterns:ghost_lantern_block",
			"skinnedlanterns:ghost_soul_lantern_block",
			"skinnedlanterns:blinky_lantern_block",
			"skinnedlanterns:blinky_soul_lantern_block",
			"skinnedlanterns:pinky_lantern_block",
			"skinnedlanterns:pinky_soul_lantern_block",
			"skinnedlanterns:inky_lantern_block",
			"skinnedlanterns:inky_soul_lantern_block",
			"skinnedlanterns:clyde_lantern_block",
			"skinnedlanterns:clyde_soul_lantern_block",
			"skinnedlanterns:pacman_lantern_block",
			"skinnedlanterns:pacman_soul_lantern_block",
			"skinnedlanterns:guardian_lantern_block",
			"skinnedlanterns:guardian_soul_lantern_block",
			"skinnedlanterns:paper_yellow_lantern_block",
			"skinnedlanterns:paper_yellow_soul_lantern_block",
			"skinnedlanterns:paper_orange_lantern_block",
			"skinnedlanterns:paper_orange_soul_lantern_block",
			"skinnedlanterns:paper_blue_lantern_block",
			"skinnedlanterns:paper_blue_soul_lantern_block",
			"skinnedlanterns:paper_light_blue_lantern_block",
			"skinnedlanterns:paper_light_blue_soul_lantern_block",
			"skinnedlanterns:paper_cyan_lantern_block",
			"skinnedlanterns:paper_cyan_soul_lantern_block",
			"skinnedlanterns:paper_lime_lantern_block",
			"skinnedlanterns:paper_lime_soul_lantern_block",
			"skinnedlanterns:paper_green_lantern_block",
			"skinnedlanterns:paper_green_soul_lantern_block",
			"skinnedlanterns:paper_lantern_block",
			"skinnedlanterns:paper_soul_lantern_block",
			"skinnedlanterns:paper_pink_lantern_block",
			"skinnedlanterns:paper_pink_soul_lantern_block",
			"skinnedlanterns:paper_brown_lantern_block",
			"skinnedlanterns:paper_brown_soul_lantern_block",
			"skinnedlanterns:paper_black_lantern_block",
			"skinnedlanterns:paper_black_soul_lantern_block",
			"skinnedlanterns:paper_gray_lantern_block",
			"skinnedlanterns:paper_gray_soul_lantern_block",
			"skinnedlanterns:paper_light_gray_lantern_block",
			"skinnedlanterns:paper_light_gray_soul_lantern_block",
			"skinnedlanterns:paper_magenta_lantern_block",
			"skinnedlanterns:paper_magenta_soul_lantern_block",
			"skinnedlanterns:paper_purple_lantern_block",
			"skinnedlanterns:paper_purple_soul_lantern_block",
			"skinnedlanterns:ornament_red_lantern_block",
			"skinnedlanterns:ornament_red_soul_lantern_block",
			"skinnedlanterns:ornament_blue_lantern_block",
			"skinnedlanterns:ornament_blue_soul_lantern_block",
			"skinnedlanterns:ornament_purple_lantern_block",
			"skinnedlanterns:ornament_purple_soul_lantern_block",
			"skinnedlanterns:ornament_lime_lantern_block",
			"skinnedlanterns:ornament_lime_soul_lantern_block",
			"skinnedlanterns:ornament_magenta_lantern_block",
			"skinnedlanterns:ornament_magenta_soul_lantern_block",
			"skinnedlanterns:ornament_yellow_lantern_block",
			"skinnedlanterns:ornament_yellow_soul_lantern_block",
			"skinnedlanterns:ornament_green_lantern_block",
			"skinnedlanterns:ornament_green_soul_lantern_block",
			"skinnedlanterns:ornament_light_blue_lantern_block",
			"skinnedlanterns:ornament_light_blue_soul_lantern_block",
			"skinnedlanterns:ornament_cyan_lantern_block",
			"skinnedlanterns:ornament_cyan_soul_lantern_block",
			"skinnedlanterns:ornament_pink_lantern_block",
			"skinnedlanterns:ornament_pink_soul_lantern_block",
			"skinnedlanterns:ornament_orange_lantern_block",
			"skinnedlanterns:ornament_orange_soul_lantern_block",
			"skinnedlanterns:ornament_brown_lantern_block",
			"skinnedlanterns:ornament_brown_soul_lantern_block",
			"skinnedlanterns:ornament_black_lantern_block",
			"skinnedlanterns:ornament_black_soul_lantern_block",
			"skinnedlanterns:ornament_white_lantern_block",
			"skinnedlanterns:ornament_white_soul_lantern_block",
			"skinnedlanterns:ornament_gray_lantern_block",
			"skinnedlanterns:ornament_gray_soul_lantern_block",
			"skinnedlanterns:ornament_light_gray_lantern_block",
			"skinnedlanterns:ornament_light_gray_soul_lantern_block",
			"skinnedlanterns:present_green_lantern_block",
			"skinnedlanterns:present_green_soul_lantern_block",
			"skinnedlanterns:present_red_lantern_block",
			"skinnedlanterns:present_red_soul_lantern_block",
			"skinnedlanterns:snowman_lantern_block",
			"skinnedlanterns:snowman_soul_lantern_block",
			"skinnedlanterns:tiny_potato_lantern_block",
			"skinnedlanterns:tiny_potato_soul_lantern_block",
			"skinnedlanterns:honey_lantern_block",
			"skinnedlanterns:honey_soul_lantern_block",
			"skinnedlanterns:slime_lantern_block",
			"skinnedlanterns:slime_soul_lantern_block"
	};

	public static String[] large_lanterns = {
			"quark:paper_lantern",
			"quark:paper_lantern_sakura"
	};
	
	//additional lanterns materials
	public static String[] add_lan_materials = {
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
	
	//additional lanterns colors
	public static String[] add_lan_colors = {
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
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register Config
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CuriousLanternsClientConfig.SPEC, "curious-lanterns-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CuriousLanternsCommonConfig.SPEC, "curious-lanterns-common.toml");
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    	
    	InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BELT.getMessageBuilder().size(CuriousLanternsCommonConfig.TOTAL_SLOTS.get()).build());
    	
        /*
         InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("hip")
        		.icon(new ResourceLocation("curios:slot/empty_hip_slot"))
        		.build()
        		);
        */
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}
