package us.blockgame.client.module.impl;

import java.util.Collection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.EnumChatFormatting;
import us.blockgame.client.BlockClient;
import us.blockgame.client.gui.impl.ModMenuGui;
import us.blockgame.client.module.Module;
import us.blockgame.client.module.ModuleState;
import us.blockgame.client.util.Wrapper;

public class ScoreboardModule extends Module {

	public ScoreboardModule() {
		super("Scoreboard");
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
		return null;
	}

}
