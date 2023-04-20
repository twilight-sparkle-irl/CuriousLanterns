package com.psilocke.curiouslanterns.datagen;

import com.psilocke.curiouslanterns.CuriousLanterns;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosApi;

public class ModItemTagsProvider extends ItemTagsProvider {
	
	public static final TagKey<Item> HIP = ItemTags.create(new ResourceLocation(CuriosApi.MODID, "hip"));
	
	protected ModItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper fileHelper) {
		super(gen, blockTags, CuriousLanterns.MOD_ID, fileHelper);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Item Tags";
	}

	@Override
	protected void addTags() {
		
		//for normal mods
		
		for(String var : CuriousLanterns.lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			this.tag(HIP).addOptional(new ResourceLocation(namespace, item));
		}

		//for medium lanterns
		
		for(String var : CuriousLanterns.medium_lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			this.tag(HIP).addOptional(new ResourceLocation(namespace, item));
		}
		
		//for larger lanterns
		
		for(String var : CuriousLanterns.large_lanterns) {
			String namespace = var.substring(0, var.indexOf(':'));
			String item = var.substring(var.indexOf(':')+1);
			
			this.tag(HIP).addOptional(new ResourceLocation(namespace, item));
		}
		
		//for additional lanterns because of fricking course
		
		for(String color : CuriousLanterns.add_lan_colors) {
			for(String material : CuriousLanterns.add_lan_materials) {
				String name = color;
				if(name == CuriousLanterns.add_lan_colors[0]) {
					name += material;
				}else name += ("_" + material);
				
				this.tag(HIP).addOptional(new ResourceLocation("additionallanterns", name+"_lantern"));
			}
		}
		
		/*
		//for skinned lanterns *sigh* (does not work)
		
		for(String name : CuriousLanterns.skinned_lanterns) {
			if(name == "paper" || name == "ornament") {
				for (String color : CuriousLanterns.lan_colors) {
					if(color == "") {
						continue;
					}
					this.tag(HIP).addOptional(new ResourceLocation("skinnedlanterns", name + "_" + color + "_lantern_block"));
					this.tag(HIP).addOptional(new ResourceLocation("skinnedlanterns", name + "_" + color + "_soul_lantern_block"));
				}
			}else {
				this.tag(HIP).addOptional(new ResourceLocation("skinnedlanterns", name + "_lantern_block"));
				this.tag(HIP).addOptional(new ResourceLocation("skinnedlanterns", name + "_soul_lantern_block"));
			}
		}
		*/
	}

}
