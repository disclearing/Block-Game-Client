package us.blockgame.client.module;

import org.apache.logging.log4j.LogManager;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import us.blockgame.client.BlockClient;

public abstract class Module {

	private String name;
	private String hudText;
	private int x;
	private int y;
	private int height;
	private int width;
	private int color;

	public Module(String name) {
		this.name = name;
	}

	private ModuleState moduleState = ModuleState.DISABLED;

	public Minecraft getMinecraft() {
		return BlockClient.getInstance().getMinecraft();
	}

	public ModuleState getModuleState() {
		return moduleState;
	}

	public String getName() {
		return name;
	}

	public String getHUDText() {
		return hudText;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getColor() {
		return color;
	}

	public void setModuleState(ModuleState moduleState) {
		this.moduleState = moduleState;
	}

	public void setHUDText(String hudText) {
		this.hudText = hudText;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void enable() {
		LogManager.getLogger().info("Module " + name + " has been enabled.");
	}

	public void disable() {
		LogManager.getLogger().info("Module " + name + " has been disabled.");
	}

	public void onPositionUpdate() {
	}

	public void onEvent2D() {
	}

	public void onMovePacket() {
	}
	
	public void onScoreboardUpdate(ScoreObjective objective) {
	}

	public abstract String renderPreview();
}
