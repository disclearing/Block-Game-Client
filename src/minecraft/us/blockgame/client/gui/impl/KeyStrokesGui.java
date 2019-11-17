package us.blockgame.client.gui.impl;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import us.blockgame.client.BlockClient;
import us.blockgame.client.gui.BGui;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;
import us.blockgame.client.util.Wrapper;

public class KeyStrokesGui extends GuiScreen implements BGui {

	@Override
	public void onEvent2D() {
		Module keyStrokes = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(6);
		if (keyStrokes.getModuleState() == ModuleState.ENABLED) {
			drawRect(keyStrokes.getX() - 9, keyStrokes.getY() - 9, keyStrokes.getX() + 15, keyStrokes.getY() + 15,
					(Keyboard.isKeyDown(Keyboard.KEY_W) ? 0x6fffffff : 0x6f000000));
			this.drawString(Wrapper.fontRenderer, "W", keyStrokes.getX(), keyStrokes.getY(),
					(Keyboard.isKeyDown(Keyboard.KEY_W) ? 0x808080 : keyStrokes.getColor()));

			drawRect(keyStrokes.getX() - 36, keyStrokes.getY() + 18, keyStrokes.getX() - 12, keyStrokes.getY() + 42,
					(Keyboard.isKeyDown(Keyboard.KEY_A) ? 0x6fffffff : 0x6f000000));
			this.drawString(Wrapper.fontRenderer, "A", keyStrokes.getX() - 27, keyStrokes.getY() + 27,
					(Keyboard.isKeyDown(Keyboard.KEY_A) ? 0x808080 : keyStrokes.getColor()));

			drawRect(keyStrokes.getX() - 9, keyStrokes.getY() + 18, keyStrokes.getX() + 15, keyStrokes.getY() + 42,
					(Keyboard.isKeyDown(Keyboard.KEY_S) ? 0x6fffffff : 0x6f000000));
			this.drawString(Wrapper.fontRenderer, "S", keyStrokes.getX(), keyStrokes.getY() + 27,
					(Keyboard.isKeyDown(Keyboard.KEY_S) ? 0x808080 : keyStrokes.getColor()));

			drawRect(keyStrokes.getX() + 18, keyStrokes.getY() + 18, keyStrokes.getX() + 42, keyStrokes.getY() + 42,
					(Keyboard.isKeyDown(Keyboard.KEY_D) ? 0x6fffffff : 0x6f000000));
			this.drawString(Wrapper.fontRenderer, "D", keyStrokes.getX() + 27, keyStrokes.getY() + 27,
					(Keyboard.isKeyDown(Keyboard.KEY_D) ? 0x808080 : keyStrokes.getColor()));
		}
	}

}
