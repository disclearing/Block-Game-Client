package us.blockgame.client.manager.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;

import us.blockgame.client.BlockClient;
import us.blockgame.client.manager.Manager;
import us.blockgame.client.manager.ManagerHandler;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class DataManager extends Manager {

	private File blockgameDir;
	private File settingsFile;
	private File tempFile;

	public DataManager(ManagerHandler managerHandler) {
		super(managerHandler);
		createFiles();
	}

	private void createFiles() {
		try {
			blockgameDir = new File("BlockGame");
			if (!blockgameDir.exists()) {
				blockgameDir.mkdirs();
			}
			settingsFile = new File(blockgameDir.getAbsolutePath(), "settings.yml");
			if (!settingsFile.exists()) {
				settingsFile.createNewFile();
			}
			tempFile = new File(blockgameDir.getAbsoluteFile(), "temp.yml");
			if (!tempFile.exists()) {
				tempFile.createNewFile();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loadSettings() {
		LogManager.getLogger().info("Loading settings.");
		for (Module module : BlockClient.getInstance().getManagerHandler().getModuleManager().getModules()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
				LogManager.getLogger().info(module.getName());
				String currentLine;
				while ((currentLine = reader.readLine()) != null) {
					String[] settings = currentLine.trim().split(":");
					if (module.getName().equalsIgnoreCase(settings[0])) {
						int x = Integer.parseInt(settings[1]);
						int y = Integer.parseInt(settings[2]);
						int color = Integer.parseInt(settings[3]);
						ModuleState moduleState = ModuleState.valueOf(settings[4]);
						module.setX(x);
						module.setY(y);
						module.setColor(color);
						module.setModuleState(moduleState);
					}
				}
				reader.close();
				LogManager.getLogger().info("Loaded settings for " + module.getName() + ".");
			} catch (Exception ex) {
				ex.printStackTrace();
				LogManager.getLogger().error("Error loading settings for " + module.getName() + ".");
			}
		}
	}

	public void save() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			for (Module module : BlockClient.getInstance().getManagerHandler().getModuleManager().getModules()) {
				writer.write(module.getName() + ":" + module.getX() + ":" + module.getY() + ":" + module.getColor()
						+ ":" + module.getModuleState().toString() + "\n");
			}
			writer.close();
			reader.close();
			settingsFile.delete();
			tempFile.renameTo(new File(blockgameDir.getAbsolutePath(), "settings.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
