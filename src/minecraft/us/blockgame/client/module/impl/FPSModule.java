package us.blockgame.client.module.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class FPSModule extends Module {
	public FPSModule() {
		super("FPS");
		setX(163);
		setY(2);
		setColor(0xfffff);
		setHeight(10);
		setWidth(50);
	}

	@Override
	public void onEvent2D() {
		if (getModuleState() == ModuleState.DISABLED) {
			return;
		}
		setHUDText("[" + Minecraft.getMinecraft().debugFPS + " FPS]");
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
		return "[999 FPS]";
	}
}
