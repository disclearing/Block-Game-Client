package us.blockgame.client.manager.impl;

import java.util.ArrayList;
import java.util.List;

import us.blockgame.client.gui.BGui;
import us.blockgame.client.gui.impl.KeyStrokesGui;
import us.blockgame.client.gui.impl.ModMenuGui;
import us.blockgame.client.gui.impl.ModuleGui;
import us.blockgame.client.gui.impl.StatusEffectHUDGui;
import us.blockgame.client.manager.Manager;
import us.blockgame.client.manager.ManagerHandler;

public class GuiManager extends Manager {
	private List<BGui> guis;

	public GuiManager(ManagerHandler managerHandler) {
		super(managerHandler);
		createGuis();
	}

	private void createGuis() {
		guis = new ArrayList();
		addGui(new ModuleGui());
		addGui(new ModMenuGui());
		addGui(new KeyStrokesGui());
		addGui(new StatusEffectHUDGui());
	}

	private void addGui(BGui bGui) {
		guis.add(bGui);
	}

	public List<BGui> getGuis() {
		return guis;
	}
}
