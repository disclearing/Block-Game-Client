package us.blockgame.client.util;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;
import us.blockgame.client.BlockClient;
import us.blockgame.client.gui.impl.ModMenuGui;

public class KeyboardUtil {
	public static void handleKeyboardInput(int key) {
		switch (key) {
		case Keyboard.KEY_RSHIFT: {
			Minecraft.getMinecraft().displayGuiScreen(new ModMenuGui());
			break;
		}

		case Keyboard.KEY_ESCAPE: {
			BlockClient.getInstance().getManagerHandler().getSettingsManager().setModMenuOpen(false);
			break;
		}
		}
	}

	public static void handleMouseInput(int click) {
		switch (click) {

		case 0: {
			if (Mouse.getEventButtonState()) {
				BlockClient.getInstance().getManagerHandler().getPlayerManager().addClick();
				break;
			}
		}
		}
	}
}
