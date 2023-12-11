package com.psilocke.curiouslanterns.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.psilocke.curiouslanterns.config.CuriousLanternsClientConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class LanternRenderer implements ICurioRenderer {

	@Override
	public <T extends LivingEntity, M extends EntityModel<T>> void render(
			ItemStack stack,
			SlotContext slotContext,
			PoseStack matrixStack,
			RenderLayerParent<T, M> renderLayerParent,
			MultiBufferSource renderTypeBuffer,
			int light,
			float limbSwing,
			float limbSwingAmount,
			float partialTicks,
			float ageInTicks,
			float netHeadYaw,
			float headPitch
	) {
		matrixStack.pushPose();
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
		LivingEntity living = slotContext.entity();
		if(living.isCrouching()) {
			matrixStack.translate(0.0F, 0.14F, 0.3F);
		}
		matrixStack.translate(-.23, 0.69, 0.133);
		matrixStack.mulPose(Axis.XP.rotationDegrees(180));
		if(CuriousLanternsClientConfig.LANTERN_SWING.get()) {
			double d0 = living.xo - living.getX();
            double d1 = living.yo - living.getY();
            double d2 = living.zo - living.getZ();
            float f = living.yBodyRotO + (living.yBodyRot - living.yBodyRotO);
            double d3 = (double)Mth.sin(f * ((float)Math.PI / 180F));
            double d4 = (double)(-Mth.cos(f * ((float)Math.PI / 180F)));
            float f1 = (float)d1 * 10.0F;
            f1 = Mth.clamp(f1, -6.0F, 32.0F);
            float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            f2 = Mth.clamp(f2, 0.0F, 150.0F);
            float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
            f3 = Mth.clamp(f3, -20.0F, 20.0F);
            

            matrixStack.mulPose(Axis.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
            matrixStack.mulPose(Axis.ZP.rotationDegrees(-f3 / 2.0F));
		}
		matrixStack.scale(0.5f, 0.5f, 0.5f);
		BakedModel lantern = blockRenderer.getBlockModel(Block.byItem(stack.getItem()).defaultBlockState());
		MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
		itemRenderer.render(stack, ItemDisplayContext.HEAD, true, matrixStack, buffer, light, OverlayTexture.NO_OVERLAY, lantern);
		matrixStack.popPose();
	}
	
	

}
