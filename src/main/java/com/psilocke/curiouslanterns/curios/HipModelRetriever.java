package com.psilocke.curiouslanterns.curios;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class HipModelRetriever {
	
	public static ResourceLocation GetHipModel(Item item) {
		return new ResourceLocation(item.getRegistryName().getNamespace(), "block/" + item.getRegistryName().getPath());
	}
}
