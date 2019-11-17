package us.blockgame.client.module.impl;

import us.blockgame.client.BlockClient;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class CPSModule extends Module {
	
	public CPSModule() {
		super("CPS");
		setX(120);
		setY(2);
		setHeight(10);
		setWidth(42);
		setColor(0xffff);
	}
	
	@Override
	public void onEvent2D() {
		setHUDText("[" + BlockClient.getInstance().getManagerHandler().getPlayerManager().getCPS() + " CPS]");
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
		return "[10 CPS]";
	}

}
