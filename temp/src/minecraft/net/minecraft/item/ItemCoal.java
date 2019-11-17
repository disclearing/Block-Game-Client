package net.minecraft.item;

import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemCoal extends Item {

   private IIcon field_111220_a;
   private static final String __OBFID = "CL_00000002";


   public ItemCoal() {
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78035_l);
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return p_77667_1_.func_77960_j() == 1?"item.charcoal":"item.coal";
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
      p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
   }

   public IIcon func_77617_a(int p_77617_1_) {
      return p_77617_1_ == 1?this.field_111220_a:super.func_77617_a(p_77617_1_);
   }

   public void func_94581_a(IIconRegister p_94581_1_) {
      super.func_94581_a(p_94581_1_);
      this.field_111220_a = p_94581_1_.func_94245_a("charcoal");
   }
}
