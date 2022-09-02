package com.psilocke.curiouslanterns.client;

import com.psilocke.curiouslanterns.CuriousLanterns;
import com.psilocke.curiouslanterns.curios.LanternRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod.EventBusSubscriber(modid = CuriousLanterns.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
	
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
	
	@SubscribeEvent
	public static void onClientSetupEvent(FMLClientSetupEvent e) {
		for(String var : lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, item)), LanternRenderer::new);
			}
		}
	}
	
	@SubscribeEvent
	public static void onModelregister(ModelRegistryEvent event) {
		for(String var : lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			if(ModList.get().isLoaded(namespace)) {
				ForgeModelBakery.addSpecialModel(new ResourceLocation(namespace, "block/" + item));
			}
		}
	}
}