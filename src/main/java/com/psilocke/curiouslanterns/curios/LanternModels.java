package com.psilocke.curiouslanterns.curios;

import com.psilocke.curiouslanterns.CuriousLanterns;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class LanternModels {
	public static ResourceLocation LANTERN = new ResourceLocation("minecraft", "block/lantern");
	public static ResourceLocation SOUL_LANTERN = new ResourceLocation("minecraft", "block/soul_lantern");
	public static ResourceLocation NULL_TEX = new ResourceLocation(CuriousLanterns.MOD_ID, "curio/null_tex");
	
	public static ResourceLocation getLanternModel(ItemStack item) {
		if(item.is(Items.LANTERN)) {
			return LANTERN;
		}else if(item.is(Items.SOUL_LANTERN)) {
			return SOUL_LANTERN;
		}else return NULL_TEX;
	}
}
