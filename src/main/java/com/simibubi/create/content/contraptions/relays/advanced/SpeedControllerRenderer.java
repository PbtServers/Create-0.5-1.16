package com.simibubi.create.content.contraptions.relays.advanced;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.simibubi.create.CreateClient;
import com.simibubi.create.content.contraptions.base.KineticTileEntityRenderer;
import com.simibubi.create.foundation.tileEntity.renderer.SmartTileEntityRenderer;

import com.simibubi.create.foundation.utility.render.instancing.*;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class SpeedControllerRenderer extends SmartTileEntityRenderer<SpeedControllerTileEntity> implements IInstancedTileEntityRenderer<SpeedControllerTileEntity> {

	public SpeedControllerRenderer(TileEntityRendererDispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	protected void renderSafe(SpeedControllerTileEntity tileEntityIn, float partialTicks, MatrixStack ms,
			IRenderTypeBuffer buffer, int light, int overlay) {
		super.renderSafe(tileEntityIn, partialTicks, ms, buffer, light, overlay);
		addInstanceData(new InstanceContext.World<>(tileEntityIn));
	}

	@Override
	public void addInstanceData(InstanceContext<SpeedControllerTileEntity> ctx) {
		KineticTileEntityRenderer.renderRotatingBuffer(ctx, getRotatedModel(ctx));
	}

	private InstanceBuffer<RotatingData> getRotatedModel(InstanceContext<SpeedControllerTileEntity> ctx) {
		return ctx.getKinetics().renderBlockInstanced(KineticTileEntityRenderer.KINETIC_TILE,
				KineticTileEntityRenderer.shaft(KineticTileEntityRenderer.getRotationAxisOf(ctx.te)));
	}

}
