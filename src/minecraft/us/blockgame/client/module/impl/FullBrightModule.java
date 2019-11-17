package us.blockgame.client.module.impl;

import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class FullBrightModule extends Module {
	
	public FullBrightModule() {
		super("FullBright");
	}

	@Override
	public void enable() {
		this.setModuleState(ModuleState.ENABLED);
		this.getMinecraft().gameSettings.gammaSetting = 10f;
	}

	@Override
	public void disable() {
		this.setModuleState(ModuleState.DISABLED);
		this.getMinecraft().gameSettings.gammaSetting = 1f;
	}

	@Override
	public String renderPreview() {
		return null;
	}
}
