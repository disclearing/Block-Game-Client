package us.blockgame.client.manager.impl;

import java.util.ArrayList;
import java.util.List;

import us.blockgame.client.manager.Manager;
import us.blockgame.client.manager.ManagerHandler;

public class SettingsManager extends Manager {
	private boolean modMenuOpen;
	private boolean antiCheatEnabled;
	private List<String> blockClientServers;
	private List<String> specialEarsUsers;
	private boolean showRedNumbers = true;

	public SettingsManager(ManagerHandler managerHandler) {
		super(managerHandler);
		setupServers();
	}

	private void setupServers() {
		blockClientServers = new ArrayList();
		blockClientServers.add("blockgame.us");
		specialEarsUsers = new ArrayList();
		specialEarsUsers.add("deadmau5");
	}

	public boolean isModMenuOpen() {
		return modMenuOpen;
	}

	public boolean isAntiCheatEnabled() {
		return antiCheatEnabled;
	}

	public List<String> getBlockClientServers() {
		return blockClientServers;
	}
	
	public List<String> getSpecialEarsUsers() {
		return specialEarsUsers;
	}
	
	public boolean showRedNumbers() {
		return showRedNumbers;
	}

	public void setModMenuOpen(boolean modMenuOpen) {
		this.modMenuOpen = modMenuOpen;
	}

	public void setAntiCheatEnabled(boolean antiCheatEnabled) {
		this.antiCheatEnabled = antiCheatEnabled;
	}
	
	public void setShowRedNumbers(boolean showRedNumbers) {
		this.showRedNumbers = showRedNumbers;
	}
}
