package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SPValueProcedure {
	public static String execute() {
		return "\u00A7lSP: " + new java.text.DecimalFormat("#").format();
	}
}
