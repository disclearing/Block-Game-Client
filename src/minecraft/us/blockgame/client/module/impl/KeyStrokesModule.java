package us.blockgame.client.module.impl;

import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class KeyStrokesModule extends Module {

	public KeyStrokesModule() {
		super("KeyStrokes");
		setX(100);
		setY(2);
		setColor(0xfffff);
		setHeight(50);
		setWidth(50);
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
		return null;
	}

}
