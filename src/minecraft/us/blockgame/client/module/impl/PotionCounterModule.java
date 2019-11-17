package us.blockgame.client.module.impl;

import net.minecraft.item.ItemStack;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;

public class PotionCounterModule extends Module {
	
	public PotionCounterModule() {
		super("PotionCounter");
		setX(215);
		setY(2);
		setColor(0xfffff);
		setHeight(10);
		setWidth(52);
	}
	
	@Override
	public void onEvent2D() {
		if (this.getModuleState() == ModuleState.DISABLED) {
			return;
		}
		int pots = 0;
		for (int i = 0; i < this.getMinecraft().thePlayer.inventory.mainInventory.length; i++) {
			ItemStack itemStack = this.getMinecraft().thePlayer.inventory.mainInventory[i];
			if (itemStack != null && itemStack.getUnlocalizedName().equals("item.potion") && (itemStack.getItemDamage() == 16421 || itemStack.getItemDamage() == 16453)) {
				pots += itemStack.stackSize;
			}
		}
		setHUDText("[" + pots + " Potion" + (pots == 1 ? "" : "s") + "]");
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
		return "[10 Potions]";
	}

}
