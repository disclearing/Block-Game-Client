package us.blockgame.client.manager.impl;

import com.google.common.base.Charsets;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import us.blockgame.client.BlockClient;
import us.blockgame.client.manager.Manager;
import us.blockgame.client.manager.ManagerHandler;

public class PacketManager extends Manager {
	
	public PacketManager(ManagerHandler managerHandler) {
		super(managerHandler);
	}
	
	public void sendCustomPayload(String message) {
		if (!managerHandler.getSettingsManager().isAntiCheatEnabled()) {
			return;
		}
        NetHandlerPlayClient.netManager.scheduleOutboundPacket(new C17PacketCustomPayload("Block-Client", message.getBytes(Charsets.UTF_8)));
	}

}
