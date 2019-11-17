package us.blockgame.client;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;
import us.blockgame.client.manager.ManagerHandler;
import us.blockgame.client.util.DiscordUtil;

public class BlockClient {
	
	private static BlockClient instance;
	private Minecraft minecraft;
	private ManagerHandler managerHandler;
	private String version = "1.0";
	public static boolean loadedSettings;

	public BlockClient(Minecraft minecraft) {
		instance = this;
		this.minecraft = minecraft;
		createDiscord();
		setupManagers();
		DiscordUtil.updateDiscordPresence();
	}

	private void createDiscord() {
		DiscordRPC.discordInitialize("600115310950875136", null, false);
	}

	private void setupManagers() {
		managerHandler = new ManagerHandler(this);
	}

	public static BlockClient getInstance() {
		return instance;
	}

	public Minecraft getMinecraft() {
		return minecraft;
	}

	public ManagerHandler getManagerHandler() {
		return managerHandler;
	}
	
	public String getVersion() {
		return version;
	}
}
