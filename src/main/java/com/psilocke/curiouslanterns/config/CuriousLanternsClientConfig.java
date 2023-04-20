package com.psilocke.curiouslanterns.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CuriousLanternsClientConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> LANTERN_SWING;
	
	static {
		BUILDER.push("Client Configs for Curious Lanterns");
		
		LANTERN_SWING = BUILDER.comment("Should the lantern swing or not.\nDefault: false").define("Should Swing", false);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}