package us.blockgame.client.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;

public class RenderUtil {

	public static void drawRect(float minX, float minY, float maxX, float maxY, final int color) {
		if (minX < maxX) {
			final float bounds = minX;
			minX = maxX;
			maxX = bounds;
		}
		if (minY < maxY) {
			final float bounds = minY;
			minY = maxY;
			maxY = bounds;
		}
		final float r = (color >> 24 & 0xFF) / 255.0f;
		final float g = (color >> 16 & 0xFF) / 255.0f;
		final float b = (color >> 8 & 0xFF) / 255.0f;
		final float a = (color & 0xFF) / 255.0f;
		final Tessellator tessellator = Tessellator.instance;
		GL11.glEnable(3042);
		GL11.glDisable(3553);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(g, b, a, r);
		tessellator.startDrawingQuads();
		tessellator.addVertex(minX, maxY, 0.0);
		tessellator.addVertex(maxX, maxY, 0.0);
		tessellator.addVertex(maxX, minY, 0.0);
		tessellator.addVertex(minX, minY, 0.0);
		tessellator.draw();
		GL11.glEnable(3553);
		GL11.glDisable(3042);
	}

	 
	public static void drawTexturedRect(final float x, final float y, final int width, final int height, final int u, final int v) {
        final float scale = 0.00390625f;
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + v, 0.0, width * scale, (height + (float)v) * scale);
        tessellator.addVertexWithUV(x + u, y + v, 0.0, (width + (float)u) * scale, (height + (float)v) * scale);
        tessellator.addVertexWithUV(x + u, y, 0.0, (width + (float)u) * scale, height * scale);
        tessellator.addVertexWithUV(x, y, 0.0, width * scale, height * scale);
        tessellator.draw();
    }
}
