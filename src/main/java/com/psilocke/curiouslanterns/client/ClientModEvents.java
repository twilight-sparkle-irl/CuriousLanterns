package com.psilocke.curiouslanterns.client;

import com.psilocke.curiouslanterns.CuriousLanterns;
import com.psilocke.curiouslanterns.curios.LanternRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
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
	
	@SubscribeEvent
	public static void onClientSetupEvent(FMLClientSetupEvent e) {
		CuriosRendererRegistry.register(Items.LANTERN, LanternRenderer::new);
		CuriosRendererRegistry.register(Items.SOUL_LANTERN, LanternRenderer::new);
		
		if(ModList.get().isLoaded("supplementaries")) {
			CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("supplementaries:copper_lantern")), LanternRenderer::new);
			CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("supplementaries:crimson_lantern")), LanternRenderer::new);
			CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("supplementaries:silver_lantern")), LanternRenderer::new);
			CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("supplementaries:brass_lantern")), LanternRenderer::new);
			CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("supplementaries:lead_lantern")), LanternRenderer::new);
			CuriosRendererRegistry.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation("supplementaries:gold_lantern")), LanternRenderer::new);
		}
	}
	
	@SubscribeEvent
	public static void onModelregister(ModelRegistryEvent event) {
		ForgeModelBakery.addSpecialModel(new ResourceLocation("minecraft", "block/lantern"));
		ForgeModelBakery.addSpecialModel(new ResourceLocation("minecraft", "block/soul_lantern"));
		
		if(ModList.get().isLoaded("supplementaries")) {
			ForgeModelBakery.addSpecialModel(new ResourceLocation("supplementaries", "block/copper_lantern"));
			ForgeModelBakery.addSpecialModel(new ResourceLocation("supplementaries", "block/crimson_lantern"));
			ForgeModelBakery.addSpecialModel(new ResourceLocation("supplementaries", "block/silver_lantern"));
			ForgeModelBakery.addSpecialModel(new ResourceLocation("supplementaries", "block/brass_lantern"));
			ForgeModelBakery.addSpecialModel(new ResourceLocation("supplementaries", "block/lead_lantern"));
			ForgeModelBakery.addSpecialModel(new ResourceLocation("supplementaries", "block/gold_lantern"));
		}
	}
}