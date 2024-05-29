package net.mcreator.animeoddysey.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class LevelValueProcedure {
	public static String execute() {
		return "\u00A7lLevel: " + new java.text.DecimalFormat("#").format() + " |\u00A7a " + new java.text.DecimalFormat("#").format() + "/" + new java.text.DecimalFormat("#").format();
	}
}
