package us.blockgame.client.module.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class CoordinatesModule extends Module {
	String[] rotations = { "N", "NE", "E", "SE", "S", "SW", "W", "NW" };

	public CoordinatesModule() {
		super("Coordinates");
		setX(2);
		setY(12);
		setColor(0xfffff);
		setHeight(10);
		setWidth(85);
	}

	@Override
	public void onMovePacket() {
		if (this.getModuleState() == ModuleState.DISABLED) {
			return;
		}
		double angle = MathHelper.wrapAngleTo180_float(this.getMinecraft().thePlayer.rotationYaw);
		angle = (angle + 202.5) % 360.0 / 45.0;
		String direction = rotations[MathHelper.floor_double(angle)];
		int x = (int) Minecraft.getMinecraft().thePlayer.posX;
		int y = (int) Minecraft.getMinecraft().thePlayer.posY - 1;
		int z = (int) Minecraft.getMinecraft().thePlayer.posZ;
		setHUDText("(" + x + ", " + y + ", " + z + ") " + direction);
	}
	
	
	@Override
	public void enable() {
		this.setModuleState(ModuleState.ENABLED);
	}

	@Override
	public void disable() {
		this.setModuleState(ModuleState.DISABLED);
	}
	
	@Override
	public String renderPreview() {
		return "(100, 100, 100) N";
	}
}
