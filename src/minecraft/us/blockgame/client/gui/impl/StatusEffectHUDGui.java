package us.blockgame.client.gui.impl;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import us.blockgame.client.BlockClient;
import us.blockgame.client.gui.BGui;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;
import us.blockgame.client.util.NumberUtil;

public class StatusEffectHUDGui extends GuiScreen implements BGui {

	@Override
	public void onEvent2D() {
		try {
			Module statusEffect = BlockClient.getInstance().getManagerHandler().getModuleManager().getModules().get(7);
			if (statusEffect.getModuleState() == ModuleState.ENABLED) {
				Collection<PotionEffect> potionEffects = null;
				int height = 0;
				int maxWidth = 0;
				int width;
				if (BlockClient.getInstance().getManagerHandler().getSettingsManager().isModMenuOpen()) {
					potionEffects = new ArrayList();
					potionEffects.add(new PotionEffect(1, 100, 1, true));
					potionEffects.add(new PotionEffect(12, 100, 0, true));
				} else {
					potionEffects = Minecraft.getMinecraft().thePlayer.getActivePotionEffects();
				}
				for (PotionEffect effect : potionEffects) {
					String label = StatCollector.translateToLocal(effect.getEffectName())
							+ NumberUtil.getAmplifierNumerals(effect.getAmplifier());
					width = Minecraft.getMinecraft().fontRenderer.getStringWidth(label) + 24;
					Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(label, statusEffect.getX() + 22,
							statusEffect.getY() + height + 2, statusEffect.getColor());
					if (width > maxWidth) {
						maxWidth = width;
					}
					String duration = Potion.getDurationString(effect);
					width = Minecraft.getMinecraft().fontRenderer.getStringWidth(duration) + 24;
					Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(duration, statusEffect.getX() + 22,
							statusEffect.getY() + height + 12, statusEffect.getColor());
					if (width > maxWidth) {
						maxWidth = width;

					}
					height += 24;
				}
				statusEffect.setWidth(maxWidth);
				statusEffect.setHeight(height);
			}

		} catch (Exception ex) {
		}
	}

}
