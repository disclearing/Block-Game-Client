package us.blockgame.client.manager.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import us.blockgame.client.manager.Manager;
import us.blockgame.client.manager.ManagerHandler;

public class PlayerManager extends Manager {

	private long lastClick;
	private List<Long> clicks;

	public PlayerManager(ManagerHandler managerHandler) {
		super(managerHandler);
		this.clicks = new ArrayList();
	}

	public void addClick() {
		clicks.add(System.currentTimeMillis());
	}

	public int getCPS() {
		final Iterator<Long> iterator = clicks.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() < System.currentTimeMillis() - 1000L) {
				iterator.remove();
			}
		}
		return clicks.size();
	}
}
