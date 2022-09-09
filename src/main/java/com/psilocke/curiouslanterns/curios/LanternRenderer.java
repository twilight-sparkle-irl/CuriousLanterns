package com.psilocke.curiouslanterns.curios;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
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
		LivingEntity living = slotContext.entity();
		if(living.isCrouching()) {
			matrixStack.translate(0.0F, 0.14F, 0.3F);
		}
		matrixStack.translate(-.23, 0.69, 0.133);
		matrixStack.mulPose(Vector3f.ZP.rotationDegrees(180));
		matrixStack.scale(0.5f, 0.5f, 0.5f);
		BakedModel lantern = itemRenderer.getItemModelShaper().getModelManager().getModel(new ResourceLocation(stack.getItem().getRegistryName().getNamespace(), "block/" + stack.getItem().getRegistryName().getPath()));
		MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
		itemRenderer.render(stack, ItemTransforms.TransformType.HEAD, true, matrixStack, buffer, light, OverlayTexture.NO_OVERLAY, lantern);
		matrixStack.popPose();
	}
	
	

}
