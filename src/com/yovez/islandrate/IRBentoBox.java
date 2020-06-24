package com.yovez.islandrate;

import world.bentobox.bentobox.BentoBox;

public class IRBentoBox {

	private final BentoBox bentoBox;

	public IRBentoBox() {
		bentoBox = BentoBox.getInstance();
	}

	public BentoBox getBentoBox() {
		return bentoBox;
	}

}
