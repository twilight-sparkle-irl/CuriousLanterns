package com.psilocke.curiouslanterns.datagen;

import com.psilocke.curiouslanterns.CuriousLanterns;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider{

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, CuriousLanterns.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		
	}
}
