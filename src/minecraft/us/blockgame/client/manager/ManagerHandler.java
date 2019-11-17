package us.blockgame.client.manager;

import us.blockgame.client.BlockClient;
import us.blockgame.client.manager.impl.DataManager;
import us.blockgame.client.manager.impl.GuiManager;
import us.blockgame.client.manager.impl.ModuleManager;
import us.blockgame.client.manager.impl.PacketManager;
import us.blockgame.client.manager.impl.PlayerManager;
import us.blockgame.client.manager.impl.SettingsManager;

public class ManagerHandler {
	private BlockClient blockClient;
	private SettingsManager settingsManager;
	private ModuleManager moduleManager;
	private GuiManager guiManager;
	private PlayerManager playerManager;
	private DataManager dataManager;
	private PacketManager packetManager;

	public ManagerHandler(BlockClient blockClient) {
		this.blockClient = blockClient;
		registerManagers();
	}

	private void registerManagers() {
		settingsManager = new SettingsManager(this);
		moduleManager = new ModuleManager(this);
		guiManager = new GuiManager(this);
		playerManager = new PlayerManager(this);
		dataManager = new DataManager(this);
		packetManager = new PacketManager(this);
	}

	public SettingsManager getSettingsManager() {
		return settingsManager;
	}

	public ModuleManager getModuleManager() {
		return moduleManager;
	}

	public GuiManager getGuiManager() {
		return guiManager;
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public DataManager getDataManager() {
		return dataManager;
	}
	
	public PacketManager getPacketManager() {
		return packetManager;
	}
}
