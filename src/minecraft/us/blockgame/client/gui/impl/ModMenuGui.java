package us.blockgame.client.gui.impl;

import java.awt.Color;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import us.blockgame.client.BlockClient;
import us.blockgame.client.gui.BGui;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;
import us.blockgame.client.util.RenderUtil;
import us.blockgame.client.util.Wrapper;

public class ModMenuGui extends GuiScreen implements BGui {

	private Module dragging;
	private int offsetX = 0, offsetY;

	@Override
	public void initGui() {
		BlockClient.getInstance().getManagerHandler().getSettingsManager().setModMenuOpen(true);
	}

	@Override
	public void onGuiClosed() {
		BlockClient.getInstance().getManagerHandler().getSettingsManager().setModMenuOpen(false);
	}

	@Override
	public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
		GuiMainMenu.drawLogo();
		
		Module toggleSneak = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(0);
		RenderUtil.drawRect(100, 80, 190, 105, (toggleSneak.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[ToggleSneak]", 145 - (Wrapper.fontRenderer.getStringWidth("[ToggleSneak]") / 2), 88, Color.white.getRGB());

		Module fullBright = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(1);
		RenderUtil.drawRect(195, 80, 285, 105, (fullBright.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[FullBright]", 240 - (Wrapper.fontRenderer.getStringWidth("[FullBright]") / 2), 88, Color.white.getRGB());
		
		Module fps = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(2);
		RenderUtil.drawRect(290, 80, 380, 105, (fps.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[FPS]", 335 - (Wrapper.fontRenderer.getStringWidth("[FPS]") / 2), 88, Color.white.getRGB());
		
		Module coordinates = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(3);
		RenderUtil.drawRect(100, 110, 190, 135, (coordinates.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[Coordinates]", 145 - (Wrapper.fontRenderer.getStringWidth("[Coordinates]") / 2), 118, Color.white.getRGB());

		Module cps = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(4);
		RenderUtil.drawRect(195, 110, 285, 135, (cps.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[CPS]", 240 - (Wrapper.fontRenderer.getStringWidth("[CPS]") / 2), 118, Color.white.getRGB());
		
		Module potionCounter = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(5);
		RenderUtil.drawRect(290, 110, 380, 135, (potionCounter.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[Potion Counter]", 335 - (Wrapper.fontRenderer.getStringWidth("[Potion Counter]") / 2), 118, Color.white.getRGB());
		
		Module keyStrokes = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(6);
		RenderUtil.drawRect(100, 140, 190, 165, (keyStrokes.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[KeyStrokes]", 145 - (Wrapper.fontRenderer.getStringWidth("[KeyStrokes]") / 2), 148, Color.white.getRGB());

		Module statusEffectHUD = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(7);
		RenderUtil.drawRect(195, 140, 285, 165, (statusEffectHUD.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[StatusEffectHUD]", 240 - (Wrapper.fontRenderer.getStringWidth("[StatusEffectHUD]") / 2), 148, Color.white.getRGB());
		
		Module scoreboard = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(8);
		RenderUtil.drawRect(290, 140, 380, 165, (scoreboard.getModuleState() == ModuleState.ENABLED ? new Color(0, 255, 0, 0x33) : new Color(255, 0, 0, 0x33)).getRGB());
		this.drawString(Wrapper.fontRenderer, "[Scoreboard]", 335 - (Wrapper.fontRenderer.getStringWidth("[Scoreboard]") / 2), 148, Color.white.getRGB());
		
		if (this.dragging != null && Mouse.isButtonDown(0)) {
			this.dragging.setX(mouseX - offsetX);
			this.dragging.setY(mouseY - offsetY);
		}
	}

	@Override
	public void handleMouseInput() {
		super.handleMouseInput();
	}

	@Override
	protected void mouseClicked(final int mouseX, final int mouseY, final int button) {
		if (100 < mouseX && 80 < mouseY && mouseX < 190 && mouseY < 105) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(0);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (195 < mouseX && 80 < mouseY && mouseX < 285 && mouseY < 105) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(1);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (290 < mouseX && 80 < mouseY && mouseX < 380 && mouseY < 105) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(2);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (100 < mouseX && 110 < mouseY && mouseX < 190 && mouseY < 135) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(3);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (195 < mouseX && 110 < mouseY && mouseX < 285 && mouseY < 135) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(4);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (290 < mouseX && 110 < mouseY && mouseX < 380 && mouseY < 135) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(5);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (100 < mouseX && 140 < mouseY && mouseX < 190 && mouseY < 165) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(6);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (195 < mouseX && 140 < mouseY && mouseX < 285 && mouseY < 165) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(7);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (290 < mouseX && 140 < mouseY && mouseX < 380 && mouseY < 165) {
			Module module = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(8);
			if (module.getModuleState() == ModuleState.ENABLED) {
				module.disable();
			} else {
				module.enable();
			}
			return;
		}
		if (dragging == null) {
			for (Module module : BlockClient.getInstance().getManagerHandler().getModuleManager().getModules()) {
				if (module.getX() < mouseX && module.getY() < mouseY && mouseX < (module.getX() + module.getWidth())
						&& mouseY < (module.getY() + module.getHeight())
						&& module.getModuleState() == ModuleState.ENABLED) {
					this.dragging = module;
					this.offsetX = (int) Math.sqrt(Math.pow(module.getX() - mouseX, 2));
					this.offsetY = (int) Math.sqrt(Math.pow(module.getY() - mouseY, 2));
				}
			}
		}
	}

	@Override
	protected void mouseMovedOrUp(final int mouseX, final int mouseY, final int button) {
		this.dragging = null;
	}
}