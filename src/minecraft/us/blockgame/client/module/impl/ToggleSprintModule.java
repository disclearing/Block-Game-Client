package us.blockgame.client.module.impl;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import us.blockgame.client.BlockClient;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class ToggleSprintModule extends Module {
	
	private boolean sprintPressTicked;
	private boolean sprinting;
	private long lastSprintPressed;
	private long lastSprint;

	public ToggleSprintModule() {
		super("ToggleSprint");
		setX(2);
		setY(2);
		setColor(0xfffff);
	}

	@Override
	public void onEvent2D() {
		if (this.getModuleState() == ModuleState.DISABLED) {
			return;
		}
		if (this.getMinecraft().thePlayer.isSneaking()) {
			setHUDText("[Sneaking (Key Held)]");
		} else if (getHUDText() != null && getHUDText().contains("Sneaking")
				&& !this.getMinecraft().thePlayer.isSneaking()) {
			setHUDText(null);
		}
		if (this.getMinecraft().thePlayer.moveForward < 0.0
				|| this.getMinecraft().thePlayer.getFoodStats().getFoodLevel() < 8) {
			return;
		}

		KeyBinding keySprint = this.getMinecraft().gameSettings.keyBindSprint;

		if (!this.getMinecraft().thePlayer.capabilities.isFlying) {
			if (keySprint.getIsKeyPressed() && !this.sprintPressTicked) {
				this.lastSprintPressed = System.currentTimeMillis();
				this.sprintPressTicked = true;
			} else if (!keySprint.getIsKeyPressed() && this.sprintPressTicked) {
				if (System.currentTimeMillis() - this.lastSprintPressed < 300L) {
					this.sprinting = !this.sprinting;
				}

				this.sprintPressTicked = false;
			}
		}

		if (this.sprinting && !this.getMinecraft().thePlayer.isSprinting()
				&& this.getMinecraft().thePlayer.moveForward > 0.0 && (System.currentTimeMillis() > 1500)) {
			this.getMinecraft().thePlayer.setSprinting(true);
			lastSprint = System.currentTimeMillis();
		}
		if (!this.getMinecraft().thePlayer.isSneaking()) {
			if (this.sprinting) {
				setHUDText("[Sprinting (Toggled)]");
			} else if (keySprint.getIsKeyPressed() && this.getMinecraft().thePlayer.isSprinting()) {
				setHUDText("[Sprinting (Key Held)]");
			} else if (this.getMinecraft().thePlayer.isSprinting()) {
				setHUDText("[Sprinting (Vanilla)]");
			} else {
				setHUDText(null);
			}
		}
		if (!BlockClient.getInstance().getManagerHandler().getSettingsManager().isModMenuOpen()) {
			setHeight(getHUDText() == null ? 0 : 10);
			setWidth(getHUDText() == null ? 0 : 110);
		} else {
			setHeight(20);
			setWidth(110);
		}
	}
	
	@Override
	public void enable() {
		this.setModuleState(ModuleState.ENABLED);
	}

	@Override
	public void disable() {
		this.setModuleState(ModuleState.DISABLED);
	}

	@Override
	public String renderPreview() {
		return "[Sprinting (Toggled)]";
	}
}
