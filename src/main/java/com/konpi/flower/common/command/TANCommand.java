package com.konpi.flower.common.command;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.konpi.flower.api.Capabilities;
import com.konpi.flower.api.temperature.Temperature;
import com.konpi.flower.api.temperature.TemperatureScale;
import com.konpi.flower.common.temperature.TemperatureDebugger;
import com.konpi.flower.common.temperature.TemperatureHandler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

public class TANCommand extends CommandBase {
	@Override
	public String getName() {
		return "toughasnails";
	}

	@Override
	public List getAliases() {
		return Lists.newArrayList("tan");
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.toughasnails.usage";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			throw new WrongUsageException("commands.toughasnails.usage");
		} else if ("tempinfo".equals(args[0])) {
			displayTemperatureInfo(sender, args);
		} else if ("settemp".equals(args[0])) {
			setTemperature(sender, args);
		}
	}

	private void displayTemperatureInfo(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		TemperatureHandler temperatureStats = (TemperatureHandler) player.getCapability(Capabilities.TEMPERATURE, null);
		TemperatureDebugger debugger = temperatureStats.debugger;

		debugger.setGuiVisible(!debugger.isGuiVisible(), player);
	}

	private void setTemperature(ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		TemperatureHandler temperatureStats = (TemperatureHandler) player.getCapability(Capabilities.TEMPERATURE, null);
		int newTemp = parseInt(args[1], 0, TemperatureScale.getScaleTotal());
		Temperature playerTemp = temperatureStats.getTemperature();

		// Remove any existing potion effects for hypo/hyperthermia
		// player.removePotionEffect(TANPotions.hypothermia);
		// player.removePotionEffect(TANPotions.hyperthermia);

		// Reset the change timer to 0
		temperatureStats.setChangeTime(0);
		// Set to the new temperature
		temperatureStats.setTemperature(new Temperature(newTemp));

		sender.sendMessage(new TextComponentTranslation("commands.toughasnails.settemp.success", newTemp));
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
		if (args.length == 1) {
			return getListOfStringsMatchingLastWord(args, "settemp", "tempinfo");
		}

		return Collections.<String>emptyList();
	}
}
