package us.blockgame.client.util;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import us.blockgame.client.BlockClient;

public class DiscordUtil {
	
	public static String username;
	public static String serverIp;

	public static void updateDiscordPresence() {
		String serverName = "";
		if (serverIp == null) {
			serverName = "In Menus";
		} else {
			String[] server =serverIp.split(":");
			serverName = "Playing: " +  server[0] + (server[1].equals("25565") ? "" : ":" +  server[1]);
		}
		  DiscordRichPresence rich = new DiscordRichPresence.Builder(serverName).setDetails("Username: " + username).setBigImage("blockgamelogofinal", "BlockGame Client").setStartTimestamps(System.currentTimeMillis()).build();
		  DiscordRPC.discordUpdatePresence(rich);
	}

}
