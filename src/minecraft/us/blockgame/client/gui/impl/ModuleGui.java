package us.blockgame.client.gui.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import us.blockgame.client.BlockClient;
import us.blockgame.client.gui.BGui;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;
import us.blockgame.client.util.Wrapper;

public class ModuleGui extends GuiScreen implements BGui {

	@Override
	public void onEvent2D() {
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		for (Module module : BlockClient.getInstance().getManagerHandler().getModuleManager().getModules()) {
			if (module.getModuleState() == ModuleState.ENABLED) {
				if (BlockClient.getInstance().getManagerHandler().getSettingsManager().isModMenuOpen()) {
					if (module.renderPreview() != null) {
						this.drawString(Wrapper.fontRenderer, module.renderPreview(), module.getX(), module.getY(),
								module.getColor());
					}
				} else if (module.getHUDText() != null) {
					this.drawString(Wrapper.fontRenderer, module.getHUDText(), module.getX(), module.getY(),
							module.getColor());
				}
			}
		}
	}

}
