package us.blockgame.client.manager.impl;

import java.util.ArrayList;
import java.util.List;

import us.blockgame.client.manager.Manager;
import us.blockgame.client.manager.ManagerHandler;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.impl.CPSModule;
import us.blockgame.client.module.impl.CoordinatesModule;
import us.blockgame.client.module.impl.FPSModule;
import us.blockgame.client.module.impl.FullBrightModule;
import us.blockgame.client.module.impl.KeyStrokesModule;
import us.blockgame.client.module.impl.PotionCounterModule;
import us.blockgame.client.module.impl.ScoreboardModule;
import us.blockgame.client.module.impl.StatusEffectHUDModule;
import us.blockgame.client.module.impl.ToggleSprintModule;

public class ModuleManager extends Manager {
	private List<Module> modules;

	public ModuleManager(ManagerHandler managerHandler) {
		super(managerHandler);
		setupModules();
	}

	private void setupModules() {
		modules = new ArrayList();
		addModule(new ToggleSprintModule());
		addModule(new FullBrightModule());
		addModule(new FPSModule());
		addModule(new CoordinatesModule());
		addModule(new CPSModule());
		addModule(new PotionCounterModule());
		addModule(new KeyStrokesModule());
		addModule(new StatusEffectHUDModule());
		addModule(new ScoreboardModule());
	}

	private void addModule(Module module) {
		modules.add(module);
	}

	public List<Module> getModules() {
		return modules;
	}
}
