package net.minecraft.network;

import net.minecraft.util.IChatComponent;
import us.blockgame.client.util.DiscordUtil;

public interface INetHandler {
	/**
	 * Invoked when disconnecting, the parameter is a ChatComponent describing the
	 * reason for termination
	 */
	public default void onDisconnect(IChatComponent p_147231_1_) {
		DiscordUtil.serverIp = null;
		DiscordUtil.updateDiscordPresence();
	}

	/**
	 * Allows validation of the connection state transition. Parameters: from, to
	 * (connection state). Typically throws IllegalStateException or
	 * UnsupportedOperationException if validation fails
	 */
	void onConnectionStateTransition(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_);

	/**
	 * For scheduled network tasks. Used in NetHandlerPlayServer to send keep-alive
	 * packets and in NetHandlerLoginServer for a login-timeout
	 */
	void onNetworkTick();
}
