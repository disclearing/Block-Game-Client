package net.minecraft.realms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class RealmsBridge extends RealmsScreen {
	private static final Logger LOGGER = LogManager.getLogger();
	private GuiScreen previousScreen;
	private static final String __OBFID = "CL_00001869";

	public void switchToRealms(GuiScreen p_switchToRealms_1_) {
		this.previousScreen = p_switchToRealms_1_;

		try {
		} catch (Exception var5) {
			LOGGER.error("Could not connect to BlockGame", var5);
		}
	}

	public void init() {
		Minecraft.getMinecraft().displayGuiScreen(this.previousScreen);
	}
}
